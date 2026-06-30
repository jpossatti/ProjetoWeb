/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Cliente;
import java.util.List;

/**
 *
 * @author Anderson
 */
public interface ClienteDAO {

    public void cadastrarCliente(Cliente cliente);
    public List<Cliente> listar();
    public List<Cliente> consultarCliente(String nome_cliente);
    public void excluirCliente(Integer id_pessoa);
    public Cliente listarCliente (Integer id_pessoa);
    public void alterarCliente(Cliente cliente);
    public Cliente verificarCliente(String login, String senha);
    public boolean verificarImovelCliente(Integer id_cliente);
    public boolean validarDados (String cpf_pessoa, String email_pessoa, String login_cliente, Integer op);
}
