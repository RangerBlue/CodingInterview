package datastructures;

import util.treesandgraphs.*;

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

    //4.5
    public static boolean checkIsTreeBST(TreeNode n) {
        return checkIsTreeBST(n, null, null);
    }

    public static boolean checkIsTreeBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }

        if ((min != null && n.value <= min) || (max != null && n.value > max)) {
            return false;
        }

        if (!checkIsTreeBST(n.left, min, n.value) || !checkIsTreeBST(n.right, n.value, max)) {
            return false;
        }

        return true;
    }

    //4.6
    public static TreeNodeWithParent leftMostChild(TreeNodeWithParent n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }

        return n;
    }

    public static TreeNodeWithParent inorderSuccessor(TreeNodeWithParent n) {
        if (n == null) {
            return null;
        }
        if (n.right != null) {
            return leftMostChild(n.right);
        }
        TreeNodeWithParent q = n;
        TreeNodeWithParent x = q.parent;
        while (x != null && x.left != q) {
            q = x;
            x = x.parent;
        }
        return x;
    }

    //4.7
    public static boolean isNodeChildOfRoot(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return isNodeChildOfRoot(root.left, p) || isNodeChildOfRoot(root.right, p);
    }

    public static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if ((root == p) || (root == q)) {
            return root;
        }

        boolean isPOnTheLeft = isNodeChildOfRoot(root.left, p);
        boolean isQOnTheLeft = isNodeChildOfRoot(root.left, q);

        if (isPOnTheLeft != isQOnTheLeft) {
            return root;
        }

        TreeNode childSide = isPOnTheLeft ? root.left : root.right;
        return commonAncestorHelper(childSide, p, q);
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!isNodeChildOfRoot(root, p) || !isNodeChildOfRoot(root, q)) {
            return null;
        }

        return commonAncestorHelper(root, p, q);
    }

    //4.8
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        return subTree(t1, t2);
    }

    public static boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false;
        }
        if (r1.value == r2.value) {
            if (matchTree(r1, r2)) {
                return true;
            }
        }
        return (subTree(r1.left, r2) || subTree(r1.right, r2));
    }

    public static boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r2 == null && r1 == null) {
            return true;
        }

        if (r1 == null || r2 == null) {
            return false;
        }

        if (r1.value != r2.value) {
            return false;
        }

        return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
    }

    //4.9
    public static void findSum(TreeNode node, int sum, int[] path, int level) {
        if (node == null) {
            return;
        }

        path[level] = node.value;
        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += path[i];
            if (t == sum) {
                print(path, i, level);
            }
        }

        findSum(node.left, sum, path, level + 1);
        findSum(node.right, sum, path, level + 1);

        path[level] = Integer.MIN_VALUE;
    }

    public static void findSum(TreeNode node, int sum) {
        int depth = depth(node);
        int[] path = new int[depth];
        findSum(node, sum, path, 0);
    }

    public static void print(int[] path, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(path[i] + " ");
        }
        System.out.println();
    }

    public static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }
}
