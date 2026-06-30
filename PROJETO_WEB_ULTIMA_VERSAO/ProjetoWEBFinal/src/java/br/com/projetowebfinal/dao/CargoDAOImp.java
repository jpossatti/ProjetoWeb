/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Cargo;
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
public class CargoDAOImp implements CargoDAO {
/*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public CargoDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }


    public void cadastrarCargo(Cargo cargo) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.cargo(nome_cargo)"
                + "VALUES"
                + "(?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cargo.getNome_cargo());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar cargo! Erro:" + ex.getMessage());
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
    public List<Cargo> listar() {
        List<Cargo> resultado = new ArrayList<Cargo>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM administrativo.cargo;";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
            Cargo cargo = new Cargo();
            cargo.setId_cargo(rs.getInt("id_cargo"));
            cargo.setNome_cargo(rs.getString("nome_cargo"));
            resultado.add(cargo);
            }
       }
            catch (SQLException ex){ /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar cargo! Erro: "+ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirCargo(Integer id_cargo) {
        PreparedStatement stmt = null;
        String sql="DELETE FROM administrativo.cargo c WHERE c.id_cargo = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_cargo);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir o cargo !Erro:"+ex.getMessage());
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
    public Cargo listarCargo(Integer id_cargo) {
        List<Cargo> resultado = new ArrayList<Cargo>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cargo cargo = null;

          String sql = "SELECT * FROM administrativo.cargo c  WHERE c.id_cargo = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_cargo);
            rs = stmt.executeQuery();

            while (rs.next()){
            cargo = new Cargo();
            cargo.setId_cargo(rs.getInt("id_cargo"));
            cargo.setNome_cargo(rs.getString("nome_cargo"));
            resultado.add(cargo);
            }

            if (resultado.size()>0){
                return resultado.get(0);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao buscar dados pessoa !Erro: "+ ex.getMessage());
            ex.printStackTrace();
        }
        return cargo;
    }
    public void alterarCargo(Cargo cargo) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.cargo SET nome_cargo=? WHERE id_cargo=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cargo.getNome_cargo());
            stmt.setInt(2, cargo.getId_cargo());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar cargo! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
 
    }
}
