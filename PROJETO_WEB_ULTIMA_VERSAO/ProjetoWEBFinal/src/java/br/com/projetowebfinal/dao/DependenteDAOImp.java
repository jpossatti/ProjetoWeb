/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Dependente;
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
public class DependenteDAOImp implements DependenteDAO {
     /*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public DependenteDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }


    public void cadastrarDependente(Dependente dependente) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.dependente(id_cliente, nome_dependente, parentesco_dependente)"
                + "VALUES"
                + "(?,?,?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, dependente.getId_cliente());
            stmt.setString(2, dependente.getNome_dependente());
            stmt.setString(3, dependente.getParentesco_dependente());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar dependente! Erro:" + ex.getMessage());
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
    public List<Dependente> listar() {
        List<Dependente> resultado = new ArrayList<Dependente>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM administrativo.dependente;";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
            Dependente dependente = new Dependente();
            dependente.setId_dependente(rs.getInt("id_dependente"));
            dependente.setNome_dependente(rs.getString("nome_dependente"));
            dependente.setParentesco_dependente(rs.getString("parentesco_dependente"));
            dependente.setId_cliente(rs.getInt("id_cliente"));
            resultado.add(dependente);
            }
       }
            catch (SQLException ex){ /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar dependente! Erro: "+ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirDependente(Integer id_dependente) {
        PreparedStatement stmt = null;
        String sql="DELETE FROM administrativo.dependente d WHERE d.id_dependente = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_dependente);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir o dependente !Erro:"+ex.getMessage());
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
    public Dependente listarDependente(Integer id_dependente) {
        List<Dependente> resultado = new ArrayList<Dependente>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Dependente dependente = null;

          String sql = "SELECT * FROM administrativo.dependente d  WHERE d.id_dependente = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_dependente);
            rs = stmt.executeQuery();

            while (rs.next()){
            dependente = new Dependente();
            dependente.setId_dependente(rs.getInt("id_dependente"));
            dependente.setNome_dependente(rs.getString("nome_dependente"));
            dependente.setParentesco_dependente(rs.getString("parentesco_dependente"));
            dependente.setId_cliente(rs.getInt("id_cliente"));
            resultado.add(dependente);
            }

            if (resultado.size()>0){
                return resultado.get(0);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao buscar dados dependente !Erro: "+ ex.getMessage());
            ex.printStackTrace();
        }
        return dependente;
    }
    public void alterarDependente(Dependente dependente) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.dependente SET id_cliente=?, nome_dependente=?, parentesco_dependente=? WHERE id_dependente=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, dependente.getId_cliente());
            stmt.setString(2, dependente.getNome_dependente());
            stmt.setString(3, dependente.getParentesco_dependente());
            stmt.setInt(4,dependente.getId_dependente());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar dependente! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }

}
