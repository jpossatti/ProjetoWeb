/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class ItemPedidoCompra{
    
  private int id_item_pedido_compra;
  private int id_pedido_compra;
  private int id_produto;
  private int quantidade_item_pedido_compra;
  private Double valorunitario_item_pedido_compra;
  private Double valortotal_item_pedido_compra;
  private String descricao_produto;
  private String marca_produto;
  
    public ItemPedidoCompra(int id_item_pedido_compra, int id_pedido_compra, int id_produto, int quantidade_item_pedido_compra, Double valorunitario_item_pedido_compra, Double valortotal_item_pedido_compra, String descricao_produto, String marca_produto) {
        this.id_item_pedido_compra = id_item_pedido_compra;
        this.id_pedido_compra = id_pedido_compra;
        this.id_produto = id_produto;
        this.quantidade_item_pedido_compra = quantidade_item_pedido_compra;
        this.valorunitario_item_pedido_compra = valorunitario_item_pedido_compra;
        this.valortotal_item_pedido_compra = valortotal_item_pedido_compra;
        this.descricao_produto = descricao_produto;
        this.marca_produto = marca_produto;
    }

    public ItemPedidoCompra() {
        
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public int getId_item_pedido_compra() {
        return id_item_pedido_compra;
    }

    public void setId_item_pedido_compra(int id_item_pedido_compra) {
        this.id_item_pedido_compra = id_item_pedido_compra;
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

    public String getMarca_produto() {
        return marca_produto;
    }

    public void setMarca_produto(String marca_produto) {
        this.marca_produto = marca_produto;
    }

    public int getQuantidade_item_pedido_compra() {
        return quantidade_item_pedido_compra;
    }

    public void setQuantidade_item_pedido_compra(int quantidade_item_pedido_compra) {
        this.quantidade_item_pedido_compra = quantidade_item_pedido_compra;
    }

    public Double getValortotal_item_pedido_compra() {
        return valortotal_item_pedido_compra;
    }

    public void setValortotal_item_pedido_compra(Double valortotal_item_pedido_compra) {
        this.valortotal_item_pedido_compra = valortotal_item_pedido_compra;
    }

    public Double getValorunitario_item_pedido_compra() {
        return valorunitario_item_pedido_compra;
    }

    public void setValorunitario_item_pedido_compra(Double valorunitario_item_pedido_compra) {
        this.valorunitario_item_pedido_compra = valorunitario_item_pedido_compra;
    }
 
}
