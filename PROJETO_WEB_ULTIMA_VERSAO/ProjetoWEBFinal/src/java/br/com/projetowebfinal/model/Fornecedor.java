/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.model;

/**
 *
 * @author Anderson
 */
public class Fornecedor extends Pessoa{
    
    private int id_fornecedor;

    public Fornecedor(int id_fornecedor  ) {
  
        this.id_fornecedor = id_fornecedor;
            }

    public Fornecedor(){
        
    }

   
    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }
  

}
