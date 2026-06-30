/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Categoria;
import br.com.projetowebfinal.model.Produto;
import br.com.projetowebfinal.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jpossatti
 */
public class ProdutoDAOImp implements ProdutoDAO {
    /*pedindo a conexão*/

    private Connection conn;
    /*gerando metodos contrutores*/

    public ProdutoDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;

        String sql0 = "SELECT descricao_produto FROM administrativo.produto WHERE '" + produto.getDescricao_produto() + "' LIKE '%ARDUINO%';";

        String sql = "INSERT INTO administrativo.produto(descricao_produto, marca_produto)"
                + "VALUES"
                + "(?, ?);";

        try {
            stmt2 = conn.prepareStatement(sql0);
            rs = stmt2.executeQuery();
            String res = "";

            while (rs.next()) {
                res = rs.getString("descricao_produto");
            }

            System.out.println("O produto: " + res + " já existe!!!");

            if (res.equals("ARDUINO")) {
                String msg = "não foi possivel cadastrar produto! item já existente";
                produto.setMsg(msg);
                JOptionPane.showMessageDialog(null, produto.getMsg());
                System.out.println("não foi possivel cadastrar produto! item já existente");

            } else {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, produto.getDescricao_produto());
                stmt.setString(2, produto.getMarca_produto());
                stmt.execute(); /* executa os dados na tabela*/
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar produto! Erro:" + ex.getMessage());
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
    public List<Produto> listar() {
        List<Produto> resultado = new ArrayList<Produto>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT * FROM administrativo.produto;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setDescricao_produto(rs.getString("descricao_produto"));
                produto.setMarca_produto(rs.getString("marca_produto"));
                resultado.add(produto);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar produto! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirProduto(Integer id_produto) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM administrativo.produto p WHERE p.id_produto = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_produto);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir o produto !Erro:" + ex.getMessage());
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
    public Produto listarProduto(Integer id_produto) {
        List<Produto> resultado = new ArrayList<Produto>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto produto = null;

        String sql = "SELECT * FROM administrativo.produto p WHERE p.id_produto = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_produto);
            rs = stmt.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                Categoria categoria = new Categoria();
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setDescricao_produto(rs.getString("descricao_produto"));
                produto.setMarca_produto(rs.getString("marca_produto"));
                //categoria.setId_categoria(rs.getInt("id_categoria"));
                //categoria.setDescricao_categoria(rs.getString("descricao_categoria"));  
                resultado.add(produto);
            }

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados produto !Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return produto;
    }

    public void alterarProduto(Produto produto) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.produto SET descricao_produto=?, marca_produto = ? "
                + "WHERE id_produto=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao_produto());
            stmt.setString(2, produto.getMarca_produto());
            stmt.setInt(3, produto.getId_produto());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar produto! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }

    @Override
    public Produto listarProdutoEstoque(Integer id_produto) {
        List<Produto> resultado = new ArrayList<Produto>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto produto = null;

        String sql = "SELECT * FROM administrativo.produto p WHERE p.id_produto = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_produto);
            rs = stmt.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                Categoria categoria = new Categoria();
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setDescricao_produto(rs.getString("descricao_produto"));
                //categoria.setId_categoria(rs.getInt("id_categoria"));
                //categoria.setDescricao_categoria(rs.getString("descricao_categoria"));  
                resultado.add(produto);
            }

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados produto !Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return produto;
    }

    @Override
    public List<Produto> consultarProdutoBem(String descricao_produto) {
        List<Produto> resultado = new ArrayList<Produto>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT p.id_produto, p.descricao_produto FROM administrativo.produto p WHERE p.descricao_produto LIKE ? AND p.descricao_produto NOT LIKE '%ARDUINO%';";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, descricao_produto + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto cliente = new Produto();
                cliente.setId_produto(rs.getInt("id_produto"));
                cliente.setDescricao_produto(rs.getString("descricao_produto"));
                resultado.add(cliente);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar produtos! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
