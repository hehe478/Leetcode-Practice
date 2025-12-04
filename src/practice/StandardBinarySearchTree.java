package practice;

public class StandardBinarySearchTree<E extends Comparable<E>>
        extends BinarySearchTree<E, TreeNode<E>>{

    @Override
    protected TreeNode<E> createNode(E data) {
        return new TreeNode<>(data);
    }

    @Override
    protected TreeNode<E> afterInsert(TreeNode<E> node) {
        return node;
    }

    @Override
    protected TreeNode<E> afterDelete(TreeNode<E> node) {
        return node;
    }
}
