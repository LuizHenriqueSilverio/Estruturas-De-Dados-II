
package javatreesaula;

import javax.swing.JTextArea;

public class AVLTree<T extends Comparable<T>>{
    Node root = null;
    int cont;
    
    public int add(T newData){
        Node<T> newNode = new Node<T>(newData);
        cont = 0;
        root = insert(root, newNode);
        return cont;
    }
    
    private Node<T> insert(Node<T> root, Node<T> newNode){
           cont++;   
           if(root == null)
                return newNode;
            
            if(newNode.data.compareTo(root.data) >= 0)
                root.right = insert(root.right, newNode);
            else
                root.left = insert(root.left, newNode);
            
            return root; // retorna a root atualizada
    }
    
    //--------------------------------------
    // Busca
    public T search(T searchData){
        return (T) search(root, searchData);
    }
    private T search(Node<T> root, T searchData){
        if(root == null){
          return null;
        }
        
        if(root.data.equals(searchData)){
            return root.data;
        }
        
        if(searchData.compareTo(root.data) < 0){
            return search(root.left, searchData);
        }
        
        else
            return search(root.right,searchData);
    }
    //--------------------------------------
    
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node<T> root){
        if(root != null){
            System.out.print(root.data+", ");
            preOrder(root.left);
            preOrder(root.right);
        }// fim 
    }
    
     public void preOrder(JTextArea listMostraDados){
        preOrder(root, listMostraDados);
        listMostraDados.append("\n");
    }
    private void preOrder(Node<T> root, JTextArea listMostraDados){
        if(root != null){
            listMostraDados.append(root.data+" |");
            preOrder(root.left, listMostraDados);
            preOrder(root.right, listMostraDados);
        }// fim 
    }
    
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node<T> root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+", ");
            inOrder(root.right);
        }// fim 
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node<T> root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+", ");
        }// fim 
    }
    //----------------------
       
    public Node<T> removeNode(Node<T> root) {
        Node<T> newRoot, parent;
        if(root.right == null){
            newRoot = root.left;
            return newRoot;
        }
        // percorrer até achar o menor da right
        parent = root; newRoot = root.right;
        while(newRoot.left!=null){
		parent = newRoot;
		newRoot = newRoot.left;
	}// fim while
        
        // reorganizar os ponteiros
	if(parent != root){
		parent.left = newRoot.right;
		newRoot.right = root.right;
	}
        
        newRoot.left = root.left;
        System.out.println("Retornando nova raiz: " + newRoot.data);
	return newRoot;
    }

    public void remove(T removeData) {
        root = remove(this.root, removeData);
    }

    public Node<T> remove(Node<T> root, T removeData) {
            if(root == null){
                    System.out.println("Não encontrado - :(");
                    return null;
            }
            if(root.data.equals(removeData)){
                    System.out.println("Encontrado - removendo");
                    return removeNode(root);
            }
            if(removeData.compareTo(root.data) < 0)
                    root.left = remove(root.left,removeData);
            else
                root.right = remove(root.right,removeData);
            return root;
    }// fim buscaRemove

    public int height(Node root) {
        int leftHeight, rightHeight;
        
        if (root == null) {
            return -1;
        }
            
        leftHeight = height(root.left);
        rightHeight = height(root.right);
        if (rightHeight > leftHeight){
            return rightHeight + 1;
        }
        else{
            return leftHeight + 1;
        }
       	
    }// fim funcao height
    
    public Node<T> rightRotation(Node<T> root) {
        Node<T> newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        //atualizar fator de balanceamento
        root.bf = height(root.right) - height(root.left);
        newRoot.bf = height(root.right) - height(root.left);
        System.out.println("Rotação Direita --> ");
        return newRoot;
    }

    public Node<T> leftRotation(Node<T> root) {
        Node<T> newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        //atualizar fator de balanceamento
        root.bf = height(root.right) - height(root.left);
        newRoot.bf = height(root.right) - height(root.left);
        System.out.println("Rotação Esquerda --> ");
        return newRoot;
    }
}
