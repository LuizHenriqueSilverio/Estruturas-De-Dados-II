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
public class JavaSorts {
    
    public static int menuEntrada() {
        int op;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Gerar Dados");
        System.out.println("2 - Entrar com Dados");
        op = scanner.nextInt();
        return op;
    }
    
    public static int menuBusca() {
        int op;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Busca Linear");
        System.out.println("2 - Busca Binária");
        op = scanner.nextInt();
        return op;
    }
    
    public static int menuSort() {
        int op;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Algoritmo de ordenação: ");
        System.out.println("1 - BubbleSort");
        System.out.println("2 - SelectionSort");
        System.out.println("3 - InsertionSort");
        System.out.println("4 - Comparar algoritmos");
        op = scanner.nextInt();
        return op;
    }
    
    public static void printArray(int array[]) {
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " | ");
        }
    }
    
    public static void printIntervalo(int array[], int ini, int fim) {
        for(int i = ini; i <= fim; i++){
            System.out.print(array[i] + " | ");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int tam;
        double tempoInicial, tempoFinal;
        
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
            default:
                System.out.println("Opcao invalida!");
                break;
        }
        
        op = menuSort();
        
        System.out.println("Vetor original: ");
        printArray(array);
        System.out.println("");
        
        switch(op) {
            case 1:
                tempoInicial = System.currentTimeMillis();
                BubbleSort.bSort(array);
                //BubbleSort.bSortComentado(array);
                tempoFinal = System.currentTimeMillis();
                System.out.println("Comparacoes: " + BubbleSort.compara);
                System.out.println("Trocas: " + BubbleSort.trocas);
                System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms");
                break;
            case 2:
                SelectionSort.sSortComentado(array);
                break;
            case 3:
                InsertionSort.iSortComentado(array);
                break;
            case 4:
                int[] array2 = array.clone();
                int[] array3 = array.clone();
                
                tempoInicial = System.currentTimeMillis();
                BubbleSort.bSort(array);
                tempoFinal = System.currentTimeMillis();
                System.out.println("Comparacoes: " + BubbleSort.compara);
                System.out.println("Trocas: " + BubbleSort.trocas);
                System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms");
                System.out.println("");
                
                tempoInicial = System.currentTimeMillis();
                SelectionSort.sSort(array2);
                tempoFinal = System.currentTimeMillis();
                System.out.println("Comparacoes: " + SelectionSort.compara);
                System.out.println("Trocas: " + SelectionSort.troca);
                System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms");
                System.out.println("");
                
                tempoInicial = System.currentTimeMillis();
                InsertionSort.iSort(array3);
                tempoFinal = System.currentTimeMillis();
                System.out.println("Comparacoes: " + InsertionSort.compara);
                System.out.println("Deslocamentos: " + InsertionSort.deslocamento);
                System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms");
                System.out.println("");
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
        }
        
        System.out.println("Vetor ordenado: ");
        printArray(array);
        
    }
    
}
