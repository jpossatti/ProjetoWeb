/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.EstoqueDAO;
import br.com.projetowebfinal.dao.EstoqueDAOImp;
import br.com.projetowebfinal.model.Estoque;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpossatti
 */
public class CadastrarEstoque extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String dataString = request.getParameter("data_movimentacao_estoque");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = new java.sql.Date(format.parse(dataString).getTime());

            Date data_movimentacao_estoque = data;
            Integer quantidade_estoque = Integer.parseInt(request.getParameter("quantidade_estoque"));
            String tipo_movimentacao_estoque = request.getParameter("tipo_movimentacao_estoque").toUpperCase();
            Integer id_produto = Integer.parseInt(request.getParameter("id_produto"));
            Double margemlucro_produto = Double.parseDouble(request.getParameter("margemlucro_produto"));

            Estoque estoque = new Estoque();

            estoque.setQuantidade_estoque(quantidade_estoque);
            estoque.setData_movimentacao_estoque(data_movimentacao_estoque);
            estoque.setTipo_movimentacao_estoque(tipo_movimentacao_estoque);
            estoque.setId_produto(id_produto);
            estoque.setMargemlucro_produto(margemlucro_produto);

            String mensagem = "Estoque  em : " + estoque.getId_produto() + " " + " Cadastrado com Sucesso";

            EstoqueDAO dao = new EstoqueDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.cadastrarEstoque(estoque);
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("DadosEstoque").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problema no servlet ao cadastrar estoque! Erro: " + ex.getMessage());
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
