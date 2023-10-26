
package javatreesaula;

import javax.swing.JTextArea;

public class BinarySearchTree<T extends Comparable<T>>{
    Node root = null;
    int cont;
    
    public int add(T newData){
        Node<T> newNode = new Node<T>(newData);
        cont = 0;
        root = inserir(root, newNode);
        return cont;
    }
    
    private Node<T> inserir(Node<T> raiz, Node<T> novo){
           cont++;   
           if(raiz == null)
                return novo;
            
            if(novo.data.compareTo(raiz.data)>=0)
                raiz.right = inserir(raiz.right, novo);
            else
                raiz.left = inserir(raiz.left, novo);
            
            return raiz; // retorna a root atualizada
    }
    
    //--------------------------------------
    // Busca
    public T buscar(T dadoBusca){
        return (T)buscar(root,dadoBusca);
    }
    private T buscar(Node<T> raiz, T dadoBusca){
        if(raiz==null)
          return null;
        if(raiz.data.equals(dadoBusca))
            return raiz.data;
        if(dadoBusca.compareTo(raiz.data)<0)
            return buscar(raiz.left, dadoBusca);
        else
            return buscar(raiz.right,dadoBusca);
    }
    //--------------------------------------
    
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node<T> raiz){
        if(raiz!=null){
            System.out.print(raiz.data+", ");
            preOrder(raiz.left);
            preOrder(raiz.right);
        }// fim 
    }
    
     public void preOrder(JTextArea listMostraDados){
        preOrder(root, listMostraDados);
        listMostraDados.append("\n");
    }
    private void preOrder(Node<T> raiz, JTextArea listMostraDados){
        if(raiz!=null){
            listMostraDados.append(raiz.data+" |");
            preOrder(raiz.left, listMostraDados);
            preOrder(raiz.right, listMostraDados);
        }// fim 
    }
    
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node<T> raiz){
        if(raiz!=null){
            inOrder(raiz.left);
            System.out.print(raiz.data+", ");
            inOrder(raiz.right);
        }// fim 
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node<T> raiz){
        if(raiz!=null){
            postOrder(raiz.left);
            postOrder(raiz.right);
            System.out.print(raiz.data+", ");
        }// fim 
    }
    //----------------------
       
    public Node<T> removeNode(Node<T> raiz) {
        Node<T> nova, pai;
        if(raiz.right==null){
            nova = raiz.left;
            return nova;
        }
        // percorrer até achar o menor da right
        pai = raiz; nova= raiz.right;
        while(nova.left!=null){
		pai=nova;
		nova = nova.left;
	}// fim while
        
        // reorganizar os ponteiros
	if(pai!=raiz){
		pai.left = nova.right;
		nova.right = raiz.right;
	}
        
        nova.left = raiz.left;
        System.out.println("Retornando nova raiz:"+nova.data);
	return nova;
}

public void remove(T dadoRemover) {
    root = remove(this.root, dadoRemover);
}

public Node<T> remove(Node<T> raiz, T dadoRemover) {
    	if(raiz==null){
                System.out.println("Não encontrado - :(");
		return null;
        }
	if(raiz.data.equals(dadoRemover)){
                System.out.println("Encontrado - removendo");
		return removeNode(raiz);
        }
	if(dadoRemover.compareTo(raiz.data)<0)
		raiz.left = remove(raiz.left,dadoRemover);
	else
	    raiz.right = remove(raiz.right,dadoRemover);
	
        return raiz;
}// fim buscaRemove

    
}
