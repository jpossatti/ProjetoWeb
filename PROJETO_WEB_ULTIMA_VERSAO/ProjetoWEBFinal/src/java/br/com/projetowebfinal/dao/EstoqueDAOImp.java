/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Estoque;
import br.com.projetowebfinal.model.Produto;
import br.com.projetowebfinal.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public class EstoqueDAOImp implements EstoqueDAO {
    /*pedindo a conexão*/

    private Connection conn;
    /*gerando metodos contrutores*/

    public EstoqueDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }

    @Override
    public void cadastrarEstoque(Estoque estoque) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.estoque(quantidade_estoque, data_movimentacao_estoque, tipo_movimentacao_estoque, id_produto, margemlucro_produto)"
                + "VALUES"
                + "(?, ?, ?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, estoque.getQuantidade_estoque());
            stmt.setDate(2, (Date) estoque.getData_movimentacao_estoque());
            stmt.setString(3, estoque.getTipo_movimentacao_estoque());
            stmt.setInt(4, estoque.getId_produto());
            stmt.setDouble(5, estoque.getMargemlucro_produto());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar estoque! Erro:" + ex.getMessage());
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
    public List<Estoque> listar() {
        List<Estoque> resultado = new ArrayList<Estoque>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM administrativo.estoque e, administrativo.produto p WHERE e.id_produto = p.id_produto;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque estoque = new Estoque();
                Produto produto = new Produto();
                estoque.setId_estoque(rs.getInt("id_estoque"));
                estoque.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setDescricao_produto(rs.getString("descricao_produto"));
                estoque.setObproduto(produto);
                resultado.add(estoque);
            }

        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar estoque! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirEstoque(Integer id_estoque) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM administrativo.estoque e WHERE e.id_estoque = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_estoque);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir o estoque !Erro:" + ex.getMessage());
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
    public Estoque listarEstoque(Integer id_estoque) {
        List<Estoque> resultado = new ArrayList<Estoque>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estoque estoque = null;

        String sql = "SELECT * FROM administrativo.estoque e  WHERE e.id_estoque = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_estoque);
            rs = stmt.executeQuery();

            while (rs.next()) {
                estoque = new Estoque();
                estoque.setId_estoque(rs.getInt("id_estoque"));
                estoque.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
                estoque.setData_movimentacao_estoque(rs.getDate("data_movimentacao_estoque"));
                estoque.setTipo_movimentacao_estoque(rs.getString("tipo_movimentacao_estoque"));
                estoque.setId_produto(rs.getInt("id_produto"));
                resultado.add(estoque);
            }

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados estoque !Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return estoque;
    }

    @Override
    public void alterarEstoque(Estoque estoque) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.estoque SET quantidade_estoque=?, data_movimentacao_estoque=?, tipo_movimentacao_estoque=?, id_produto=? WHERE id_estoque=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, estoque.getQuantidade_estoque());
            stmt.setDate(2, (Date) estoque.getData_movimentacao_estoque());
            stmt.setString(3, estoque.getTipo_movimentacao_estoque());
            stmt.setInt(4, estoque.getId_produto());
            stmt.setInt(5, estoque.getId_estoque());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar estoque! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        } finally {/*executa ele todas as vezes*/

        }
    }
}
