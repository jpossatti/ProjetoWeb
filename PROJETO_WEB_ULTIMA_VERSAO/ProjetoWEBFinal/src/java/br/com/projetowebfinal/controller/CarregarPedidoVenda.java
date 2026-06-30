/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.ArduinoDAO;
import br.com.projetowebfinal.dao.ArduinoDAOImp;
import br.com.projetowebfinal.dao.CarrinhoDAO;
import br.com.projetowebfinal.dao.CarrinhoDAOImp;
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
public class CarregarPedidoVenda extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer idPedido = Integer.parseInt(request.getParameter("id_pedido_venda"));
        HttpSession sessao = request.getSession();
        sessao.setAttribute("id_pedido_venda", idPedido);
        try{
            ArduinoDAO arduino = new ArduinoDAOImp();
            CarrinhoDAO carrinho = new CarrinhoDAOImp();
            request.setAttribute("arduinos", arduino.listarArduino(idPedido));
            request.setAttribute("itens", carrinho.listarItem(idPedido));
            
            request.getRequestDispatcher("cadastraracoespedidovenda.jsp").forward(request, response);
        }catch (Exception ex){
            System.out.println("Problemas no Servlet ao listar pedidos!Erro:"+ex.getMessage());
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
