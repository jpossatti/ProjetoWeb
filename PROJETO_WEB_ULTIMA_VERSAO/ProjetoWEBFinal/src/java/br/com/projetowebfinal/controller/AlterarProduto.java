/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.ProdutoDAO;
import br.com.projetowebfinal.dao.ProdutoDAOImp;
import br.com.projetowebfinal.model.Produto;
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
public class AlterarProduto extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       Integer id_produto=Integer.parseInt(request.getParameter("id_produto"));
        String descricao_produto = request.getParameter("descricao_produto").toUpperCase();
        String marca_produto = request.getParameter("marca_produto").toUpperCase();

        Produto produto = new Produto();

        produto.setDescricao_produto(descricao_produto);
        produto.setMarca_produto(marca_produto);
        produto.setId_produto(id_produto);


        String mensagem = produto.getDescricao_produto()+ " Alterado com Sucesso";

        try{
            ProdutoDAO dao = new ProdutoDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.alterarProduto(produto);
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("listagem", dao);
            request.getRequestDispatcher("ListarProduto").forward(request, response);
         }catch (Exception ex){
            System.out.println("Problema no servlet ao alterar produto! Erro: "+ex.getMessage());
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
