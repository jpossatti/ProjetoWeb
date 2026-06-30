<%-- 
    Document   : alterarsubcategoria
    Created on : 22/05/2011, 16:32:26
    Author     : jpossatti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.Categoria"%>
<%@page import="br.com.projetowebfinal.controller.LogarUsuario"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="javascript" src="scripts/funcoes.js" ></script>
        <title> Alterar de Sub-Categoria </title>
    </head>
    <body onload="abrirPag('paginaprincipal.jsp');">
        <fieldset>
            <table border="0" align="center" width="100%">
                <tr>
                    <td style="background-color: #87CEFA;"align="center" colspan="3"><div id="titulo">Alteração de Sub-Categoria</div></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                <tr>
                    <td colspan="3" bgcolor="#f9f9f9">
                        <form name="alterarsubcategoria" action="AlterarSubCategoria" method="POST">
                            <table border="0" align="center">
                                <tbody>
                                    <tr>
                                        <td colspan="2" id="textsubtitle">Dados Principais</td>
                                    </tr>
                                <tbody>
                                    <tr>
                                        <td id="textcadastro">Sub-Categoria </td>
                                        <td><input type="text" name="nome_sub_categoria" value="${subcategoria.nome_sub_categoria}" size="60"/>
                                            <input type="hidden" name="id_sub_categoria" value="${subcategoria.id_sub_categoria}" size="60"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Categoria </td>
                                        <td>
                                            <select name="id_categoria">
                                                <%
                                                    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categoria");
                                                    for (Categoria categoria : categorias) {
                                                %>
                                                <option value="<%= categoria.getId_categoria()%>"> <%= categoria.getDescricao_categoria()%></option>
                                                <% }%>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Sequência Contabil</td>
                                        <td><input type="text" name="sequencia_subcategoria" value="${subcategoria.sequencia_subcategoria}" size="5"/></td>
                                    </tr>
                                    <tr>
                                        <td align="center" colspan="3">
                                            <input class="btn" type="submit" value="Alterar" name="Enviar" id="btnsumbit"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3">
                                            <div id="conteudo_mostrar">
                                            </div>
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