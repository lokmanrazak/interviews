package HackerRank.BinaryTree;

public class BinaryTreeInsertion {

    public Node insert(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (current.data > data) {
            current.left = insert(current.left, data);
        }

        if (current.data < data) {
            current.right = insert(current.right, data);
        }

        return current;
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
