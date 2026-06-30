/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.ClienteImovel;
import br.com.projetowebfinal.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Anderson
 */
public class ClienteImovelDAOImp implements ClienteImovelDAO {
    /*pedindo a conexão*/
    private Connection conn;

    public ClienteImovelDAOImp () throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e){
            throw new Exception("Problemas ao conectar com o banco! Erro: " + e.getMessage());
        }
    }

    public void cadastrarImagem(ClienteImovel clienteimovel) {
        
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE administrativo.cliente_imovel SET caminho_imagem=? WHERE id_cliente=? AND id_imovel=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, clienteimovel.getCaminho_imagem());
            stmt.setInt(2, clienteimovel.getId_cliente());
            stmt.setInt(3, clienteimovel.getId_imovel());
            stmt.executeUpdate();
       } catch (SQLException ex) {
            System.out.println("Problemas ao alterar cliente! Erro:" + ex.getMessage());
            ex.printStackTrace();/*mostra onde esta os erros*/
        }
    }
}
