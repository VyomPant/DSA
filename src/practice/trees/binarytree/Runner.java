package practice.trees.binarytree;

// =============================
// Example Usage
// =============================
public class Runner {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

        // Build a simple tree
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);

        System.out.println("Preorder:");
        bt.preorder(bt.root);

        System.out.println("\nInorder:");
        bt.inorder(bt.root);

        System.out.println("\nPostorder:");
        bt.postorder(bt.root);

        System.out.println("\nLevel Order:");
        bt.levelOrder(bt.root);
    }
}

