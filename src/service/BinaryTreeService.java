package service;

import classes.binaryTree.BinaryTree;

public class BinaryTreeService {
    private BinaryTree binaryTree;

    public BinaryTreeService(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    /**
     * Insere um valor na árvore binária.
     * @param data O valor a ser inserido.
     */
    public void insert(int data) {
        binaryTree.insert(data);
    }

    /**
     * Realiza uma travessia em ordem na árvore binária e imprime os valores.
     */
    public void inOrderTraversal() {
        System.out.println("Travessia em ordem:");
        binaryTree.inOrder();
    }

    /**
     * Verifica se um valor está presente na árvore binária.
     * @param data O valor a ser procurado.
     * @return true se o valor estiver presente, false caso contrário.
     */
    public boolean search(int data) {
        return binaryTree.search(data);
    }

    /**
     * Remove um valor da árvore binária.
     * @param data O valor a ser removido.
     * @throws IllegalArgumentException Se o valor não estiver presente na árvore.
     */
    public void remove(int data) {
        if (!binaryTree.search(data)) {
            throw new IllegalArgumentException("Valor " + data + " não encontrado na árvore.");
        }
        binaryTree.remove(data);
    }
}
