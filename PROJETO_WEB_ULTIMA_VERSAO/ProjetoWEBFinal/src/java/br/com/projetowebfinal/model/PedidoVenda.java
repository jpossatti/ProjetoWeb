/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.model;

import java.util.Date;

/**
 *
 * @author Anderson
 */
public class PedidoVenda {

    private int id_pedido_venda;
    private Date data_pedido_venda;
    private double valor_pedido_venda;
    private String status_pedido_venda;
    private int id_cliente;
    private String nome_pessoa;
    private int id_imovel;
    private String endereco_imovel;
    private int id_comodo;

    public PedidoVenda(int id_pedido_venda, Date data_pedido_venda, double valor_pedido_venda, String status_pedido_venda, int id_cliente, String nome_pessoa, int id_imovel, String endereco_imovel, int id_comodo) {
        this.id_pedido_venda = id_pedido_venda;
        this.data_pedido_venda = data_pedido_venda;
        this.valor_pedido_venda = valor_pedido_venda;
        this.status_pedido_venda = status_pedido_venda;
        this.id_cliente = id_cliente;
        this.nome_pessoa = nome_pessoa;
        this.id_imovel = id_imovel;
        this.endereco_imovel = endereco_imovel;
        this.id_comodo = id_comodo;
    }

    public PedidoVenda() {
    }

    public Date getData_pedido_venda() {
        return data_pedido_venda;
    }

    public void setData_pedido_venda(Date data_pedido_venda) {
        this.data_pedido_venda = data_pedido_venda;
    }

    public String getEndereco_imovel() {
        return endereco_imovel;
    }

    public void setEndereco_imovel(String endereco_imovel) {
        this.endereco_imovel = endereco_imovel;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_comodo() {
        return id_comodo;
    }

    public void setId_comodo(int id_comodo) {
        this.id_comodo = id_comodo;
    }

    public int getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(int id_imovel) {
        this.id_imovel = id_imovel;
    }

    public int getId_pedido_venda() {
        return id_pedido_venda;
    }

    public void setId_pedido_venda(int id_pedido_venda) {
        this.id_pedido_venda = id_pedido_venda;
    }

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public String getStatus_pedido_venda() {
        return status_pedido_venda;
    }

    public void setStatus_pedido_venda(String status_pedido_venda) {
        this.status_pedido_venda = status_pedido_venda;
    }

    public double getValor_pedido_venda() {
        return valor_pedido_venda;
    }

    public void setValor_pedido_venda(double valor_pedido_venda) {
        this.valor_pedido_venda = valor_pedido_venda;
    }
}
