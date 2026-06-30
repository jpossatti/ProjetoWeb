/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.controller;

import br.com.projetowebfinal.dao.ClienteDAO;
import br.com.projetowebfinal.dao.ClienteDAOImp;
import br.com.projetowebfinal.dao.FuncionarioDAO;
import br.com.projetowebfinal.dao.FuncionarioDAOImp;
import br.com.projetowebfinal.model.Cliente;
import br.com.projetowebfinal.model.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jpossatti
 */
public class LogarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login_usuario").toUpperCase();
        String senha = request.getParameter("senha_usuario");

        Funcionario funcionario = null;
        Cliente cliente = null;
        String mensagem, status = null;

        if (request.getParameter("acao").equals("logar")) {

            if (!login.equals("") || !senha.equals("")) {
                try {
//====================================USUARIO E SENHA THE FULL DO SISTEMA=======================================
                    if (login.equals("ADMIN") && senha.equals("siga1web2")) {
                        HttpSession sessao = request.getSession();
                        sessao.setAttribute("administrador", "ADMIN");
                        request.getRequestDispatcher("cadastrarcliente.jsp").forward(request, response);
                    }
//==============================================================================================================
                    ClienteDAO dao = new ClienteDAOImp();
                    cliente = dao.verificarCliente(login, senha);

                    if (cliente != null) {
                        HttpSession sessao = request.getSession();
                        sessao.setAttribute("id_imovel", cliente.getId_imovel());
                        sessao.setAttribute("idCliente", cliente.getId_cliente());
                        sessao.setAttribute("nomeCliente", cliente.getNome_pessoa());
                        sessao.setAttribute("loginCliente", cliente.getLogin_cliente());
                        sessao.setAttribute("senhaCliente", cliente.getSenha_cliente());

//||||||||||||||||||||||||||||||caso possua imóvel será redirecionado para a página principal||||||||||||||||||||||||||||||||||||||||||||||||||

                        if (dao.verificarImovelCliente(cliente.getId_cliente())) {
                            mensagem = "Seja bem vindo! Sr.(a)" + cliente.getNome_pessoa();
                            request.setAttribute("mensagem", mensagem);
                            request.getRequestDispatcher("paginaprincipalcliente.jsp").forward(request, response);
                        } //|||||||||||||||||||||||||||||||caso não possua imóvel será redirecionado para a pagina de cadastro de imóveis||||||||||||||||||||||||||||||||
                        else {
                            System.out.println("Sr(a). " + cliente.getNome_pessoa() + ", é necessário cadastrar um imóvel!");
                            mensagem = "Seja bem vindo! Sr.(a) " + cliente.getNome_pessoa();
                            request.setAttribute("mensagem", mensagem);
                            request.getRequestDispatcher("ListarProduto").forward(request, response);
                        }
                    } else {

                        FuncionarioDAO daofun = new FuncionarioDAOImp();
                        funcionario = daofun.verificarFuncionario(login, senha);

                        if (funcionario != null) {
                            HttpSession sessao = request.getSession();
                            sessao.setAttribute("idFuncionario", funcionario.getId_funcionario());
                            sessao.setAttribute("nomeFuncionario", funcionario.getNome_pessoa());
                            sessao.setAttribute("loginFuncionario", funcionario.getLogin_funcionario());
                            sessao.setAttribute("senhaFuncionario", funcionario.getSenha_funcionario());

                            mensagem = "Seja bem vindo! Sr.(a)" + funcionario.getNome_pessoa();
                            request.setAttribute("mensagem", mensagem);
                            request.setAttribute("status", status);
                            request.getRequestDispatcher("ListarProduto").forward(request, response);

                        } else {

                            mensagem = "Usuario ou senha inválidos!";
                            request.setAttribute("mensagem", mensagem);
                            request.getRequestDispatcher("index.jsp").forward(request, response);

                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Problemas as logar usuario!Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }

            } else {
                mensagem = "Usuario ou senha inválidos!";
                //mensagem2 = "*Verique os campos e tente novamente...";
                request.setAttribute("mensagem", mensagem);
                //request.setAttribute("mensagem2", mensagem2);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } else if (request.getParameter("acao").equals("logout")) {
            HttpSession sessao = request.getSession();
            sessao.invalidate();
            sessao = null;
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
