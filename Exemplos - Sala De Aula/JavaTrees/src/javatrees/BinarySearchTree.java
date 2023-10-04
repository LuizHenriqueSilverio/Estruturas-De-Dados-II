/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatrees;

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
        return newNode;
    }
}
