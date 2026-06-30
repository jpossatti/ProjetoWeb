/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Cargo;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public interface CargoDAO {
    public void cadastrarCargo(Cargo cargo);
    public List<Cargo> listar();
    public void excluirCargo(Integer id_cargo);
    public Cargo listarCargo (Integer id_cargo);
    public void alterarCargo(Cargo cargo);
}
