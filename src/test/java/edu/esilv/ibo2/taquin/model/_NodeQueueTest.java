package edu.esilv.ibo2.taquin.model;

import org.junit.Before;
import org.junit.Test;

import java.util.PriorityQueue;

public class _NodeQueueTest {

    private PriorityQueue<Node> myQueue;
    private Node node1;

    @Before
    public void setUp() throws Exception {
        myQueue = new PriorityQueue<Node>();
        node1 = new Node(new Grid());
    }

    @Test
    public void nodeQueueAdd() {
        assert myQueue.isEmpty();
        myQueue.add(node1);
        assert !myQueue.isEmpty();
        assert myQueue.size() == 1;
        myQueue.add(new Node(new Grid()));
    }

    @Test
    public void nodeQueuePoll() {
        myQueue.add(node1);
        Node node2 = new Node(new Grid());
        myQueue.add(node2);
        assert myQueue.poll().equals(node1);
        assert myQueue.isEmpty();
    }
}