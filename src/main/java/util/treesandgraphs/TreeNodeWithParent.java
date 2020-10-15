package util.treesandgraphs;


import java.util.Objects;

public class TreeNodeWithParent {
    int value;
    public TreeNodeWithParent parent;
    public TreeNodeWithParent left;
    public TreeNodeWithParent right;

    public TreeNodeWithParent(int value) {
        this.value = value;
        right = null;
        left = null;
        parent = null;
    }

    public TreeNodeWithParent(int value, TreeNodeWithParent parent) {
        this(value);
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNodeWithParent treeNode = (TreeNodeWithParent) o;
        return value == treeNode.value &&
                left.value == treeNode.left.value &&
                right.value == treeNode.right.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }

}
