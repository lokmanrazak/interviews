package HackerRank.BinaryTree;

public class BinaryTreeTraversalPostOrder {

    public static void postOrder(Node root) {
        postOrderRecurse(root);
    }

    static void postOrderRecurse(Node node) {
        if (node != null) {
            postOrderRecurse(node.left);
            postOrderRecurse(node.right);
            System.out.print(node.data + " ");
        }
    }

    public class Node {
        public int data;
        public Node left;
        public Node right;
    }
}
