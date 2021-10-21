package lh223cc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import graphs.Node;

public class MyTests {

        MyGraph<Integer> g = new MyGraph<Integer>();
        Integer[] i = new Integer[50000];
		
        @Test
        public void test1() {

            g.addNodeFor(0);
            g.addNodeFor(1);
            g.addNodeFor(2);
            g.addNodeFor(3);
            g.addNodeFor(4);
            g.addNodeFor(5);
            g.addNodeFor(6);

            g.addEdgeFor(0, 1);
            g.addEdgeFor(1, 2);
            g.addEdgeFor(2, 3);
            g.addEdgeFor(3, 4);
            g.addEdgeFor(3, 5);
            g.addEdgeFor(0, 6);

            Node<Integer> mynode = g.getNodeFor(0);

            MyDFS<Integer> dfs = new MyDFS<>();
            List<Node<Integer>> result = dfs.dfs(g, mynode);

            System.out.println(result);

        }
		/* Add nodes */

}



