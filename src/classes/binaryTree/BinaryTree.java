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

    public Node remove(Node root, int data) {
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

            // Encontre o menor valor na subárvore direita para substituir o valor do nó atual
            root.setData(minValue(root.getRight()));

            // Remova o nó com o menor valor da subárvore direita
            root.setRight(remove(root.getRight(), root.getData()));
        }

        return root;
    }

    // Método auxiliar para encontrar o menor valor na subárvore
    private int minValue(Node root) {
        int minValue = root.getData();
        while (root.getLeft() != null) {
            minValue = root.getLeft().getData();
            root = root.getLeft();
        }
        return minValue;
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

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}