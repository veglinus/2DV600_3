package lh223cc;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyBFS<E> implements BFS<E> {

    private List<Node<E>> list = new LinkedList<Node<E>>();
    private Set<Node<E>> visited = new HashSet<Node<E>>();
    private Queue<Node<E>> queue = new LinkedList<Node<E>>();
    private int breadth = 0;

    private void innerBFS(Node<E> node) {
        queue.add(node);

        while (queue.size() > 0) {
            Node<E> current = queue.remove();
            if (!visited.contains(current)) {
                
                Iterator<Node<E>> successors = current.succsOf();
                while (successors.hasNext()) { // Adding successors to queue
                    Node<E> succ = successors.next();
                    queue.add(succ);
                }

                visited.add(current);
                list.add(current);
                current.num = breadth++;
                
            }
        }
    }

    private void clear() {
        visited.clear();
        list.clear();
        queue.clear();
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        clear();
        innerBFS(root);
        return list;
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        clear();
        if (graph.headCount() > 0) {
            Iterator<Node<E>> iterator = graph.heads();

            while (iterator.hasNext()) {
                innerBFS(iterator.next()); // Use BFS on all heads to not miss a node, duplicates are handled in innerBFS
            }

        } else {
            E firstItem = graph.allItems().get(0); // Force get first item in list
            innerBFS(graph.getNodeFor(firstItem));
        }
        return list;
    }
    
}
