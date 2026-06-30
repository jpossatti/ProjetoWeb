/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

/**
 *
 * @author jpossatti
 */
public class Categoria {
    private int id_categoria;
    private String descricao_categoria;
    private int grupo_categoria;

    public Categoria (){
    }

    public Categoria(int id_categoria, String descricao_categoria, int grupo_categoria) {
        this.id_categoria = id_categoria;
        this.descricao_categoria = descricao_categoria;
        this.descricao_categoria = descricao_categoria;
    }

    public int getGrupo_categoria() {
        return grupo_categoria;
    }

    public void setGrupo_categoria(int grupo_categoria) {
        this.grupo_categoria = grupo_categoria;
    }

    public String getDescricao_categoria() {
        return descricao_categoria;
    }

    public void setDescricao_categoria(String descricao_categoria) {
        this.descricao_categoria = descricao_categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

}
