package HackerRank.BinaryTree;

public class BinaryTreeSearch {

    public boolean search(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        }

        if (root.data > data) {
            return search(root.left, data);
        }

        if (root.data < data) {
            return search(root.right, data);
        }

        return false;
    }

    public class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
