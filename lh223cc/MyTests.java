package lh223cc;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MyTests {

    MyGraph<Integer> mygraph = new MyGraph<Integer>();
    
    @Test
    public void Test1() {
        mygraph.addNodeFor(1);
        mygraph.addNodeFor(2);

        Assertions.assertEquals(2, mygraph.nodeCount());
    }
}
