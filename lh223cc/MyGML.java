package lh223cc;

import graphs.DirectedGraph;
import graphs.GML;

public class MyGML<E> extends GML<E> {

    public MyGML(DirectedGraph<E> input) {
        super(input);
    }

    @Override
    public String toGML() {
        String result;

        String prefix = "graph [";
        String suffix = "\n]";



        return result;
    }
}
