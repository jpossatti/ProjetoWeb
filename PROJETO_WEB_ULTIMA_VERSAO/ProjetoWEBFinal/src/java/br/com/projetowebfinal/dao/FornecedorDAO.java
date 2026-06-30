/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Fornecedor;
import java.util.List;

/**
 *
 * @author Anderson
 */
public interface FornecedorDAO {
    public void cadastrarFornecedor(Fornecedor fornecedor);
    public List<Fornecedor> listar();
    public void excluirFornecedor(Integer id_pessoa);
    public Fornecedor listarFornecedor (Integer id_pessoa);
    public void alterarFornecedor(Fornecedor fornecedor);
    public List<Fornecedor> consultarFornecedor(String nome_fornecedor);
}
