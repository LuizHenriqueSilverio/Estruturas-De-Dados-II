    
package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Graph {
     private Map<String, LinkedList<Edge>> myGraph;
     private ArrayList visited;

    public Graph() {
        this.myGraph = new HashMap<>();
    }

    // Método para adicionar um vértice ao grafo
    public void addVertex(User vertex) {
        if (!myGraph.containsKey(vertex.getCpf())) {
            myGraph.put(vertex.getCpf(), new LinkedList<>());
        }
    }
    public void addConnection(User origin, User destination, int weight) {
        
        if(origin == null || destination == null) {
            throw new NullPointerException();
        }

        myGraph.get(origin.getCpf()).add(new Edge(destination, weight));
        myGraph.get(destination.getCpf()).add(new Edge(origin, weight));

    }
    
    public boolean reach(User origin, User destination) {
        Set<User> visited = new HashSet<>();        
        return pathExists(origin, destination, visited);
    }
    
    private boolean pathExists(User currentVertex, User destination, Set<User> visited) {
        if(currentVertex.getCpf().equalsIgnoreCase(destination.getCpf())) {
            System.out.println("Conexões: ");
            for(User user : visited) {
                System.out.println(user.getName());
            }
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
    
    /*
    
    public ArrayList depthSearch(String origin) {
        visited = new ArrayList();
        exploreDFS(origin);
        return visited;
    }
    
    
    private void exploreDFS(String currentVertex) {
        visited.add(currentVertex);
        LinkedList<Edge> adjacents = myGraph.get(currentVertex);
        for(Edge adj : adjacents) {
            if(!visited.contains(adj.vertex)) {
                exploreDFS(adj.vertex);
            }
        }
    }
    
    */
    
    public void imprimirGrafo() {
        System.out.println("\n----------------------------------");
        for (Map.Entry<String, LinkedList<Edge>> entry : myGraph.entrySet()) {
            String cpf = entry.getKey();

            User user = UserData.getUser(cpf);
            
            System.out.println("Usuário: " + user.getName());
            System.out.println("CPF: " + user.getCpf());
            System.out.println("Endereço: " + user.getAddress());
            System.out.println("Telefone: " + user.getTelephone());

            LinkedList<Edge> connections = entry.getValue();

            System.out.print("Conexões: ");
            for (Edge currentUser : connections) {
                System.out.print(currentUser.vertex.getName() + ";");
            }
            System.out.println("\n----------------------------------");
        }
    }
     
    // Método para salvar os dados dos nós em um arquivo texto
    public void salvarNos(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Map.Entry<String, LinkedList<Edge>> entry : myGraph.entrySet()) {
                String cpf = entry.getKey();
                User user = UserData.getUser(cpf);
                writer.println("N " + user); // Salva informações do nó (usuário)
            }
            writer.flush(); // Garante que os dados sejam gravados no arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Método para salvar as conexões do grafo em um arquivo texto
    public void salvarConexoes(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Map.Entry<String, LinkedList<Edge>> entry : myGraph.entrySet()) {
                String cpf = entry.getKey();

                LinkedList<Edge> connections = entry.getValue();
                for (Edge connection : connections) {
                    String destinationCpf = connection.vertex.getCpf();
                    int weight = connection.weight;
                    writer.println("C " + cpf + " " + destinationCpf + " " + weight); // Salva informações da conexão
                }
            }
            writer.flush(); // Garante que os dados sejam gravados no arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Método para carregar os dados dos nós do grafo de um arquivo texto
    public void carregarNos(String nomeArquivo) {
        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
            while (scanner.hasNext()) {
                String tipo = scanner.next();

                if (tipo.equals("N")) {
                    String cpf = scanner.next();
                    String name = scanner.next();
                    String address = scanner.next();
                    String telephone = scanner.next();

                    User loadedUser = new User(name, cpf, address, telephone);
                    UserData.addData(loadedUser);
                    addVertex(loadedUser);
                } else {
                    System.out.println("Tipo de linha desconhecido no arquivo!");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar as conexões do grafo de um arquivo texto
    public void carregarConexoes(String nomeArquivo) {
        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
            while (scanner.hasNext()) {
                String tipo = scanner.next();

                if (tipo.equals("C")) {
                    String origemCpf = scanner.next();
                    String destinoCpf = scanner.next();
                    int peso = scanner.nextInt();

                    User origem = UserData.getUser(origemCpf);
                    User destino = UserData.getUser(destinoCpf);

                    if (origem != null && destino != null) {
                        addConnection(origem, destino, peso);
                    } else {
                        System.out.println("Usuário de origem/destino não existe!");
                        System.out.println("Origem: " + origemCpf + ", Destino: " + destinoCpf);
                        System.out.println("Usuários existentes: " + UserData.users.keySet());
                    }
                } else {
                    System.out.println("Tipo de linha desconhecido no arquivo!");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
    
  
    



