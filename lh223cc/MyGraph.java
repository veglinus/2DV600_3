package lh223cc;

import java.util.*;

import graphs.Node;
import graphs.DirectedGraph;

public class MyGraph<E> implements DirectedGraph<E> {

    private HashMap<E, Node<E>> NodeMap = new HashMap<E, Node<E>>(); // Maybe should be Map instead of hashmap
    private Set<Node<E>> heads;
    private Set<Node<E>> tails;

    @Override
    public Node<E> addNodeFor(E item) {

        if (item != null) {

            MyNode<E> newnode = new MyNode<E>(item);
            NodeMap.put(item, newnode);
            heads.add(newnode);
            tails.add(newnode);

            return newnode;
        } else {
            throw new NullPointerException("Input is null.");
        }
    }

    @Override
    public Node<E> getNodeFor(E item) {
        return NodeMap.get(item);
    }

    @Override
    public boolean addEdgeFor(E from, E to) {
        
        // give from a successor
        MyNode<E> from2 = (MyNode<E>) from;
        from2.addSucc((MyNode<E>) from);

        // give to a predecessor
        MyNode<E> to2 = (MyNode<E>) to;
        to2.addPred((MyNode<E>) to);

        // handle heads and tails

        return false;
    }

    @Override
    public boolean containsNodeFor(E item) {
        if (getNodeFor(item) != null) {
            return true;
        }
        return false;
    }

    @Override
    public int nodeCount() {
        return NodeMap.size();
    }

    @Override
    public Iterator<Node<E>> iterator() {
        // TODO Auto-generated method stub
        return NodeMap.values().iterator();
    }

    @Override
    public Iterator<Node<E>> heads() {
        // TODO Auto-generated method stub
        return heads.iterator();
    }

    @Override
    public int headCount() {
        // TODO Auto-generated method stub
        return heads.size();
    }

    @Override
    public Iterator<Node<E>> tails() {
        // TODO Auto-generated method stub
        return tails.iterator();
    }

    @Override
    public int tailCount() {
        // TODO Auto-generated method stub
        return tails.size();
    }

    @Override
    public List<E> allItems() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int edgeCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void removeNodeFor(E item) {
        NodeMap.remove(item);
    }

    @Override
    public boolean containsEdgeFor(E from, E to) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeEdgeFor(E from, E to) {
        // TODO Auto-generated method stub
        return false;
    }



}
