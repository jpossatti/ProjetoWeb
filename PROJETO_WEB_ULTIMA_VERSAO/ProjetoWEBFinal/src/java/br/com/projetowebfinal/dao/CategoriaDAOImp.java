/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Categoria;
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
public class CategoriaDAOImp implements CategoriaDAO {
 /*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public CategoriaDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }


    @Override
    public void cadastrarCategoria(Categoria categoria) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.categoria(descricao_categoria, grupo_categoria)"
                + "VALUES"
                + "(?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao_categoria());
            stmt.setInt(2, categoria.getGrupo_categoria());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar categoria! Erro:" + ex.getMessage());
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
    public List<Categoria> listar() {
        List<Categoria> resultado = new ArrayList<Categoria>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM administrativo.categoria;";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
            Categoria categoria = new Categoria();
            categoria.setId_categoria(rs.getInt("id_categoria"));
            categoria.setDescricao_categoria(rs.getString("descricao_categoria"));
            categoria.setGrupo_categoria(rs.getInt("grupo_categoria"));
            resultado.add(categoria);
            }
       }
            catch (SQLException ex){ /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar categoria! Erro: "+ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirCategoria(Integer id_categoria) {
        PreparedStatement stmt = null;
        String sql="DELETE FROM administrativo.categoria c WHERE c.id_categoria = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_categoria);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir o categoria !Erro:"+ex.getMessage());
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
    public Categoria listarCategoria(Integer id_categoria) {
        List<Categoria> resultado = new ArrayList<Categoria>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Categoria categoria = null;

          String sql = "SELECT * FROM administrativo.categoria c  WHERE c.id_categoria = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_categoria);
            rs = stmt.executeQuery();

            while (rs.next()){
            categoria = new Categoria();
            categoria.setId_categoria(rs.getInt("id_categoria"));
            categoria.setDescricao_categoria(rs.getString("descricao_categoria"));
            categoria.setGrupo_categoria(rs.getInt("grupo_categoria"));
            resultado.add(categoria);
            }

            if (resultado.size()>0){
                return resultado.get(0);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao buscar dados categoria !Erro: "+ ex.getMessage());
            ex.printStackTrace();
        }
        return categoria;
    }

     public void alterarCategoria(Categoria categoria) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.categoria SET descricao_categoria=?, grupo_categoria = ? WHERE id_categoria=?";
               
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao_categoria());
            stmt.setInt(2,categoria.getGrupo_categoria());
            stmt.setInt(3,categoria.getId_categoria());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar categoria! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }
}

