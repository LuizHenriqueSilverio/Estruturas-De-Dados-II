/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heapsort;

/**
 *
 * @author luizh
 */
public class HeapSort {
   
    public static void hSort(int array[]) {
        int arraySize = array.length;
        
        // Constrói o heap máximo
        for(int i = arraySize / 2 - 1; i >= 0; i--) {
            heapify(array, arraySize, i);
        }
        
        // Extrai elementos do heap, um por um
        for(int i = arraySize - 1; i >= 0; i--) {
            // Move o elemento atual para o final do array
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // Chama heapify no heap reduzido
            heapify(array, i, 0);
        }
    }
    
   private static void heapify(int array[], int heapSize, int rootIndex) {
       int largest = rootIndex; // Inicializa o maior como o nó raiz
       int left = 2 * rootIndex + 1; // Índice do filho esquerdo
       int right = 2 * rootIndex + 2; // Índice do filho direito
       
       // Se o filho esquerdo for maior que o nó raiz
       if(left < heapSize && array[left] > array[largest]) {
           largest = left;
       }
       
       // Se o filho direito for maior que o nó raiz
       if(right < heapSize && array[right] > array[largest]) {
           largest = right;
       }
       
       // Se o maior não for o nó raiz
       if(largest != rootIndex) {
           int swap = array[rootIndex];
           array[rootIndex] = array[largest];
           array[largest] = swap;
           
           // Recursivamente heapify na subárvore afetada
           heapify(array, heapSize, largest);
       }
   }  
    
}
