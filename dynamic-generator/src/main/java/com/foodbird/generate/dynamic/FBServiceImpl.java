package com.foodbird.generate.dynamic;

import com.foodbird.common.context.FBIContext;
import com.foodbird.generate.dynamic.annotations.FBService;
import com.foodbird.generate.dynamic.constants.FBConstants;
import com.foodbird.generate.dynamic.enums.FBPersistentType;
import com.foodbird.generate.dynamic.utils.FBDAGUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/28
 */
public class FBServiceImpl implements FBIService, FBConstants {

    public static final String INIT_METHOD = "reorderByDependencies";

    /**
     * 操作动作列
     */
    private List<FBIAction> actions;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 流程id
     */
    private String id;

    /**
     * 是否需要重试
     */
    private boolean needRetry;

    /**
     * 限流
     */
    private int limitation;

    /**
     * 降级
     */
    private int degradation;

    /**
     * 节点间是否有序
     */
    private boolean ordered;

    /**
     * 持久化类型
     */
    private FBPersistentType persistentType;

    public FBServiceImpl(String id, List<FBIAction> actions) {
        this.actions = actions;
        this.degradation = -1;
        this.id = id;
        this.limitation = -1;
        this.name = id;
        this.needRetry = false;
        this.ordered = false;
        this.persistentType = FBPersistentType.MEMORY;
    }

    public FBServiceImpl(FBService fbservice, List<FBIAction> actions) {
        this.actions = actions;
        this.degradation = fbservice.degradation();
        this.id = fbservice.id();
        this.limitation = fbservice.limitation();
        this.name = fbservice.name();
        this.needRetry = fbservice.needRetry();
        this.ordered = fbservice.ordered();
        this.persistentType = fbservice.persistentType();
    }

    public FBSeries reorderByDependencies() {
        FBSeries series = new FBSeries(id);
        Map<String, FBNode> actsByKey = Maps.newHashMap();
        Map<String, String[]> refs = Maps.newHashMap();
        List<String> actionIds = Lists.newArrayList();

        for (FBIAction action : getActions()) {
            actsByKey.put(action.id(), new FBNode(action));
            String[] dependencies = action.dependencies();
            refs.put(action.id(), dependencies);
            actionIds.add(action.id());
        }

        List<String> topologyActionsIds = FBDAGUtils.topologySort(actionIds, refs);

        for (String id : topologyActionsIds) {
            series.addLast(actsByKey.get(id));
        }

        return series;
    }

    public Object start(Object parameter) throws Throwable {
        FBIContext context = new FBActionContext();
        Object result = null;
        if (actions.size() > 0) {
            context.put(actions.get(0).id(), parameter);
        }
        FBSeries fbSeries = reorderByDependencies();
        FBNode current = fbSeries.getFirst();
        while (current != null) {
            FBIAction action = current.getAction();
            try {
                result = action.doAction(context);
            } catch (Throwable throwable) {
                action.onException(throwable);
            }
            if (result == null) {
                current = null;
                continue;
            }
            switch (action.actionType()) {
                case NORMAL:
                    context.put(action.id(), result);
                    current = current.getNext();
                    break;
                case ROUTER:
                    if (result instanceof String) {
                        String target = (String) result;
                        current = fbSeries.find(current, target);
                        if (current == null) {
                            throw new IllegalArgumentException("目标节点「"+target+"」不存在！");
                        }
                        break;
                    }
                    throw new IllegalArgumentException("目标节点「" + action.id() + "」返回值类型与操作类型不匹配。期待类型："
                                + String.class.getName() + "；" + "实际类型：" + result.getClass().getName() + "。");
                case CHECKER:
                    if (result instanceof Boolean) {
                        current = (Boolean) result ? current.getNext() : null;
                        break;
                    }
                    throw new IllegalArgumentException("目标节点「"+action.id()+"」返回值类型与操作类型不匹配。期待类型："
                                + Boolean.class.getName() + "；" + "实际类型：" + result.getClass().getName() + "。");
                default:
                    throw new IllegalArgumentException("不支持的操作类型！");
            }
        }
        return result;
    }

    @Override
    public List<FBIAction> getActions() {
        return actions;
    }

    @Override
    public Object process(Object... args) throws Throwable {
        return start(args);
    }

}
