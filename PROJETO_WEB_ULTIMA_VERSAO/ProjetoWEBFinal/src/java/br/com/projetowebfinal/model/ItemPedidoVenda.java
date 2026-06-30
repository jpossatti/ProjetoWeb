/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class ItemPedidoVenda extends Bem{
    private int id_item_pedido_venda;
    private int quantidade_item_pedido_venda;
    private double total_item_pedido_venda;
    private int id_pedido_venda;
    private int id_imovel_comodo_bem;
    private int id_bem;
    private int id_comodo;
    private String nome_comodo;
    private Arduino obArduino;

    public ItemPedidoVenda() {
    }

    public ItemPedidoVenda(int id_item_pedido_venda, int quantidade_item_pedido_venda, double total_item_pedido_venda, int id_pedido_venda, int id_imovel_comodo_bem, int id_bem, int id_comodo, String nome_comodo, Arduino obArduino) {
        this.id_item_pedido_venda = id_item_pedido_venda;
        this.quantidade_item_pedido_venda = quantidade_item_pedido_venda;
        this.total_item_pedido_venda = total_item_pedido_venda;
        this.id_pedido_venda = id_pedido_venda;
        this.id_imovel_comodo_bem = id_imovel_comodo_bem;
        this.id_bem = id_bem;
        this.id_comodo = id_comodo;
        this.nome_comodo = nome_comodo;
        this.obArduino = obArduino;
    }

    public int getId_comodo() {
        return id_comodo;
    }

    public void setId_comodo(int id_comodo) {
        this.id_comodo = id_comodo;
    }

    public int getId_imovel_comodo_bem() {
        return id_imovel_comodo_bem;
    }

    public void setId_imovel_comodo_bem(int id_imovel_comodo_bem) {
        this.id_imovel_comodo_bem = id_imovel_comodo_bem;
    }

    public int getId_item_pedido_venda() {
        return id_item_pedido_venda;
    }

    public void setId_item_pedido_venda(int id_item_pedido_venda) {
        this.id_item_pedido_venda = id_item_pedido_venda;
    }

    public int getId_pedido_venda() {
        return id_pedido_venda;
    }

    public void setId_pedido_venda(int id_pedido_venda) {
        this.id_pedido_venda = id_pedido_venda;
    }

    public String getNome_comodo() {
        return nome_comodo;
    }

    public void setNome_comodo(String nome_comodo) {
        this.nome_comodo = nome_comodo;
    }

    public Arduino getObArduino() {
        return obArduino;
    }

    public void setObArduino(Arduino obArduino) {
        this.obArduino = obArduino;
    }

    public int getQuantidade_item_pedido_venda() {
        return quantidade_item_pedido_venda;
    }

    public void setQuantidade_item_pedido_venda(int quantidade_item_pedido_venda) {
        this.quantidade_item_pedido_venda = quantidade_item_pedido_venda;
    }

    public double getTotal_item_pedido_venda() {
        return total_item_pedido_venda;
    }

    public void setTotal_item_pedido_venda(double total_item_pedido_venda) {
        this.total_item_pedido_venda = total_item_pedido_venda;
    }

}
