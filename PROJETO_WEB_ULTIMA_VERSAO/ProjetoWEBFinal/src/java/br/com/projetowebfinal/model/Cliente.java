/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class Cliente extends Pessoa {
        private int id_cliente;
        private int id_imovel;
        private String login_cliente;
        private String senha_cliente;

    public Cliente(int id_cliente, String login_cliente, String senha_cliente, int id_imovel) {
        this.id_cliente = id_cliente;
        this.login_cliente = login_cliente;
        this.senha_cliente = senha_cliente;
        this.id_imovel = id_imovel;
    }

    public Cliente() {
        
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(int id_imovel) {
        this.id_imovel = id_imovel;
    }
    
    public String getLogin_cliente() {
        return login_cliente;
    }

    public void setLogin_cliente(String login_cliente) {
        this.login_cliente = login_cliente;
    }

    public String getSenha_cliente() {
        return senha_cliente;
    }

    public void setSenha_cliente(String senha_cliente) {
        this.senha_cliente = senha_cliente;
    }

}
