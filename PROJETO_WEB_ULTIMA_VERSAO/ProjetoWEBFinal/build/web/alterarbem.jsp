<%-- 
    Document   : alterarbem
    Created on : 22/05/2011, 16:11:08
    Author     : jpossatti
--%>


<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.ProdutoBem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.projetowebfinal.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.projetowebfinal.controller.LogarUsuario"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="br.com.projetowebfinal.model.Permissao"%>
<%@page import="br.com.projetowebfinal.model.Categoria"%>
<%@page import="br.com.projetowebfinal.model.Bem"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="javascript">
            function gravaSessao(){
                var p1 = document.alterarbem.descricao_bem.value;
                var p2 = document.alterarbem.marca_bem.value;
                var p3 = document.alterarbem.precomaodeobra_bem.value;
                var p4 = document.alterarbem.id_categoria.value;
                location.href='GravaSessaoBem?descricao_bem='+p1+'&marca_bem='+p2+'&precomaodeobra_bem='+p3+'&id_categoria='+p4;
            }
        </script>
        <title> Alterar de Bem </title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
                <tr>
                    <td style="background-color: #87CEFA;"align="center" colspan="3"><div id="titulo">Cadastro de Bens</div></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                </tr>
                <tr>
                    <td colspan="3" bgcolor="#f9f9f9">
                        <form name="alterarbem" action="AlterarBem" method="POST">
                            <table border="0" align="center">
                                <tr>
                                    <td colspan="2" id="textsubtitle">Dados Principais</td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Descricao</td>
                                    <td><input type="text" name="descricao_bem" value="${bem.descricao_bem}" size="60"/>
                                        <input type="hidden" name="id_bem" value="${bem.id_bem}" size="60"/>
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Marca</td>
                                    <td><input type="text" name="marca_bem" value="${bem.marca_bem}" size="10"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Preco mao de obra</td>
                                    <td><input type="text" name="precomaodeobra_bem" value="${bem.precomaodeobra_bem}" size="10"/></td>
                                </tr>
                                <tr>
                                    <td align="center" colspan="3">
                                        <input class="btn" type="submit" value="Alterar" name="Enviar" id="btnsumbit"/>
                                    </td>
                                </tr>
                        </form>
            </table>
        </td>
    </tr>
</table>
</fieldset>
</body>
</html>
<%@include file="rodape.html" %>
<%} else
        response.sendRedirect("index.jsp");
%>