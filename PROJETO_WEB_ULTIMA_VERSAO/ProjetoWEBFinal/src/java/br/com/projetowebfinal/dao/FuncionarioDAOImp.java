/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Funcionario;
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
public class FuncionarioDAOImp implements FuncionarioDAO {

    /*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public FuncionarioDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.pessoa(tipo_pessoa, nome_pessoa, "
                + "cpf_pessoa, rg_pessoa, endereco_pessoa, numero_pessoa, bairro_pessoa, complemento_pessoa,"
                + "cidade_pessoa, uf_pessoa, cep_pessoa, telefone_pessoa, celular_pessoa, email_pessoa,"
                + "obs_pessoa)"
                + "VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
                + "COMMIT;"
                + "INSERT INTO administrativo.funcionario (dataadmissao_funcionario, salario_funcionario,"
                + " login_funcionario, senha_funcionario, id_departamento_cargo, id_pessoa)"
                + "VALUES"
                + "(?, ?, ?, "
                + "(SELECT MD5(?)), "
                + "(SELECT dc.id_departamento_cargo FROM administrativo.departamento_cargo dc WHERE dc.id_cargo = ?), "
                + "(SELECT MAX (p.id_pessoa) FROM administrativo.pessoa p) );";
        System.out.println(sql);
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getTipo_pessoa());
            stmt.setString(2, funcionario.getNome_pessoa());
            stmt.setString(3, funcionario.getCpf_pessoa());
            stmt.setString(4, funcionario.getRg_pessoa());
            stmt.setString(5, funcionario.getEndereco_pessoa());
            stmt.setInt(6, funcionario.getNumero_pessoa());
            stmt.setString(7, funcionario.getBairro_pessoa());
            stmt.setString(8, funcionario.getComplemento_pessoa());
            stmt.setString(9, funcionario.getCidade_pessoa());
            stmt.setString(10, funcionario.getUf_pessoa());
            stmt.setString(11, funcionario.getCep_pessoa());
            stmt.setString(12, funcionario.getTelefone_pessoa());
            stmt.setString(13, funcionario.getCelular_pessoa());
            stmt.setString(14, funcionario.getEmail_pessoa());
            stmt.setString(15, funcionario.getObs_pessoa());
            stmt.setDate(16, funcionario.getDataadmissao_funcionario());
            stmt.setDouble(17, funcionario.getSalario_funcionario());
            stmt.setString(18, funcionario.getLogin_funcionario());
            stmt.setString(19, funcionario.getSenha_funcionario());
            stmt.setInt(20, funcionario.getId_departamento_cargo());
            stmt.execute(); /* executa os dados na tabela*/

            System.out.println(sql);
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar funcionario! Erro:" + ex.getMessage());
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
    public List<Funcionario> listar() {
        List<Funcionario> resultado = new ArrayList<Funcionario>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM administrativo.pessoa p , administrativo.funcionario f WHERE p.id_pessoa = f.id_pessoa ORDER BY f.id_funcionario;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId_pessoa(rs.getInt("id_pessoa"));
                funcionario.setTipo_pessoa(rs.getString("tipo_pessoa"));
                funcionario.setNome_pessoa(rs.getString("nome_pessoa"));
                funcionario.setCpf_pessoa(rs.getString("cpf_pessoa"));
                funcionario.setRg_pessoa(rs.getString("rg_pessoa"));
                funcionario.setEndereco_pessoa(rs.getString("endereco_pessoa"));
                funcionario.setNumero_pessoa(rs.getInt("numero_pessoa"));
                funcionario.setBairro_pessoa(rs.getString("bairro_pessoa"));
                funcionario.setComplemento_pessoa(rs.getString("complemento_pessoa"));
                funcionario.setCidade_pessoa(rs.getString("cidade_pessoa"));
                funcionario.setUf_pessoa(rs.getString("uf_pessoa"));
                funcionario.setCep_pessoa(rs.getString("cep_pessoa"));
                funcionario.setTelefone_pessoa(rs.getString("telefone_pessoa"));
                funcionario.setCelular_pessoa(rs.getString("celular_pessoa"));
                funcionario.setEmail_pessoa(rs.getString("email_pessoa"));
                funcionario.setObs_pessoa(rs.getString("obs_pessoa"));
                funcionario.setDataadmissao_funcionario(rs.getDate("dataadmissao_funcionario"));
                funcionario.setSalario_funcionario(rs.getDouble("salario_funcionario"));
                funcionario.setLogin_funcionario(rs.getString("login_funcionario"));
                funcionario.setSenha_funcionario(rs.getString("senha_funcionario"));
                funcionario.setId_departamento_cargo(rs.getInt("id_departamento_cargo"));
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                resultado.add(funcionario);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar Funcionario! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirFuncionario(Integer id_pessoa) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM administrativo.pessoa p WHERE p.id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pessoa);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir o funcionario !Erro:" + ex.getMessage());
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
    public Funcionario listarFuncionario(Integer id_pessoa) {
        List<Funcionario> resultado = new ArrayList<Funcionario>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionario = null;

        String sql = "SELECT * FROM administrativo.pessoa p, administrativo.funcionario f WHERE p.id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pessoa);
            rs = stmt.executeQuery();

            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId_pessoa(rs.getInt("id_pessoa"));
                funcionario.setTipo_pessoa(rs.getString("tipo_pessoa"));
                funcionario.setNome_pessoa(rs.getString("nome_pessoa"));
                funcionario.setCpf_pessoa(rs.getString("cpf_pessoa"));
                funcionario.setRg_pessoa(rs.getString("rg_pessoa"));
                funcionario.setEndereco_pessoa(rs.getString("endereco_pessoa"));
                funcionario.setNumero_pessoa(rs.getInt("numero_pessoa"));
                funcionario.setBairro_pessoa(rs.getString("bairro_pessoa"));
                funcionario.setComplemento_pessoa(rs.getString("complemento_pessoa"));
                funcionario.setCidade_pessoa(rs.getString("cidade_pessoa"));
                funcionario.setUf_pessoa(rs.getString("uf_pessoa"));
                funcionario.setCep_pessoa(rs.getString("cep_pessoa"));
                funcionario.setTelefone_pessoa(rs.getString("telefone_pessoa"));
                funcionario.setCelular_pessoa(rs.getString("celular_pessoa"));
                funcionario.setEmail_pessoa(rs.getString("email_pessoa"));
                funcionario.setObs_pessoa(rs.getString("obs_pessoa"));
                funcionario.setDataadmissao_funcionario(rs.getDate("dataadmissao_funcionario"));
                funcionario.setSalario_funcionario(rs.getDouble("salario_funcionario"));
                funcionario.setLogin_funcionario(rs.getString("login_funcionario"));
                funcionario.setSenha_funcionario(rs.getString("senha_funcionario"));
                funcionario.setId_departamento_cargo(rs.getInt("id_departamento_cargo"));
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                resultado.add(funcionario);
            }

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados pessoa !Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return funcionario;
    }

    @Override
    public void alterarFuncionario(Funcionario funcionario) {
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.pessoa SET nome_pessoa=?, endereco_pessoa=?, numero_pessoa=?, bairro_pessoa=?, "
                + "complemento_pessoa=?, cidade_pessoa=?, uf_pessoa=?, cep_pessoa=?, telefone_pessoa=?, celular_pessoa=?, "
                + "email_pessoa=?, obs_pessoa=? WHERE id_pessoa=?;"
                + "COMMIT;"
                + "UPDATE administrativo.funcionario SET salario_funcionario=?, "
                + "senha_funcionario=(SELECT MD5(?)), id_departamento_cargo=? WHERE id_pessoa = ?;";
        System.out.println(sql);
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome_pessoa());
            stmt.setString(2, funcionario.getEndereco_pessoa());
            stmt.setInt(3, funcionario.getNumero_pessoa());
            stmt.setString(4, funcionario.getBairro_pessoa());
            stmt.setString(5, funcionario.getComplemento_pessoa());
            stmt.setString(6, funcionario.getCidade_pessoa());
            stmt.setString(7, funcionario.getUf_pessoa());
            stmt.setString(8, funcionario.getCep_pessoa());
            stmt.setString(9, funcionario.getTelefone_pessoa());
            stmt.setString(10, funcionario.getCelular_pessoa());
            stmt.setString(11, funcionario.getEmail_pessoa());
            stmt.setString(12, funcionario.getObs_pessoa());
            stmt.setInt(13, funcionario.getId_pessoa());
            stmt.setDouble(14, funcionario.getSalario_funcionario());
            stmt.setString(15, funcionario.getSenha_funcionario());
            stmt.setInt(16, funcionario.getId_departamento_cargo());
            stmt.setInt(17, funcionario.getId_pessoa());
            stmt.execute(); /* executa os dados na tabela*/

            System.out.println(sql);
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar funcionario! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }

    @Override
    public Funcionario verificarFuncionario(String login, String senha) {
        List<Funcionario> resultado = new ArrayList<Funcionario>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionario = null;

        String sql = "SELECT * FROM administrativo.funcionario f, administrativo.pessoa p "
                + "WHERE f.login_funcionario = ? and f.senha_funcionario = (SELECT MD5(?)) and f.id_pessoa = p.id_pessoa;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setNome_pessoa(rs.getString("nome_pessoa"));
                funcionario.setLogin_funcionario(rs.getString("login_funcionario"));
                funcionario.setSenha_funcionario(rs.getString("senha_funcionario"));
                resultado.add(funcionario);
                System.out.println(funcionario);
            }
            if (resultado.size() > 0) {
                return resultado.get(0);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados do funcionario!Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return funcionario;
    }

    @Override
    public boolean validarDados(String cpf_pessoa, String email_pessoa, String login_funcionario, Integer op) {
    PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql1 = "SELECT p.cpf_pessoa FROM administrativo.pessoa p WHERE p.cpf_pessoa = ?;";
        String sql2 = "SELECT p.email_pessoa FROM administrativo.pessoa p WHERE p.email_pessoa = ?;";
        String sql3 = "SELECT f.login_funcionario FROM administrativo.funcionario f WHERE f.login_funcionario = ?;";
        String sql4 = "SELECT p.cpf_pessoa, p.email_pessoa, f.login_funcionario FROM administrativo.funcionario f, administrativo.pessoa p WHERE p.cpf_pessoa=? AND p.email_pessoa=? AND f.login_funcionario=?;";
        try {
            switch (op) {
                case 1:
                    if (!cpf_pessoa.equals("") && email_pessoa == null && login_funcionario == null) {
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
                    if (cpf_pessoa == null && !email_pessoa.equals("") && login_funcionario == null) {
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
                    if (cpf_pessoa == null && email_pessoa == null && !login_funcionario.equals("")) {
                        stmt = conn.prepareStatement(sql3);
                        stmt.setString(1, login_funcionario);
                        rs = stmt.executeQuery();

                        if (rs.next()) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    break;
                case 4:
                    if (!cpf_pessoa.equals("") && !email_pessoa.equals("") && !login_funcionario.equals("")) {
                        stmt = conn.prepareStatement(sql4);
                        stmt.setString(1, cpf_pessoa);
                        stmt.setString(2, email_pessoa);
                        stmt.setString(3, login_funcionario);
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
