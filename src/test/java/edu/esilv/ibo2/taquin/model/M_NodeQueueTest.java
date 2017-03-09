package edu.esilv.ibo2.taquin.model;

import org.junit.Before;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Created by adrianpothuaud on 05/03/2017.
 */
public class M_NodeQueueTest {

    private PriorityQueue<M_PossibNode> myQueue;
    private M_PossibNode node1;

    @Before
    public void setUp() throws Exception {
        myQueue = new PriorityQueue<M_PossibNode>();
        node1 = new M_PossibNode(new M_Grid());
    }

    @Test
    public void nodeQueueAdd() {
        assert myQueue.isEmpty();
        myQueue.add(node1);
        assert !myQueue.isEmpty();
        assert myQueue.size() == 1;
    }

    @Test
    public void nodeQueuePoll() {
        myQueue.add(node1);
        assert myQueue.poll().equals(node1);
        assert myQueue.isEmpty();
    }

}