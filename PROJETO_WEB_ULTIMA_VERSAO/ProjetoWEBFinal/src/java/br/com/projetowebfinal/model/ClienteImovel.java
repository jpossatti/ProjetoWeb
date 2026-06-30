/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class ClienteImovel {
        String caminho_imagem;
        int id_cliente;
        int id_imovel;

    public ClienteImovel() {
        
    }

    public ClienteImovel(String caminho_imagem, int id_cliente, int id_imovel) {
        this.caminho_imagem = caminho_imagem;
        this.id_cliente = id_cliente;
        this.id_imovel = id_imovel;
    }

    public String getCaminho_imagem() {
        return caminho_imagem;
    }

    public void setCaminho_imagem(String caminho_imagem) {
        this.caminho_imagem = caminho_imagem;
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

}
