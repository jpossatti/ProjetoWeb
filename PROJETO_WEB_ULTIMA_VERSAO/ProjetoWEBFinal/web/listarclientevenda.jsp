<%-- 
    Document   : listarcliente
    Created on : 16/05/2011, 05:24:51
    Author     : jpossatti
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Consulta de Cliente</title>
    </head>
    <body>
        <p/>
        <hr/>
        <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
            <tbody>
                <tr id="texttitlelist">
                    <td><b>Nome</b></td>
                    <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <tr>
                    <td colspan="8" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de clientes cadastrados</font>
                    </td>
                </tr>
                <%
                    List<Cliente> clientes = (List<Cliente>) request.getAttribute("listaclientes");
                    for (Cliente cliente : clientes) {
                %>
            <form action="AdicionarClienteVenda" method="POST">
                <tr id="textcorplist">
                    <td><input type="hidden" name="id_cliente" value="<%=cliente.getId_cliente()%>" size="40" readonly="readonly" />
                        <%=cliente.getNome_pessoa()%>
                        <input type="hidden" name="nome_cliente" value="<%=cliente.getNome_pessoa()%>" size="40" readonly="readonly" /></td>
                    <td><input type="submit" value="Adicionar" /></td>
                </tr>
            </form>
            <%}%>
        </tbody>
    </table>
    <hr/>
    <p/>
</body>
</html>
<%@include file="rodape.html" %>