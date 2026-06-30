/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.BemDAO;
import br.com.projetowebfinal.dao.BemDAOImp;
import br.com.projetowebfinal.model.Bem;
import br.com.projetowebfinal.model.ProdutoBem;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jpossatti
 */
public class CadastrarBem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession sessao = request.getSession();
            ArrayList<ProdutoBem> produtoBem = (ArrayList<ProdutoBem>) sessao.getAttribute("produtoBem");
            
//--------------------------------cadastrar itens e descricoes ---------------------------------
            BemDAO dao = new BemDAOImp();
            Bem bem = new Bem();
            
            String descricao_bem = request.getParameter("descricao_bem").toUpperCase();
            String marca_bem = request.getParameter("marca_bem").toUpperCase();
            String id = request.getParameter("id_categoria");
            Integer id_categoria = Integer.parseInt(id);
            Double precomaodeobra_bem = Double.parseDouble(request.getParameter("precomaodeobra_bem"));
            
            bem.setDescricao_bem(descricao_bem);
            bem.setMarca_bem(marca_bem);
            bem.setId_categoria(id_categoria);
            bem.setPrecomaodeobra_bem(precomaodeobra_bem);
            
            dao.cadastrarBem(bem);

//--------------------------------cadastrar produtos ---------------------------------
            int i = 0;
            for (ProdutoBem item : produtoBem) {
                item.setId_produto_bem(Integer.parseInt(request.getParameter("id_produto_bem"+i)));
                item.setQuantidade_produto_bem(Integer.parseInt(request.getParameter("quantidade_produto_bem")));
                produtoBem.set(i, item);
                i++;
            }
            
            dao.cadastrarProdutoBem(produtoBem);
            sessao.setAttribute("descricaoBem", "");
            sessao.setAttribute("marcaBem", "");
            sessao.setAttribute("precomaodeobraBem", "");
            sessao.setAttribute("produtoBem", null);
            request.getRequestDispatcher("DadosBem").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problema no servlet ao cadastrar bem! Erro: " + ex.getMessage());
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
