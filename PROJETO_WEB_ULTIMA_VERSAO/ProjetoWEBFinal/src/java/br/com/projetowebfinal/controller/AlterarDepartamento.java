/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.DepartamentoDAO;
import br.com.projetowebfinal.dao.DepartamentoDAOImp;
import br.com.projetowebfinal.model.Departamento;
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
public class AlterarDepartamento extends HttpServlet {
   
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
            String nome_departamento = request.getParameter("nome_departamento").toUpperCase();
            Integer id_departamento = Integer.parseInt(request.getParameter("id_departamento"));
            Departamento departamento = new Departamento();
            departamento.setNome_departamento(nome_departamento);
            departamento.setId_departamento(id_departamento);

            String mensagem = departamento.getNome_departamento() + " Alterado com Sucesso";

            DepartamentoDAO dao = new DepartamentoDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.alterarDepartamento(departamento);
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("listagem", dao);
            request.getRequestDispatcher("ListarDepartamento")/*Quando for LISTAR usar o servlet no Dispacther*/.forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problema no servlet ao alterar departamento! Erro: " + ex.getMessage());
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
