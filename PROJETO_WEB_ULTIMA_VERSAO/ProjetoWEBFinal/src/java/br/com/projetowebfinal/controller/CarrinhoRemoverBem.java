/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.BemDAO;
import br.com.projetowebfinal.dao.BemDAOImp;
import br.com.projetowebfinal.model.ItemPedidoVenda;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CarrinhoRemoverBem extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        HttpSession sessao = request.getSession();
        ArrayList<ItemPedidoVenda> carrinho = (ArrayList<ItemPedidoVenda>) sessao.getAttribute("carrinho");
        if (carrinho == null) {
            carrinho = new ArrayList<ItemPedidoVenda>();
            sessao.setAttribute("carrinho", carrinho);
        }
        String sseq = request.getParameter("seq");
        if (sseq != null) {
            /* essa variavel nao pode ser Integer, pois nao é considerada como indice e sim obj */
            int seq = Integer.parseInt(sseq);
            carrinho.remove(seq);
            sessao.setAttribute("carrinho", carrinho);
        } else {
            String sidbem = request.getParameter("id_bem");
            Integer id_comodo = Integer.parseInt(request.getParameter("id_comodo"));
            if (sidbem != null) {
                Integer idbem = Integer.parseInt(sidbem);
                for (ItemPedidoVenda itens : carrinho) {
                    if (itens.getId_bem() == idbem && itens.getId_comodo() == id_comodo) {
                        itens.setQuantidade_item_pedido_venda(itens.getQuantidade_item_pedido_venda() - 1);
                        BemDAO dao = new BemDAOImp();
                        Double precomaodeobra_bem = dao.ResgatarValor(idbem);
                        itens.setTotal_item_pedido_venda(itens.getQuantidade_item_pedido_venda() * precomaodeobra_bem);
                        sessao.setAttribute("carrinho", carrinho);
                    }
                }
            }
        }
        response.sendRedirect("DadosPedidoVenda");
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
            Logger.getLogger(CarrinhoRemoverBem.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CarrinhoRemoverBem.class.getName()).log(Level.SEVERE, null, ex);
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
