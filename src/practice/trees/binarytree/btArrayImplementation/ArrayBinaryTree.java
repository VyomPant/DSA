package practice.trees.binarytree.btArrayImplementation;

/**
 * Array Representation of a Binary Tree (Complete Binary Tree)
 *
 * Index Rules:
 *  - root stored at index 1
 *  - left child  = 2 * i
 *  - right child = 2 * i + 1
 *
 *  Further reading: <a href="https://www.geeksforgeeks.org/dsa/binary-tree-array-implementation/">...</a>
 */
class ArrayBinaryTree {

    int[] tree;        // Array to store tree nodes
    int size;          // Number of nodes currently in tree
    int capacity;      // Maximum possible nodes

    // Constructor to initialize tree with given capacity
    public ArrayBinaryTree(int capacity) {
        this.capacity = capacity;
        this.tree = new int[capacity + 1];   // index 0 unused
        this.size = 0;
    }

    /**
     * Insert node in level-order (like a complete tree)
     */
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Tree is full!");
            return;
        }

        size++;
        tree[size] = value;  // insert at next free spot
    }

    /**
     * Get left child of node at index i
     */
    public Integer leftChild(int i) {
        int leftIndex = 2 * i;
        if (leftIndex <= size)
            return tree[leftIndex];
        return null;
    }

    /**
     * Get right child of node at index i
     */
    public Integer rightChild(int i) {
        int rightIndex = 2 * i + 1;
        if (rightIndex <= size)
            return tree[rightIndex];
        return null;
    }

    /**
     * Preorder Traversal using array representation
     * root → left → right
     */
    public void preorder(int index) {
        if (index > size) return;

        System.out.print(tree[index] + " ");
        preorder(index * 2);       // left
        preorder(index * 2 + 1);   // right
    }

    /**
     * Inorder Traversal: left → root → right
     */
    public void inorder(int index) {
        if (index > size) return;

        inorder(index * 2);
        System.out.print(tree[index] + " ");
        inorder(index * 2 + 1);
    }

    /**
     * Postorder Traversal: left → right → root
     */
    public void postorder(int index) {
        if (index > size) return;

        postorder(index * 2);
        postorder(index * 2 + 1);
        System.out.print(tree[index] + " ");
    }

    /**
     * Level order is simply index order from 1..size
     */
    public void levelOrder() {
        for (int i = 1; i <= size; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}

