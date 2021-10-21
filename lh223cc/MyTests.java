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
            g.addNodeFor(7);
            g.addNodeFor(8);

            g.addEdgeFor(0, 1);
            g.addEdgeFor(1, 2);
            g.addEdgeFor(2, 3);
            g.addEdgeFor(3, 4);
            g.addEdgeFor(3, 5);
            g.addEdgeFor(0, 6);

            g.addEdgeFor(2, 1); // move back up one
            g.addEdgeFor(5, 0);
            g.addEdgeFor(8, 2);
            g.addEdgeFor(5, 8);
            g.addEdgeFor(8, 5);


            g.addEdgeFor(0, 7);
            g.addEdgeFor(7, 8);
            g.addEdgeFor(1, 1);

            Node<Integer> mynode = g.getNodeFor(0);

            MyBFS<Integer> bfs = new MyBFS<>();
            List<Node<Integer>> result = bfs.bfs(g, mynode);

            System.out.println("Expected:");
            System.out.println("[0, 1, 6, 7, 2, 8, 3, 4, 5]");

        }
		/* Add nodes */

}



