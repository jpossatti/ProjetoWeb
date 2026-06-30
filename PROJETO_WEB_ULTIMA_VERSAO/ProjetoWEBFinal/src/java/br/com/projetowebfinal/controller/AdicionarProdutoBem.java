/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.ProdutoDAO;
import br.com.projetowebfinal.dao.ProdutoDAOImp;
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
public class AdicionarProdutoBem extends HttpServlet {

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

        String id_produto = request.getParameter("id_produto");
        Integer idProduto = Integer.parseInt(id_produto);
        String descricaoProduto = request.getParameter("descricao_produto");
        String quantidade_produto = request.getParameter("quantidade_produto");
        Integer quantidadeProduto = Integer.parseInt(quantidade_produto);
        try {
            HttpSession sessao = request.getSession();
            ArrayList<ProdutoBem> produtoBem = (ArrayList<ProdutoBem>) sessao.getAttribute("produtoBem");

            if (produtoBem == null) {
                produtoBem = new ArrayList<ProdutoBem>();
                sessao.setAttribute("produtoBem", produtoBem);
            }

            if (idProduto != null) { //ITEM JA EXITE
                boolean adicionou = false;
                for (ProdutoBem itens : produtoBem) {
                    if (itens.getId_produto_bem() == idProduto) {
                        itens.setId_produto_bem(idProduto);
                        itens.setDescricao_produto_bem(itens.getDescricao_produto_bem());
                        itens.setQuantidade_produto_bem(quantidadeProduto + itens.getQuantidade_produto_bem());
                        adicionou = true;
                    }
                }
                if (adicionou == false) {//ITEM AINDA NÃO EXITE
                    try {
                        ProdutoBem item = new ProdutoBem();
                        item.setId_produto_bem(idProduto);
                        item.setDescricao_produto_bem(descricaoProduto);
                        item.setQuantidade_produto_bem(quantidadeProduto);
                        produtoBem.add(item);
                        sessao.setAttribute("produtoBem", produtoBem);
                    } catch (Exception ex) {
                        System.out.println("Problemas no servlet ao adicionar produto no carrinho! Erro: " + ex.getMessage());
                    }
                }
            }
            response.sendRedirect("DadosBem");

        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao adicionar cliente !Erro:" + ex.getMessage());
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
