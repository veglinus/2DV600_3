package lh223cc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
            g.addNodeFor(i[0]);
            g.addNodeFor(i[1]);
            Node<Integer> n2 = g.addNodeFor(i[2]);
            Node<Integer> n3 = g.getNodeFor(i[2]);
            assertSame(n2,n3);
            assertEquals(3,g.nodeCount());
            assertEquals(0,g.edgeCount());
            
            /* Add connecting edges */
            assertTrue(g.addEdgeFor(i[0],i[1]));
            assertTrue(g.addEdgeFor(i[0],i[2]));
            assertTrue(g.addEdgeFor(i[1],i[2]));
            assertEquals(3,g.nodeCount());
            assertEquals(3,g.edgeCount());
        }
		/* Add nodes */

}



