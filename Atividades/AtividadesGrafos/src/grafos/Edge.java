/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

public class Edge {
        User vertex;
        int weight;

        public Edge(User destiny, int weight) {
            this.vertex = destiny;
            this.weight = weight;
        }
        
        public User getUser() {
            return this.vertex;
        }
    
}
