/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

/**
 *
 * @author jpossatti
 */
public class Produto{
 private int id_produto;
 private String descricao_produto;
 private String marca_produto;
 private String mac_produto;
 private String msg;

    public Produto(int id_produto, String descricao_produto, String marca_produto, String mac_produto, String msg) {
        this.id_produto = id_produto;
        this.descricao_produto = descricao_produto;
        this.marca_produto = marca_produto;
        this.mac_produto = mac_produto;
        this.msg = msg;
    }
 
    public Produto (){
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMac_produto() {
        return mac_produto;
    }

    public void setMac_produto(String mac_produto) {
        this.mac_produto = mac_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
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
}
