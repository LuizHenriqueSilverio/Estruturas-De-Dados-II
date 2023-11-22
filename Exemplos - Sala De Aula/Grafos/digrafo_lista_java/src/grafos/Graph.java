
package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Graph {
     private Map<Integer, LinkedList<Edge>> listaAdjacencia;

    public Graph() {
        this.listaAdjacencia = new HashMap<>();
    }

    // Método para adicionar um vértice ao grafo
    public void adicionarVertice(int vertice) {
        if (!listaAdjacencia.containsKey(vertice)) {
            listaAdjacencia.put(vertice, new LinkedList<>());
        }
    }
    public void adicionarAresta(int origem, int destino, int peso) {
        if (!listaAdjacencia.containsKey(origem) || !listaAdjacencia.containsKey(destino)) {
            throw new IllegalArgumentException("Os vértices de origem e destino devem existir no grafo.");
        }

        listaAdjacencia.get(origem).add(new Edge(destino, peso));
        //listaAdjacencia.get(destino).add(new Edge(origem, weight));

    }
    
  
    public void imprimirGrafo() {
        for (Map.Entry<Integer, LinkedList<Edge>> entry : listaAdjacencia.entrySet()) {
            int vertice = entry.getKey();
            LinkedList<Edge> vizinhos = entry.getValue();
            System.out.print(vertice + " -> ");
            for (Edge vizinho : vizinhos) {
                System.out.print(vizinho.vertex+"["+vizinho.weight+"]" + " ");
            }
            System.out.println();
        }
    }
    
     public void salvarGrafo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("grafo.txt"))) {
            for (Map.Entry<Integer, LinkedList<Edge>> entry : listaAdjacencia.entrySet()) {
                int vertice = entry.getKey();
                LinkedList<Edge> vizinhos = entry.getValue();
                for (Edge vizinho : vizinhos) {
                    writer.println(vertice + " " + vizinho.vertex + " " + vizinho.weight);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar os dados do grafo de um arquivo texto
    public void carregarGrafo() {
        try (Scanner scanner = new Scanner(new File("grafo.txt"))) {
            while (scanner.hasNext()) {
                int origem = scanner.nextInt();
                int destino = scanner.nextInt();
                int peso = scanner.nextInt();

                adicionarVertice(origem);
                adicionarVertice(destino);
                adicionarAresta(origem, destino, peso);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    
  
    
}


