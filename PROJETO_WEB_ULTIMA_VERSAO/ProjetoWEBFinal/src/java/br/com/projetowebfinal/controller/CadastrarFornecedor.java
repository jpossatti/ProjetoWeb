/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.FornecedorDAO;
import br.com.projetowebfinal.dao.FornecedorDAOImp;
import br.com.projetowebfinal.model.Fornecedor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson
 */
public class CadastrarFornecedor extends HttpServlet {
   
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
        String tipo_pessoa = request.getParameter("tipo_pessoa").toUpperCase();        
        String cpf_pessoa = request.getParameter("cpf_pessoa");
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
    
        Fornecedor fornecedor = new Fornecedor();
        
        fornecedor.setNome_pessoa(nome_pessoa);   
        fornecedor.setTipo_pessoa(tipo_pessoa);        
        fornecedor.setCpf_pessoa(cpf_pessoa);
        fornecedor.setRg_pessoa(rg_pessoa);
        fornecedor.setEndereco_pessoa(endereco_pessoa);
        fornecedor.setNumero_pessoa(numero_pessoa);/*colocando os valores da view dentro do objeto*/
        fornecedor.setBairro_pessoa(bairro_pessoa);
        fornecedor.setComplemento_pessoa(complemento_pessoa);
        fornecedor.setCidade_pessoa(cidade_pessoa);
        fornecedor.setUf_pessoa(uf_pessoa);
        fornecedor.setCep_pessoa(cep_pessoa);
        fornecedor.setTelefone_pessoa(telefone_pessoa);
        fornecedor.setCelular_pessoa(celular_pessoa);
        fornecedor.setEmail_pessoa(email_pessoa);
        fornecedor.setObs_pessoa(obs_pessoa);
        

        String mensagem = fornecedor.getNome_pessoa()+ " Cadastrado com Sucesso";

        try{
            FornecedorDAO dao = new FornecedorDAOImp();/*cria o metodo mas ele recebe o AlunoDAOImp*/
            dao.cadastrarFornecedor(fornecedor);
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarFornecedor").forward(request, response);
         }catch (Exception ex){
            System.out.println("Problema no servlet ao cadastrar cliente! Erro: "+ex.getMessage());
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
