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
public class Search {
    
    public static int compLinear = 0, compBinaria = 0;
    
    public static boolean buscaLinear(int array[], int x) {
        compLinear = 0;
        for(int i = 0; i < array.length; i++) {
            compLinear++;
            if(array[i] == x) {
                return true;
            }
        }
        compLinear = 0;
        return false;
    }
    
    public static boolean buscaBinaria(int array[], int x) {
        int ini, fim, meio;
        ini = 0;
        fim = (array.length - 1);
        compBinaria = 0;
        while(ini <= fim) {
            meio = (ini + fim) / 2;
            compBinaria++;
            if(x == array[meio]){
                return true;
            }else if(x > array[meio]) {
                ini = meio + 1;
            }else {
                fim = meio - 1;
            }
        }
        return false;
    }
    
    //--------------------------------------------------------------------------
    
    public static boolean buscaBinariaComentada(int array[], int x) {
        int ini, fim, meio;
        ini = 0;
        fim = (array.length - 1);
        Scanner scanner = new Scanner(System.in);
        compBinaria = 0;
        while(ini <= fim) {
            meio = (ini + fim) / 2;
            System.out.println("Ini: " + ini + ", Fim: " + fim + ", Meio: " + meio);
            JavaSorts.printIntervalo(array, ini, fim);
            compBinaria++;
            System.out.println("Comparando com: " + array[meio]);
            scanner.nextLine();
            if(x == array[meio]){
                return true;
            }else if(x > array[meio]) {
                ini = meio + 1;
            }else {
                fim = meio - 1;
            }
        }
        return false;
    }
    
}
