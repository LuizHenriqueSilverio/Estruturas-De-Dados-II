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
        Random rand = new Random();
        int tam;
        
        System.out.println("Tamanho do vetor: ");
        tam = scanner.nextInt();
        int[] array = new int[tam];
        
        int op = menuEntrada();
        
        switch(op){
            case 1:
                for(int i = 0; i < array.length - 1; i++) {
                    array[i] = rand.nextInt(100);
                }
                break;
            case 2:
                System.out.println("Dados vetor: ");
                for(int i = 0; i < array.length - 15; i++) {
                    array[i] = scanner.nextInt();
                }
                break;
        }
        
        System.out.println("Vetor original: ");
        printArray(array);
        System.out.println("");
        
        // BubbleSort.bSortComentado(array);
        // BubbleSort.bSortDesc(array);
        //SelectionSort.sSort(array);
        
        SelectionSort.sSortComentado(array);
        
        System.out.println("Vetor ordenado: ");
        printArray(array);
        
    }
    
}
