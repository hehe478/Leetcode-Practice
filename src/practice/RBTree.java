package practice;

public class RBTree<E extends Comparable<E>>
        extends BinarySearchTree<E, RBTreeNode<E>> {

    @Override
    protected RBTreeNode<E> createNode(E data) {
        return new RBTreeNode<>(data);
    }

    @Override
    protected RBTreeNode<E> afterInsert(RBTreeNode<E> node) {
        return null;
    }

    @Override
    protected RBTreeNode<E> afterDelete(RBTreeNode<E> node) {
        return null;
    }
}
