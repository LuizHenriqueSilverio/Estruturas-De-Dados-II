/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryform;

/**
 *
 * @author luizh
 */
public class BinarySearchTree<T extends Comparable<T>> {
    Node root = null;
    
    public void add(T newData) {
        Node<T> newNode = new Node<T>(newData);
        root = insert(root, newNode);
    }
    
    private Node<T> insert(Node<T> root, Node<T> newNode) {
        if(root == null) {
            return newNode;
        }
        
        if(newNode.data.compareTo(root.data) > 0) {
            root.right = insert(root.right, newNode);
        }else {
            root.left = insert(root.left, newNode);
        }
        
        return root; //retorna a raiz atualizada.
    }
    
    public void preOrder() {
        preOrder(root);
    }
    
    private void preOrder(Node<T> root) {
        if(root != null) {
            System.out.print(root.data + ", ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    public void inOrder() {
        inOrder(root);
    }
    
    private void inOrder(Node<T> root) {
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data + ", ");
            inOrder(root.right);
        }
    }
    
    public void postOrder() {
        postOrder(root);
    }
    
    private void postOrder(Node<T> root) {
        if(root != null) {
            postOrder(root.right);
            postOrder(root.left);
            System.out.print(root.data + ", ");
        }
    }
}
