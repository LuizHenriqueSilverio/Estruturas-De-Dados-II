/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreesearch;

/**
 *
 * @author luizh
 */
public class BinarySearchTree<T extends Comparable<T>> {
    Node root = null;
    int count;
    
    public int add(T newData) {
        Node<T> newNode = new Node<T>(newData);
        count = 0;
        root = insert(root, newNode);
        return count;
    }
    
    private Node<T> insert(Node<T> root, Node<T> newNode) {
        count++;
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
    
    public T search(T dataSearch) {
        return (T) search(root, dataSearch);
    }
    
    private T search(Node<T> root, T dataSearch) {
        if(root == null) {
            return null;
        }
        
        if(root.data.equals(dataSearch)) {
            return root.data;
        }
        
        if(dataSearch.compareTo(root.data) < 0) {
            return search(root.left, dataSearch);
        }else {
            return search(root.right, dataSearch);
        }
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
    
    
    public String getStudentDataPreOrder() {
        StringBuilder studentData = new StringBuilder();
        getStudentDataPreOrder(root, studentData);
        return studentData.toString();
    }
    
    public void getStudentDataPreOrder(Node<T> root, StringBuilder studentData) {
        if(root != null) {
            studentData.append(root.data.toString() + "\n");
            getStudentDataPreOrder(root.left, studentData);
            getStudentDataPreOrder(root.right, studentData);
        }
    }
    
    /*
    
    Mostra os alunos em ordem
    
    public String getStudentDataInOrder() {
        StringBuilder studentData = new StringBuilder();
        getStudentDataInOrder(root, studentData);
        return studentData.toString();
    }

    private void getStudentDataInOrder(Node<T> root, StringBuilder studentData) {
        if (root != null) {
            getStudentDataInOrder(root.left, studentData);
            studentData.append(root.data.toString() + "\n");
            getStudentDataInOrder(root.right, studentData);
        }
    }
    */

    
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
