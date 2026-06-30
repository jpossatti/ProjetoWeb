/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.ItemPedidoCompra;
import br.com.projetowebfinal.model.ItemPedidoVenda;
import br.com.projetowebfinal.model.PedidoCompra;
import br.com.projetowebfinal.model.PedidoVenda;
import br.com.projetowebfinal.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class CarrinhoDAOImp implements CarrinhoDAO {

    private Connection conn;
    private Statement stmt;

    public CarrinhoDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());
        }
    }

    @Override
    public Integer cadastrarVenda(PedidoVenda pedidovenda) {
        Integer idvenda = 0;
        String sql = "Insert into administrativo.pedido_venda(data_pedido_venda, valor_pedido_venda, status_pedido_venda, id_cliente, id_imovel)  values(now(), ?, ?, ?, ?) returning id_pedido_venda;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, pedidovenda.getValor_pedido_venda());
            stmt.setString(2, pedidovenda.getStatus_pedido_venda());
            stmt.setInt(3, pedidovenda.getId_cliente());
            stmt.setInt(4, pedidovenda.getId_imovel());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idvenda = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar venda! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return idvenda;
    }

    @Override
    public void cadastrarItemVenda(ArrayList<ItemPedidoVenda> itens) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.item_pedido_venda(quantidade_item_pedido_venda, total_item_pedido_venda, id_pedido_venda,  id_bem, id_comodo) "
                + "VALUES(?, ?, ?, ?, ?); "
                + "COMMIT; "
                + "INSERT INTO administrativo.movimentacao (quantidade_estoque, data_movimentacao_estoque, tipo_movimentacao_estoque, valorcompra_produto, id_pedido) "
                + "VALUES (?, now(), 'SAIDA', ?, ?);";
        try {
            for (ItemPedidoVenda item : itens) {
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, item.getQuantidade_item_pedido_venda());
                stmt.setDouble(2, item.getTotal_item_pedido_venda());
                stmt.setDouble(3, item.getId_pedido_venda());
                stmt.setDouble(4, item.getId_bem());
                stmt.setInt(5, item.getId_comodo());

                stmt.setInt(6, item.getQuantidade_item_pedido_venda());
                stmt.setDouble(7, item.getTotal_item_pedido_venda());
                stmt.setInt(8, item.getId_pedido_venda());

                stmt.execute();
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar venda item! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<PedidoVenda> listarVenda() {
        List<PedidoVenda> resultado = new ArrayList<PedidoVenda>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT pd.id_pedido_venda, p.nome_pessoa, i.endereco_imovel, pd.status_pedido_venda, pd.valor_pedido_venda "
                + "FROM administrativo.pedido_venda pd, administrativo.cliente c, administrativo.pessoa p, administrativo.bem b, administrativo.imovel i "
                + "WHERE pd.id_cliente = c.id_cliente AND c.id_pessoa = p.id_pessoa AND pd.id_imovel = i.id_imovel "
                + "ORDER BY pd.id_pedido_venda DESC;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoVenda pedidovenda = new PedidoVenda();
                pedidovenda.setId_pedido_venda(rs.getInt("id_pedido_venda"));
                pedidovenda.setNome_pessoa(rs.getString("nome_pessoa"));
                pedidovenda.setEndereco_imovel(rs.getString("endereco_imovel"));
                pedidovenda.setStatus_pedido_venda(rs.getString("status_pedido_venda"));
                pedidovenda.setValor_pedido_venda(rs.getDouble("valor_pedido_venda"));
                resultado.add(pedidovenda);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar pedido! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public List<PedidoCompra> listarCompra() {
        List<PedidoCompra> resultado = new ArrayList<PedidoCompra>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT pd.status_pedido_compra, pd.id_pedido_compra, p.nome_pessoa, pd.data_pedido_compra, pd.total_pedido_compra "
                + "FROM administrativo.pessoa p, administrativo.fornecedor f, administrativo.pedido_compra pd "
                + "WHERE pd.id_fornecedor = f.id_fornecedor "
                + "AND f.id_pessoa = p.id_pessoa "
                + "ORDER BY pd.data_pedido_compra;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoCompra pedidocompra = new PedidoCompra();
                pedidocompra.setId_pedido_compra(rs.getInt("id_pedido_compra"));
                pedidocompra.setNome_pessoa(rs.getString("nome_pessoa"));
                pedidocompra.setData_pedido_compra(rs.getString("data_pedido_compra"));
                pedidocompra.setStatus_pedido_compra(rs.getString("status_pedido_compra"));
                pedidocompra.setValor_total(rs.getDouble("total_pedido_compra"));
                resultado.add(pedidocompra);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar pedido! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public List<PedidoVenda> consultarPedidoStatusVenda(String status_pedido_venda) {
        List<PedidoVenda> resultado = new ArrayList<PedidoVenda>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT pd.id_pedido_venda, p.nome_pessoa, i.endereco_imovel, pd.status_pedido_venda, pd.valor_pedido_venda "
                + "FROM administrativo.pedido_venda pd, administrativo.cliente c, administrativo.pessoa p, administrativo.bem b, administrativo.imovel i "
                + "WHERE pd.status_pedido_venda = '" + status_pedido_venda + "' AND pd.id_cliente = c.id_cliente AND c.id_pessoa = p.id_pessoa AND pd.id_imovel = i.id_imovel ORDER BY pd.id_pedido_venda DESC;;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoVenda pedidovenda = new PedidoVenda();
                pedidovenda.setId_pedido_venda(rs.getInt("id_pedido_venda"));
                pedidovenda.setNome_pessoa(rs.getString("nome_pessoa"));
                pedidovenda.setEndereco_imovel(rs.getString("endereco_imovel"));
                pedidovenda.setStatus_pedido_venda(rs.getString("status_pedido_venda"));
                pedidovenda.setValor_pedido_venda(rs.getDouble("valor_pedido_venda"));
                resultado.add(pedidovenda);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar pedido! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
            ex.printStackTrace(); /*Mostra certinho onde esta o erro, em detalhes*/
        }
        return resultado;
    }

    @Override
    public List<PedidoCompra> consultarPedidoStatusCompra(String status_pedido_compra) {
        List<PedidoCompra> resultado = new ArrayList<PedidoCompra>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT pc.id_pedido_compra, pc.data_pedido_compra, pc.status_pedido_compra, p.nome_pessoa, pc.total_pedido_compra "
                + "FROM administrativo.pedido_compra pc, administrativo.fornecedor fn, administrativo.pessoa p "
                + "WHERE pc.id_fornecedor = fn.id_fornecedor "
                + "AND fn.id_pessoa = p.id_pessoa "
                + "AND pc.status_pedido_compra = '" + status_pedido_compra + "' "
                + "ORDER BY pc.id_pedido_compra DESC;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoCompra pedidocompra = new PedidoCompra();
                pedidocompra.setId_pedido_compra(rs.getInt("id_pedido_compra"));
                pedidocompra.setNome_pessoa(rs.getString("nome_pessoa"));
                pedidocompra.setData_pedido_compra(rs.getString("data_pedido_compra"));
                pedidocompra.setStatus_pedido_compra(rs.getString("status_pedido_compra"));
                pedidocompra.setValor_total(rs.getDouble("total_pedido_compra"));
                resultado.add(pedidocompra);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar pedido! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
            ex.printStackTrace(); /*Mostra certinho onde esta o erro, em detalhes*/
        }
        return resultado;
    }

    @Override
    public Integer confirmarPedidoVenda(PedidoVenda pedidovenda) {
        PreparedStatement stmt = null;

        String sql = "UPDATE administrativo.pedido_venda SET status_pedido_venda = ? WHERE id_pedido_venda = ? AND status_pedido_venda = 'ATIVO'; "
                + "COMMIT;"
                + "INSERT INTO administrativo.arduino_venda (id_pedido_venda, id_produto) VALUES (?, (SELECT DISTINCT p.id_produto FROM administrativo.produto p WHERE p.descricao_produto LIKE '%ARDUINO%'))";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pedidovenda.getStatus_pedido_venda());
            stmt.setInt(2, pedidovenda.getId_pedido_venda());

            stmt.setInt(3, pedidovenda.getId_pedido_venda());
            stmt.execute();

            String sql2 = "SELECT ipv.id_item_pedido_venda, bp.id_produto, ipv.quantidade_item_pedido_venda "
                    + "FROM administrativo.item_pedido_venda ipv, administrativo.bem_produto bp "
                    + "WHERE id_pedido_venda = ? "
                    + "AND bp.id_bem = ipv.id_bem;";

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, pedidovenda.getId_pedido_venda());
            ResultSet rs2 = stmt2.executeQuery();

            while (rs2.next()) {
                String update = "UPDATE administrativo.estoque SET quantidade_estoque = (quantidade_estoque - " + rs2.getInt(3) + ") WHERE id_produto = "+rs2.getInt(2);
                PreparedStatement stmt3 = conn.prepareStatement(update);

                stmt3 = conn.prepareStatement(update);
                stmt3.execute();
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao confirmar pedido! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        } finally {/*executa ele todas as vezes*/
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public Integer estornarPedidoVenda(PedidoVenda pedidovenda) {
        PreparedStatement stmt = null;

        String sql = "UPDATE administrativo.pedido_venda SET status_pedido_venda = ? WHERE id_pedido_venda = ? AND status_pedido_venda = 'FINALIZADO'; "
                + "COMMIT; "
                + "DELETE FROM arduino WHERE id_arduino = (SELECT id_arduino FROM administrativo.arduino_venda WHERE id_pedido_venda = ?);"
                + "DELETE FROM administrativo.arduino_venda WHERE id_pedido_venda = ?; "
                + "COMMIT;"
                + "UPDATE administrativo.estoque SET quantidade_estoque = (quantidade_estoque + 1) WHERE id_produto = "
                + "(SELECT id_produto FROM administrativo.produto WHERE descricao_produto LIKE '%ARDUINO%');";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pedidovenda.getStatus_pedido_venda());
            stmt.setInt(2, pedidovenda.getId_pedido_venda());
            stmt.setInt(3, pedidovenda.getId_pedido_venda());
            stmt.setInt(4, pedidovenda.getId_pedido_venda());
            
            stmt.execute();

            String sql2 = "SELECT ipv.id_item_pedido_venda, bp.id_produto, ipv.quantidade_item_pedido_venda "
                    + "FROM administrativo.item_pedido_venda ipv, administrativo.bem_produto bp "
                    + "WHERE id_pedido_venda = ? "
                    + "AND bp.id_bem = ipv.id_bem;";

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, pedidovenda.getId_pedido_venda());
            ResultSet rs2 = stmt2.executeQuery();

            while (rs2.next()) {
                String update = "UPDATE administrativo.estoque SET quantidade_estoque = (quantidade_estoque + " + rs2.getInt("quantidade_item_pedido_venda") + ") WHERE id_produto = "+rs2.getInt("id_produto");
                PreparedStatement stmt3 = conn.prepareStatement(update);

                stmt3 = conn.prepareStatement(update);
                stmt3.execute();
            }
            
        } catch (SQLException ex) {
            System.out.println("Problemas ao confirmar pedido! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        } finally {/*executa ele todas as vezes*/
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public void cancelarPedidoVenda(Integer id_pedido_venda) {
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.pedido_venda SET status_pedido_venda = 'CANCELADO' WHERE id_pedido_venda = ? ;"
                + "COMMIT; "
                + "DELETE FROM arduino WHERE id_arduino = (SELECT id_arduino FROM administrativo.arduino_venda WHERE id_pedido_venda = ?);"
                + "DELETE FROM administrativo.arduino_venda WHERE id_pedido_venda = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pedido_venda);
            stmt.setInt(2, id_pedido_venda);
            stmt.setInt(3, id_pedido_venda);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir o pedido !Erro:" + ex.getMessage());
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
    public Integer cadastrarCompra(PedidoCompra pedidocompra) {
        Integer idCompra = 0;

        String sql = "INSERT INTO administrativo.pedido_compra "
                + "(data_pedido_compra, status_pedido_compra, id_fornecedor, id_funcionario, total_pedido_compra)  "
                + "VALUES "
                + "(now(), ?, ?, ?, ?) returning id_pedido_compra;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, pedidocompra.getStatus_pedido_compra());
            stmt.setInt(2, pedidocompra.getId_fornecedor());
            stmt.setInt(3, pedidocompra.getId_funcionario());
            stmt.setDouble(4, pedidocompra.getValor_total());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idCompra = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar venda! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return idCompra;
    }

    @Override
    public void cadastrarItemCompra(ArrayList<ItemPedidoCompra> itens) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.item_pedido_compra (id_pedido_compra, id_produto, quantidade_item_pedido_compra,  valorunitario_item_pedido_compra, valortotal_item_pedido_compra) "
                + "VALUES ((SELECT MAX (id_pedido_compra) FROM administrativo.pedido_compra), ?, ?, ?, ?);"
                + "COMMIT;"
                + "INSERT INTO administrativo.produto_fornecedor (id_produto, id_fornecedor) VALUES (?, (SELECT id_fornecedor FROM administrativo.pedido_compra pc WHERE id_pedido_compra = (SELECT MAX (id_pedido_compra) FROM administrativo.pedido_compra)));"
                + "COMMIT;"
                + "INSERT INTO administrativo.movimentacao (quantidade_estoque, data_movimentacao_estoque, tipo_movimentacao_estoque, valorcompra_produto, id_pedido) "
                + "VALUES (?, now(), 'ENTRADA', ?, (SELECT MAX (id_pedido_compra) FROM administrativo.pedido_compra));";
        try {
            for (ItemPedidoCompra item : itens) {
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, item.getId_produto());
                stmt.setInt(2, item.getQuantidade_item_pedido_compra());
                stmt.setDouble(3, item.getValorunitario_item_pedido_compra());
                stmt.setDouble(4, item.getValortotal_item_pedido_compra());                
                
                stmt.setInt(5, item.getId_produto());

                stmt.setInt(6, item.getQuantidade_item_pedido_compra());
                stmt.setDouble(7, item.getValorunitario_item_pedido_compra());
                stmt.execute();
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar item compra! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }         
    }

    @Override
    public void cancelarPedidoCompra(Integer id_pedido_compra) {
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        ResultSet rs = null;

        String sql0 = "SELECT DISTINCT ipc.id_item_pedido_compra "
                + "FROM administrativo.pedido_compra pc, administrativo.item_pedido_compra ipc "
                + "WHERE pc.id_pedido_compra = ipc.id_pedido_compra "
                + "AND pc.id_pedido_compra = " + id_pedido_compra + ";";

        String sql2 = "UPDATE administrativo.pedido_compra SET status_pedido_compra = 'CANCELADO'  WHERE id_pedido_compra = " + id_pedido_compra + " ;";

        try {

            stmt2 = conn.prepareStatement(sql0);
            rs = stmt2.executeQuery();

            while (rs.next()) {
                int v = rs.getInt(1);
                String sql3 = "SELECT administrativo.fn_retorna_estoque_compra (" + v + ");";
                stmt3 = conn.prepareStatement(sql3);
                stmt3.executeQuery();
            }

            stmt = conn.prepareStatement(sql2);
            stmt.executeUpdate();


        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir o pedido !Erro:" + ex.getMessage());
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
    public List<ItemPedidoVenda> listarItem(Integer idPedido) {
        List<ItemPedidoVenda> resultado = new ArrayList<ItemPedidoVenda>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ItemPedidoVenda itempedidovenda = null;

        String sql = "SELECT ipv.id_bem, ipv.id_comodo, ipv.quantidade_item_pedido_venda, c.nome_comodo, b.descricao_bem "
                + "FROM administrativo.item_pedido_venda ipv, administrativo.bem b, administrativo.comodo c "
                + "WHERE id_pedido_venda = ? "
                + "AND b.id_bem = ipv.id_bem "
                + "AND c.id_comodo = ipv.id_comodo";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPedido);
            rs = stmt.executeQuery();

            while (rs.next()) {
                itempedidovenda = new ItemPedidoVenda();
                itempedidovenda.setId_bem(rs.getInt("id_bem"));
                itempedidovenda.setDescricao_bem(rs.getString("descricao_bem"));
                itempedidovenda.setId_comodo(rs.getInt("id_comodo"));
                itempedidovenda.setNome_comodo(rs.getString("nome_comodo"));
                itempedidovenda.setQuantidade_item_pedido_venda(rs.getInt("quantidade_item_pedido_venda"));
                resultado.add(itempedidovenda);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados bem !Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return resultado;
    }
}
