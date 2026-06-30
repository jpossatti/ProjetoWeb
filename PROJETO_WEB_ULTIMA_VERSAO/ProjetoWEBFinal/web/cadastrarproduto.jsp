<%-- 
    Document   : cadastrarproduto
    Created on : 11/05/2011, 14:53:53
    Author     : jpossatti
--%>
<%@page import="javax.swing.JOptionPane"%>
<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.projetowebfinal.controller.LogarUsuario"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="br.com.projetowebfinal.model.Produto"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <script language="javascript" src="scripts/funcoes.js"></script>
        <title> Cadastro de Produto </title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
                <tr>
                    <td style="background-color: #87CEFA;" align="center" colspan="3"><div id="titulo">Cadastro de Produtos</div></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                <tr>
                    <td colspan="3" bgcolor="#f9f9f9">
                        <form name="cadastrarproduto" action="CadastrarProduto" method="POST" onsubmit="return ValidaCadastroProduto()">
                            <table border="0" align="center">
                                <tbody>
                                    <tr>
                                        <td colspan="2" id="textsubtitle">Dados Principais</td>
                                    </tr>
                                </tbody>
                                <tbody>
                                    <tr>
                                        <td id="textcadastro">Descricao<font color="red">*</font></td>
                                        <td><input type="text" name="descricao_produto" value="" size="40" maxlength="60"/></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Marca<font color="red">*</font></td>
                                        <td><input type="text" name="marca_produto" value="" size="20" maxlength="60"/></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td align="center" colspan="3">
                                            <input class="btn" type="submit" value="Cadastrar" name="Enviar" id="btnsumbit"/>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </body>
</html>
<%@include file="rodape.html" %>
<%} else
        response.sendRedirect("index.jsp");
%>