package util.treesandgraphs;

import java.util.Objects;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return value == treeNode.value &&
                left.value == treeNode.left.value &&
                right.value == treeNode.right.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }
}

