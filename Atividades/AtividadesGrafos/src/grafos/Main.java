/*
   MODELO PARA AULA
 */
package grafos;

import java.util.List;
import java.util.Scanner;


public class Main {

     static int menuMetodos(){
        Scanner scanner = new Scanner(System.in);
        int op;
        System.out.println("1-Adicionar Usuário");
        System.out.println("2-Adicionar Conexão");
        System.out.println("3-Listar Usuários Registrados");
        System.out.println("4-Verificar conexão entre usuários");
        System.out.println("0-Sair");
        op = scanner.nextInt();
        return op;
    }

    public static void main(String[] args) {
        Graph grafo = new Graph();
        Scanner scanner = new Scanner(System.in);
        int op=0;
        User originUser, destinationUser;
        String origin, destination;
        grafo.carregarNos("nos.txt");
        grafo.carregarConexoes("conexoes.txt");
        do{
        op = menuMetodos();
        switch(op){
            case 1:
                System.out.println("--------- Cadastro de Usuário ---------");
                
                System.out.println("Nome: ");
                String name = scanner.nextLine();
                
                System.out.println("CPF: ");
                String cpf = scanner.nextLine();
                
                System.out.println("Endereço: ");
                String address = scanner.nextLine();
                
                System.out.println("Telefone: ");
                String telephone = scanner.nextLine();
                
                User newUser = new User(name, cpf, address, telephone);
                UserData.addData(newUser);
                grafo.addVertex(newUser);
                
                break;
            case 2: 
                System.out.println("--------- Adicionar Conexão ----------");
                
                System.out.println("CPF do primeiro usuário: ");
                origin = scanner.nextLine();
                originUser = UserData.getUser(origin);
                
                System.out.println("CPF do segundo usuário: ");
                destination = scanner.nextLine();
                destinationUser = UserData.getUser(destination);
                
                
                System.out.println("Peso:");
                int weight = scanner.nextInt();
                
                try{
                    grafo.addConnection(originUser, destinationUser, weight);
                    grafo.imprimirGrafo();
                }catch(NullPointerException e) {
                    System.out.println("Usuário de origem/destino não existe!");
                }
                
                break;
            case 3:
                    grafo.imprimirGrafo();
                    break;
            case 4:
                System.out.println("CPF do primeiro usuário: ");
                origin = scanner.nextLine();
                originUser = UserData.getUser(origin);
                
                System.out.println("CPF do segundo usuário: ");
                destination = scanner.nextLine();
                destinationUser = UserData.getUser(destination);
                
                try{
                    boolean exists = grafo.reach(originUser, destinationUser);
                    if(exists) {
                        System.out.println("Há conexão entre os usuários!");
                    }else {
                        System.out.println("Não há conexão entre os usuários!");
                    }
                }catch(NullPointerException e) {
                    System.out.println("Usuário de origem/destino não existe!");
                            
                }
                
                break;
            case 0: 
                System.out.println("Saindo...");
                grafo.salvarNos("nos.txt");
                grafo.salvarConexoes("conexoes.txt");
            break;
        }// fim switch
        }while(op!=0);

    
    }
    
}
