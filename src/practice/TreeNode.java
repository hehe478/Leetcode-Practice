package practice;

public class TreeNode<E> {
    public E data;
    public TreeNode<E> left;
    public TreeNode<E> right;
    public int height = 1;

    public TreeNode(E data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
