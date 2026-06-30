/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.ClienteDAO;
import br.com.projetowebfinal.dao.ClienteDAOImp;
import br.com.projetowebfinal.dao.FuncionarioDAO;
import br.com.projetowebfinal.dao.FuncionarioDAOImp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson
 */
public class ValidaDados extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int op = Integer.parseInt(request.getParameter("op"));
        String cpf_pessoa = request.getParameter("cpf_pessoa");
        String email_pessoa = request.getParameter("email_pessoa");
        String login_cliente = request.getParameter("login_cliente").toUpperCase();
        String login_funcionario = request.getParameter("login_cliente").toUpperCase();
        String mensagem = null;

        try {
            ClienteDAO dao = new ClienteDAOImp();
            FuncionarioDAO daoFunc = new FuncionarioDAOImp();

            switch (op) {
                case 1:
                    if (dao.validarDados(cpf_pessoa, null, null, op)) {
                        mensagem = "Este CPF já está cadastrado no sistema!\nPor favor insira outro CPF válido.";
                        response.setContentType("text/plain;charset=ISO-8859-1");
                        response.setHeader("Cache-Control", "no-cache");
                        response.setHeader("Pragma", "no-cache");
                        response.setDateHeader("Expires", -1);
                        PrintWriter writer = response.getWriter();
                        writer.print(mensagem);
                        writer.close();
                    }
                    break;
                case 2:
                    if (dao.validarDados(null, email_pessoa, null, op)) {
                        mensagem = "Este Email já está cadastrado no sistema!\nPor favor insira outro Email válido.";

                        response.setContentType("text/plain;charset=ISO-8859-1");
                        response.setHeader("Cache-Control", "no-cache");
                        response.setHeader("Pragma", "no-cache");
                        response.setDateHeader("Expires", -1);
                        PrintWriter writer = response.getWriter();
                        writer.print(mensagem);
                        writer.close();
                    }
                    break;
                case 3:
                    if (dao.validarDados(null, null, login_cliente, op) || daoFunc.validarDados(null, null, login_funcionario, op)) {
                        mensagem = "Este Login já está cadastrado no sistema!\nPor favor insira outro Nome de Usuário";

                        response.setContentType("text/plain;charset=ISO-8859-1");
                        response.setHeader("Cache-Control", "no-cache");
                        response.setHeader("Pragma", "no-cache");
                        response.setDateHeader("Expires", -1);
                        PrintWriter writer = response.getWriter();
                        writer.print(mensagem);
                        writer.close();
                    }
                    break;
                case 4:
                    if (dao.validarDados(cpf_pessoa, email_pessoa, login_cliente, op)) {
                        mensagem = "Este Cpf, email ou login já estão cadastrados no sistema!\nPor favor Verifique";

                        response.setContentType("text/plain;charset=ISO-8859-1");
                        response.setHeader("Cache-Control", "no-cache");
                        response.setHeader("Pragma", "no-cache");
                        response.setDateHeader("Expires", -1);
                        PrintWriter writer = response.getWriter();
                        writer.print(mensagem);
                        writer.close();
                    }
                    break;
            }
            
        } catch (Exception ex) {
            System.out.println("Problemas ao invocar método para validar dados do usuário! Erro: " + ex.getMessage());
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
