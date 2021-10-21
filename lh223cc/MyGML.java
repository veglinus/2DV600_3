package lh223cc;

import java.util.Iterator;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;

public class MyGML<E> extends GML<E> {

    public MyGML(DirectedGraph<E> input) {
        super(input);
    }

    @Override
    public String toGML() {
        String nodes = "";
        String edges = "";

        Integer id = 1;
        for (Node<E> node : graph) {
            String nodeString = "";
            nodeString += "\t\t" + "id " + id + "\n";
            nodeString += "\t\t" + "label " + node + "";
            nodes += "\tnode [\n" + nodeString + "\n\t]\n";

            // Handle edges
            Iterator<Node<E>> nodeIterator = node.succsOf();
            while (nodeIterator.hasNext()) {
                String edgeString = "";
                edgeString += "\t\t" + "source " + node + "\n";
                edgeString += "\t\t" + "target " + nodeIterator.next();
                edges += "\tedge [\n" + edgeString + "\n\t]\n";
            }
            id++;
        }

        //System.out.println("graph [\n" + nodes + edges + "]"); // Debug
        return "graph [\n" + nodes + edges + "]";
    }
}

/*

        for (Node<E> node : graph) {
            String nodeString = "";
            nodeString += "\t\t" + "id " + id + "\n";
            nodeString += "\t\t" + "label " + node + "";
            nodes += "\tnode [\n" + nodeString + "\n\t]\n";
            id++;
        }

        Iterator<Node<E>> graphIterator = graph.iterator();
        while (graphIterator.hasNext()) {
            Node<E> node = (MyNode<E>) graphIterator.next(); 
            Iterator<Node<E>> nodeIterator = node.succsOf();
            while (nodeIterator.hasNext()) {
                String edgeString = "";
                edgeString += "\t\t" + "source " + node + "\n";
                edgeString += "\t\t" + "target " + nodeIterator.next();
                edges += "\tedge [\n" + edgeString + "\n\t]\n";
            }
        }
*/
