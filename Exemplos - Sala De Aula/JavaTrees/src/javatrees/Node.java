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
public class Node<T extends Comparable<T>> {
    T data;
    Node<T> left, right;
    
    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
