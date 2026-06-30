/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.CarrinhoDAO;
import br.com.projetowebfinal.dao.CarrinhoDAOImp;
import br.com.projetowebfinal.model.ItemPedidoCompra;
import br.com.projetowebfinal.model.PedidoCompra;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson
 */
public class CarrinhoFinalizarProduto extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession sessao = request.getSession();
            ArrayList<ItemPedidoCompra> carrinho = (ArrayList<ItemPedidoCompra>) sessao.getAttribute("carrinho");
            CarrinhoDAO dao = new CarrinhoDAOImp();
            PedidoCompra compra = new PedidoCompra();
            ArrayList<Double> totItem = new ArrayList<Double>();
            ArrayList<Double> vlrItem = new ArrayList<Double>();
            ArrayList<Integer> idProd = new ArrayList<Integer>();
            int y = 0;
            double total = 0.00;
            for (ItemPedidoCompra x : carrinho) {
                totItem.add(Double.parseDouble(request.getParameter("valorunitario_item_pedido_compra" + y)) * x.getQuantidade_item_pedido_compra());
                vlrItem.add(Double.parseDouble(request.getParameter("valorunitario_item_pedido_compra" + y)));
                idProd.add(Integer.parseInt(request.getParameter("descricao_produto" + y)));
                System.out.println(idProd);
                total = total + totItem.get(y);
                y++;
            }
            
            //////////////////////////////////////////PEDIDO compra//////////////////////////////////////////////////
            compra.setStatus_pedido_compra("FINALIZADO");
            compra.setValor_total(total);
            compra.setId_fornecedor(Integer.parseInt(sessao.getAttribute("id_fornecedor").toString()));
            compra.setId_funcionario(Integer.parseInt(sessao.getAttribute("idFuncionario").toString()));
//            compra.setId_funcionario(29);
            dao.cadastrarCompra(compra);
            /////////////////////////////////////////ITENS PEDIDO compra/////////////////////////////////////////////
            int i = 0;
            for (ItemPedidoCompra item : carrinho) {
                item.setId_produto(idProd.get(i));
                item.setValorunitario_item_pedido_compra(vlrItem.get(i));
                item.setValortotal_item_pedido_compra(totItem.get(i));
                carrinho.set(i, item);
                i++;
            }
            
            dao.cadastrarItemCompra(carrinho);
            sessao.setAttribute("carrinho", null);
            sessao.setAttribute("id_fornecedor", null);
            response.sendRedirect("ListarPedidoCompra");

        } catch (Exception ex) {
            System.out.println("Problemas no servlet ao finalizar pedido! Erro: " + ex.getMessage());
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
