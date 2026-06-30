/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.AcaoDispositivo;
import br.com.projetowebfinal.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anderson
 */
public class AcaoDispositivoDAOImp implements AcaoDispositivoDAO {

    /*pedindo a conexão*/
    private Connection conn;
    /*gerando metodos contrutores*/

    public AcaoDispositivoDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }

    @Override
    public Integer cadastrarAcao(AcaoDispositivo acao) {
        Integer idacaobem = 0;
        PreparedStatement stmt = null;
        //******************primeiro insert na tabela BEM.*********************SEM VETOR****************************
        String sql = "INSERT INTO administrativo.acao_bem(id_pedido_venda, id_bem, id_comodo, ligar_dispositivo, desligar_dispositivo, data_cadastro)"
                + "VALUES"
                + "(?, ?, ?, ?, ?, now()) returning id_acao_bem;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, acao.getIdPedido());
            stmt.setInt(2, acao.getId_bem());
            stmt.setInt(3, acao.getId_comodo());
            stmt.setString(4, acao.getLigar_dispotivo());
            stmt.setString(5, acao.getDesligar_dispotivo());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idacaobem = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar ações! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        } finally {/*executa ele todas as vezes*/
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            return idacaobem;
        }
    }
}
