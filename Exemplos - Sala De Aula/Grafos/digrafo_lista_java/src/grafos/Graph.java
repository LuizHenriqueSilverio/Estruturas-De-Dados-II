
package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class DistanceComparator implements Comparator<Node> {
    public int compare(Node n1, Node n2) {
        return Integer.compare(n1.distance, n2.distance);
    }
}

public class Graph {
     private Map<Integer, LinkedList<Edge>> myGraph;
     private ArrayList visited;

    public Graph() {
        this.myGraph = new HashMap<>();
    }

    // Método para adicionar um vértice ao grafo
    public void adicionarVertice(int vertice) {
        if (!myGraph.containsKey(vertice)) {
            myGraph.put(vertice, new LinkedList<>());
        }
    }
    public void adicionarAresta(int origem, int destino, int peso) {
        if (!myGraph.containsKey(origem) || !myGraph.containsKey(destino)) {
            throw new IllegalArgumentException("Os vértices de origem e destino devem existir no grafo.");
        }

        myGraph.get(origem).add(new Edge(destino, peso));
        //listaAdjacencia.get(destino).add(new Edge(origem, weight));

    }
    
    public boolean reach(int origin, int destination) {
        Set<Integer> visited = new HashSet<>();        
        return pathExists(origin, destination, visited);
    }
    
    private boolean pathExists(int currentVertex, int destination, Set<Integer> visited) {
        if(currentVertex == destination) {
            System.out.println("Conexoes: " + visited);
            return true;
        }
        visited.add(currentVertex);
        LinkedList<Edge> adjacencies = myGraph.get(currentVertex);
        if(adjacencies != null) {
            for(Edge adjacent : adjacencies) {
                if(!visited.contains(adjacent.vertex) && pathExists(currentVertex, destination, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public ArrayList depthSearch(int origin) {
        visited = new ArrayList();
        exploreDFS(origin);
        return visited;
    }
    
    private void exploreDFS(int currentVertex) {
        visited.add(currentVertex);
        LinkedList<Edge> adjacents = myGraph.get(currentVertex);
        for(Edge adj : adjacents) {
            if(!visited.contains(adj.vertex)) {
                exploreDFS(adj.vertex);
            }
        }
    }
    
    public List breadthSearch(int startingVertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new ArrayList<>();
        queue.add(startingVertex);
        
        while(!queue.isEmpty()) {
            int currentVertex = queue.poll(); //dequeue
            visited.add(currentVertex);
            List<Edge> neighbors = myGraph.get(currentVertex);
            
            for(Edge adjacent : neighbors) {
                if(!visited.contains(adjacent.vertex) && !queue.contains(adjacent.vertex)) {
                    queue.add(adjacent.vertex);
                }
            }
        }
        return visited;
    }
    
    
  
    public void imprimirGrafo() {
        for (Map.Entry<Integer, LinkedList<Edge>> entry : myGraph.entrySet()) {
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
            for (Map.Entry<Integer, LinkedList<Edge>> entry : myGraph.entrySet()) {
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
        try (Scanner scanner = new Scanner(new File("grafo2.txt"))) {
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


