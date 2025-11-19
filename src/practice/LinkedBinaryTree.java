package practice;

public abstract class LinkedBinaryTree<E> {
    protected TreeNode<E> root;
    protected int size;

    public LinkedBinaryTree(){
        this.root = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void preOrder(){
        System.out.print("Pre-Order:");
        preOrderRecursive(root);
        System.out.println();
    }

    public void preOrderRecursive(TreeNode<E> node){
        if(node == null) return;
        System.out.print(node.data + "  ");
        preOrderRecursive(node.left);
        preOrderRecursive(node.right);
    }

    public void inOrder() {
        System.out.print("In-Order: ");
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(TreeNode<E> node) {
        if (node == null) {
            return;
        }
        inOrderRecursive(node.left);
        System.out.print(node.data + "  ");
        inOrderRecursive(node.right);
    }

    public void postOrder() {
        System.out.print("Post-Order: ");
        postOrderRecursive(root);
        System.out.println();
    }

    public void postOrderRecursive(TreeNode<E> node){
        if(node == null) return;
        postOrderRecursive(node.left);
        postOrderRecursive(node.right);
        System.out.print(node.data + "  ");
    }
}
