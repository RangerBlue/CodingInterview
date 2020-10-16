import DataStructures.TreesAndGraphs;
import org.junit.Test;

import static org.junit.Assert.*;

import sun.reflect.generics.tree.Tree;
import util.treesandgraphs.Graph;
import util.treesandgraphs.TreeNode;
import util.treesandgraphs.TreeNodeWithParent;
import util.treesandgraphs.Vertex;

import java.util.*;
import java.util.stream.Collectors;

public class TreesAndGraphsTests {
    //4.1
    @Test
    public void testIsTreeBalanced() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;

        assertTrue(TreesAndGraphs.isBalanced(root));
    }

    @Test
    public void testIsTreeUnbalanced() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);
        root.left = left;
        left.left = leftLeft;
        leftLeft.left = leftRight;
        leftLeft.right = leftRight;

        assertFalse(TreesAndGraphs.isBalanced(root));
    }

    //4.2
    @Test
    public void testDoesEdgeExistBetweenTwoVertices() {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addVertex("Emma");
        graph.addEdge("Rob", "Bob");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Rob", "Maria");

        graph.addEdge("Bob", "Alice");
        graph.addEdge("Mark", "Alice");
        graph.addEdge("Alice", "Maria");


        assertTrue(TreesAndGraphs.search(graph, new Vertex("Bob"), new Vertex("Alice")));
        assertFalse(TreesAndGraphs.search(graph, new Vertex("Alice"), new Vertex("Bob")));
        assertFalse(TreesAndGraphs.search(graph, new Vertex("Bob"), new Vertex("Mark")));
    }

    //4.3
    @Test
    public void testCreateMinimalBST() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode expectedRoot = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        expectedRoot.left = node2;
        expectedRoot.right = node8;

        node2.left = node1;
        node2.right = node3;

        node3.right = node4;

        node8.left = node6;
        node8.right = node9;

        node6.right = node7;
        node9.right = node10;

        TreeNode actual = TreesAndGraphs.createMinimalBinarySearchTree(input);
        assertEquals(TreesAndGraphs.printBinaryTreeBreadthFirst(expectedRoot), TreesAndGraphs.printBinaryTreeBreadthFirst(actual));
        assertEquals(TreesAndGraphs.printBinaryTreeDepthFirst(expectedRoot), TreesAndGraphs.printBinaryTreeDepthFirst(actual));

    }

    //4.4
    @Test
    public void testCreateLevelLinkedList() {
        TreeNode expectedRoot = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        expectedRoot.left = node2;
        expectedRoot.right = node8;

        node2.left = node1;
        node2.right = node3;

        node3.right = node4;

        node8.left = node6;
        node8.right = node9;

        node6.right = node7;
        node9.right = node10;

        Integer[] level0 = {5};
        Integer[] level1 = {2, 8};
        Integer[] level2 = {1, 3, 6, 9};
        Integer[] level3 = {4, 7, 10};


        ArrayList<LinkedList<TreeNode>> result = TreesAndGraphs.createLevelLinkedList(expectedRoot);
        assertArrayEquals(level0, result.get(0).stream().map(treeNode -> treeNode.value).toArray());
        assertArrayEquals(level1, result.get(1).stream().map(treeNode -> treeNode.value).toArray());
        assertArrayEquals(level2, result.get(2).stream().map(treeNode -> treeNode.value).toArray());
        assertArrayEquals(level3, result.get(3).stream().map(treeNode -> treeNode.value).toArray());
    }

    //4.5
    @Test
    public void testIsTreeBSTSuccess() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        root.left = node2;
        root.right = node8;

        node2.left = node1;
        node2.right = node3;

        node3.right = node4;

        node8.left = node6;
        node8.right = node9;

        node6.right = node7;
        node9.right = node10;

        assertTrue(TreesAndGraphs.checkIsTreeBST(root));
    }

    @Test
    public void testIsTreeBSTFailure() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        root.left = node2;
        root.right = node8;

        node2.left = node1;
        node2.right = node3;

        node3.right = node4;

        node8.left = node6;
        node8.right = node9;

        node6.right = node7;
        node9.right = node10;

        assertFalse(TreesAndGraphs.checkIsTreeBST(root));
    }

    //4.6
    @Test
    public void testInorderSuccessor() {
        TreeNodeWithParent root = new TreeNodeWithParent(5);
        TreeNodeWithParent node1 = new TreeNodeWithParent(1);
        TreeNodeWithParent node2 = new TreeNodeWithParent(2);
        TreeNodeWithParent node3 = new TreeNodeWithParent(3);
        TreeNodeWithParent node4 = new TreeNodeWithParent(4);
        TreeNodeWithParent node6 = new TreeNodeWithParent(6);
        TreeNodeWithParent node7 = new TreeNodeWithParent(7);
        TreeNodeWithParent node8 = new TreeNodeWithParent(8);
        TreeNodeWithParent node9 = new TreeNodeWithParent(9);
        TreeNodeWithParent node10 = new TreeNodeWithParent(10);
        root.left = node2;
        node2.parent = root;

        root.right = node8;
        node8.parent = root;

        node2.left = node1;
        node1.parent = node2;
        node2.right = node3;
        node3.parent = node2;

        node3.right = node4;
        node4.parent = node3;

        node8.left = node6;
        node6.parent = node8;
        node8.right = node9;
        node9.parent = node8;

        node6.right = node7;
        node7.parent = node6;
        node9.right = node10;
        node10.parent = node9;

        assertEquals(node2, TreesAndGraphs.inorderSuccessor(node1));
        assertNotEquals(node1, TreesAndGraphs.inorderSuccessor(node1));
    }

    //4.7
    @Test
    public void testIsCommonAncestorExists() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        root.left = node2;
        root.right = node8;

        node2.left = node1;
        node2.right = node3;

        node3.right = node4;

        node8.left = node6;
        node8.right = node9;

        node6.right = node7;
        node9.right = node10;

        assertEquals(root, TreesAndGraphs.commonAncestor(root, node2, node8));
        assertEquals(node2, TreesAndGraphs.commonAncestor(root, node1, node3));
        assertEquals(node8, TreesAndGraphs.commonAncestor(root, node7, node10));
        assertNull(TreesAndGraphs.commonAncestor(root, node7, node11));
    }

    //4.8
    @Test
    public void testIsTreeSubtree() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        root.left = node2;
        root.right = node8;

        node2.left = node1;
        node2.right = node3;

        node3.right = node4;

        node8.left = node6;
        node8.right = node9;

        node6.right = node7;
        node9.right = node10;

        assertTrue(TreesAndGraphs.containsTree(root, node8));
        assertTrue(TreesAndGraphs.containsTree(root, root));
        assertTrue(TreesAndGraphs.containsTree(root, node3));
        assertFalse(TreesAndGraphs.containsTree(root, node11));
    }

    //4.9
    @Test
    public void testFindSum() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        root.left = node2;
        root.right = node8;

        node2.left = node1;
        node2.right = node3;

        node3.right = node4;

        node8.left = node6;
        node8.right = node9;

        node6.right = node7;
        node9.right = node10;

        TreesAndGraphs.findSum(root, 8);
    }
}
