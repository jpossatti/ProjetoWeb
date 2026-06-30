/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class CompraItem {
    private int idcompra;
    private int idproduto;
    private String descricao;
    private double valorcompra;
    private double quantidade;
    private double valortotal;
    
    public CompraItem(){
        
    }

    public CompraItem(int idcompra, int idproduto, String descricao, double valorcompra, double quantidade, double valortotal) {
        this.idcompra = idcompra;
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.valorcompra = valorcompra;
        this.quantidade = quantidade;
        this.valortotal = valortotal;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }
}
