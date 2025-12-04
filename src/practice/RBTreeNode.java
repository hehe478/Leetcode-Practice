package practice;

public class RBTreeNode<E> extends TreeNode<E>{
    boolean isRed = true;

    public RBTreeNode(E data){
        super(data);
    }
}
