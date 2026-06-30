/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Arduino;
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
public class ArduinoDAOImp implements ArduinoDAO {
    /*pedindo a conexão*/

    private Connection conn;
    /*gerando metodos contrutores*/

    public ArduinoDAOImp() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar no banco de dados! Erro." + ex.getMessage());

        }
    }

    @Override
    public Arduino cadastrarAcao(Integer id, Integer porta) {
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;

        try {//******************primeiro insert na tabela BEM.*********************SEM VETOR****************************
            String sql0 = "SELECT DISTINCT de.solicitante_web FROM dispositivo_ee de, arduino a, administrativo.arduino_venda av, administrativo.porta_arduino pa "
                    + "WHERE pa.id_porta_arduino = ? "
                     +"AND de.porta_arduino = ? "
                    + "AND de.id_arduino = a.id_arduino "
                    + "AND de.id_arduino = av.id_arduino "
                    + "AND a.id_arduino = av.id_arduino "
                    + "AND pa.id_arduino = av.id_arduino;";

            String sql = "INSERT INTO administrativo.acao_bem(acao_dispositivo, data_acao, id_porta_arduino)"
                    + "VALUES"
                    + "(?, now(), ?);";
            stmt2 = conn.prepareStatement(sql0);
            System.out.println(id);
            stmt2.setInt(1, id);
            stmt2.setInt(2, porta);
            rs = stmt2.executeQuery();
            String res = "";
            
            while (rs.next()) {
                res = rs.getString("solicitante_web");
                System.out.println(res);
            }
            if (!res.equals("desligar")) {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "desligar");
                stmt.setInt(2, id);
                stmt.execute();
            }else{
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "ligar");
                stmt.setInt(2, id);
                stmt.execute();
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar acao arduino! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
        return null;
    }

    @Override
    public List<Arduino> listarArduino(Integer idPedido) {
        List<Arduino> resultado = new ArrayList<Arduino>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Arduino arduino = null;

        String sql = "SELECT  * FROM administrativo.arduino_venda WHERE id_pedido_venda= ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPedido);
            rs = stmt.executeQuery();

            while (rs.next()) {
                arduino = new Arduino();
                arduino.setId_arduino(rs.getInt("id_arduino"));
                arduino.setId_pedido_venda(rs.getInt("id_pedido_venda"));
                arduino.setMac_arduino(rs.getString("mac_arduino"));
                arduino.setId_produto(rs.getInt("id_produto")); //esse é o id do ARDUINO QUE SE ENCONTRA NO ESTOQUE!!!!!!!!!!!
                resultado.add(arduino);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar dados bem !Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public void cadastrarMac(Arduino arduino) {
        PreparedStatement stmt = null;
        //******************primeiro insert na tabela BEM.*********************SEM VETOR****************************
        String sql = "UPDATE administrativo.arduino_venda SET mac_arduino = ? WHERE id_pedido_venda = ? ;"
                + "COMMIT;"
                + "UPDATE arduino SET mac_arduino = ? WHERE id_arduino = (SELECT id_arduino FROM administrativo.arduino_venda WHERE id_pedido_venda = ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, arduino.getMac_arduino());
            stmt.setInt(2, arduino.getId_pedido_venda());
            stmt.setString(3, arduino.getMac_arduino());
            stmt.setInt(4, arduino.getId_pedido_venda());
            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar mac arduino! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }

    @Override
    public void cadastrarPorta(Arduino arduino) {
        try {
            PreparedStatement stmt = null;
            //******************primeiro insert na tabela BEM.*********************SEM VETOR****************************
            String sql = "INSERT INTO administrativo.porta_arduino (numero_porta, id_arduino, id_bem) "
                    + "VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, arduino.getNumero_porta());
            stmt.setInt(2, arduino.getId_arduino());
            stmt.setInt(3, arduino.getId_bem());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar portas! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
