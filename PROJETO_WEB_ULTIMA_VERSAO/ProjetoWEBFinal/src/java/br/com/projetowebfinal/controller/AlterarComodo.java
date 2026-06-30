/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.CargoDAO;
import br.com.projetowebfinal.dao.CargoDAOImp;
import br.com.projetowebfinal.dao.ComodoDAO;
import br.com.projetowebfinal.dao.ComodoDAOImp;
import br.com.projetowebfinal.model.Cargo;
import br.com.projetowebfinal.model.Comodo;
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
public class AlterarComodo extends HttpServlet {
   
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
            String nome_comodo = request.getParameter("nome_comodo").toUpperCase();
            Integer id_comodo = Integer.parseInt(request.getParameter("id_comodo"));
            Comodo comodo = new Comodo();
            comodo.setNome_comodo(nome_comodo);
            comodo.setId_comodo(id_comodo);

            String mensagem = comodo.getNome_comodo() + " Alterar com Sucesso";

            ComodoDAO dao = new ComodoDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.alterarComodo(comodo);
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("listagem", dao);
            request.getRequestDispatcher("ListarComodo")/*Quando for LISTAR usar o servlet no Dispacther*/.forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problema no servlet ao alterar comodo! Erro: " + ex.getMessage());
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
