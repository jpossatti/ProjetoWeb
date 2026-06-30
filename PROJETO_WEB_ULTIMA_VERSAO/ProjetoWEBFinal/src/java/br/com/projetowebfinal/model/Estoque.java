/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

import java.util.Date;

/**
 *
 * @author jpossatti
 */
public class Estoque {
        private int id_estoque;
        private int quantidade_estoque;
        private Date data_movimentacao_estoque;
        private String tipo_movimentacao_estoque;
        private int id_produto;
        private Produto obproduto;
        private double margemlucro_produto;

    public Estoque(int id_estoque, int quantidade_estoque, Date data_movimentacao_estoque, String tipo_movimentacao_estoque, int id_produto, Produto obproduto, double margemlucro_produto) {
        this.id_estoque = id_estoque;
        this.quantidade_estoque = quantidade_estoque;
        this.data_movimentacao_estoque = data_movimentacao_estoque;
        this.tipo_movimentacao_estoque = tipo_movimentacao_estoque;
        this.id_produto = id_produto;
        this.obproduto = obproduto;
        this.margemlucro_produto = margemlucro_produto;
    }

    public Date getData_movimentacao_estoque() {
        return data_movimentacao_estoque;
    }

    public void setData_movimentacao_estoque(Date data_movimentacao_estoque) {
        this.data_movimentacao_estoque = data_movimentacao_estoque;
    }

    public int getId_estoque() {
        return id_estoque;
    }

    public void setId_estoque(int id_estoque) {
        this.id_estoque = id_estoque;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public double getMargemlucro_produto() {
        return margemlucro_produto;
    }

    public void setMargemlucro_produto(double margemlucro_produto) {
        this.margemlucro_produto = margemlucro_produto;
    }

    public Produto getObproduto() {
        return obproduto;
    }

    public void setObproduto(Produto obproduto) {
        this.obproduto = obproduto;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public String getTipo_movimentacao_estoque() {
        return tipo_movimentacao_estoque;
    }

    public void setTipo_movimentacao_estoque(String tipo_movimentacao_estoque) {
        this.tipo_movimentacao_estoque = tipo_movimentacao_estoque;
    }


    public Estoque() {
        
    }
}
