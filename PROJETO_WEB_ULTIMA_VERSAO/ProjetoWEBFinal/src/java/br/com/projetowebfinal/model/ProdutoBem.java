/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class ProdutoBem {
    private int id_produto_bem, quantidade_produto_bem;
    private String descricao_produto_bem;

    public ProdutoBem() {
    }

    public ProdutoBem(int id_produto_bem, int quantidade_produto_bem, String descricao_produto_bem) {
        this.id_produto_bem = id_produto_bem;
        this.quantidade_produto_bem = quantidade_produto_bem;
        this.descricao_produto_bem = descricao_produto_bem;
    }

    public String getDescricao_produto_bem() {
        return descricao_produto_bem;
    }

    public void setDescricao_produto_bem(String descricao_produto_bem) {
        this.descricao_produto_bem = descricao_produto_bem;
    }

    public int getId_produto_bem() {
        return id_produto_bem;
    }

    public void setId_produto_bem(int id_produto_bem) {
        this.id_produto_bem = id_produto_bem;
    }

    public int getQuantidade_produto_bem() {
        return quantidade_produto_bem;
    }

    public void setQuantidade_produto_bem(int quantidade_produto_bem) {
        this.quantidade_produto_bem = quantidade_produto_bem;
    }

}
