/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heapsort;

/**
 *
 * @author luizh
 */
public class Heapsort {
    
   private void heapify(int array[], int n, int i) {
       int largest = i;
       int left = (2 * i) + 1;
       int right = (2 * i) + 2;
       
       if(left < n && array[left] > array[largest]) {
           largest = left;
       }
       
       if(right < n && array[right] > array[largest]) {
           largest = right;
       }
       
       if(largest != i) {
           int swap = array[i];
           array[i] = array[largest];
           array[largest] = swap;
           
           // Recursively heapify the affected sub-tree
           heapify(array, n, largest);
       }
   }
    
    public void hSort(int array[]) {
        int n = array.length;
        
        for(int i = (n / 2) - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        
        for(int i = (n - 1); i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, n, i);
        }
    }
    
}
