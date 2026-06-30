/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

/**
 *
 * @author jpossatti
 */
public class Permissao {

    private int id_permissao;
    private String nome_permissao;

    public Permissao (){
    }
    public Permissao (int id_permissao, String nome_permissao){
         this.id_permissao = id_permissao;
         this.nome_permissao= nome_permissao;
    }
        public int getId_permissao() {
        return id_permissao;
    }

    public void setId_permissao(int id_permissao) {
        this.id_permissao = id_permissao;
    }

    public String getNome_permissao() {
        return nome_permissao;
    }

    public void setNome_permissao(String nome_permissao) {
        this.nome_permissao = nome_permissao;
    }
}
