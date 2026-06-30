/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.SubCategoria;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public interface SubCategoriaDAO {
    public void cadastrarSubCategoria(SubCategoria subcategoria);
    public List<SubCategoria> listar();
    public void excluirSubCategoria(Integer id_sub_categoria);
    public SubCategoria listarSubCategoria (Integer id_sub_categoria);
    public void alterarSubCategoria(SubCategoria subcategoria);
}
