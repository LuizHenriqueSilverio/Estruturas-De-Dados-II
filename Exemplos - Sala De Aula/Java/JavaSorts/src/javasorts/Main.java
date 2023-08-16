/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasorts;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author luizh
 */
public class Main {
    
    public static int menuEntrada() {
        int op;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Gerar Dados");
        System.out.println("2 - Entrar com Dados");
        op = scanner.nextInt();
        return op;
    }
    
    public static void printArray(int array[]) {
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " | ");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Random rand = new Random();
        int tam;
        
        System.out.println("Tamanho do vetor: ");
        tam = scanner.nextInt();
        int[] vetor = new int[tam];
        
        int op = menuEntrada();
        
        switch(op){
            case 1:
                System.out.println("Dados vetor: ");
                for(int i = 0; i < vetor.length; i++) {
                    vetor[i] = scanner.nextInt();
                }
                break;
            
                
        }
        
        System.out.println("Vetor original: ");
        printArray(vetor);
        
        /* 
        System.out.println("");
        BubbleSort.bSortComentado(vetor);
        System.out.println("Vetor ordenado: ");
        printArray(vetor);
        */

        /*
        System.out.println("");
        BubbleSort.bSortDesc(vetor);
        System.out.println("Vetor ordenado: ");
        printArray(vetor);
        */
    }
    
}
