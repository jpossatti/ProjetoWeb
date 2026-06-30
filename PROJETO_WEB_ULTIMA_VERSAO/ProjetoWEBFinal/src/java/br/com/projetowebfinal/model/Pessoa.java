/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class Pessoa {
        private int id_pessoa;
        private String tipo_pessoa;    
        private String nome_pessoa;       
        private String cpf_pessoa;
        private String rg_pessoa;
        private String endereco_pessoa;
        private int numero_pessoa;
        private String bairro_pessoa;
        private String complemento_pessoa;
        private String cidade_pessoa;
        private String uf_pessoa;
        private String cep_pessoa;
        private String telefone_pessoa;
        private String celular_pessoa;
        private String email_pessoa;
        private String obs_pessoa;

        public Pessoa(){

        }

    public String getBairro_pessoa() {
        return bairro_pessoa;
    }

    public void setBairro_pessoa(String bairro_pessoa) {
        this.bairro_pessoa = bairro_pessoa;
    }

    public String getCelular_pessoa() {
        return celular_pessoa;
    }

    public void setCelular_pessoa(String celular_pessoa) {
        this.celular_pessoa = celular_pessoa;
    }

    public String getCep_pessoa() {
        return cep_pessoa;
    }

    public void setCep_pessoa(String cep_pessoa) {
        this.cep_pessoa = cep_pessoa;
    }

    public String getCidade_pessoa() {
        return cidade_pessoa;
    }

    public void setCidade_pessoa(String cidade_pessoa) {
        this.cidade_pessoa = cidade_pessoa;
    }

    public String getComplemento_pessoa() {
        return complemento_pessoa;
    }

    public void setComplemento_pessoa(String complemento_pessoa) {
        this.complemento_pessoa = complemento_pessoa;
    }

    public String getCpf_pessoa() {
        return cpf_pessoa;
    }

    public void setCpf_pessoa(String cpf_pessoa) {
        this.cpf_pessoa = cpf_pessoa;
    }

    public String getEmail_pessoa() {
        return email_pessoa;
    }

    public void setEmail_pessoa(String email_pessoa) {
        this.email_pessoa = email_pessoa;
    }

    public String getEndereco_pessoa() {
        return endereco_pessoa;
    }

    public void setEndereco_pessoa(String endereco_pessoa) {
        this.endereco_pessoa = endereco_pessoa;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public int getNumero_pessoa() {
        return numero_pessoa;
    }

    public void setNumero_pessoa(int numero_pessoa) {
        this.numero_pessoa = numero_pessoa;
    }

    public String getObs_pessoa() {
        return obs_pessoa;
    }

    public void setObs_pessoa(String obs_pessoa) {
        this.obs_pessoa = obs_pessoa;
    }

    public String getRg_pessoa() {
        return rg_pessoa;
    }

    public void setRg_pessoa(String rg_pessoa) {
        this.rg_pessoa = rg_pessoa;
    }

    public String getTelefone_pessoa() {
        return telefone_pessoa;
    }

    public void setTelefone_pessoa(String telefone_pessoa) {
        this.telefone_pessoa = telefone_pessoa;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

    public String getUf_pessoa() {
        return uf_pessoa;
    }

    public void setUf_pessoa(String uf_pessoa) {
        this.uf_pessoa = uf_pessoa;
    }

    public Pessoa(int id_pessoa, String tipo_pessoa, String nome_pessoa, String cpf_pessoa, String rg_pessoa, String endereco_pessoa, int numero_pessoa, String bairro_pessoa, String complemento_pessoa, String cidade_pessoa, String uf_pessoa, String cep_pessoa, String telefone_pessoa, String celular_pessoa, String email_pessoa, String obs_pessoa) {
        this.id_pessoa = id_pessoa;
        this.tipo_pessoa = tipo_pessoa;
        this.nome_pessoa = nome_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.rg_pessoa = rg_pessoa;
        this.endereco_pessoa = endereco_pessoa;
        this.numero_pessoa = numero_pessoa;
        this.bairro_pessoa = bairro_pessoa;
        this.complemento_pessoa = complemento_pessoa;
        this.cidade_pessoa = cidade_pessoa;
        this.uf_pessoa = uf_pessoa;
        this.cep_pessoa = cep_pessoa;
        this.telefone_pessoa = telefone_pessoa;
        this.celular_pessoa = celular_pessoa;
        this.email_pessoa = email_pessoa;
        this.obs_pessoa = obs_pessoa;
    }

        
}
