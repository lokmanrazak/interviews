package HackerRank.BinaryTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversalInOrder {

    public List<Integer> traverseInOrder(Node root) {
        List<Integer> order = new ArrayList<>();

        traverseInOrderRecurse(root, order);

        return order;
    }

    public void traverseInOrderRecurse(Node node, List<Integer> order) {
        if (node != null) {
            traverseInOrderRecurse(node.left, order);
            order.add(node.data);
            traverseInOrderRecurse(node.right, order);
        }
    }

    public static void inOrder(Node root) {
        inOderRecurse(root);
    }

    static void inOderRecurse(Node node) {
        if (node != null) {
            inOderRecurse(node.left);
            System.out.print(node.data);
            inOderRecurse(node.right);
        }
    }

    public class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public class BinaryTree {
        public Node root;

        public void insert(int data) {
            root = insert(root, data);
        }

        private Node insert(Node current, int data) {
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
    }

    @Test
    public void test() {
        BinaryTree tree = new BinaryTree();
        tree.insert(4);
        tree.insert(1);
        tree.insert(7);
        tree.insert(8);
        tree.insert(2);
        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);

        List<Integer> order = traverseInOrder(tree.root);
    }
}
