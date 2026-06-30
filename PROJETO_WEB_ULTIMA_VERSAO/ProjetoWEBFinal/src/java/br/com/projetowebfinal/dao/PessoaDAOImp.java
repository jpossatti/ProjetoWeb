/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Pessoa;
import br.com.projetowebfinal.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public class PessoaDAOImp implements PessoaDAO {
 /*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public PessoaDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }


    public void cadastrarPessoa(Pessoa pessoa) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.pessoa(tipo_pessoa, nome_pessoa, cpf_pessoa, rg_pessoa, endereco_pessoa,"
                + "numero_pessoa, bairro_pessoa, complemento_pessoa, cidade_pessoa, uf_pessoa, cep_pessoa, telefone_pessoa, celular_pessoa,"
                + "email_pessoa, obs_pessoa)"
                + "VALUES"
                + "('PF', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getTipo_pessoa());
            stmt.setString(2, pessoa.getNome_pessoa());
            stmt.setString(3, pessoa.getCpf_pessoa());
            stmt.setString(4, pessoa.getRg_pessoa());
            stmt.setString(5, pessoa.getEndereco_pessoa());
            stmt.setInt(6,    pessoa.getNumero_pessoa());
            stmt.setString(7, pessoa.getBairro_pessoa());
            stmt.setString(8, pessoa.getComplemento_pessoa());
            stmt.setString(9, pessoa.getCidade_pessoa());
            stmt.setString(10, pessoa.getUf_pessoa());
            stmt.setString(11, pessoa.getCep_pessoa());
            stmt.setString(12, pessoa.getTelefone_pessoa());
            stmt.setString(13, pessoa.getCelular_pessoa());
            stmt.setString(14, pessoa.getEmail_pessoa());
            stmt.setString(15, pessoa.getObs_pessoa());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar pessoa! Erro:" + ex.getMessage());
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
    public List<Pessoa> listar() {
        List<Pessoa> resultado = new ArrayList<Pessoa>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT * FROM administrativo.pessoa p;";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
            Pessoa pessoa = new Pessoa();
            pessoa.setId_pessoa(rs.getInt("id_pessoa"));
            pessoa.setTipo_pessoa(rs.getString("tipo_pessoa"));
            pessoa.setNome_pessoa(rs.getString("nome_pessoa"));
            pessoa.setCpf_pessoa(rs.getString("cpf_pessoa"));
            pessoa.setRg_pessoa(rs.getString("rg_pessoa"));
            pessoa.setEndereco_pessoa(rs.getString("endereco_pessoa"));
            pessoa.setNumero_pessoa(rs.getInt("numero_pessoa"));
            pessoa.setBairro_pessoa(rs.getString("bairro_pessoa"));
            pessoa.setComplemento_pessoa(rs.getString("complemento_pessoa"));
            pessoa.setCidade_pessoa(rs.getString("cidade_pessoa"));
            pessoa.setUf_pessoa(rs.getString("uf_pessoa"));
            pessoa.setCep_pessoa(rs.getString("cep_pessoa"));
            pessoa.setTelefone_pessoa(rs.getString("telefone_pessoa"));
            pessoa.setCelular_pessoa(rs.getString("celular_pessoa"));
            pessoa.setEmail_pessoa(rs.getString("email_pessoa"));
            pessoa.setObs_pessoa(rs.getString("obs_pessoa"));
            pessoa.setId_pessoa(rs.getInt("id_pessoa"));
            resultado.add(pessoa);
            }
       }
            catch (SQLException ex){ /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar pessoa! Erro: "+ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
            ex.printStackTrace(); /*Mostra certinho onde esta o erro, em detalhes*/
        }finally { /*Executo ele todas as vezes */
            try{
                ConnectionFactory.closeConnection(conn,stmt,rs);
            }catch(Exception ex){
                System.out.println("Problemas as fechar os parâmetros de conexão!Erro:"+ex.getMessage());
                ex.printStackTrace();
            }

        }
        return resultado;
    }

    @Override
    public void excluirPessoa(Integer id_pessoa) {
        PreparedStatement stmt = null;
        String sql="DELETE FROM administrativo.pessoa p WHERE p.id_pessoa = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pessoa);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir o pessoa !Erro:"+ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn,stmt);
            }catch (Exception ex){
                System.out.println("Problemas as fechar os parâmetros de conexão!Erro:"+ex.getMessage());
           }
        }
    }

    @Override
    public Pessoa listarPessoa(Integer id_pessoa) {
        List<Pessoa> resultado = new ArrayList<Pessoa>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pessoa pessoa = null;

          String sql = "SELECT * FROM administrativo.pessoa p  WHERE p.id_pessoa = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pessoa);
            rs = stmt.executeQuery();

            while (rs.next()){
            pessoa = new Pessoa();
            pessoa.setId_pessoa(rs.getInt("id_pessoa"));
            pessoa.setTipo_pessoa(rs.getString("tipo_pessoa"));
            pessoa.setNome_pessoa(rs.getString("nome_pessoa"));
            pessoa.setCpf_pessoa(rs.getString("cpf_pessoa"));
            pessoa.setRg_pessoa(rs.getString("rg_pessoa"));
            pessoa.setEndereco_pessoa(rs.getString("endereco_pessoa"));
            pessoa.setNumero_pessoa(rs.getInt("numero_pessoa"));
            pessoa.setBairro_pessoa(rs.getString("bairro_pessoa"));
            pessoa.setComplemento_pessoa(rs.getString("complemento_pessoa"));
            pessoa.setCidade_pessoa(rs.getString("cidade_pessoa"));
            pessoa.setUf_pessoa(rs.getString("uf_pessoa"));
            pessoa.setCep_pessoa(rs.getString("cep_pessoa"));
            pessoa.setTelefone_pessoa(rs.getString("telefone_pessoa"));
            pessoa.setCelular_pessoa(rs.getString("celular_pessoa"));
            pessoa.setEmail_pessoa(rs.getString("email_pessoa"));
            pessoa.setObs_pessoa(rs.getString("obs_pessoa"));
            resultado.add(pessoa);
            }

            if (resultado.size()>0){
                return resultado.get(0);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao buscar dados pessoa !Erro: "+ ex.getMessage());
            ex.printStackTrace();
        }
        return pessoa;
    }
     public void alterarPessoa(Pessoa pessoa) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.pessoa SET tipo_pessoa=?, nome_pessoa=?, cpf_pessoa=?, rg_pessoa=?, endereco_pessoa=?,"
                + "numero_pessoa=?, bairro_pessoa=?, complemento_pessoa=?, cidade_pessoa=?, uf_pessoa=?, cep_pessoa=?, telefone_pessoa=?, celular_pessoa=?,"
                + "email_pessoa=?, obs_pessoa=? WHERE id_pessoa=?;";
               

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getTipo_pessoa());
            stmt.setString(2, pessoa.getNome_pessoa());
            stmt.setString(3, pessoa.getCpf_pessoa());
            stmt.setString(4, pessoa.getRg_pessoa());
            stmt.setString(5, pessoa.getEndereco_pessoa());
            stmt.setInt(6,    pessoa.getNumero_pessoa());
            stmt.setString(7, pessoa.getBairro_pessoa());
            stmt.setString(8, pessoa.getComplemento_pessoa());
            stmt.setString(9, pessoa.getCidade_pessoa());
            stmt.setString(10, pessoa.getUf_pessoa());
            stmt.setString(11, pessoa.getCep_pessoa());
            stmt.setString(12, pessoa.getTelefone_pessoa());
            stmt.setString(13, pessoa.getCelular_pessoa());
            stmt.setString(14, pessoa.getEmail_pessoa());
            stmt.setString(15, pessoa.getObs_pessoa());
            stmt.setInt(16,    pessoa.getId_pessoa());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar pessoa! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }

    
}
