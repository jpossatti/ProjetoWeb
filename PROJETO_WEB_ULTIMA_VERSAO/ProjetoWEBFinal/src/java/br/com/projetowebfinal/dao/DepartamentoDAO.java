/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Departamento;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public interface DepartamentoDAO {
    public void cadastrarDepartamento(Departamento departamento);
    public List<Departamento> listar();
    public void excluirDepartamento(Integer id_departamento);
    public Departamento listarDepartamento (Integer id_departamento);
    public void alterarDepartamento(Departamento departamento);
}
