package com.foodbird.generate.dynamic.utils;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/28
 */
public class FBDAGUtils {

    public static <T> List<T> topologySort(List<T> nodes, Map<T, T[]> edges) {
        Stack<T> topologySort = topology(nodes, edges);
        List<T> topologyList = Lists.newArrayList();
        while (!topologySort.isEmpty()) {
            topologyList.add(topologySort.pop());
        }
        return topologyList;
    }

    public static <T> Stack<T> topology(List<T> nodes, Map<T, T[]> edges) {
        MutableGraph<T> dag = GraphBuilder.directed().allowsSelfLoops(false).build();
        for (T node : nodes) {
            dag.addNode(node);
            T[] depNodes = edges.get(node);
            if (depNodes != null) {
                for (T depNode : depNodes) {
                    dag.putEdge(node, depNode);
                }
            }
        }
        return topologySort(dag);
    }

    static <T> Stack<T> topologySort(MutableGraph<T> dag) throws IllegalArgumentException {
        Queue<T> queue = Lists.newLinkedList();
        Stack<T> sort = new Stack<>();
        // 查找无入度的点
        for (T node : dag.nodes()) {
            if (dag.inDegree(node) == 0) {
                queue.add(node);
            }
        }
        // 循环删除无入度的点
        while (!queue.isEmpty()) {
            T node = queue.poll();
            sort.push(node);
            dag.removeNode(node);
            // 查询是否有新的无入度的点
            for (T temp : dag.nodes()) {
                if (dag.inDegree(temp) == 0 && !queue.contains(temp)) {
                    queue.add(temp);
                }
            }
        }
        // 是否有环
        if (dag.nodes().size() != 0) {
            System.out.println(Joiner.on(" ").join(dag.nodes()));
            throw new IllegalArgumentException("依赖关系「 "+Joiner.on(" ").join(dag.nodes())+" 」中存在循环依赖！");
        }
        return sort;
    }

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1", "2", "3", "4", "5", "6");
        Map<String, String[]> refs = Maps.newHashMap();
        refs.put("3", new String[] {"1", "6"});
        refs.put("5", new String[] {"2", "3"});
        refs.put("1", new String[] {"4"});
        refs.put("4", new String[] {"6"});
        List<String> topologySort = topologySort(list, refs);
        System.out.println(Joiner.on(" ").join(topologySort));
    }

}
