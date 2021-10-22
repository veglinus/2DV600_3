package lh223cc;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import graphs.ConnectedComponents;
import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyConnectedComponents<E> implements ConnectedComponents<E> {

    private Set<Node<E>> visited = new HashSet<Node<E>>();
    private Collection<Collection<Node<E>>> collection = new HashSet<>();

    private DirectedGraph<E> currGraph;

    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {

        currGraph = dg;
        Iterator<Node<E>> iterator = dg.iterator();

        while (iterator.hasNext()) {
            visit(iterator.next());
        }

        
        return collection;
    }

    private void visit(Node<E> node) {
        if (!visited.contains(node)) {
            visited.add(node);

            Iterator<Node<E>> outNeighbors = node.succsOf();

            while (outNeighbors.hasNext()) {
                visit(outNeighbors.next());
            }

            MyDFS<E> mydfs = new MyDFS<>();
            List<Node<E>> mylist = mydfs.dfs(currGraph, node);
            collection.add(mylist);

        }
    }

    private void assign() {
        
    }
    
}
