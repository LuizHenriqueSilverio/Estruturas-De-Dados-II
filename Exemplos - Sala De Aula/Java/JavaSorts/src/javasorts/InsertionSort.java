/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasorts;

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
}
