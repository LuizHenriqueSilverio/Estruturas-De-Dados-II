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
public class Search {
    
    public static boolean buscaLinear(int array[], int x) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == x) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean buscaBinaria(int array[], int x) {
        int ini, fim, meio;
        ini = 0;
        fim = (array.length - 1);
        while(ini <= fim) {
            meio = (ini + fim) / 2;
            if(x == array[meio]){
                return true;
            }else if(x > array[meio]) {
                ini = meio + 1;
            }else {
                ini = meio - 1;
            }
        }
        return false;
    }
}
