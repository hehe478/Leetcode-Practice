package practice;

public class BinarySearchTree <E extends Comparable<E>> extends LinkedBinaryTree<E>{
    public BinarySearchTree(){
        super();
    }

    public void insert(E element){
        root = insertRecursive(root, element);
        size++;
    }

    private TreeNode<E> insertRecursive(TreeNode<E> node, E element){
        if(node == null) return new TreeNode<>(element);
        int compareResult = element.compareTo(node.data);
        if(compareResult < 0) node.left = insertRecursive(node.left,element);
        else if (compareResult > 0) node.right = insertRecursive(node.right,element);
        else size--;
        return node;
    }

    public boolean search(E element){
        return searchRecursive(root,element);
    }

    private boolean searchRecursive(TreeNode<E> node,E element){
        if(node == null) return false;
        int compareResult = element.compareTo(node.data);
        if(compareResult < 0) return searchRecursive(node.left,element);
        else if (compareResult > 0) return searchRecursive(node.right,element);
        else return true;
    }

    public void delete(E element){
        root = deleteRecursive(root,element);
    }

    private TreeNode<E> deleteRecursive(TreeNode<E> node, E element){
        if(node == null) return null;
        int compareResult = element.compareTo(node.data);
        if(compareResult < 0) node.left = deleteRecursive(node.left,element);
        else if (compareResult > 0) node.right = deleteRecursive(node.right,element);
        else{
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;
            E smallValue = findMin(node.right);
            node.data = smallValue;
            node.right = deleteRecursive(node.right,smallValue);
        }
        return node;
    }

    private E findMin(TreeNode<E> node){
        return node.left == null ? node.data : findMin(node.left);
    }

}