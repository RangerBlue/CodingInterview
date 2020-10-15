package DataStructures;

import util.treesandgraphs.Graph;
import util.treesandgraphs.State;
import util.treesandgraphs.TreeNode;
import util.treesandgraphs.Vertex;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

    ///4.3
    public static TreeNode createMinimalBinarySearchTree(int[] input) {
        return createMinimalBinarySearchTree(input, 0, input.length - 1);
    }

    public static TreeNode createMinimalBinarySearchTree(int[] input, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(input[mid]);
        n.left = createMinimalBinarySearchTree(input, start, mid - 1);
        n.right = createMinimalBinarySearchTree(input, mid + 1, end);
        return n;
    }

    public static ArrayList<Integer> printBinaryTreeBreadthFirst(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            result.add(root.value);
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> parents = queue;
            queue = new LinkedList<>();
            for (TreeNode node : parents) {
                result.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> printBinaryTreeDepthFirst(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode current;
        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.pop();
            result.add(current.value);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }

    //4.4
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
}
