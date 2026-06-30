/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.BemDAO;
import br.com.projetowebfinal.dao.BemDAOImp;
import br.com.projetowebfinal.model.Bem;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpossatti
 */
public class AlterarBem extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        int id_bem = Integer.parseInt(request.getParameter("id_bem"));
        String descricao_bem = request.getParameter("descricao_bem").toUpperCase();
        String marca_bem = request.getParameter("marca_bem").toUpperCase();
        Double precomaodeobra_bem = Double.parseDouble(request.getParameter("precomaodeobra_bem"));

        Bem bem = new Bem();
        
        bem.setDescricao_bem(descricao_bem);
        bem.setMarca_bem(marca_bem);
        bem.setPrecomaodeobra_bem(precomaodeobra_bem);
        bem.setId_bem(id_bem);

        String mensagem = bem.getDescricao_bem()+ " Alterado com Sucesso";

        try{
            BemDAO dao = new BemDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.alterarBem(bem);
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("listagem", dao.listar());
            request.getRequestDispatcher("ListarBem").forward(request, response);
         }catch (Exception ex){
            System.out.println("Problema no servlet ao alterar bem! Erro: "+ex.getMessage());
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
