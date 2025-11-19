package practice;

public class AVLTree<E extends Comparable<E>> extends BinarySearchTree<E> {
    public AVLTree(){
        super();
    }

    private int getHeight(TreeNode<E> node){
        return node == null ? 0 : node.height;
    }

    private int getBalanceFactor(TreeNode<E> node){
        if(node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private void updateHeight(TreeNode<E> node){
        node.height = Math.max(getHeight(node.left),getHeight((node.right))) + 1;
    }

    private TreeNode<E> rightRotate(TreeNode<E> root){
        TreeNode<E> newRoot = root.left;
        TreeNode<E> T2 = newRoot.right;

        newRoot.right = root;
        root.left = T2;

        updateHeight(root);
        updateHeight(newRoot);

        return newRoot;
    }

    private TreeNode<E> leftRotate(TreeNode<E> root){
        TreeNode<E> newRoot = root.right;
        TreeNode<E> T3 = newRoot.left;

        newRoot.left = root;
        root.right = T3;

        updateHeight(root);
        updateHeight(newRoot);

        return newRoot;
    }

    private TreeNode<E> balance(TreeNode<E> node){
        int balanceFactor = getBalanceFactor(node);
        if(balanceFactor > 1){
            if(getBalanceFactor(node.left) < 0){
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }
        if(balanceFactor < -1){
            if(getBalanceFactor(node.right) > 0){
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }
        return node;
    }

    @Override
    protected TreeNode<E> insertRecursive(TreeNode<E> node,E element){
        if(node == null) return new TreeNode<>(element);

        int compareResult = element.compareTo(node.data);
        if(compareResult < 0) node.left = insertRecursive(node.left,element);
        else if(compareResult > 0) node.right = insertRecursive(node.right,element);
        else {
            size--;
            return node;
        }

        updateHeight(node);
        return balance(node);
    }
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        // 测试：故意按顺序插入，BST 会变成链表，AVL 应该保持平衡
        int[] inputs = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Inserting 1 to 8 sequentially...");

        for (int num : inputs) {
            avl.insert(num);
        }

        // 验证
        System.out.println("Root is: " + avl.root.data); // BST 是 1，AVL 应该是 4
        System.out.println("Tree Height: " + avl.root.height); // BST 是 8，AVL 应该是 4

        System.out.println("In-Order (Should be sorted):");
        avl.inOrder(); // 必须依然有序：1 2 3 4 5 6 7 8

        System.out.println("Level-Order / Pre-Order check:");
        avl.preOrder(); // 看一下结构，根应该是4，左边是2，右边是6...
    }
}
