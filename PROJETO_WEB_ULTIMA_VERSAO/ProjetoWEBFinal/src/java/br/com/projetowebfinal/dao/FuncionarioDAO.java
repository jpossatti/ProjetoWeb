/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Funcionario;
import java.util.List;

/**
 *
 * @author Anderson
 */
public interface FuncionarioDAO {
    public void cadastrarFuncionario(Funcionario funcionario);
    public List<Funcionario> listar();
    public void excluirFuncionario(Integer id_pessoa);
    public Funcionario listarFuncionario (Integer id_pessoa);
    public void alterarFuncionario(Funcionario funcionario);
    public Funcionario verificarFuncionario(String login, String senha);
    public boolean validarDados (String cpf_pessoa, String email_pessoa, String login_funcionario, Integer op);
}
