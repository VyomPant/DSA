package practice.trees.binarytree.btArrayImplementation;


// =============================
// Demo / Usage
// =============================
public class Runner {
    public static void main(String[] args) {

        ArrayBinaryTree tree = new ArrayBinaryTree(10);

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        System.out.println("Preorder:");
        tree.preorder(1);

        System.out.println("\nInorder:");
        tree.inorder(1);

        System.out.println("\nPostorder:");
        tree.postorder(1);

        System.out.println("\nLevel Order:");
        tree.levelOrder();
    }
}