/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author 0068943
 */
public class Cliente implements Serializable{
    private long id;
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.id + "," + this.nome;
    }
    
    
}
