/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.model.ProdutoBem;
import java.io.IOException;
import java.io.PrintWriter;
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
public class RemoverProdutoBem extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sessao = request.getSession();

        ArrayList<ProdutoBem> produtoBem = (ArrayList<ProdutoBem>) sessao.getAttribute("produtoBem");
        if (produtoBem == null) {
            produtoBem = new ArrayList<ProdutoBem>();
            sessao.setAttribute("produtoBem", produtoBem);
        }

        String sseq = request.getParameter("seq");
        if (sseq != null) {
            /* essa variavel nao pode ser Integer, pois nao é considerada como indice e sim obj */
            int seq = Integer.parseInt(sseq);
            produtoBem.remove(seq);
            sessao.setAttribute("produtoBem", produtoBem);
        } else {
            String sidProduto = request.getParameter("id_produto");
            if (sidProduto != null) {
                Integer idProduto = Integer.parseInt(sidProduto);
                for (ProdutoBem itens : produtoBem) {
                    if (itens.getId_produto_bem() == idProduto) {
                        itens.setQuantidade_produto_bem(itens.getQuantidade_produto_bem() - 1);
                        sessao.setAttribute("produtoBem", produtoBem);
                    }
                }
            }
        }
        response.sendRedirect("DadosBem");
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
