/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.ImovelDAO;
import br.com.projetowebfinal.dao.ImovelDAOImp;
import br.com.projetowebfinal.model.Imovel;
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
public class AlterarImovel extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Integer id_imovel = Integer.parseInt(request.getParameter("id_imovel"));
        String endereco_imovel = request.getParameter("endereco_imovel").toUpperCase();
        Integer numero_imovel = Integer.parseInt(request.getParameter("numero_imovel"));
        String bairro_imovel = request.getParameter("bairro_imovel").toUpperCase();
        String cidade_imovel = request.getParameter("cidade_imovel").toUpperCase();
        String uf_imovel = request.getParameter("uf_imovel").toUpperCase();
        String cep_imovel = request.getParameter("cep_imovel").toUpperCase();


        Imovel imovel = new Imovel();

        imovel.setEndereco_imovel(endereco_imovel);
        imovel.setNumero_imovel(numero_imovel);
        imovel.setBairro_imovel(bairro_imovel);
        imovel.setCidade_imovel(cidade_imovel);
        imovel.setUf_imovel(uf_imovel);
        imovel.setCep_imovel(cep_imovel);
        imovel.setId_imovel(id_imovel);


        String mensagem = "Imovel situado em : "+imovel.getEndereco_imovel()+ " "+imovel.getNumero_imovel()+ " Alterado com Sucesso";

        try{
            ImovelDAO dao = new ImovelDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.alterarImovel(imovel);
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("listagem", dao);
            request.getRequestDispatcher("ListarImovel").forward(request, response);
         }catch (Exception ex){
            System.out.println("Problema no servlet ao alterar imovel! Erro: "+ex.getMessage());
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
