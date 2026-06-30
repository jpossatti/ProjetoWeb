/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Arduino;
import br.com.projetowebfinal.model.Bem;
import br.com.projetowebfinal.model.ProdutoBem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public interface BemDAO {
    public void cadastrarBem(Bem bem);
    public List<Bem> listar();
    public Double ResgatarValor(Integer id_bem);
    public void excluirBem(Integer id_bem);
    public Bem listarBem (Integer id_bem);
    public void alterarBem(Bem bem);
    public List<Arduino> listarBemImovelArduino(Integer id_cliente,Integer id_imovel);
    public void cadastrarProdutoBem(ArrayList<ProdutoBem> itens);
}
