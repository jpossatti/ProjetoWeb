/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.EstoqueDAO;
import br.com.projetowebfinal.dao.EstoqueDAOImp;
import br.com.projetowebfinal.dao.ProdutoDAO;
import br.com.projetowebfinal.dao.ProdutoDAOImp;
import br.com.projetowebfinal.model.CompraItem;
import br.com.projetowebfinal.model.Estoque;
import br.com.projetowebfinal.model.Produto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson
 */
public class PedidoAdicionar extends HttpServlet {

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
        ArrayList<CompraItem> pedido = (ArrayList<CompraItem>) sessao.getAttribute("pedido");
        if (pedido == null) {
            pedido = new ArrayList<CompraItem>();
            sessao.setAttribute("pedido", pedido);
        }
        Integer idproduto = Integer.parseInt(request.getParameter("idproduto"));

        if (idproduto != null) {
            boolean adicionou = false;
            for (CompraItem itens : pedido) {
                if (itens.getIdproduto() == idproduto) {
                    itens.setQuantidade(itens.getQuantidade() + 1);
                    itens.setValortotal(itens.getQuantidade() * itens.getValorcompra());
                    adicionou = true;
                }
            }
            if (adicionou == false) {
                try {
                    ProdutoDAO dao = new ProdutoDAOImp();
                    Produto produto = dao.listarProduto(idproduto);
                                 
                    CompraItem item = new CompraItem();
                    item.setIdcompra(0);
                    item.setIdproduto(idproduto);
                    item.setQuantidade(1.0);
                    item.setDescricao(produto.getDescricao_produto());
                    pedido.add(item);
                    sessao.setAttribute("pedido", pedido);
                } catch (Exception ex) {
                    System.out.println("Problemas no servlet ao adicionar pedido! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }

            }
        }
        response.sendRedirect("cadastrarpedidointerno.jsp");
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
