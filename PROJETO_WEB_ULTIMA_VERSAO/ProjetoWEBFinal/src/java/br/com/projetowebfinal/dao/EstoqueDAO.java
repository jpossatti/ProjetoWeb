/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Estoque;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public interface EstoqueDAO {
    public void cadastrarEstoque(Estoque estoque);
    public List<Estoque> listar();
    public void excluirEstoque(Integer id_estoque);
    public Estoque listarEstoque (Integer id_estoque);
    public void alterarEstoque(Estoque estoque);
}
