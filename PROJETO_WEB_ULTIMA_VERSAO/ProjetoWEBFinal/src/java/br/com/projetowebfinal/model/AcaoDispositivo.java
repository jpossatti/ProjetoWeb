/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class AcaoDispositivo {

    private int id_acao_bem;
    private int idPedido;
    private int id_bem;
    private int id_comodo;
    private String ligar_dispotivo;
    private String desligar_dispotivo;

    public AcaoDispositivo() {
    }

    public AcaoDispositivo(int id_acao_bem, int idPedido, int id_bem, int id_comodo, String ligar_dispotivo, String desligar_dispotivo) {
        this.idPedido = idPedido;
        this.id_bem = id_bem;
        this.id_comodo = id_comodo;
        this.ligar_dispotivo = ligar_dispotivo;
        this.desligar_dispotivo = desligar_dispotivo;
        this.id_acao_bem = id_acao_bem;
    }
public int getId_acao_bem() {
        return id_acao_bem;
    }

    public void setId_acao_bem(int id_acao_bem) {
        this.id_acao_bem = id_acao_bem;
    }
    public String getDesligar_dispotivo() {
        return desligar_dispotivo;
    }

    public void setDesligar_dispotivo(String desligar_dispotivo) {
        this.desligar_dispotivo = desligar_dispotivo;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getId_bem() {
        return id_bem;
    }

    public void setId_bem(int id_bem) {
        this.id_bem = id_bem;
    }

    public int getId_comodo() {
        return id_comodo;
    }

    public void setId_comodo(int id_comodo) {
        this.id_comodo = id_comodo;
    }

    public String getLigar_dispotivo() {
        return ligar_dispotivo;
    }

    public void setLigar_dispotivo(String ligar_dispotivo) {
        this.ligar_dispotivo = ligar_dispotivo;
    }
}
