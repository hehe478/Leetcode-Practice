package practice;


public abstract class LinkedBinaryTree<E, N extends TreeNode<E>> {
    protected N root;
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

    public void preOrderRecursive(N node){
        if(node == null) return;
        System.out.print(node.data + "  ");
        preOrderRecursive(cast(node.left));
        preOrderRecursive(cast(node.right));
    }

    public void inOrder() {
        System.out.print("In-Order: ");
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(N node) {
        if (node == null) {
            return;
        }
        inOrderRecursive(cast(node.left));
        System.out.print(node.data + "  ");
        inOrderRecursive(cast(node.right));
    }

    public void postOrder() {
        System.out.print("Post-Order: ");
        postOrderRecursive(root);
        System.out.println();
    }

    public void postOrderRecursive(N node){
        if(node == null) return;
        postOrderRecursive(cast(node.left));
        postOrderRecursive(cast(node.right));
        System.out.print(node.data + "  ");
    }

    @SuppressWarnings("unchecked")
    public N cast(TreeNode<E> node){
        return (N)node;
    }
}
