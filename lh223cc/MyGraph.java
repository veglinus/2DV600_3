package lh223cc;

import java.util.*;

import graphs.Node;
import graphs.DirectedGraph;

public class MyGraph<E> implements DirectedGraph<E> {

    private Map<E, Node<E>> NodeMap; // Maybe should be Map instead of hashmap
    private Set<Node<E>> heads;
    private Set<Node<E>> tails;

    public MyGraph() {
        NodeMap = new HashMap<E, Node<E>>();
        heads = new HashSet<Node<E>>();
        tails = new HashSet<Node<E>>();
    }

    @Override
    public Node<E> addNodeFor(E item) {

        if (item != null) {

            if (!NodeMap.containsKey(item)) {
                MyNode<E> newnode = new MyNode<E>(item);
                
                heads.add(newnode);
                tails.add(newnode);

                NodeMap.put(item, newnode);
    
                return newnode;
                
            } else {
                return NodeMap.get(item);
            }

        } else {
            throw new RuntimeException("Input is null.");
        }
    }

    @Override
    public Node<E> getNodeFor(E item) {
        if (item == null) {
            throw new RuntimeException("Input is null");
        }
        
        if (!NodeMap.containsKey(item)) {
            throw new RuntimeException("Map does not contain item");
        }

        //if (NodeMap.containsKey(item)) {
            Node<E> result = NodeMap.get(item);
            return result;
            /*
        } else {
            throw new RuntimeException("Couldn't find node");
        }*/
    }

    @Override
    public boolean addEdgeFor(E from, E to) {

        if (from == null || to == null) {
            throw new RuntimeException("Input was null");
        }
        
        MyNode<E> src = (MyNode<E>) addNodeFor(from);
        MyNode<E> tgt = (MyNode<E>) addNodeFor(to);


        if (src.hasSucc(tgt)) {
            return false;
        }

        src.addSucc(tgt);
        tgt.addPred(src);
        
        tails.remove(src);
        heads.remove(tgt);

        return true;
    }

    @Override
    public boolean containsNodeFor(E item) {
        if (item == null) {
            throw new RuntimeException("Input was null");
        }
        if (NodeMap.get(item) != null) {
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
        return NodeMap.values().iterator();
    }

    @Override
    public Iterator<Node<E>> heads() {
        return heads.iterator();
    }

    @Override
    public int headCount() {
        return heads.size();
    }

    @Override
    public Iterator<Node<E>> tails() {
        return tails.iterator();
    }

    @Override
    public int tailCount() {
        return tails.size();
    }

    @Override
    public List<E> allItems() {
        ArrayList<E> list = new ArrayList<E>();
        for (Node<E> node : NodeMap.values()) {
            list.add(node.item());
        }
        return list;
    }

    @Override
    public int edgeCount() {
        int count = 0;

        for (Node<E> node : NodeMap.values()) {
            count += node.outDegree();
        }

        return count;
    }

    @Override
    public void removeNodeFor(E item) {
        if (item == null) {
            throw new RuntimeException("Input was null");
        }

        MyNode<E> node = (MyNode<E>) NodeMap.get(item);

        for (Node<E> curr : NodeMap.values()) {
            MyNode<E> currNode = (MyNode<E>) curr;

            if (currNode.hasPred(node)) {
                currNode.removePred(node);

                if (currNode.isHead()) { // If we have no ingoing edges, make head
                    heads.add(currNode);
                }
            }

            if (currNode.hasSucc(node)) {
                currNode.removeSucc(node);

                if (currNode.isTail()) { // If we have no outgoing edges, make tail
                    tails.add(currNode);
                }
            }

        }
    
        // Remove actual node
        if (node.isHead()) {
            heads.remove(node);
        }
        if (node.isTail()) {
            tails.remove(node);
        }
        node.disconnect();
        NodeMap.remove(item);
    }

    @Override
    public boolean containsEdgeFor(E from, E to) {
        if (from == null || to == null) {
            throw new RuntimeException("Input was null");
        }

        if (containsNodeFor(from) && containsNodeFor(to)) {
            if (NodeMap.get(from).hasSucc(NodeMap.get(to))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeEdgeFor(E from, E to) {
        if (from == null || to == null) {
            throw new RuntimeException("Either input was null");
        }

        if (containsEdgeFor(from, to)) {
            MyNode<E> src = (MyNode<E>) NodeMap.get(from);
            MyNode<E> tgt = (MyNode<E>) NodeMap.get(to);
    
            src.removeSucc(tgt);
            tgt.removePred(src);

            if (src.isHead()) {
                heads.add(src);
            }
            if (src.isTail()) {
                tails.add(src);
            }

            if (tgt.isHead()) {
                heads.add(tgt);
            }
            if (tgt.isTail()) {
                tails.add(tgt);
            }

            return true;
        }

        return false;
    }
}
