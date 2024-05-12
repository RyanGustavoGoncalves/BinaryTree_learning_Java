import classes.binaryTree.BinaryTree;
import controller.BinaryTestController;
import service.BinaryTreeService;

public class Main {
    public static void main(String[] args) {
        BinaryTestController binaryTestController = new BinaryTestController(new BinaryTreeService(new BinaryTree()));
        binaryTestController.runTests();
    }
}
