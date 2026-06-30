/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class Bem {

    private int id_bem;
    private String descricao_bem;
    private String marca_bem;
    private int id_categoria;
    private double precomaodeobra_bem;
    private String[] permissoes;
    private String[] itens;

    public Bem() {
    }

    public Bem(int id_bem, String descricao_bem, String marca_bem, int id_categoria, double precomaodeobra_bem, String[] permissoes, String[] itens) {
        this.id_bem = id_bem;
        this.descricao_bem = descricao_bem;
        this.marca_bem = marca_bem;
        this.id_categoria = id_categoria;
        this.precomaodeobra_bem = precomaodeobra_bem;
        this.permissoes = permissoes;
        this.itens = itens;
    }

    public String getDescricao_bem() {
        return descricao_bem;
    }

    public void setDescricao_bem(String descricao_bem) {
        this.descricao_bem = descricao_bem;
    }

    public int getId_bem() {
        return id_bem;
    }

    public void setId_bem(int id_bem) {
        this.id_bem = id_bem;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String[] getItens() {
        return itens;
    }

    public void setItens(String[] itens) {
        this.itens = itens;
    }

    public String getMarca_bem() {
        return marca_bem;
    }

    public void setMarca_bem(String marca_bem) {
        this.marca_bem = marca_bem;
    }

    public String[] getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(String[] permissoes) {
        this.permissoes = permissoes;
    }

    public double getPrecomaodeobra_bem() {
        return precomaodeobra_bem;
    }

    public void setPrecomaodeobra_bem(double precomaodeobra_bem) {
        this.precomaodeobra_bem = precomaodeobra_bem;
    }

}
