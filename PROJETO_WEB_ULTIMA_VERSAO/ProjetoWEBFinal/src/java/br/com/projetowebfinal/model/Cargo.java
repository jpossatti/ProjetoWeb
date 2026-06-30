/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

/**
 *
 * @author jpossatti
 */
public class Cargo {


 private int id_cargo;
 private String nome_cargo;

    public Cargo (){
    }
    public Cargo (int id_cargo, String nome_cargo){
         this.id_cargo = id_cargo;
         this.nome_cargo= nome_cargo;
    }
  public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNome_cargo() {
        return nome_cargo;
    }

    public void setNome_cargo(String nome_cargo) {
        this.nome_cargo = nome_cargo;
    }
}

