/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class PedidoCompra {
    int id_pedido_compra;
    int id_fornecedor;
    int id_produto;
    int quantidade_produto;
    double valor_total;
    String status_pedido_compra;
    int id_funcionario;
    private String nome_pessoa;
    private String data_pedido_compra;
    

    public PedidoCompra() {
    }

    public PedidoCompra(int id_pedido_compra, int id_fornecedor, int id_produto, int quantidade_produto, double valor_total, String status_pedido_compra, int id_funcionario, String nome_pessoa, String data_pedido_compra) {
        this.id_pedido_compra = id_pedido_compra;
        this.id_fornecedor = id_fornecedor;
        this.id_produto = id_produto;
        this.quantidade_produto = quantidade_produto;
        this.valor_total = valor_total;
        this.status_pedido_compra = status_pedido_compra;
        this.id_funcionario = id_funcionario;
        this.nome_pessoa = nome_pessoa;
        this.data_pedido_compra = data_pedido_compra;
    }

    public String getData_pedido_compra() {
        return data_pedido_compra;
    }

    public void setData_pedido_compra(String data_pedido_compra) {
        this.data_pedido_compra = data_pedido_compra;
    }

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_pedido_compra() {
        return id_pedido_compra;
    }

    public void setId_pedido_compra(int id_pedido_compra) {
        this.id_pedido_compra = id_pedido_compra;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade_produto() {
        return quantidade_produto;
    }

    public void setQuantidade_produto(int quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
    }

    public String getStatus_pedido_compra() {
        return status_pedido_compra;
    }

    public void setStatus_pedido_compra(String status_pedido_compra) {
        this.status_pedido_compra = status_pedido_compra;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
  
}
