package practice;

public class AVLTree<E extends Comparable<E>> extends BinarySearchTree<E, AVLTreeNode<E>> {
    public AVLTree(){
        super();
    }

    @Override
    protected AVLTreeNode<E> createNode(E data) {
        return new AVLTreeNode<>(data);
    }

    private int getHeight(AVLTreeNode<E> node){
        return node == null ? 0 : node.height;
    }

    private int getBalanceFactor(AVLTreeNode<E> node){
        if(node == null) return 0;
        return getHeight(cast(node.left)) - getHeight(cast(node.right));
    }

    private void updateHeight(AVLTreeNode<E> node){
        node.height = Math.max(getHeight(cast(node.left)),getHeight(cast(node.right))) + 1;
    }

    private AVLTreeNode<E> rightRotate(AVLTreeNode<E> root){
        AVLTreeNode<E> newRoot = cast(root.left);
        AVLTreeNode<E> T2 = cast(newRoot.right);

        newRoot.right = root;
        root.left = T2;

        updateHeight(root);
        updateHeight(newRoot);

        return newRoot;
    }

    private AVLTreeNode<E> leftRotate(AVLTreeNode<E> root){
        AVLTreeNode<E> newRoot = cast(root.right);
        AVLTreeNode<E> T3 = cast(newRoot.left);

        newRoot.left = root;
        root.right = T3;

        updateHeight(root);
        updateHeight(newRoot);

        return newRoot;
    }

    private AVLTreeNode<E> balance(AVLTreeNode<E> node){
        int balanceFactor = getBalanceFactor(node);
        if(balanceFactor > 1){
            if(getBalanceFactor(cast(node.left)) < 0){
                node.left = leftRotate(cast(node.left));
            }
            return rightRotate(node);
        }
        if(balanceFactor < -1){
            if(getBalanceFactor(cast(node.right)) > 0){
                node.right = rightRotate(cast(node.right));
            }
            return leftRotate(node);
        }
        return node;
    }

    @Override
    protected AVLTreeNode<E> afterInsert(AVLTreeNode<E> node){
        updateHeight(node);
        return balance(node);
    }

    @Override
    protected AVLTreeNode<E> afterDelete(AVLTreeNode<E> node){
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
