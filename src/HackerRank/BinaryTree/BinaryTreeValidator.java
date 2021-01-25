package HackerRank.BinaryTree;

public class BinaryTreeValidator {

    boolean isBst(Node root) {
        return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBstUtil(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data < min || node.data > max) {
            return false;
        }

        return (isBstUtil(node.left, min, node.data - 1) &&
                isBstUtil(node.right, node.data + 1, max));
    }

    boolean isBst_nullPointer(Node root, Node left, Node right) {
        if (root == null) {
            return true;
        }

        if (left != null && root.data <= left.data) {
            return false;
        }

        if (right != null && root.data >= right.data) {
            return false;
        }

        return isBst_nullPointer(root.left, left, root) &&
                isBst_nullPointer(root.right, root, right);
    }

    // Best solution
    // Time O(n) since each node gets visited once

    boolean checkBST(Node root) {
        return checkBstUtil(root, 0, 10000);
    }

    boolean checkBstUtil(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        return checkBstUtil(root.left, min, root.data) &&
                checkBstUtil(root.right, root.data, max);
    }

    // Inorder Traversal Solution
    // Time O(n) since each node gets visited once

    class Node {
        int data;
        Node left;
        Node right;
    }
}
