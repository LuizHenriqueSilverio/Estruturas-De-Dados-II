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
public class BubbleSort {
    public static void bSort(int array[]) {
        int n = array.length;
        int temp;
        for(int fase = 1; fase < n; fase++) {
            for(int comp = 0; comp < n - fase; comp++) {
                if(array[comp] > array[comp + 1]) {
                    temp = array[comp];
                    array[comp] = array[comp + 1];
                    array[comp + 1] = temp;
                }
            }
        }
    }
}
