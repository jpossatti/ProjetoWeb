/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

/**
 *
 * @author jpossatti
 */
public class Departamento {

    private int id_departamento;
    private String nome_departamento;
    private String[] cargos_departamento;

    public Departamento (){
        
    }

    public Departamento(int id_departamento, String nome_departamento, String[] cargos_departamento) {
        this.id_departamento = id_departamento;
        this.nome_departamento = nome_departamento;
        this.cargos_departamento = cargos_departamento;
    }

    public String[] getCargos_departamento() {
        return cargos_departamento;
    }

    public void setCargos_departamento(String[] cargos_departamento) {
        this.cargos_departamento = cargos_departamento;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNome_departamento() {
        return nome_departamento;
    }

    public void setNome_departamento(String nome_departamento) {
        this.nome_departamento = nome_departamento;
    }
}
