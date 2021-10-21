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
    private Queue<Node<E>> queue = new ArrayDeque<>();

    private void innerBFS(Node<E> node) {
        
        queue.add(node);

        while (queue.size() > 0) {
            
            Node<E> current = queue.remove(); // REMOVING from queue
            System.out.println(current);
            if (!visited.contains(current)) {
                
                System.out.println("Added: " + current);

                Iterator<Node<E>> successors = current.succsOf();
                while (successors.hasNext()) { // ADDING ALL NEIGHBORS
                    Node<E> succ = successors.next();
                    System.out.println("Found succs: " + succ);

                    //if (!visited.contains(succ)) {
                        queue.add(succ);
                        
                    //}

                }

                visited.add(current);
                list.add(current);
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
        System.out.println(list);
        return list;
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        if (graph.headCount() > 0) {

        } else {
            
        }
        return null;
    }
    
}
