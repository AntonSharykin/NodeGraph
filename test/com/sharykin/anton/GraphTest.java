package com.sharykin.anton;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void walkGraph() {
        GNode gNode = new Graph("test");
        Assert.assertNotNull(((Graph) gNode).walkGraph(gNode));
    }

    @Test
    public void paths() {
        GNode gNode = new Graph("test");
        Assert.assertNotNull(((Graph) gNode).paths(gNode));
    }

    @Test
    public void getChildren() {
        GNode gNode = new Graph("test");
        Assert.assertNotNull(gNode.getChildren());
    }
}