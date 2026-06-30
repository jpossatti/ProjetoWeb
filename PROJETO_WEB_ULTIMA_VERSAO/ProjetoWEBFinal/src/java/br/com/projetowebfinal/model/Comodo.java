/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

/**
 *
 * @author jpossatti
 */
public class Comodo {

    private int id_comodo;
    private String nome_comodo;

    public Comodo (){
    }
    public Comodo (int id_comodo, String nome_comodo){
         this.id_comodo = id_comodo;
         this.nome_comodo= nome_comodo;
    }


public int getId_comodo() {
        return id_comodo;
    }

    public void setId_comodo(int id_comodo) {
        this.id_comodo = id_comodo;
    }

    public String getNome_comodo() {
        return nome_comodo;
    }

    public void setNome_comodo(String nome_comodo) {
        this.nome_comodo = nome_comodo;
    }


}
