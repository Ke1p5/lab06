package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.Graph;
import java.util.Map;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GraphImpl implements Graph<String> {

    private Map<String, Set<String>> graph;

    public GraphImpl() {
        this.graph = new HashMap<>();
    }

    public void addNode(String node) {
        this.graph.put(node, new HashSet<>());
    }
    
    public void addEdge(String source, String target) {
        if (source != null && target != null) {
            this.graph.get(source).add(target);
        }    
    }

    public Set<String> nodeSet() {
        return this.graph.keySet();
    }

    public Set<String> linkedNodes(final String node) {
        return this.graph.get(node);
    }

    public List<String> getPath(final String source, final String target) {
        List<String> path = new ArrayList<>();
        Set<String> set = this.graph.get(source);
       
        path = getPathRecursive(source, target, path, set);
        return path;
    }

    private List<String> getPathRecursive(final String source, final String target, List<String> path, Set<String> nodes) {
        path.add(source);
        if (source.equals(target)) {
            return path;
        }
        Iterator<String> iter = nodes.iterator();
        String temp;
        while (iter.hasNext()) {
            temp = iter.next();
            if (temp.equals(target)) {
                path.add(temp);
                return path;
            }
            path = getPathRecursive(temp, target, path, this.graph.get(temp));
        }
        return path;
    }
}
