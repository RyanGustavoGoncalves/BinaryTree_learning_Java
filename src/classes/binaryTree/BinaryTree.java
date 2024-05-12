package classes.binaryTree;
import classes.node.Node;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.getData()) {
            root.setLeft(insertRec(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(insertRec(root.getRight(), data));
        }

        return root;
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private Node remove(Node root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.getData()) {
            root.setLeft(remove(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(remove(root.getRight(), data));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            root.setData(minValue(root.getRight()));
            root.setRight(remove(root.getRight(), root.getData()));
        }

        return root;
    }

    private boolean searchRec(Node root, int data) {
        if (root == null)
            return false;

        if (data == root.getData())
            return true;

        if (data < root.getData())
            return searchRec(root.getLeft(), data);

        return searchRec(root.getRight(), data);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrderRec(root.getRight());
        }
    }
}