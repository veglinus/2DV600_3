package lh223cc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import graphs.ConnectedComponents;
import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyConnectedComponents<E> implements ConnectedComponents<E> {

    private List<Node<E>> connections = new LinkedList<Node<E>>();
    private Set<Node<E>> visited = new HashSet<Node<E>>();
    private Collection<Collection<Node<E>>> result = new HashSet<Collection<Node<E>>>();

    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        clear();

        Iterator<Node<E>> iterator = dg.iterator();
        while (iterator.hasNext()) {
            Node<E> current = iterator.next();

            if (!visited.contains(current)) {
                visit(current);
                for (Node<E> visitedNode : visited) {
                    if (!connections.contains(visitedNode)) {
                        handleConnections(visitedNode);
                    }
                }
            }

            if (!connections.isEmpty()) {
                result.add(connections);
                connections = new LinkedList<Node<E>>();
            }
        }

        System.out.println(result);
        return result;
    }

    private void clear() {
        visited.clear();
        connections.clear();
        result.clear();
    }

    private void handleConnections(Node<E> node) {
        for (Collection<Node<E>> coll : result) {
            if (!Collections.disjoint(coll, connections)) {
                coll.addAll(connections);
                connections = new LinkedList<Node<E>>();
            }
        }
    }

    private void visit(Node<E> node) {
        visited.add(node);
        connections.add(node);

        Iterator<Node<E>> successors = node.succsOf();
        Iterator<Node<E>> predecessors = node.predsOf();

        while (successors.hasNext()) {
            checkConnectedList(successors.next());
        }
        while (predecessors.hasNext()) {
            checkConnectedList(predecessors.next());
        }

    }

    private void checkConnectedList(Node<E> curr) {
        if (!connections.contains(curr)) {
            visit(curr);
        }
    }

    
}
