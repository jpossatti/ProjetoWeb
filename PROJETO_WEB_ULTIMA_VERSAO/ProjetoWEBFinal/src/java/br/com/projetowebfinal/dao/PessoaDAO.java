/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Pessoa;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public interface PessoaDAO {
    public void cadastrarPessoa(Pessoa pessoa);
    public List<Pessoa> listar();
    public void excluirPessoa(Integer id_pessoa);
    public Pessoa listarPessoa (Integer id_pessoa);
    public void alterarPessoa(Pessoa pessoa);
}

