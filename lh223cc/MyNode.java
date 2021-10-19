package lh223cc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import graphs.Node;

public class MyNode<E> extends Node<E> {

    private Set<Node<E>> predecessor = new HashSet<Node<E>>();
	private Set<Node<E>> successor = new HashSet<Node<E>>();

    protected MyNode(E item) {
        super(item);
    }

    @Override
    public boolean hasSucc(Node<E> node) {
        return successor.contains(node);
    }

    @Override
    public int outDegree() {
        return successor.size();
    }

    @Override
    public Iterator<Node<E>> succsOf() {
        return successor.iterator();
    }

    @Override
    public boolean hasPred(Node<E> node) {
        return predecessor.contains(node);
    }

    @Override
    public int inDegree() {
        return predecessor.size();
    }

    @Override
    public Iterator<Node<E>> predsOf() {
        return predecessor.iterator();
    }

    @Override
    protected void addSucc(Node<E> succ) {
        successor.add(succ);
    }

    @Override
    protected void removeSucc(Node<E> succ) {
        successor.remove(succ);
    }

    @Override
    protected void addPred(Node<E> pred) {
        predecessor.add(pred);
    }

    @Override
    protected void removePred(Node<E> pred) {
        predecessor.remove(pred);        
    }

    @Override
    protected void disconnect() {
        predecessor.clear();
        successor.clear();
    }
    
}
