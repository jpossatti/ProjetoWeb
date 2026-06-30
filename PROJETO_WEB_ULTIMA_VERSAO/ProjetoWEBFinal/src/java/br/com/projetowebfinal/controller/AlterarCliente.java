/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.ClienteDAO;
import br.com.projetowebfinal.dao.ClienteDAOImp;
import br.com.projetowebfinal.model.Cliente;
import br.com.projetowebfinal.model.Pessoa;
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
public class AlterarCliente extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String nome_pessoa = request.getParameter("nome_pessoa").toUpperCase();
        String endereco_pessoa = request.getParameter("endereco_pessoa").toUpperCase();
        Integer numero_pessoa = Integer.parseInt(request.getParameter("numero_pessoa"));
        String bairro_pessoa = request.getParameter("bairro_pessoa").toUpperCase();
        String complemento_pessoa = request.getParameter("complemento_pessoa").toUpperCase();
        String cidade_pessoa = request.getParameter("cidade_pessoa").toUpperCase();
        String uf_pessoa = request.getParameter("uf_pessoa").toUpperCase();
        String cep_pessoa = request.getParameter("cep_pessoa").toUpperCase();
        String telefone_pessoa = request.getParameter("telefone_pessoa").toUpperCase();
        String celular_pessoa = request.getParameter("celular_pessoa").toUpperCase();
        String email_pessoa = request.getParameter("email_pessoa").toUpperCase();
        String obs_pessoa = request.getParameter("obs_pessoa").toUpperCase();
        String senha_cliente = request.getParameter("senha_cliente").toUpperCase();
        Integer id_pessoa = Integer.parseInt(request.getParameter("id_pessoa"));

        Cliente cliente = new Cliente();

        cliente.setNome_pessoa(nome_pessoa);
        cliente.setEndereco_pessoa(endereco_pessoa);
        cliente.setNumero_pessoa(numero_pessoa);/*colocando os valores da view dentro do objeto*/
        cliente.setBairro_pessoa(bairro_pessoa);
        cliente.setComplemento_pessoa(complemento_pessoa);
        cliente.setCidade_pessoa(cidade_pessoa);
        cliente.setUf_pessoa(uf_pessoa);
        cliente.setCep_pessoa(cep_pessoa);
        cliente.setTelefone_pessoa(telefone_pessoa);
        cliente.setCelular_pessoa(celular_pessoa);
        cliente.setEmail_pessoa(email_pessoa);
        cliente.setObs_pessoa(obs_pessoa);
        cliente.setSenha_cliente(senha_cliente);
        cliente.setId_pessoa(id_pessoa);

        String mensagem = cliente.getNome_pessoa()+ " Alterado com Sucesso";

        try{
            ClienteDAO dao = new ClienteDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.alterarCliente(cliente);
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("listagem", dao);
            request.getRequestDispatcher("ListarCliente").forward(request, response);
         }catch (Exception ex){
            System.out.println("Problema no servlet ao alterar cliente! Erro: "+ex.getMessage());
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
