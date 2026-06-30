/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.SubCategoria;
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
public class SubCategoriaDAOImp implements SubCategoriaDAO {
/*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public SubCategoriaDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }


    @Override
    public void cadastrarSubCategoria(SubCategoria subcategoria) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.sub_categoria(nome_sub_categoria, id_categoria, sequencia_subcategoria)"
                + "VALUES"
                + "(?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, subcategoria.getNome_sub_categoria());
            stmt.setInt(2,subcategoria.getId_categoria());
            stmt.setInt(3, subcategoria.getSequencia_subcategoria());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar sub-categoria! Erro:" + ex.getMessage());
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
    public List<SubCategoria> listar() {
        List<SubCategoria> resultado = new ArrayList<SubCategoria>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT  * FROM administrativo.sub_categoria;";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
            SubCategoria subcategoria = new SubCategoria();
            subcategoria.setId_sub_categoria(rs.getInt("id_sub_categoria"));
            subcategoria.setId_categoria(rs.getInt("id_categoria"));
            subcategoria.setNome_sub_categoria(rs.getString("nome_sub_categoria"));
            subcategoria.setSequencia_subcategoria(rs.getInt("sequencia_subcategoria"));
            resultado.add(subcategoria);
            }
       }
            catch (SQLException ex){ /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar sub-categoria! Erro: "+ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirSubCategoria(Integer id_sub_categoria) {
        PreparedStatement stmt = null;
        String sql="DELETE FROM administrativo.sub_categoria sc WHERE sc.id_sub_categoria = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_sub_categoria);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir a sub-categoria !Erro:"+ex.getMessage());
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
    public SubCategoria listarSubCategoria(Integer id_sub_categoria) {
        List<SubCategoria> resultado = new ArrayList<SubCategoria>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SubCategoria subcategoria = null;

          String sql = "SELECT * FROM administrativo.sub_categoria WHERE id_sub_categoria = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_sub_categoria);
            rs = stmt.executeQuery();

            while (rs.next()){
            subcategoria = new SubCategoria();
            subcategoria.setId_sub_categoria(rs.getInt("id_sub_categoria"));
            subcategoria.setNome_sub_categoria(rs.getString("nome_sub_categoria"));
            subcategoria.setId_categoria(rs.getInt("id_categoria"));    
            subcategoria.setSequencia_subcategoria(rs.getInt("sequencia_subcategoria"));
            resultado.add(subcategoria);
            }

            if (resultado.size()>0){
                return resultado.get(0);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao buscar dados sub-categoria !Erro: "+ ex.getMessage());
            ex.printStackTrace();
        }
        return subcategoria;
    }
    @Override
    public void alterarSubCategoria(SubCategoria subcategoria) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.sub_categoria SET nome_sub_categoria=?, id_categoria=?, sequencia_subcategoria = ? WHERE id_sub_categoria=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, subcategoria.getNome_sub_categoria());
            stmt.setInt(2,subcategoria.getId_categoria());
            stmt.setInt(3,subcategoria.getSequencia_subcategoria());
            stmt.setInt(4, subcategoria.getId_sub_categoria());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar sub-categoria! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }
}
