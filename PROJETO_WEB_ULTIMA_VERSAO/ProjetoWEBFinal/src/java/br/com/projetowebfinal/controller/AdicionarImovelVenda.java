/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.ImovelDAO;
import br.com.projetowebfinal.dao.ImovelDAOImp;
import br.com.projetowebfinal.model.Imovel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson
 */
public class AdicionarImovelVenda extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idimovel = Integer.parseInt(request.getParameter("id_imovel"));
        int idImovel = idimovel;        
        HttpSession sessao = request.getSession();
        String id = sessao.getAttribute("id_cliente").toString();
        Integer idCliente = Integer.parseInt(id);

        try {
            ImovelDAO dao = new ImovelDAOImp();
            request.setAttribute("id_imovel", dao.consultarImovelCliente(idCliente, idImovel));
            sessao.setAttribute("id_imovel", request.getParameter("id_imovel"));
            sessao.setAttribute("endereco_imovel", request.getParameter("endereco_imovel"));
            request.getRequestDispatcher("carrinhocomprabem.jsp").forward(request, response);

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
