/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Arduino;
import br.com.projetowebfinal.model.Bem;
import br.com.projetowebfinal.model.ProdutoBem;
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
public class BemDAOImp implements BemDAO {

    /*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public BemDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }

    @Override
    public void cadastrarBem(Bem bem) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/

        PreparedStatement stmt = null;
        //******************primeiro insert na tabela BEM.*********************SEM VETOR****************************
        String sql = "INSERT INTO administrativo.bem(descricao_bem, marca_bem, id_sub_categoria, precomaodeobra_bem )"
                + "VALUES"
                + "(?, ?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, bem.getDescricao_bem());
            stmt.setString(2, bem.getMarca_bem());
            stmt.setInt(3, bem.getId_categoria());
            stmt.setDouble(4, bem.getPrecomaodeobra_bem());

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar bem! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }

    @Override
    public Double ResgatarValor(Integer id_bem) {
        Double resultado = 0.00;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM administrativo.bem b where b.id_bem=" + id_bem + ";";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Double totalmargem = 0.00;
                Double totalmaobra = 0.00;
                Double totalproduto = 0.00;

                //produto agrupado do interno
                String sql2 = "SELECT p.id_produto from  administrativo.item_pedido_compra it, administrativo.produto p where p.id_produto = it.id_produto group by 1";
                stmt = conn.prepareStatement(sql2);
                ResultSet rs2 = stmt.executeQuery();
                while (rs2.next()) {
                    // ultima compra de produto (laço)
                    String sql3 = "SELECT it.valorunitario_item_pedido_compra , it.id_produto from  administrativo.item_pedido_compra it, administrativo.produto p where p.id_produto = it.id_produto and p.id_produto=" + rs2.getString(1).trim() + " order by it.id_item_pedido_compra desc limit 1";
                    stmt = conn.prepareStatement(sql3);
                    ResultSet rs3 = stmt.executeQuery();
                    while (rs3.next()) {
                        //bem
                        String sql4 = "SELECT DISTINCT id.id_produto from administrativo.bem_produto id where id.id_bem =" + rs.getString(1).trim() + " order by 1";
                        stmt = conn.prepareStatement(sql4);
                        ResultSet rs4 = stmt.executeQuery();
                        while (rs4.next()) {
                            //acumulação valor produto
                            int v1 = rs4.getInt(1);
                            int v2 = rs3.getInt(2);
                            if (v1 == v2) {
                                totalproduto = totalproduto + rs3.getDouble(1);
                                //margem lucro
                                String sql5 = "SELECT pc.valorunitario_item_pedido_compra FROM administrativo.item_pedido_compra pc, administrativo.produto p WHERE pc.id_produto = p.id_produto AND pc.id_produto= " + v1;
                                stmt = conn.prepareStatement(sql5);
                                ResultSet rs5 = stmt.executeQuery();
                                if (rs5.next()) {
                                    totalmargem = totalmargem + rs5.getDouble(1);// acumulação margem lucro
                                }
                            }
                        }
                    }
                }
                //mao obra
                String sql6 = "SELECT x.precomaodeobra_bem from administrativo.bem x where x.id_bem =" + rs.getString(1).trim();
                stmt = conn.prepareStatement(sql6);
                ResultSet rs6 = stmt.executeQuery();
                if (rs6.next()) {
                    totalmaobra = rs6.getDouble(1);
                }


                double total = ((totalmaobra + totalmargem) + totalproduto);
                resultado = total;
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar bem! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public List<Bem> listar() {
        List<Bem> resultado = new ArrayList<Bem>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM administrativo.bem b ;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Bem bem = new Bem();
                bem.setId_bem(rs.getInt("id_bem"));
                bem.setDescricao_bem(rs.getString("descricao_bem"));
                bem.setMarca_bem(rs.getString("marca_bem"));
                bem.setId_categoria(rs.getInt("id_sub_categoria"));
                Double totalmargem = 0.00;
                Double totalmaobra = 0.00;
                Double totalproduto = 0.00;

                //produto agrupado do interno
                String sql2 = "SELECT p.id_produto from  administrativo.item_pedido_compra it, administrativo.produto p where p.id_produto = it.id_produto group by 1";
                stmt = conn.prepareStatement(sql2);
                ResultSet rs2 = stmt.executeQuery();
                while (rs2.next()) {
                    // ultima compra de produto (laço)
                    String sql3 = "SELECT it.valorunitario_item_pedido_compra , it.id_produto from  administrativo.item_pedido_compra it, administrativo.produto p where p.id_produto = it.id_produto and p.id_produto=" + rs2.getString(1).trim() + " order by it.id_item_pedido_compra desc limit 1";
                    stmt = conn.prepareStatement(sql3);
                    ResultSet rs3 = stmt.executeQuery();
                    while (rs3.next()) {
                        //bem
                        String sql4 = "SELECT id.id_produto from administrativo.bem_produto id where id.id_bem =" + rs.getString(1).trim() + " order by 1";
                        stmt = conn.prepareStatement(sql4);
                        ResultSet rs4 = stmt.executeQuery();
                        while (rs4.next()) {
                            //acumulação valor produto
                            int v1 = rs4.getInt(1);
                            int v2 = rs3.getInt(2);
                            if (v1 == v2) {
                                totalproduto = totalproduto + rs3.getDouble(1);
                                //margem lucro 
                                //e.id_produto_fornecedor =" + v1 + " and 
                                String sql5 = "SELECT e.valorcompra_produto from administrativo.movimentacao e WHERE e.tipo_movimentacao_estoque ='ENTRADA'";
                                stmt = conn.prepareStatement(sql5);
                                ResultSet rs5 = stmt.executeQuery();
                                if (rs5.next()) {
                                    totalmargem = totalmargem + rs5.getDouble(1);// acumulação margem lucro
                                }
                            }
                        }
                    }
                }
                //mao obra
                String sql6 = "SELECT x.precomaodeobra_bem from administrativo.bem x where x.id_bem =" + rs.getString(1).trim();
                stmt = conn.prepareStatement(sql6);
                ResultSet rs6 = stmt.executeQuery();
                if (rs6.next()) {
                    totalmaobra = rs6.getDouble(1);
                }


                double total = ((totalmaobra + totalmargem) + totalproduto);
                bem.setPrecomaodeobra_bem(total);
                resultado.add(bem);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar bem! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirBem(Integer id_bem) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM administrativo.bem b WHERE b.id_bem = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_bem);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir o bem !Erro:" + ex.getMessage());
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
    public Bem listarBem(Integer id_bem) {
        List<Bem> resultado = new ArrayList<Bem>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bem bem = null;

        String sql = "SELECT  * FROM administrativo.bem b WHERE b.id_bem = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_bem);
            rs = stmt.executeQuery();

            while (rs.next()) {
                bem = new Bem();
                bem.setId_bem(rs.getInt("id_bem"));
                bem.setDescricao_bem(rs.getString("descricao_bem"));
                bem.setMarca_bem(rs.getString("marca_bem"));
                bem.setId_categoria(rs.getInt("id_categoria"));
                bem.setPrecomaodeobra_bem(rs.getDouble("precomaodeobra_bem"));
                resultado.add(bem);
            }

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados bem !Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return bem;
    }

    @Override
    public void alterarBem(Bem bem) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.bem SET descricao_bem=?, marca_bem=?,  precomaodeobra_bem=? "
                + "WHERE id_bem=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, bem.getDescricao_bem());
            stmt.setString(2, bem.getMarca_bem());
            stmt.setDouble(3, bem.getPrecomaodeobra_bem());
            stmt.setInt(4, bem.getId_bem());
            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar bem! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }

    @Override
    public void cadastrarProdutoBem(ArrayList<ProdutoBem> itens) {
        PreparedStatement stmt = null;
        String sql = "Insert into administrativo.bem_produto (id_bem, id_produto, quantidade_produto) values ((SELECT MAX (id_bem) FROM administrativo.bem), ?, ?);";
        try {
            for (ProdutoBem item : itens) {
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, item.getId_produto_bem());
                stmt.setInt(2, item.getQuantidade_produto_bem());
                stmt.execute();
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar venda item! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public List<Arduino> listarBemImovelArduino(Integer id_cliente, Integer id_imovel) {
        List<Arduino> resultado = new ArrayList<Arduino>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT pa.id_porta_arduino, pa.numero_porta, c.id_comodo, c.nome_comodo, b.id_bem, b.descricao_bem "
                +"FROM administrativo.item_pedido_venda ipv, "
                +"administrativo.pedido_venda pv, "
                +"administrativo.bem b, "
                +"administrativo.comodo c, "
                +"administrativo.arduino_venda av, "
                +"administrativo.porta_arduino pa "                
                +"WHERE pv.id_pedido_venda = ipv.id_pedido_venda "
                +"AND pv.id_cliente = ? "
                +"AND pv.id_imovel = ? "
                +"AND ipv.id_comodo = c.id_comodo "
                +"AND pv.id_pedido_venda = av.id_pedido_venda "
                +"AND av.id_arduino = pa.id_arduino "
                +"AND pa.id_bem = b.id_bem "
                +"AND ipv.id_bem = b.id_bem;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_cliente);
            stmt.setInt(2, id_imovel);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Arduino arduino = new Arduino();
                arduino.setId_porta_arduino(rs.getInt("id_porta_arduino"));
                arduino.setNumero_porta(rs.getInt("numero_porta"));
                arduino.setId_comodo(rs.getInt("id_comodo"));
                arduino.setNome_comodo(rs.getString("nome_comodo"));
                arduino.setId_bem(rs.getInt("id_bem"));
                arduino.setDescricao_bem(rs.getString("descricao_bem"));                
                resultado.add(arduino);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar cliente! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
