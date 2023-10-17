/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryform;

/**
 *
 * @author luizh
 */
public class Pokemon implements Comparable<Pokemon>{
    private int id;
    private String name;
    private int totalPc;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public void setTotalPc(int totalPc) {
        this.totalPc = totalPc;
    }
    
    public int getTotalPc() {
        return this.totalPc;
    }

    @Override
    public int compareTo(Pokemon other) {
        return Integer.compare(this.getTotalPc(), other.getTotalPc());
    }
    
    
}
