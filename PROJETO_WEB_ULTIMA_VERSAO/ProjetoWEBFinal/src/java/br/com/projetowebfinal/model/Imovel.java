/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

/**
 *
 * @author jpossatti
 */
public class Imovel {

    
    private int id_imovel;
    private String endereco_imovel;
    private int numero_imovel;
    private String bairro_imovel;
    private String cidade_imovel;
    private String uf_imovel;
    private String cep_imovel;
    private int id_cliente;
    private Cliente objcliente;

    public Imovel() {
    }

    public Imovel(int id_imovel, String endereco_imovel, int numero_imovel, String bairro_imovel,
            String cidade_imovel, String uf_imovel, String cep_imovel, int id_cliente, Cliente objcliente) {
        this.id_imovel = id_imovel;
        this.endereco_imovel = endereco_imovel;
        this.numero_imovel = numero_imovel;
        this.bairro_imovel = bairro_imovel;
        this.cidade_imovel = cidade_imovel;
        this.uf_imovel = uf_imovel;
        this.cep_imovel = cep_imovel;
        this.id_cliente = id_cliente;
        this.objcliente = objcliente;
    }

    public String getBairro_imovel() {
        return bairro_imovel;
    }

    public void setBairro_imovel(String bairro_imovel) {
        this.bairro_imovel = bairro_imovel;
    }

    public String getCep_imovel() {
        return cep_imovel;
    }

    public void setCep_imovel(String cep_imovel) {
        this.cep_imovel = cep_imovel;
    }

    public String getCidade_imovel() {
        return cidade_imovel;
    }

    public void setCidade_imovel(String cidade_imovel) {
        this.cidade_imovel = cidade_imovel;
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

    public int getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(int id_imovel) {
        this.id_imovel = id_imovel;
    }

    public int getNumero_imovel() {
        return numero_imovel;
    }

    public void setNumero_imovel(int numero_imovel) {
        this.numero_imovel = numero_imovel;
    }

    public String getUf_imovel() {
        return uf_imovel;
    }

    public void setUf_imovel(String uf_imovel) {
        this.uf_imovel = uf_imovel;
    }

    public Cliente getObjcliente() {
        return objcliente;
    }

    public void setObjcliente(Cliente objcliente) {
        this.objcliente = objcliente;
    }
    
    
}
