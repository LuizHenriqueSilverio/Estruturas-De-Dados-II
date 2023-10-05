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
public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(new Aluno(30, "Luiz"));
        tree.add(new Aluno(10, "Athos"));
        tree.add(new Aluno(25, "Gabriel"));
        tree.add(new Aluno(40, "Guilherme"));
        tree.add(new Aluno(50, "Gustavo"));
        /*tree.add(30);
        tree.add(10);
        tree.add(50);
        tree.add(40);
        tree.add(45);
        */
        
        tree.preOrder();
        System.out.println("");
        tree.inOrder();
        System.out.println("");
        tree.postOrder();
    }
}
