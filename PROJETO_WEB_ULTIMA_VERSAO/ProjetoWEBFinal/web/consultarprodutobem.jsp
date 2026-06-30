<%-- 
    Document   : ConsultarProdutoBem
    Created on : 17/10/2011, 21:48:18
    Author     : Anderson
--%>
<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <table border="0" align="center" width="100%">
            <tbody>
                <tr>
                    <td></td>
                    <td align="center"><h5 align="center">${mensagem}</h5><br/><font size="2pt" color="#FF4500">Insira um novo cliente para efetuar a venda.</font></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td bgcolor="#f9f9f9">
                        <form name="buscarproduto" action="BuscarProdutoBem" method="POST">
                            <table border="0" align="center">
                                <tbody>
                                    <tr>
                                        <td colspan="2" id="textsubtitle">Dados Principais</td>
                                    </tr>
                                </tbody>
                                <tbody>
                                    <tr>
                                        <td id="textcadastro">Produto </td>
                                        <td><input type="text" name="descricao_produto" value="" size="40"/></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td align="center" colspan="3">
                                            <input class="btn" type="submit" value="Buscar" name="Enviar" id="btnsumbit"/>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
<%@include file="rodape.html" %>
<%} else
        response.sendRedirect("index.jsp");
%>
