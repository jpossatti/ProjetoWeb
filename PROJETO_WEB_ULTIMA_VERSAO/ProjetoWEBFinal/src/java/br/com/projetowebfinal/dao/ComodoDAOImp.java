/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Comodo;
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
public class ComodoDAOImp implements ComodoDAO{
    /*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public ComodoDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }


    public void cadastrarComodo(Comodo comodo) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.comodo(nome_comodo)"
                + "VALUES"
                + "(?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, comodo.getNome_comodo());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar comodo! Erro:" + ex.getMessage());
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
    public List<Comodo> listar() {
        List<Comodo> resultado = new ArrayList<Comodo>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM administrativo.comodo;";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
            Comodo comodo = new Comodo();
            comodo.setId_comodo(rs.getInt("id_comodo"));
            comodo.setNome_comodo(rs.getString("nome_comodo"));
            resultado.add(comodo);
            }
       }
            catch (SQLException ex){ /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar comodo! Erro: "+ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirComodo(Integer id_comodo) {
        PreparedStatement stmt = null;
        String sql="DELETE FROM administrativo.comodo c WHERE c.id_comodo = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_comodo);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir o comodo !Erro:"+ex.getMessage());
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
    public Comodo listarComodo(Integer id_comodo) {
        List<Comodo> resultado = new ArrayList<Comodo>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Comodo comodo = null;

          String sql = "SELECT  * FROM administrativo.comodo c WHERE c.id_comodo = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_comodo);
            rs = stmt.executeQuery();

            while (rs.next()){
            comodo = new Comodo();
            comodo.setId_comodo(rs.getInt("id_comodo"));
            comodo.setNome_comodo(rs.getString("nome_comodo"));
            resultado.add(comodo);
            }

            if (resultado.size()>0){
                return resultado.get(0);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao buscar dados comodo !Erro: "+ ex.getMessage());
            ex.printStackTrace();
        }
        return comodo;
     }
     public void alterarComodo(Comodo comodo) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.comodo SET nome_comodo=? WHERE id_comodo=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, comodo.getNome_comodo());
            stmt.setInt(2,comodo.getId_comodo());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar comodo! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }
}
