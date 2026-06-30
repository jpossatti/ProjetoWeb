/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Cliente;
import br.com.projetowebfinal.model.Imovel;
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
public class ImovelDAOImp implements ImovelDAO {
    /*pedindo a conexão*/

    private Connection conn;
    /*gerando metodos contrutores*/

    public ImovelDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }

    @Override
    public void cadastrarImovel(Imovel imovel) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "INSERT INTO administrativo.imovel(endereco_imovel, numero_imovel, bairro_imovel, cidade_imovel, "
                + "uf_imovel, cep_imovel) "
                + "VALUES "
                + "(?, ?, ?, ?, ?, ?);"
                + "COMMIT;"
                + "INSERT INTO administrativo.cliente_imovel(id_cliente, id_imovel) values (?, (select MAX(i.id_imovel) from administrativo.imovel i));";
        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, imovel.getEndereco_imovel());
            stmt.setInt(2, imovel.getNumero_imovel());
            stmt.setString(3, imovel.getBairro_imovel());
            stmt.setString(4, imovel.getCidade_imovel());
            stmt.setString(5, imovel.getUf_imovel());
            stmt.setString(6, imovel.getCep_imovel());
            stmt.setInt(7, imovel.getId_cliente());

            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar imovel! Erro:" + ex.getMessage());
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
    public List<Imovel> listarImovelCliente(Integer id_cliente) {
        List<Imovel> resultado = new ArrayList<Imovel>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT i.id_imovel, i.endereco_imovel, i.numero_imovel, i.bairro_imovel, i.cidade_imovel, i.uf_imovel, i.cep_imovel, p.nome_pessoa "
                + "FROM administrativo.imovel i, administrativo.cliente_imovel im, administrativo.cliente c,administrativo.pessoa p "
                + "WHERE im.id_cliente= 2 AND im.id_imovel = i.id_imovel and c.id_cliente = im.id_cliente and c.id_pessoa=p.id_pessoa;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Imovel imovel = new Imovel();
                Cliente cliente = new Cliente();
                imovel.setId_imovel(rs.getInt("id_imovel"));
                imovel.setEndereco_imovel(rs.getString("endereco_imovel"));
                imovel.setNumero_imovel(rs.getInt("numero_imovel"));
                imovel.setBairro_imovel(rs.getString("bairro_imovel"));
                imovel.setCidade_imovel(rs.getString("cidade_imovel"));
                imovel.setUf_imovel(rs.getString("uf_imovel"));
                imovel.setCep_imovel(rs.getString("cep_imovel"));
                cliente.setNome_pessoa(rs.getString("nome_pessoa"));
                imovel.setObjcliente(cliente);
                resultado.add(imovel);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar imovel cliente! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public List<Imovel> listar() {
        List<Imovel> resultado = new ArrayList<Imovel>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM administrativo.imovel i ORDER BY i.endereco_imovel;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setId_imovel(rs.getInt("id_imovel"));
                imovel.setEndereco_imovel(rs.getString("endereco_imovel"));
                imovel.setNumero_imovel(rs.getInt("numero_imovel"));
                imovel.setBairro_imovel(rs.getString("bairro_imovel"));
                imovel.setCidade_imovel(rs.getString("cidade_imovel"));
                imovel.setUf_imovel(rs.getString("uf_imovel"));
                imovel.setCep_imovel(rs.getString("cep_imovel"));
                resultado.add(imovel);
            }
        } catch (SQLException ex) { /*Só executa o catch no TRY....*/
            System.out.println("Problemas ao listar imovel! Erro: " + ex.getMessage());/*Caso ocorra algum erro(exeção) dentro do TRY*/
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
    public void excluirImovel(Integer id_imovel) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM administrativo.imovel i WHERE i.id_imovel = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_imovel);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir o imovel !Erro:" + ex.getMessage());
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
    public Imovel listarImovel(Integer id_imovel) {
        List<Imovel> resultado = new ArrayList<Imovel>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Imovel imovel = null;

        String sql = "SELECT  * FROM administrativo.imovel i WHERE i.id_imovel = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_imovel);
            rs = stmt.executeQuery();

            while (rs.next()) {
                imovel = new Imovel();
                imovel.setId_imovel(rs.getInt("id_imovel"));
                imovel.setEndereco_imovel(rs.getString("endereco_imovel"));
                imovel.setNumero_imovel(rs.getInt("numero_imovel"));
                imovel.setBairro_imovel(rs.getString("bairro_imovel"));
                imovel.setCidade_imovel(rs.getString("cidade_imovel"));
                imovel.setUf_imovel(rs.getString("uf_imovel"));
                imovel.setCep_imovel(rs.getString("cep_imovel"));
                resultado.add(imovel);
            }

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados imovel !Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return imovel;
    }

    @Override
    public void alterarImovel(Imovel imovel) {
        /*throw new UnsupportedOperationException("Not supported yet."); APAGAR*/
        PreparedStatement stmt = null;
        String sql = "UPDATE administrativo.imovel SET endereco_imovel=?, numero_imovel=?, bairro_imovel=?, cidade_imovel=?,"
                + "uf_imovel=?, cep_imovel=? WHERE id_imovel=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, imovel.getEndereco_imovel());
            stmt.setInt(2, imovel.getNumero_imovel());
            stmt.setString(3, imovel.getBairro_imovel());
            stmt.setString(4, imovel.getCidade_imovel());
            stmt.setString(5, imovel.getUf_imovel());
            stmt.setString(6, imovel.getCep_imovel());
            stmt.setInt(7, imovel.getId_imovel());

            stmt.execute(); /* executa os dados na tabela*/

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar imovel! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }

    @Override
    public List<Imovel> consultarImovel(Integer idCliente) {
        List<Imovel> resultado = new ArrayList<Imovel>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT i.id_imovel, i.endereco_imovel "
                     +"FROM administrativo.imovel i, administrativo.cliente c, administrativo.cliente_imovel ci "
                     +"WHERE c.id_cliente = ci.id_cliente "
                     +"AND c.id_cliente = ? "
                     +"AND ci.id_imovel = i.id_imovel;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setId_imovel(rs.getInt("id_imovel"));
                imovel.setEndereco_imovel(rs.getString("endereco_imovel"));
                resultado.add(imovel);
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

    @Override
    public List<Imovel> consultarImovelCliente(Integer idCliente, Integer idImovel) {
        List<Imovel> resultado = new ArrayList<Imovel>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT i.id_imovel, i.endereco_imovel FROM administrativo.imovel i, administrativo.cliente c, administrativo.cliente_imovel ci "
                + "WHERE c.id_cliente = ci.id_cliente AND i.id_imovel = ci.id_imovel AND c.id_cliente = ? AND i.id_imovel = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idImovel);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setId_imovel(rs.getInt("id_imovel"));
                imovel.setEndereco_imovel(rs.getString("endereco_imovel"));
                resultado.add(imovel);
                System.out.println("Endereco:" + imovel.getEndereco_imovel());
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

    @Override
    public List<Imovel> imovelCliente(Integer id_cliente) {
        List<Imovel> resultado = new ArrayList<Imovel>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT i.id_imovel, i.endereco_imovel, i.numero_imovel "
                + "FROM administrativo.imovel i, administrativo.cliente c, administrativo.cliente_imovel ci, administrativo.pedido_venda pv "
                + "WHERE c.id_cliente = ci.id_cliente "
                + "AND i.id_imovel = ci.id_imovel "
                + "AND c.id_cliente = ? "
                + "AND i.id_imovel = pv.id_imovel;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_cliente);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setId_imovel(rs.getInt("id_imovel"));
                imovel.setEndereco_imovel(rs.getString("endereco_imovel"));
                imovel.setNumero_imovel(rs.getInt("numero_imovel"));
                resultado.add(imovel);
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
