import DataStructures.TreesAndGraphs;
import org.junit.Test;

import static org.junit.Assert.*;

import sun.reflect.generics.tree.Tree;
import util.treesandgraphs.Graph;
import util.treesandgraphs.TreeNode;
import util.treesandgraphs.Vertex;

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
}
