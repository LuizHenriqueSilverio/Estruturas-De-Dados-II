/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bplustree;

/**
 *
 * @author luizh
 */
public class Node {
    int[] keys = new int[3];
    Node[] children = new Node[4];
    boolean isLeaf = true;
    int numberOfKeys = 0;
    Node next = null; // Pointer to the next leaf node

    public int getNumberOfKeys() {
        return this.numberOfKeys;
    }

    public Node[] getChildren() {
        return this.children;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
