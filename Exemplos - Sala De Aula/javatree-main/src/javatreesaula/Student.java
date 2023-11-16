package javatreesaula;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private int matricula;
    private String nome;
    
    public Student(int matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }
    
    public Student(){

    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public int compareTo(Student outro){
        return Integer.compare
           (this.matricula, outro.matricula);
    }
    @Override
    public String toString(){
            return " Matricula: "+this.matricula+
                      " Nome:"+this.nome;
    }
    @Override
    public boolean equals(Object novoObjeto){
        if(this == novoObjeto)
            return true;
        if(novoObjeto == null || 
                this.getClass()!= novoObjeto.getClass())
           return false; 
        Student outroAluno = (Student) novoObjeto;
        return this.matricula == outroAluno.matricula;
    }
    
    
    
}
