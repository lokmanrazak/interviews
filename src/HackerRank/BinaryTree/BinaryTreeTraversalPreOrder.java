package HackerRank.BinaryTree;

public class BinaryTreeTraversalPreOrder {

    public static void preOrder(Node root) {
        preOrderRecurse(root);
    }

    static void preOrderRecurse(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRecurse(node.left);
            preOrderRecurse(node.right);
        }
    }

    public class Node {
        public int data;
        public Node left;
        public Node right;
    }
}
