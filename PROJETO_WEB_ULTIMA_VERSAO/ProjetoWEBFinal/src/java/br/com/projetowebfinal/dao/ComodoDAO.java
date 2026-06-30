/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Comodo;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public interface ComodoDAO {
    public void cadastrarComodo(Comodo comodo);
    public List<Comodo> listar();
    public void excluirComodo(Integer id_comodo);
    public Comodo listarComodo (Integer id_comodo);
    public void alterarComodo(Comodo comodo);
}
