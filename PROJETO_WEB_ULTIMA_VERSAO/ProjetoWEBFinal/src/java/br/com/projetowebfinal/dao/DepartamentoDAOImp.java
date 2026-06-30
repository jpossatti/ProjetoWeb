/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Departamento;
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
public class DepartamentoDAOImp implements DepartamentoDAO {
  /*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public DepartamentoDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }


    public void cadastrarDepartamento(Departamento departamento) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        String sql = "INSERT INTO administrativo.departamento(nome_departamento)"
                + "VALUES"
                + "(?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, departamento.getNome_departamento());
            stmt.execute(); /* executa os dados na tabela*/            
            //******************SEGUNDO E TERCEIRO insert na tabela BEM_PRODUTO/BEM_PERMISSAO*********************COM VETOR******************
            String sql2 = "INSERT INTO administrativo.departamento_cargo(id_departamento, id_cargo)"
                    + "VALUES"
                    + "((SELECT max(id_departamento) from administrativo.departamento), ?);";
            String[] cargos_departamento = departamento.getCargos_departamento();
            for (int i = 0; i < cargos_departamento.length; i++) {
                stmt2 = conn.prepareStatement(sql2);
                stmt2.setInt(1, Integer.parseInt(cargos_departamento[i]));
                stmt2.execute(); /* executa os dados na tabela*/
            }
            System.out.println(sql2);
            
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar departamento! Erro:" + ex.getMessage());
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
    public List<Departamento> listar() {
        List<Departamento> resultado = new ArrayList<Departamento>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM administrativo.departamento;";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
            Departamento departamento = new Departamento();
            departamento.setId_departamento(rs.getInt("id_departamento"));
            departamento.setNome_departamento(rs.getString("nome_departamento"));
            resultado.add(departamento);
            }
       }
            catch (SQLException ex){ /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar departamento! Erro: "+ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirDepartamento(Integer id_departamento) {
        PreparedStatement stmt = null;
        String sql="DELETE FROM administrativo.departamento d WHERE d.id_departamento = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_departamento);
            stmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Problemas ao excluir o departamento !Erro:"+ex.getMessage());
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
    public Departamento listarDepartamento(Integer id_departamento) {
        List<Departamento> resultado = new ArrayList<Departamento>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Departamento departamento = null;

          String sql = "SELECT * FROM administrativo.departamento d  WHERE d.id_departamento = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_departamento);
            rs = stmt.executeQuery();

            while (rs.next()){
            departamento = new Departamento();
            departamento.setId_departamento(rs.getInt("id_departamento"));
            departamento.setNome_departamento(rs.getString("nome_departamento"));
            resultado.add(departamento);
            }

            if (resultado.size()>0){
                return resultado.get(0);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao buscar dados pessoa !Erro: "+ ex.getMessage());
            ex.printStackTrace();
        }
        return departamento;
    }
     public void alterarDepartamento(Departamento departamento) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.departamento SET nome_departamento=? WHERE id_departamento=?;";
               
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, departamento.getNome_departamento());
            stmt.setInt(2, departamento.getId_departamento());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar departamento! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }


   
}
