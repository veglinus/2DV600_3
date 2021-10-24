package lh223cc;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

public class MyConnectedComponents<E> implements ConnectedComponents<E> {

    private Collection<Node<E>> connections = new LinkedList<Node<E>>();
    private Set<Node<E>> visited = new HashSet<Node<E>>();

    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        Collection<Collection<Node<E>>> result = new HashSet<Collection<Node<E>>>();
        clear();

        Iterator<Node<E>> iterator = dg.iterator();
        while (iterator.hasNext()) {
            Node<E> current = iterator.next();

            if (!visited.contains(current)) {
                visit(current);

                Iterator<Node<E>> visitedIterator = visited.iterator();
                while (visitedIterator.hasNext()) {

                    Node<E> visitedNode = visitedIterator.next();
                    if (!connections.contains(visitedNode)) {

                        Iterator<Collection<Node<E>>> resultIterator =  result.iterator();
                        while (resultIterator.hasNext()) {
                            handleConnections(resultIterator.next());
                        }

                    }
                }
            }

            if (!connections.isEmpty()) {
                result.add(connections);
                connections = new LinkedList<Node<E>>();
            }
        }

        return result;
    }

    private void handleConnections(Collection<Node<E>> coll) {
        if (!coll.stream().anyMatch(connections::contains)) {
            coll.addAll(connections);
            connections = new LinkedList<Node<E>>();
        }
    }

    private void clear() {
        visited.clear();
        connections.clear();
    }

    private void visit(Node<E> node) {
        visited.add(node);
        connections.add(node);

        Iterator<Node<E>> successors = node.succsOf();
        Iterator<Node<E>> predecessors = node.predsOf();

        while (successors.hasNext()) {
            Node<E> curr = successors.next();
            if (!connections.contains(curr)) {
                visit(curr);
            }
        }
        while (predecessors.hasNext()) {
            Node<E> curr = predecessors.next();
            if (!connections.contains(curr)) {
                visit(curr);
            }
        }
    }
}
