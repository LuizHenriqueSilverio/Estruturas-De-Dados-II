#include <stdio.h>
#include <stdlib.h>

void mostraVetor(int v[], int tam) {
    for(int i = 0; i < tam; i++) {
        printf("%d |", v[i]);
    }
}

void bSort(int v[], int tam) {
    int temp;

    for(int fase = 1; fase < tam; fase++) {
        int trocaFase = 0;
        printf("Fase: %d\n", fase);
        mostraVetor(v, tam);
        getchar();

        for(int comp = 0; comp < tam - fase; comp++){
            printf("Comparando: %d e %d\n", v[comp], v[comp + 1]);
            if(v[comp] > v[comp + 1]) {
                temp = v[comp];
                v[comp] = v[comp + 1];
                v[comp + 1] = temp;
                trocaFase = 1;
            }
        }

        if(trocaFase == 0) {
            return;
        }
    }
}

int main() {
    int vet[10];
    

    for(int i = 0; i < 10; i++) {
        vet[i] = rand()%20;
    }

    printf("Array original:\n");
    mostraVetor(vet, 10);
    printf("\n");

    bSort(vet, 10);

    printf("Array ordenado:\n");
    mostraVetor(vet, 10);
    getchar();

    return 0;
}