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
public class InsertionSort {
    
    private static void insert(int array[], int i) {
        int eleito = array[i];
        int comp = (i - 1);
        
        while(comp >= 0 && eleito < array[comp]) {
            array[comp + 1] = array[comp]; //deslocando
            comp--;
        }
        
        array[comp + 1] = eleito;
    }
    
    public static void iSort(int array[]) {
        for(int i = 1; i < array.length; i++) {
            insert(array, i);
        }
    }
    
    //--------------------------------------------------------------------------
    
        private static void insertComentado(int array[], int i) {
            Scanner scanner = new Scanner(System.in);
            int eleito = array[i];
            int comp = (i - 1);
            System.out.println("Eleito: " + eleito);
            scanner.nextLine();
        
            while(comp >= 0 && eleito < array[comp]) {
                System.out.println("Comparando: ");
                System.out.println("Vet["+comp+"] = " + array[comp]);
                array[comp + 1] = array[comp]; //deslocando
                comp--;
                JavaSorts.printArray(array);
                scanner.nextLine();
            }
        
            System.out.println("Inserindo eleito indice: " + (comp + 1));
            array[comp + 1] = eleito;
            JavaSorts.printArray(array);
            scanner.nextLine();
        }
    
    public static void iSortComentado(int array[]) {
        for(int i = 1; i < array.length; i++) {
            System.out.println("Fase: " + i);
            insertComentado(array, i);
        }
    }
}
