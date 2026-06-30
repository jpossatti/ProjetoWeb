/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Cliente;
import br.com.projetowebfinal.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class ClienteDAOImp implements ClienteDAO {

    /*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public ClienteDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.pessoa(tipo_pessoa, nome_pessoa, "
                + "cpf_pessoa, rg_pessoa, endereco_pessoa, numero_pessoa, bairro_pessoa, complemento_pessoa,"
                + "cidade_pessoa, uf_pessoa, cep_pessoa, telefone_pessoa, celular_pessoa, email_pessoa,"
                + "obs_pessoa)"
                + "VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
                + "COMMIT;"
                + "INSERT INTO administrativo.cliente (login_cliente, senha_cliente, id_pessoa)"
                + "VALUES"
                + "(?, (SELECT MD5 (?)), (SELECT MAX (p.id_pessoa) FROM administrativo.pessoa p));";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getTipo_pessoa());
            stmt.setString(2, cliente.getNome_pessoa());
            stmt.setString(3, cliente.getCpf_pessoa());
            stmt.setString(4, cliente.getRg_pessoa());
            stmt.setString(5, cliente.getEndereco_pessoa());
            stmt.setInt(6, cliente.getNumero_pessoa());
            stmt.setString(7, cliente.getBairro_pessoa());
            stmt.setString(8, cliente.getComplemento_pessoa());
            stmt.setString(9, cliente.getCidade_pessoa());
            stmt.setString(10, cliente.getUf_pessoa());
            stmt.setString(11, cliente.getCep_pessoa());
            stmt.setString(12, cliente.getTelefone_pessoa());
            stmt.setString(13, cliente.getCelular_pessoa());
            stmt.setString(14, cliente.getEmail_pessoa());
            stmt.setString(15, cliente.getObs_pessoa());
            stmt.setString(16, cliente.getLogin_cliente());
            stmt.setString(17, cliente.getSenha_cliente());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar cliente! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        } finally {/*executa ele todas as vezes*/
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }

        }
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> resultado = new ArrayList<Cliente>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM administrativo.pessoa p , administrativo.cliente c WHERE p.id_pessoa = c.id_pessoa ORDER BY c.id_cliente;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setTipo_pessoa(rs.getString("tipo_pessoa"));
                cliente.setNome_pessoa(rs.getString("nome_pessoa"));
                cliente.setCpf_pessoa(rs.getString("cpf_pessoa"));
                cliente.setRg_pessoa(rs.getString("rg_pessoa"));
                cliente.setEndereco_pessoa(rs.getString("endereco_pessoa"));
                cliente.setNumero_pessoa(rs.getInt("numero_pessoa"));
                cliente.setBairro_pessoa(rs.getString("bairro_pessoa"));
                cliente.setComplemento_pessoa(rs.getString("complemento_pessoa"));
                cliente.setCidade_pessoa(rs.getString("cidade_pessoa"));
                cliente.setUf_pessoa(rs.getString("uf_pessoa"));
                cliente.setCep_pessoa(rs.getString("cep_pessoa"));
                cliente.setTelefone_pessoa(rs.getString("telefone_pessoa"));
                cliente.setCelular_pessoa(rs.getString("celular_pessoa"));
                cliente.setEmail_pessoa(rs.getString("email_pessoa"));
                cliente.setObs_pessoa(rs.getString("obs_pessoa"));
                cliente.setLogin_cliente(rs.getString("login_cliente"));
                cliente.setSenha_cliente(rs.getString("senha_cliente"));
                cliente.setId_pessoa(rs.getInt("id_pessoa"));
                cliente.setId_cliente(rs.getInt("id_cliente"));
                resultado.add(cliente);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar cliente! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
            ex.printStackTrace(); /*Mostra certinho onde esta o erro, em detalhes*/
        } finally { /*Executo ele todas as vezes */
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas as fechar os parâmetros de conexão!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }

        }
        return resultado;
    }

    @Override
    public void excluirCliente(Integer id_pessoa) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM pessoa WHERE id_pessoa = ?;"
                + "COMMIT;"
                + "DELETE FROM administrativo.pessoa p WHERE p.id_pessoa = ? ;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pessoa);
            stmt.setInt(2, id_pessoa);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir o cliente !Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas as fechar os parâmetros de conexão!Erro:" + ex.getMessage());
            }
        }
    }

    @Override
    public Cliente listarCliente(Integer id_pessoa) {
        List<Cliente> resultado = new ArrayList<Cliente>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        String sql = "SELECT * FROM administrativo.pessoa p, administrativo.cliente c WHERE p.id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pessoa);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId_pessoa(rs.getInt("id_pessoa"));
                cliente.setTipo_pessoa(rs.getString("tipo_pessoa"));
                cliente.setNome_pessoa(rs.getString("nome_pessoa"));
                cliente.setCpf_pessoa(rs.getString("cpf_pessoa"));
                cliente.setRg_pessoa(rs.getString("rg_pessoa"));
                cliente.setEndereco_pessoa(rs.getString("endereco_pessoa"));
                cliente.setNumero_pessoa(rs.getInt("numero_pessoa"));
                cliente.setBairro_pessoa(rs.getString("bairro_pessoa"));
                cliente.setComplemento_pessoa(rs.getString("complemento_pessoa"));
                cliente.setCidade_pessoa(rs.getString("cidade_pessoa"));
                cliente.setUf_pessoa(rs.getString("uf_pessoa"));
                cliente.setCep_pessoa(rs.getString("cep_pessoa"));
                cliente.setTelefone_pessoa(rs.getString("telefone_pessoa"));
                cliente.setCelular_pessoa(rs.getString("celular_pessoa"));
                cliente.setEmail_pessoa(rs.getString("email_pessoa"));
                cliente.setObs_pessoa(rs.getString("obs_pessoa"));
                cliente.setLogin_cliente(rs.getString("login_cliente"));
                cliente.setSenha_cliente(rs.getString("senha_cliente"));
                resultado.add(cliente);
            }

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados cliente !Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return cliente;
    }

    public void alterarCliente(Cliente cliente) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.pessoa SET nome_pessoa=?, "
                + "endereco_pessoa=?, numero_pessoa=?, bairro_pessoa=?, complemento_pessoa=?,"
                + "cidade_pessoa=?, uf_pessoa=?, cep_pessoa=?, telefone_pessoa=?, celular_pessoa=?, email_pessoa=?,"
                + "obs_pessoa=? WHERE id_pessoa=?;"
                + "COMMIT;"
                + "UPDATE administrativo.cliente SET senha_cliente=(SELECT MD5 (?)) WHERE id_pessoa=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome_pessoa());
            stmt.setString(2, cliente.getEndereco_pessoa());
            stmt.setInt(3, cliente.getNumero_pessoa());
            stmt.setString(4, cliente.getBairro_pessoa());
            stmt.setString(5, cliente.getComplemento_pessoa());
            stmt.setString(6, cliente.getCidade_pessoa());
            stmt.setString(7, cliente.getUf_pessoa());
            stmt.setString(8, cliente.getCep_pessoa());
            stmt.setString(9, cliente.getTelefone_pessoa());
            stmt.setString(10, cliente.getCelular_pessoa());
            stmt.setString(11, cliente.getEmail_pessoa());
            stmt.setString(12, cliente.getObs_pessoa());
            stmt.setInt(13, cliente.getId_pessoa());
            stmt.setString(14, cliente.getSenha_cliente());
            stmt.setInt(15, cliente.getId_pessoa());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar cliente! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }

    @Override
    public Cliente verificarCliente(String login, String senha) {
        List<Cliente> resultado = new ArrayList<Cliente>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        String sql = "SELECT * FROM administrativo.cliente c, administrativo.pessoa p "
                + "WHERE c.login_cliente=? and c.senha_cliente=(SELECT MD5 (?)) and c.id_pessoa = p.id_pessoa;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome_pessoa(rs.getString("nome_pessoa"));
                cliente.setLogin_cliente(rs.getString("login_cliente"));
                cliente.setSenha_cliente(rs.getString("senha_cliente"));
                resultado.add(cliente);
            }

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados do cliente!Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return cliente;
    }

    @Override
    public boolean verificarImovelCliente(Integer id_cliente) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        int res = 0;
        int res1 = 0;

        String sql = "select ci.id_cliente, ci.id_imovel from administrativo.cliente_imovel ci where ci.id_cliente = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_cliente);
            rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setId_imovel(rs.getInt("id_imovel"));
                res = cliente.getId_cliente();
                res1 = cliente.getId_imovel();
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados do cliente!Erro: " + ex.getMessage());
        }

        if (res != 0 && res1 != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Cliente> consultarCliente(String nome_cliente) {
        List<Cliente> resultado = new ArrayList<Cliente>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT c.id_cliente, p.nome_pessoa FROM administrativo.pessoa p , administrativo.cliente c WHERE p.id_pessoa = c.id_pessoa AND p.nome_pessoa LIKE ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome_cliente + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome_pessoa(rs.getString("nome_pessoa"));
                resultado.add(cliente);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar cliente! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
            ex.printStackTrace(); /*Mostra certinho onde esta o erro, em detalhes*/
        } finally { /*Executo ele todas as vezes */
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas as fechar os parâmetros de conexão!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }

        }
        return resultado;
    }

    @Override
    public boolean validarDados(String cpf_pessoa, String email_pessoa, String login_cliente, Integer op) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        System.out.println(cpf_pessoa);
        System.out.println(email_pessoa);
        System.out.println(login_cliente);
        System.out.println(op);

        String sql1 = "SELECT p.cpf_pessoa FROM administrativo.pessoa p WHERE p.cpf_pessoa = ?;";
        String sql2 = "SELECT p.email_pessoa FROM administrativo.pessoa p WHERE p.email_pessoa = ?;";
        String sql3 = "SELECT c.login_cliente FROM administrativo.cliente c WHERE c.login_cliente = ?;";
        String sql4 = "SELECT p.cpf_pessoa, p.email_pessoa, c.login_cliente FROM administrativo.cliente c, administrativo.pessoa p WHERE p.cpf_pessoa=? AND p.email_pessoa=? AND c.login_cliente=?;";
        try {
            switch (op) {
                case 1:
                    if (!cpf_pessoa.equals("") && email_pessoa == null && login_cliente == null) {
                        stmt = conn.prepareStatement(sql1);
                        stmt.setString(1, cpf_pessoa);
                        rs = stmt.executeQuery();

                        if (rs.next()) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    break;
                case 2:
                    if (cpf_pessoa == null && !email_pessoa.equals("") && login_cliente == null) {
                        stmt = conn.prepareStatement(sql2);
                        stmt.setString(1, email_pessoa);
                        rs = stmt.executeQuery();

                        if (rs.next()) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    break;
                case 3:
                    if (cpf_pessoa == null && email_pessoa == null && !login_cliente.equals("")) {
                        stmt = conn.prepareStatement(sql3);
                        stmt.setString(1, login_cliente);
                        rs = stmt.executeQuery();

                        if (rs.next()) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    break;
                case 4:
                    if (!cpf_pessoa.equals("") && !email_pessoa.equals("") && !login_cliente.equals("")) {
                        stmt = conn.prepareStatement(sql4);
                        stmt.setString(1, cpf_pessoa);
                        stmt.setString(2, email_pessoa);
                        stmt.setString(3, login_cliente);
                        rs = stmt.executeQuery();

                        if (rs.next()) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    break;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados do cliente!Erro: " + ex.getMessage());
            return false;
        }
    }
}
