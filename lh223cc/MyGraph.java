package lh223cc;

import java.util.*;

import graphs.Node;
import graphs.DirectedGraph;

public class MyGraph<E> implements DirectedGraph<E> {

    HashMap<E, MyNode<E>> NodeMap = new HashMap<E, MyNode<E>>(); // Maybe should be Map instead of hashmap

    // TODO: Something to keep track of edges

    /*
    class Edge {
        MyNode from;
        MyNode to;

        Edge(MyNode from, MyNode to) {
            this.from = from;
            this.to = to;
        }
    }*/

    @Override
    public Node<E> addNodeFor(E item) {
        // TODO Auto-generated method stub

        if (item != null) {

            MyNode<E> newnode = new MyNode<E>(item);
            NodeMap.put(item, newnode);

            return newnode;
        } else {
            // TODO: throw;
        }


        return null;
    }

    @Override
    public Node<E> getNodeFor(E item) {
        return NodeMap.get(item);
    }

    @Override
    public boolean addEdgeFor(E from, E to) {
        // TODO Auto-generated method stub
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
        return null;
    }

    @Override
    public Iterator<Node<E>> heads() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int headCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Node<E>> tails() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int tailCount() {
        // TODO Auto-generated method stub
        return 0;
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
