/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class Arduino {
    private int id_arduino, id_pedido_venda, id_produto, id_porta, numero_porta, id_bem, id_porta_arduino, id_comodo;
    private String mac_arduino, descricao_bem, nome_comodo, acao_bem;

    public Arduino() {
    }

    public Arduino(int id_arduino, int id_pedido_venda, int id_produto, int id_porta, int numero_porta, int id_bem, int id_porta_arduino, String mac_arduino, String descricao_bem, String nome_comodo, int id_comodo, String acao_bem) {
        this.id_arduino = id_arduino;
        this.id_pedido_venda = id_pedido_venda;
        this.id_produto = id_produto;
        this.id_porta = id_porta;
        this.numero_porta = numero_porta;
        this.id_bem = id_bem;
        this.id_porta_arduino = id_porta_arduino;
        this.mac_arduino = mac_arduino;
        this.descricao_bem = descricao_bem;
        this.nome_comodo = nome_comodo;
        this.id_comodo = id_comodo;
        this.acao_bem = acao_bem;
    }

    public String getAcao_bem() {
        return acao_bem;
    }

    public void setAcao_bem(String acao_bem) {
        this.acao_bem = acao_bem;
    }

    public int getId_comodo() {
        return id_comodo;
    }

    public void setId_comodo(int id_comodo) {
        this.id_comodo = id_comodo;
    }

    public String getDescricao_bem() {
        return descricao_bem;
    }

    public void setDescricao_bem(String descricao_bem) {
        this.descricao_bem = descricao_bem;
    }

    public int getId_arduino() {
        return id_arduino;
    }

    public void setId_arduino(int id_arduino) {
        this.id_arduino = id_arduino;
    }

    public int getId_bem() {
        return id_bem;
    }

    public void setId_bem(int id_bem) {
        this.id_bem = id_bem;
    }

    public int getId_pedido_venda() {
        return id_pedido_venda;
    }

    public void setId_pedido_venda(int id_pedido_venda) {
        this.id_pedido_venda = id_pedido_venda;
    }

    public int getId_porta() {
        return id_porta;
    }

    public void setId_porta(int id_porta) {
        this.id_porta = id_porta;
    }

    public int getId_porta_arduino() {
        return id_porta_arduino;
    }

    public void setId_porta_arduino(int id_porta_arduino) {
        this.id_porta_arduino = id_porta_arduino;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getMac_arduino() {
        return mac_arduino;
    }

    public void setMac_arduino(String mac_arduino) {
        this.mac_arduino = mac_arduino;
    }

    public String getNome_comodo() {
        return nome_comodo;
    }

    public void setNome_comodo(String nome_comodo) {
        this.nome_comodo = nome_comodo;
    }

    public int getNumero_porta() {
        return numero_porta;
    }

    public void setNumero_porta(int numero_porta) {
        this.numero_porta = numero_porta;
    }    
}
