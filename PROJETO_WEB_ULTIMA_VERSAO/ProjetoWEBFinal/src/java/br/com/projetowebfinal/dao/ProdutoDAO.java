/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Produto;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public interface ProdutoDAO {
    public void cadastrarProduto(Produto produto);
    public List<Produto> listar();
    public void excluirProduto(Integer id_produto);
    public Produto listarProduto (Integer id_produto);
    public Produto listarProdutoEstoque (Integer id_produto);
    public void alterarProduto(Produto produto);
    
    public List<Produto> consultarProdutoBem(String descricao_produto);
}
