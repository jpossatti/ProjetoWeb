/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Fornecedor;
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
public class FornecedorDAOImp implements FornecedorDAO {

    /*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public FornecedorDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }

    @Override
    public void cadastrarFornecedor(Fornecedor fornecedor) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.pessoa(tipo_pessoa, nome_pessoa,"
                + "cpf_pessoa, rg_pessoa, endereco_pessoa, numero_pessoa, bairro_pessoa, complemento_pessoa,"
                + "cidade_pessoa, uf_pessoa, cep_pessoa, telefone_pessoa, celular_pessoa, email_pessoa,"
                + "obs_pessoa)"
                + "VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);"
                + "COMMIT;"
                + "INSERT INTO administrativo.fornecedor (id_pessoa)"
                + "VALUES"
                + "( (SELECT MAX (id_pessoa) FROM administrativo.pessoa ));";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getTipo_pessoa());
            stmt.setString(2, fornecedor.getNome_pessoa());
            stmt.setString(3, fornecedor.getCpf_pessoa());
            stmt.setString(4, fornecedor.getRg_pessoa());
            stmt.setString(5, fornecedor.getEndereco_pessoa());
            stmt.setInt(6, fornecedor.getNumero_pessoa());
            stmt.setString(7, fornecedor.getBairro_pessoa());
            stmt.setString(8, fornecedor.getComplemento_pessoa());
            stmt.setString(9, fornecedor.getCidade_pessoa());
            stmt.setString(10, fornecedor.getUf_pessoa());
            stmt.setString(11, fornecedor.getCep_pessoa());
            stmt.setString(12, fornecedor.getTelefone_pessoa());
            stmt.setString(13, fornecedor.getCelular_pessoa());
            stmt.setString(14, fornecedor.getEmail_pessoa());
            stmt.setString(15, fornecedor.getObs_pessoa());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar fornecedor! Erro:" + ex.getMessage());
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
    public List<Fornecedor> listar() {
        List<Fornecedor> resultado = new ArrayList<Fornecedor>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM administrativo.pessoa p , administrativo.fornecedor f WHERE p.id_pessoa = f.id_pessoa ORDER BY f.id_fornecedor;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId_pessoa(rs.getInt("id_pessoa"));
                fornecedor.setTipo_pessoa(rs.getString("tipo_pessoa"));
                fornecedor.setNome_pessoa(rs.getString("nome_pessoa"));
                fornecedor.setCpf_pessoa(rs.getString("cpf_pessoa"));
                fornecedor.setRg_pessoa(rs.getString("rg_pessoa"));
                fornecedor.setEndereco_pessoa(rs.getString("endereco_pessoa"));
                fornecedor.setNumero_pessoa(rs.getInt("numero_pessoa"));
                fornecedor.setBairro_pessoa(rs.getString("bairro_pessoa"));
                fornecedor.setComplemento_pessoa(rs.getString("complemento_pessoa"));
                fornecedor.setCidade_pessoa(rs.getString("cidade_pessoa"));
                fornecedor.setUf_pessoa(rs.getString("uf_pessoa"));
                fornecedor.setCep_pessoa(rs.getString("cep_pessoa"));
                fornecedor.setTelefone_pessoa(rs.getString("telefone_pessoa"));
                fornecedor.setCelular_pessoa(rs.getString("celular_pessoa"));
                fornecedor.setEmail_pessoa(rs.getString("email_pessoa"));
                fornecedor.setObs_pessoa(rs.getString("obs_pessoa"));
                fornecedor.setId_fornecedor(rs.getInt("id_fornecedor"));
                resultado.add(fornecedor);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar fornecedor! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirFornecedor(Integer id_pessoa) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM administrativo.pessoa p WHERE p.id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pessoa);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir o fornecedor !Erro:" + ex.getMessage());
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
    public Fornecedor listarFornecedor(Integer id_pessoa) {
        List<Fornecedor> resultado = new ArrayList<Fornecedor>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Fornecedor fornecedor = null;

        String sql = "SELECT * FROM administrativo.pessoa p, administrativo.fornecedor f WHERE p.id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pessoa);
            rs = stmt.executeQuery();

            while (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId_pessoa(rs.getInt("id_pessoa"));
                fornecedor.setTipo_pessoa(rs.getString("tipo_pessoa"));
                fornecedor.setNome_pessoa(rs.getString("nome_pessoa"));
                fornecedor.setCpf_pessoa(rs.getString("cpf_pessoa"));
                fornecedor.setRg_pessoa(rs.getString("rg_pessoa"));
                fornecedor.setEndereco_pessoa(rs.getString("endereco_pessoa"));
                fornecedor.setNumero_pessoa(rs.getInt("numero_pessoa"));
                fornecedor.setBairro_pessoa(rs.getString("bairro_pessoa"));
                fornecedor.setComplemento_pessoa(rs.getString("complemento_pessoa"));
                fornecedor.setCidade_pessoa(rs.getString("cidade_pessoa"));
                fornecedor.setUf_pessoa(rs.getString("uf_pessoa").toUpperCase());
                fornecedor.setCep_pessoa(rs.getString("cep_pessoa"));
                fornecedor.setTelefone_pessoa(rs.getString("telefone_pessoa"));
                fornecedor.setCelular_pessoa(rs.getString("celular_pessoa"));
                fornecedor.setEmail_pessoa(rs.getString("email_pessoa"));
                fornecedor.setObs_pessoa(rs.getString("obs_pessoa"));
                resultado.add(fornecedor);
            }

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados fornecedor !Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return fornecedor;
    }

    @Override
    public void alterarFornecedor(Fornecedor fornecedor) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.pessoa SET nome_pessoa=?, endereco_pessoa=?,"
                + "numero_pessoa=?, bairro_pessoa=?, complemento_pessoa=?, cidade_pessoa=?, uf_pessoa=?, cep_pessoa=?, telefone_pessoa=?, celular_pessoa=?,"
                + "email_pessoa=?, obs_pessoa=? WHERE id_pessoa=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome_pessoa());
            stmt.setString(2, fornecedor.getEndereco_pessoa());
            stmt.setInt(3, fornecedor.getNumero_pessoa());
            stmt.setString(4, fornecedor.getBairro_pessoa());
            stmt.setString(5, fornecedor.getComplemento_pessoa());
            stmt.setString(6, fornecedor.getCidade_pessoa());
            stmt.setString(7, fornecedor.getUf_pessoa());
            stmt.setString(8, fornecedor.getCep_pessoa());
            stmt.setString(9, fornecedor.getTelefone_pessoa());
            stmt.setString(10, fornecedor.getCelular_pessoa());
            stmt.setString(11, fornecedor.getEmail_pessoa());
            stmt.setString(12, fornecedor.getObs_pessoa());
            stmt.setInt(13, fornecedor.getId_pessoa());

            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar fornecedor! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }

    @Override
    public List<Fornecedor> consultarFornecedor(String nome_fornecedor) {
        List<Fornecedor> resultado = new ArrayList<Fornecedor>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT f.id_fornecedor, p.nome_pessoa FROM administrativo.pessoa p , administrativo.fornecedor f WHERE p.id_pessoa = f.id_pessoa AND p.nome_pessoa LIKE ? ;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome_fornecedor + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId_fornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setNome_pessoa(rs.getString("nome_pessoa"));
                resultado.add(fornecedor);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar fornecedor! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
}
