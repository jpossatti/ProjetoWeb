/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.CategoriaDAO;
import br.com.projetowebfinal.dao.CategoriaDAOImp;
import br.com.projetowebfinal.model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpossatti
 */
public class CadastrarCategoria extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 try {
            String descricao_categoria = request.getParameter("descricao_categoria").toUpperCase();
            Integer grupo_categoria = Integer.parseInt(request.getParameter("grupo_categoria"));
            
            Categoria categoria = new Categoria();
            
            categoria.setDescricao_categoria(descricao_categoria);
            categoria.setGrupo_categoria(grupo_categoria);

            String mensagem = categoria.getDescricao_categoria() + " Cadastrado com Sucesso";

            CategoriaDAO dao = new CategoriaDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.cadastrarCategoria(categoria);
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("cadastrarcategoria.jsp")/*Quando for LISTAR usar o servlet no Dispacther*/.forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problema no servlet ao cadastrar categoria! Erro: " + ex.getMessage());
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
