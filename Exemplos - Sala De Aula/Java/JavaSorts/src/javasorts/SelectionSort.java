/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasorts;

import java.util.Scanner;

/**
 *
 * @author luizh
 */
public class SelectionSort {
    
    private static int indexMinArray(int array[], int posAtual) {
        int k = posAtual;
        int tam = array.length;
        for(int i = posAtual + 1; i < tam; i++) {
            if(array[i] < array[k]) {
                k = i;
            }
        }
        return k;
    }
    
    public static void sSort(int array[]) {
        int tam = array.length;
        for(int i = 0; i < tam - 1; i++) {
            int k = indexMinArray(array, i);
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }
    }
    
    public static void sSortComentado(int array[]) {
        int tam = array.length;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < tam - 1; i++) {
            System.out.println("Fase: " + (i + 1));
            int k = indexMinArray(array, i);
            System.out.println("Atual: " + array[i] + ", trocando com menor valor: " + array[k]);
            scanner.nextLine();
            
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
            
            JavaSorts.printArray(array);
            scanner.nextLine();
        }
    }
}
