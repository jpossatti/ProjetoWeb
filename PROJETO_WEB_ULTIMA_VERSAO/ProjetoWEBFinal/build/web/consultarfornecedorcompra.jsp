<%-- 
    Document   : cadastrarcargo
    Created on : 13/05/2011, 09:54:55
    Author     : jpossatti
--%>
<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script language="javascript" src="scripts/funcoes.js"></script>
        <script language="javascript">
            function retiraAcentos(){
                var f = document.consultafornecedorcompra;

                for (i = 0; i < f.elements.length; i++){
                    if (f.elements[i].type == 'textarea' || f.elements[i].type == 'text'){
                        f.elements[i].value = f.elements[i].value.toLowerCase()();
                        var valor = f.elements[i].value;
                        valor = valor.replace(/Á/g, "A");
                        valor = valor.replace(/Ã/g, "A");
                        valor = valor.replace(/À/g, "A");
                        valor = valor.replace(/Â/g, "A");
                        valor = valor.replace(/É/g, "E");
                        valor = valor.replace(/Ê/g, "E");
                        valor = valor.replace(/Í/g, "I");
                        valor = valor.replace(/Ó/g, "O");
                        valor = valor.replace(/Õ/g, "O");
                        valor = valor.replace(/Ú/g, "U");
                        valor = valor.replace(/Ü/g, "U");
                        valor = valor.replace(/Ç/g, "C");
                        f.elements[i].value = valor;
                    }
                }
            };
        </script>
        <title> Consultafornecedor </title>
    </head>
    <body>
        <table border="0" align="center" width="100%">
            <tbody>
                <tr>
                    <td></td>
                    <td align="center"><h5 align="center">${mensagem}</h5><br/><font size="2pt" color="#FF4500">Insira um novo fornecedor para efetuar a venda.</font></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td bgcolor="#f9f9f9">
                        <form name="ConsultarFornecedorCompra" action="ConsultarFornecedorCompra" method="POST">
                            <table border="0" align="center">
                                <tbody>
                                    <tr>
                                        <td colspan="2" id="textsubtitle">Dados Principais</td>
                                    </tr>
                                </tbody>
                                <tbody>
                                    <tr>
                                        <td id="textcadastro">Fornecedor </td>
                                        <td><input type="text" name="nome_fornecedor" value="" size="40"/></td>
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
