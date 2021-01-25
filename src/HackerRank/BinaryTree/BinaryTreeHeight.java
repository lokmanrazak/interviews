package HackerRank.BinaryTree;

public class BinaryTreeHeight {

//    public static int height(Node root) {
//
//        int leftHeight = 0;
//        int rightHeight = 0;
//
//        if (root.left != null) {
//            leftHeight = 1 + height(root.left);
//        }
//
//        if (root.right != null) {
//            rightHeight = 1 + height(root.right);
//        }
//
//        return Math.max(leftHeight, rightHeight);
//    }

    static class Node {
        int data;
        Node left;
        Node right;
    }

    int getHeight(Node root) {
        int leftHeight = 0;
        int rightHeight = 0;

        if (root.left != null) {
            leftHeight = 1 + getHeight(root.left);
        }

        if (root.right != null) {
            rightHeight = 1 + getHeight(root.right);
        }

        return Math.max(leftHeight, rightHeight);
    }
}
