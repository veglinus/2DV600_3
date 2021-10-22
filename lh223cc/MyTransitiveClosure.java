package lh223cc;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;
import graphs.DFS;

public class MyTransitiveClosure<E> implements TransitiveClosure<E> {

    private Map< Node<E>, Collection<Node<E>> > map = new HashMap<>();
    private Collection<Node<E>> nodes = new HashSet<Node<E>>();

    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        map.clear();
        nodes.clear();

        Iterator <Node<E>> iterator = dg.iterator();

        while (iterator.hasNext()) {
            Node<E> current = iterator.next();
            DFS<E> myDFS = new MyDFS<E>();

            nodes = myDFS.dfs(dg, current);
            map.put(current, nodes);
        }

        return map;
    }
}
