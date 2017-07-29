package com.kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.kata.Kata.Node;

public class KataTest {

    Kata kata;

    @Before
    public void setup() {
        kata = new Kata();
    }

    @Test
    public void testWithOnlyOneLeftOneRightShouldWork() {

        Node LefNode = new Node().withValue("a");
        Node rightNode = new Node().withValue("a");

        Node root = new Node().withRoot(true).withNodeLeft(LefNode).withNodeRight(rightNode);

        assertTrue(kata.isMirror(root));

    }

    @Test
    public void testWithOnlyOneLeftOneRightShouldFail() {

        Node LefNode = new Node().withValue("a");
        Node rightNode = new Node().withValue("b");

        Node root = new Node().withRoot(true).withNodeLeft(LefNode).withNodeRight(rightNode);

        assertFalse(kata.isMirror(root));

    }

    @Test
    public void testWithMultipleOnlyOneLeftOneRightShouldWork() {

        Node LefNode0 = new Node().withValue("c");
        Node rightNode0 = new Node().withValue("d");
        Node LefNode1 = new Node().withValue("b").withNodeLeft(LefNode0).withNodeRight(rightNode0);
        Node RightNode1 = new Node().withValue("b").withNodeLeft(LefNode0).withNodeRight(rightNode0);

        Node root = new Node().withValue("a").withRoot(true).withNodeLeft(LefNode1).withNodeRight(RightNode1);

        assertTrue(kata.isMirror(root));

    }


    @Test
    public void testWithMultipleOnlyOneLeftOneRightShouldFail() {

        Node LefNode0A = new Node().withValue("d");

        Node LefNode0 = new Node().withValue("c");
        Node rightNode0 = new Node().withValue("d");
        Node LefNode1 = new Node().withValue("b").withNodeLeft(LefNode0A).withNodeRight(rightNode0);
        Node RightNode1 = new Node().withValue("b").withNodeLeft(LefNode0).withNodeRight(rightNode0);

        Node root = new Node().withValue("a").withRoot(true).withNodeLeft(LefNode1).withNodeRight(RightNode1);

        assertFalse(kata.isMirror(root));

    }
}
