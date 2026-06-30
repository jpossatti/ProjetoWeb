/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.ProdutoDAO;
import br.com.projetowebfinal.dao.ProdutoDAOImp;
import br.com.projetowebfinal.model.ItemPedidoCompra;
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
public class CarrinhoAdicionarProduto extends HttpServlet {

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
        ArrayList<ItemPedidoCompra> carrinho = (ArrayList<ItemPedidoCompra>) sessao.getAttribute("carrinho");
        
        ItemPedidoCompra item = new ItemPedidoCompra();
        Integer id_produto = Integer.parseInt(request.getParameter("id_produto"));
        String descricao_produto = request.getParameter("descricao_produto");
        String marca_produto = request.getParameter("marca_produto");
        Integer quantidade_item_pedido_compra = Integer.parseInt(request.getParameter("quantidade_item_pedido_compra"));
        
        if (carrinho == null) {
            carrinho = new ArrayList<ItemPedidoCompra>();
            sessao.setAttribute("carrinho", carrinho);
        }
        if (id_produto != null) {//ja existe
            boolean adicionou = false;
            for (ItemPedidoCompra itens : carrinho) {
                if ( itens.getId_produto() == id_produto ) {
                    itens.setId_produto(id_produto);
                    itens.setDescricao_produto(itens.getDescricao_produto());
                    itens.setMarca_produto(itens.getMarca_produto());
                    itens.setQuantidade_item_pedido_compra(itens.getQuantidade_item_pedido_compra() + quantidade_item_pedido_compra);
                    adicionou = true;
                }
            }
           if (adicionou == false) {
                try {
                    ProdutoDAO dao = new ProdutoDAOImp();
                    Produto bem = dao.listarProduto(id_produto);
                    
                    item.setId_pedido_compra(0);
                    item.setId_produto(id_produto);
                    item.setDescricao_produto(descricao_produto);
                    item.setMarca_produto(marca_produto);
                    item.setQuantidade_item_pedido_compra(quantidade_item_pedido_compra);
                    carrinho.add(item);
                    sessao.setAttribute("carrinho", carrinho);
                } catch (Exception ex) {
                    System.out.println("Problemas no servlet ao adicionar carrinho! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }

            }
        }
        response.sendRedirect("carrinhocompraproduto.jsp");
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
