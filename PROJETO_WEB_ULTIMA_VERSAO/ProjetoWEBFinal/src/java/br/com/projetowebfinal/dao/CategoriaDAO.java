/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Categoria;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public interface CategoriaDAO {
    public void cadastrarCategoria(Categoria categoria);
    public List<Categoria> listar();
    public void excluirCategoria(Integer id_categoria);
    public Categoria listarCategoria (Integer id_categoria);
    public void alterarCategoria(Categoria categoria);
}
