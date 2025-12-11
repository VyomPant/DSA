package practice.trees.binarytree.btArrayImplementation;


// =============================
// Demo / Usage
// =============================
public class Runner {
    public static void main(String[] args) {

        /**
         * Insert a value into the tree using level-order insertion.
         * This does NOT keep the tree sorted; it fills the tree left-to-right at each level.
         *
         * Example insertion order: 1,2,3,4,5
         * Results in:
         *         1
         *       /   \
         *      2     3
         *     / \
         *    4   5
         */
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