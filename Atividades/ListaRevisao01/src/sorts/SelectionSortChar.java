/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

import java.util.Scanner;

/**
 *
 * @author luizh
 */
public class SelectionSortChar {
    
    public static long compara = 0, troca = 0;
    
    private static int indexMinArray(char array[], int posAtual) {
        int k = posAtual;
        int tam = array.length;
        for(int i = posAtual + 1; i < tam; i++) {
            compara++;
            if(array[i] < array[k]) {
                k = i;
            }
        }
        return k;
    }
    
    public static void sSort(char array[]) {
        int tam = array.length;
        for(int i = 0; i < tam - 1; i++) {
            int k = indexMinArray(array, i);
            troca++;
            char temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }
    }
    
    public static void sSortComentado(char array[]) {
        int tam = array.length;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < tam - 1; i++) {
            System.out.println("Fase: " + (i + 1));
            int k = indexMinArray(array, i);
            System.out.println("Atual: " + array[i] + ", trocando com menor valor: " + array[k]);
            scanner.nextLine();
            
            char temp = array[i];
            array[i] = array[k];
            array[k] = temp;
            
            JavaSorts.printArrayChar(array);
            scanner.nextLine();
        }
    }
}
