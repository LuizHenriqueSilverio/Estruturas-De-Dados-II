
package javatreesaula;

public class Node<T extends Comparable<T>>{
    T data;
    Node<T> left;
    Node<T> right;
    int bf;
    
    public Node(T newData){
        this.data = newData;
        this.left = null;
        this.right = null;
        this.bf = 0;
    }
}
