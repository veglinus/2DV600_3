package lh223cc;

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
        //System.out.println("Visited: " + node);
        
        Iterator<Node<E>> successors = node.succsOf();

        //System.out.println("node has successors: " + node.outDegree());

        while (successors.hasNext()) {
            Node<E> succ = successors.next();

            //System.out.println("Succesor is: " + succ);
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

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        clear();
        
        
        return null;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
