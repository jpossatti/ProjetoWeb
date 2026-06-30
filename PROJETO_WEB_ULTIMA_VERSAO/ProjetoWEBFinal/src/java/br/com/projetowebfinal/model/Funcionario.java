/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

import java.sql.Date;




/**
 *
 * @author Anderson
 */
    public class Funcionario extends Pessoa{
        private int id_funcionario;
        private Date dataadmissao_funcionario;
        private double salario_funcionario;  
        private int id_departamento_cargo;
        private String login_funcionario;
        private String senha_funcionario;

    public Funcionario(int id_funcionario, Date dataadmissao_funcionario, double salario_funcionario,int id_departamento_cargo, String login_funcionario, String senha_funcionario) {
        this.dataadmissao_funcionario = dataadmissao_funcionario;
        this.salario_funcionario = salario_funcionario;
        this.id_funcionario=id_funcionario;        
        this.id_departamento_cargo=id_departamento_cargo;
        this.login_funcionario = login_funcionario;
        this.senha_funcionario = senha_funcionario;
    }

    public Funcionario(){
        
    }   

    public int getId_departamento_cargo() {
        return id_departamento_cargo;
    }

    public void setId_departamento_cargo(int id_departamento_cargo) {
        this.id_departamento_cargo = id_departamento_cargo;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getLogin_funcionario() {
        return login_funcionario;
    }

    public void setLogin_funcionario(String login_funcionario) {
        this.login_funcionario = login_funcionario;
    }

    public double getSalario_funcionario() {
        return salario_funcionario;
    }

    public void setSalario_funcionario(double salario_funcionario) {
        this.salario_funcionario = salario_funcionario;
    }

    public String getSenha_funcionario() {
        return senha_funcionario;
    }

    public void setSenha_funcionario(String senha_funcionario) {
        this.senha_funcionario = senha_funcionario;
    }

   

    public Date getDataadmissao_funcionario() {
        return dataadmissao_funcionario;
    }

    public void setDataadmissao_funcionario(Date dataadmissao_funcionario) {
        this.dataadmissao_funcionario = dataadmissao_funcionario;
    }

  
    
}
