/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.model.CompraItem;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson
 */
public class PedidoRemover extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        ArrayList<CompraItem> pedido = (ArrayList<CompraItem>) sessao.getAttribute("pedido");
        if (pedido == null) {
            pedido = new ArrayList<CompraItem>();
            sessao.setAttribute("pedido", pedido);
        }
        String sseq = request.getParameter("seq");
        if (sseq != null) {
            /* essa variavel nao pode ser Integer, pois nao é considerada como indice e sim obj */
            int seq = Integer.parseInt(sseq);
            pedido.remove(seq);
            sessao.setAttribute("pedido", pedido);
        }
        String sidproduto = request.getParameter("idproduto");
        if (sidproduto != null) {
            Integer idproduto = Integer.parseInt(sidproduto);
            for (CompraItem itens : pedido) {
                if (itens.getIdproduto() == idproduto) {
                    itens.setQuantidade(itens.getQuantidade() - 1);
                    sessao.setAttribute("pedido", pedido);
                }
            }
        }

        response.sendRedirect("cadastrarpedidointerno.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
