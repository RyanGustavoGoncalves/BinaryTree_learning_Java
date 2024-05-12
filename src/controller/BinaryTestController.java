package controller;


import service.BinaryTreeService;

public class BinaryTestController {
    private BinaryTreeService binaryTreeService;

    public BinaryTestController(BinaryTreeService binaryTreeService) {
        this.binaryTreeService = binaryTreeService;
    }

    /**
     * Realiza testes na árvore binária.
     */
    public void runTests() {
        // Teste de inserção e travessia
        System.out.println("Teste de inserção e travessia:");
        binaryTreeService.insert(4);
        binaryTreeService.insert(2);
        binaryTreeService.insert(6);
        binaryTreeService.insert(1);
        binaryTreeService.insert(3);
        binaryTreeService.insert(5);
        binaryTreeService.insert(7);
        binaryTreeService.inOrderTraversal();

        // Teste de pesquisa
        int keyToSearch = 5;
        System.out.println("\nTeste de pesquisa:");
        if (binaryTreeService.search(keyToSearch)) {
            System.out.println("Chave " + keyToSearch + " encontrada na árvore.");
        } else {
            System.out.println("Chave " + keyToSearch + " não encontrada na árvore.");
        }

        // Teste de remoção
        int keyToRemove = 2;
        System.out.println("\nTeste de remoção:");
        try {
            binaryTreeService.remove(keyToRemove);
            System.out.println("Nó com chave " + keyToRemove + " removido com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao remover nó com chave " + keyToRemove + ": " + e.getMessage());
        }
    }
}
