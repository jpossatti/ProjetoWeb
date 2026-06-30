/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.BemDAO;
import br.com.projetowebfinal.dao.BemDAOImp;
import br.com.projetowebfinal.model.ItemPedidoVenda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson
 */
public class CarrinhoAdicionarBem extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        try {
            HttpSession sessao = request.getSession();
            ArrayList<ItemPedidoVenda> carrinho = (ArrayList<ItemPedidoVenda>) sessao.getAttribute("carrinho");
            if (carrinho == null) {
                carrinho = new ArrayList<ItemPedidoVenda>();
                sessao.setAttribute("carrinho", carrinho);
            }
            //requisição de dados iguais
            Integer id_comodo = Integer.parseInt(request.getParameter("id_comodo"));
            Integer id_bem = Integer.parseInt(request.getParameter("id_bem"));
            Integer quantidade_pedido = Integer.parseInt(request.getParameter("quantidade_pedido_compra"));
            BemDAO dao = new BemDAOImp();
            Double precomaodeobra_bem = dao.ResgatarValor(id_bem);

            if (id_bem != null) { //ITEM JA EXITE
                boolean adicionou = false;
                for (ItemPedidoVenda itens : carrinho) {
                    if (itens.getId_bem() == id_bem && itens.getId_comodo() == id_comodo) {
                        itens.setId_bem(id_bem);
                        itens.setId_comodo(itens.getId_comodo());
                        itens.setDescricao_bem(itens.getDescricao_bem());
                        itens.setPrecomaodeobra_bem(itens.getPrecomaodeobra_bem());
                        itens.setQuantidade_item_pedido_venda(itens.getQuantidade_item_pedido_venda() + quantidade_pedido);
                        itens.setTotal_item_pedido_venda(itens.getQuantidade_item_pedido_venda() * itens.getPrecomaodeobra_bem());
                        adicionou = true;
                    }
                }
                if (adicionou == false) {//ITEM AINDA NÃO EXITE
                    //restante de dados
                    String descricao_bem = request.getParameter("descricao_bem");
                    try {
                        ItemPedidoVenda item = new ItemPedidoVenda();
                        item.setId_pedido_venda(0);
                        item.setId_bem(id_bem);
                        item.setId_comodo(id_comodo);
                        item.setDescricao_bem(descricao_bem);
                        item.setPrecomaodeobra_bem(precomaodeobra_bem);
                        item.setQuantidade_item_pedido_venda(quantidade_pedido);
                        item.setTotal_item_pedido_venda(item.getQuantidade_item_pedido_venda() * precomaodeobra_bem);
                        carrinho.add(item);
                        sessao.setAttribute("carrinho", carrinho);
                    } catch (Exception ex) {
                        System.out.println("Problemas no servlet ao adicionar carrinho! Erro: " + ex.getMessage());
                    }
                }
            }
            response.sendRedirect("DadosPedidoVenda");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CarrinhoAdicionarBem.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CarrinhoAdicionarBem.class.getName()).log(Level.SEVERE, null, ex);
        }
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
