/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

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
        System.out.println("3 - SelectionSort com caracteres");
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
    
    public static void printArrayChar(char array[]) {
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

        for(int i = 0; i < array.length - 1; i++) {
            array[i] = rand.nextInt(100);
        }
        
        char[] arrayChar = new char[tam];
        int codigoAscii;
        
        for(int i = 0; i < arrayChar.length; i++) {
            codigoAscii = rand.nextInt(26) + 'a';
            arrayChar[i] = (char) codigoAscii;
        }
        
            
                
        System.out.println("Vetor original(BubbleSort): ");
        printArray(array);
        System.out.println("");
        
        BubbleSort.bSortDesc(array);
        System.out.println("Vetor ordenado(descrescente): ");
        printArray(array);
        System.out.println("");
        
        System.out.println("Vetor de caracteres: ");
        printArrayChar(arrayChar);
        System.out.println("");
        
        SelectionSortChar.sSortComentado(arrayChar);
        System.out.println("Vetor de caracteres ordenado: ");
        printArrayChar(arrayChar);
        System.out.println("");
        
        
    }
    
}
