/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bplustree;

/**
 *
 * @author luizh
 */
public class Main {
    public static void main(String[] args) {
        BPlusTree tree = new BPlusTree();
        
        tree.insert(12);
        tree.insert(5);
        tree.insert(7);
        tree.insert(10);
        tree.insert(3);
        
        tree.print();
        
        System.out.println(tree.search(12));
    }
}
