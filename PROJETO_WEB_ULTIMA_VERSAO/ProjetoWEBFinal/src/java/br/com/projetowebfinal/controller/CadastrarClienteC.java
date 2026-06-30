/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.ClienteDAO;
import br.com.projetowebfinal.dao.ClienteDAOImp;
import br.com.projetowebfinal.model.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson
 */
public class CadastrarClienteC extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo_pessoa = request.getParameter("tipo_pessoa").toLowerCase();
        String nome_pessoa = request.getParameter("nome_pessoa").toLowerCase();
        String cpf_pessoa = request.getParameter("cpf_pessoa").toLowerCase();
        String rg_pessoa = request.getParameter("rg_pessoa").toLowerCase();
        String endereco_pessoa = request.getParameter("endereco_pessoa").toLowerCase();
        Integer numero_pessoa = Integer.parseInt(request.getParameter("numero_pessoa"));
        String bairro_pessoa = request.getParameter("bairro_pessoa").toLowerCase();
        String complemento_pessoa = request.getParameter("complemento_pessoa").toLowerCase();
        String cidade_pessoa = request.getParameter("cidade_pessoa").toLowerCase();
        String uf_pessoa = request.getParameter("uf_pessoa").toLowerCase();
        String cep_pessoa = request.getParameter("cep_pessoa").toLowerCase();
        String telefone_pessoa = request.getParameter("telefone_pessoa").toLowerCase();
        String celular_pessoa = request.getParameter("celular_pessoa").toLowerCase();
        String email_pessoa = request.getParameter("email_pessoa").toLowerCase();
        String obs_pessoa = request.getParameter("obs_pessoa").toLowerCase();
        String login_cliente = request.getParameter("login_cliente").toLowerCase();
        String senha_cliente = request.getParameter("senha_cliente");

        Cliente cliente = new Cliente();

        cliente.setTipo_pessoa(tipo_pessoa);
        cliente.setNome_pessoa(nome_pessoa);
        cliente.setCpf_pessoa(cpf_pessoa);
        cliente.setRg_pessoa(rg_pessoa);
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
        cliente.setLogin_cliente(login_cliente);
        cliente.setSenha_cliente(senha_cliente);

        String mensagem = cliente.getNome_pessoa() + " Cadastrado com Sucesso";

        try {
            ClienteDAO dao = new ClienteDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.cadastrarCliente(cliente);
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("cadastrarimovelc.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problema no servlet ao cadastrar cliente! Erro: " + ex.getMessage());
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
