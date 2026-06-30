/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

/**
 *
 * @author jpossatti
 */
public class Dependente extends Cliente {
        private int id_dependente;        
        private String nome_dependente;
        private String parentesco_dependente;


    public Dependente(int id_dependente,int id_cliente, String nome_dependente, String parentesco_dependente) {
        this.id_dependente = id_dependente;        
        this.nome_dependente=nome_dependente;
        this.parentesco_dependente=parentesco_dependente;
    }

    public Dependente() {
       
    } 

    public int getId_dependente() {
        return id_dependente;
    }

    public void setId_dependente(int id_dependente) {
        this.id_dependente = id_dependente;
    }

    public String getNome_dependente() {
        return nome_dependente;
    }

    public void setNome_dependente(String nome_dependente) {
        this.nome_dependente = nome_dependente;
    }

    public String getParentesco_dependente() {
        return parentesco_dependente;
    }

    public void setParentesco_dependente(String parentesco_dependente) {
        this.parentesco_dependente = parentesco_dependente;
    }

   
    
}
