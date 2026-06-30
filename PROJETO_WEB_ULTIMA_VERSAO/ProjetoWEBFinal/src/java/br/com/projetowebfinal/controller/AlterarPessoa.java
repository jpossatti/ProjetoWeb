/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.PessoaDAO;
import br.com.projetowebfinal.dao.PessoaDAOImp;
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
public class AlterarPessoa extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Integer id_pessoa = Integer.parseInt(request.getParameter("id_pessoa"));
        String tipo_pessoa = request.getParameter("tipo_pessoa").toUpperCase();
        String nome_pessoa = request.getParameter("nome_pessoa").toUpperCase();
        String cpf_pessoa = request.getParameter("cpf_pessoa").toUpperCase();
        String rg_pessoa = request.getParameter("rg_pessoa").toUpperCase();
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


        Pessoa pessoa = new Pessoa();

        pessoa.setTipo_pessoa(tipo_pessoa);
        pessoa.setNome_pessoa(nome_pessoa);
        pessoa.setCpf_pessoa(cpf_pessoa);
        pessoa.setRg_pessoa(rg_pessoa);
        pessoa.setEndereco_pessoa(endereco_pessoa);
        pessoa.setNumero_pessoa(numero_pessoa);
        pessoa.setBairro_pessoa(bairro_pessoa);
        pessoa.setComplemento_pessoa(complemento_pessoa);
        pessoa.setCidade_pessoa(cidade_pessoa);
        pessoa.setUf_pessoa(uf_pessoa);
        pessoa.setCep_pessoa(cep_pessoa);
        pessoa.setTelefone_pessoa(telefone_pessoa);
        pessoa.setCelular_pessoa(celular_pessoa);
        pessoa.setEmail_pessoa(email_pessoa);
        pessoa.setObs_pessoa(obs_pessoa);
        pessoa.setId_pessoa(id_pessoa);


        String mensagem = pessoa.getNome_pessoa()+ " alterado com Sucesso";

        try{
            PessoaDAO dao = new PessoaDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.alterarPessoa(pessoa);
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("listagem", dao);
            request.getRequestDispatcher("ListarPessoa").forward(request, response);
         }catch (Exception ex){
            System.out.println("Problema no servlet ao alterar pessoa! Erro: "+ex.getMessage());
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
