package lh223cc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyDFS<E> implements DFS<E> {

    private List<Node<E>> list = new LinkedList<Node<E>>();
    private Set<Node<E>> visited = new HashSet<Node<E>>();
    private int depth = 0;
    private int depthPost = 0;


    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        clear();
        innerDFS(root);
        return list;
    }

    private void innerDFS(Node<E> node) {

        node.num = depth++;
        visited.add(node);
        list.add(node);
        
        Iterator<Node<E>> successors = node.succsOf();

        while (successors.hasNext()) {
            Node<E> succ = successors.next();
            if (!visited.contains(succ)) {
                innerDFS(succ);
            }
        }
    }

    private void clear() {
        visited.clear();
        list.clear();
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {

        clear();

        for (Node<E> node : graph) {
            if (!visited.contains(node)) {
                innerDFS(node);
            }
        }

        return list;
    }

    private void innerPostOrder(Node<E> node) {

        visited.add(node);
        
        Iterator<Node<E>> successors = node.succsOf();

        while (successors.hasNext()) {
            Node<E> succ = successors.next();

            if (!visited.contains(succ)) {                
                innerPostOrder(succ);
            }
        }
        
        node.num = depthPost;
        list.add(node);
        
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        clear();
        innerPostOrder(root);
        return list;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        clear();
        Iterator<Node<E>> iterator = g.iterator();

        while (iterator.hasNext()) {
            Node<E> node = iterator.next();

            if (!visited.contains(node)) {
                innerPostOrder(node);
            }

        }

        return list;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        
        Iterator<Node<E>> iterator = g.iterator();

        while (iterator.hasNext()) {
            Node<E> node = iterator.next();

            if (attach_dfs_number) {
                node.num = depth++;
            }
            innerPostOrder(node);
        }

        return list;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {

        Iterator<Node<E>> iterator = postOrder(graph).iterator();
        while (iterator.hasNext()) {
            Node<E> nextnode = iterator.next();

            Iterator<Node<E>> successors = nextnode.succsOf();
            while (successors.hasNext()) {
                if (nextnode.num <= successors.next().num) { // TODO: fix?
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        // Top sort is basically a reversed postOrder
        List<Node<E>> list = postOrder(graph);
        Collections.reverse(list);
        return list;
    }
    
}
