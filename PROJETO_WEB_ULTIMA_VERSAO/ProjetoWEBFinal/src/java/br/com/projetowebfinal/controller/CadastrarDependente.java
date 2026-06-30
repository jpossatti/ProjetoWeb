/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.DependenteDAO;
import br.com.projetowebfinal.dao.DependenteDAOImp;
import br.com.projetowebfinal.model.Dependente;
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
public class CadastrarDependente extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        Integer id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        String nome_dependente = request.getParameter("nome_dependente").toUpperCase();
        String parentesco_dependente = request.getParameter("parentesco_dependente").toUpperCase();

        Dependente dependente = new Dependente();

        dependente.setId_cliente(id_cliente);
        dependente.setNome_dependente(nome_dependente);
        dependente.setParentesco_dependente(parentesco_dependente);


        String mensagem = "Dependente situado em : "+dependente.getNome_dependente()+ " Cadastrado com Sucesso";

        try{
            DependenteDAO dao = new DependenteDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.cadastrarDependente(dependente);
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("cadastrardependente.jsp").forward(request, response);
         }catch (Exception ex){
            System.out.println("Problema no servlet ao cadastrar dependente! Erro: "+ex.getMessage());
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
