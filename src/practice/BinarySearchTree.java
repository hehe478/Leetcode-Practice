package practice;

public abstract class BinarySearchTree <E extends Comparable<E>, N extends TreeNode<E>>
        extends LinkedBinaryTree<E, N>{
    public BinarySearchTree(){
        super();
    }

    protected abstract N createNode(E data);
    protected abstract N afterInsert(N node);
    protected abstract N afterDelete(N node);

    public void insert(E element){
        root = insertRecursive(root, element);
        size++;
    }

    protected N insertRecursive(N node, E element){
        if(node == null) return createNode(element);
        int compareResult = element.compareTo(node.data);
        if(compareResult < 0) node.left = insertRecursive(cast(node.left),element);
        else if (compareResult > 0) node.right = insertRecursive(cast(node.right),element);
        else size--;
        return afterInsert(node);
    }

    public boolean search(E element){
        return searchRecursive(root,element);
    }

    private boolean searchRecursive(N node,E element){
        if(node == null) return false;
        int compareResult = element.compareTo(node.data);
        if(compareResult < 0) return searchRecursive(cast(node.left),element);
        else if (compareResult > 0) return searchRecursive(cast(node.right),element);
        else return true;
    }

    public void delete(E element){
        root = deleteRecursive(cast(root),element);
    }

    protected N deleteRecursive(N node, E element){
        if(node == null) return null;
        int compareResult = element.compareTo(node.data);
        if(compareResult < 0) node.left = deleteRecursive(cast(node.left),element);
        else if (compareResult > 0) node.right = deleteRecursive(cast(node.right),element);
        else{
            if(node.left == null) return cast(node.right);
            if(node.right == null) return cast(node.left);
            E smallValue = findMin(node.right);
            node.data = smallValue;
            node.right = deleteRecursive(cast(node.right),smallValue);
        }
        return afterDelete(node);
    }

    private E findMin(TreeNode<E> node){
        return node.left == null ? node.data : findMin(node.left);
    }

}