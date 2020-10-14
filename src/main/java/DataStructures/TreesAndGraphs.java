package DataStructures;

import util.treesandgraphs.Graph;
import util.treesandgraphs.State;
import util.treesandgraphs.TreeNode;
import util.treesandgraphs.Vertex;

import java.util.LinkedList;

public class TreesAndGraphs {
    //4.1
    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (checkHeight(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    //4.2
    public static boolean search(Graph graph, Vertex start, Vertex end) {
        if (start.equals(end)) {
            return true;
        }

        LinkedList<Vertex> vertexList = new LinkedList<>();
        for (Vertex v : graph.getVertices()) {
            v.setState(State.Unvisited);
        }

        start.setState(State.Visiting);
        vertexList.add(start);
        Vertex temp;
        while (!vertexList.isEmpty()) {
            temp = vertexList.removeFirst();
            if (temp != null) {
                for (Vertex v : graph.getAdjVertices(temp.getLabel())) {
                    if (v.getState() == State.Unvisited) {
                        if (v.equals(end)) {
                            return true;
                        } else {
                            v.setState(State.Visiting);
                            vertexList.add(v);
                        }
                    }
                }
                temp.setState(State.Visited);
            }
        }
        return false;
    }
}
