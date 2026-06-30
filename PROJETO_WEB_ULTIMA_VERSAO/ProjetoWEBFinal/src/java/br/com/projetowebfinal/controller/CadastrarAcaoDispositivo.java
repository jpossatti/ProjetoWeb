/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.AcaoDispositivoDAO;
import br.com.projetowebfinal.dao.AcaoDispositivoDAOImp;
import br.com.projetowebfinal.model.AcaoDispositivo;
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
public class CadastrarAcaoDispositivo extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        
        String id1 = sessao.getAttribute("id_pedido_venda").toString();
        Integer idPedido = Integer.parseInt(id1);
        Integer id_bem = Integer.parseInt(request.getParameter("id_bem"));
        Integer id_comodo = Integer.parseInt(request.getParameter("id_comodo"));
        String ligar = request.getParameter("ligar_dispositivo"); 
        String desligar = request.getParameter("desligar_dispositivo");       
        
        AcaoDispositivo acao = new AcaoDispositivo();
        
        acao.setIdPedido(idPedido);
        acao.setId_bem(id_bem);
        acao.setId_comodo(id_comodo);
        acao.setLigar_dispotivo(ligar);
        acao.setDesligar_dispotivo(desligar);
        
        try {
            AcaoDispositivoDAO dao = new AcaoDispositivoDAOImp();
            Integer id_acao_bem = dao.cadastrarAcao(acao);
//            acao.setId_acao_bem(id_acao_bem);
            request.getRequestDispatcher("CarregarPedidoVenda?id_pedido_venda="+idPedido).forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problema no servlet ao cadastrar acao! Erro: " + ex.getMessage());
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
