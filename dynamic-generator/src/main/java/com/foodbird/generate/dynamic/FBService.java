package com.foodbird.generate.dynamic;

import com.foodbird.common.context.FBIContext;
import com.foodbird.generate.dynamic.annotations.fbsvc;
import com.foodbird.generate.dynamic.constants.FBConstants;
import com.foodbird.generate.dynamic.enums.FBPersistentType;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/28
 */
public class FBService implements FBConstants {

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

    public FBService(String id, List<FBIAction> actions) {
        this.actions = actions;
        this.degradation = -1;
        this.id = id;
        this.limitation = -1;
        this.name = id;
        this.needRetry = false;
        this.ordered = false;
        this.persistentType = FBPersistentType.MEMORY;
    }

    public FBService(fbsvc fbservice, List<FBIAction> actions) {
        this.actions = actions;
        this.degradation = fbservice.degradation();
        this.id = fbservice.id();
        this.limitation = fbservice.limitation();
        this.name = fbservice.name();
        this.needRetry = fbservice.needRetry();
        this.ordered = fbservice.ordered();
        this.persistentType = fbservice.persistentType();
    }

    protected FBSeries reorderByReference() {
        FBSeries series = new FBSeries(id);
        Map<String, FBIAction> actsByKey = actions.stream().collect(Collectors.toMap(FBIAction::id, a -> a));
        for (FBIAction action : actions) {
            String[] dependencies = action.dependencies();
            FBNode current = new FBNode(action);
            if (series.getFirst() == null) {
                series.setFirst(current);
            }
            for (String dependency : dependencies) {
                FBIAction depAct = actsByKey.get(dependency);
                FBNode depNode = new FBNode(depAct);
                // TODO yuyang
            }
        }
        return series;
    }

    public Object start(Object parameter) throws Throwable {
        FBIContext context = new FBActionContext();
        Object result = null;
        if (actions.size() > 0) {
            context.put(actions.get(0).id(), parameter);
        }
        for (FBIAction action : actions) {
            switch (action.actionType()) {
                case NORMAL:
                    result = action.doAction(context);
                    context.put(action.id(), result);
                    break;
                case ROUTER:

                case CHECKER:
                default:
                    throw new IllegalArgumentException("不支持的操作类型！");
            }
            result = action.doAction(context);
        }

        return result;
    }
}
