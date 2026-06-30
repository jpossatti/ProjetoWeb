<%-- 
    Document   : cadastrardepartamento
    Created on : 13/05/2011, 09:55:10
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
<%@page import="br.com.projetowebfinal.model.Cargo"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <link href="css/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
        <script language="javascript" src="scripts/funcoes.js"></script>
        <title> Cadastro de Departamento </title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
                <tr>
                    <td style="background-color: #87CEFA;" align="center" colspan="3"><div id="titulo">Cadastro de Departamentos</div></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                <tr>
                    <td colspan="3" bgcolor="#f9f9f9">
                        <form name="cadastrardepartamento" action="CadastrarDepartamento" method="POST" onsubmit="return ValidaCadastroDepartamento()">
                            <table border="0" align="center">
                                <tbody>
                                    <tr>
                                        <td colspan="2" id="textsubtitle">Dados Principais</td>
                                    </tr>
                                <tbody>
                                    <tr>
                                        <td id="textcadastro">Departamento </td>
                                        <td><input type="text" name="nome_departamento" value="" size="60"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Cargo </td>
                                        <td>
                                            <div align="center" colspan="3"><font size="2pt" color="#FF4500">Selecione 1 (um) ou mais cargos para o departamento<br/>mantenha pressionado CTRL</font></div>
                                            <select name="id_cargo" multiple class="box">
                                                <%
                                                    List<Cargo> cargos = (List<Cargo>) request.getAttribute("cargos");
                                                    for (Cargo cargo : cargos) {
                                                %>
                                                <option value="<%= cargo.getId_cargo()%>"> <%= cargo.getNome_cargo()%></option>
                                                <% }%>
                                            </select>
                                        </td>
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

