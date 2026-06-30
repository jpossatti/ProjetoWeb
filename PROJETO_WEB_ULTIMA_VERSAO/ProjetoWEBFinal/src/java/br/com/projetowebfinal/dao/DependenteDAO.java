/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Dependente;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public interface DependenteDAO {
    public void cadastrarDependente(Dependente dependente);
    public List<Dependente> listar();
    public void excluirDependente(Integer id_dependente);
    public Dependente listarDependente (Integer id_dependente);
    public void alterarDependente(Dependente dependente);
}
