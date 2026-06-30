/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.CarrinhoDAO;
import br.com.projetowebfinal.dao.CarrinhoDAOImp;
import br.com.projetowebfinal.model.ItemPedidoVenda;
import br.com.projetowebfinal.model.PedidoVenda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson
 */
public class CarrinhoFinalizarBem extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        try {
            HttpSession sessaoC = request.getSession();
            ArrayList<ItemPedidoVenda> carrinho = (ArrayList<ItemPedidoVenda>) sessaoC.getAttribute("carrinho");
            CarrinhoDAO dao = new CarrinhoDAOImp();
            PedidoVenda venda = new PedidoVenda();
            double total = 0.00;
            for (ItemPedidoVenda x : carrinho) {
                total = total + x.getTotal_item_pedido_venda();
            }

            //////////////////////////////////////////PEDIDO VENDA//////////////////////////////////////////////////

            venda.setValor_pedido_venda(total);
            venda.setStatus_pedido_venda("ATIVO");
            venda.setId_cliente(Integer.parseInt(sessaoC.getAttribute("id_cliente").toString()));
            venda.setId_imovel(Integer.parseInt(sessaoC.getAttribute("id_imovel").toString()));
            Integer id_venda = dao.cadastrarVenda(venda); //grava venda

            /////////////////////////////////////////ITENS PEDIDO VENDA/////////////////////////////////////////////
            int i = 0;
            for (ItemPedidoVenda item : carrinho) {
                item.setId_pedido_venda(id_venda);
                item.setId_imovel_comodo_bem(Integer.parseInt(sessaoC.getAttribute("id_imovel").toString()));
                carrinho.set(i, item);
                i++;
            }

            dao.cadastrarItemVenda(carrinho);
            response.sendRedirect("ListarPedidoVenda");

        } catch (Exception ex) {
            System.out.println("Problemas no servlet ao finalizar pedido! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CarrinhoFinalizarBem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CarrinhoFinalizarBem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
