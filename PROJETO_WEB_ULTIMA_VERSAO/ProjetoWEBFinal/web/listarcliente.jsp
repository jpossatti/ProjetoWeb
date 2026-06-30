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
        <table border="1" align="center" cellspacing="0" cellpadding="9" id="tbl" class="borda">
            <tbody>
                <tr id="texttitlelist">
                    <td><b>Codigo</b></td>
                    <td><b>Tipo</b></td>
                    <td><b>Nome</b></td>
                    <td><b>Cidade</b></td>
                    <td><b>UF</b></td>
                    <td><b>Telefone</b></td>
                    <td align="center" colspan="3" ><b>Editar</b></td>
                </tr>
                <tr>
                    <td colspan="9" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de clientes cadastrados</font>
                    </td>
                </tr>
                <%
                    List<Cliente> clientes = (List<Cliente>) request.getAttribute("listagem");
                    for (Cliente cliente : clientes) {
                %>
                <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                    <td id="id_list"><%=cliente.getId_cliente()%></td>
                    <td><%=cliente.getTipo_pessoa()%></td>
                    <td><%=cliente.getNome_pessoa()%></td>
                    <td><%=cliente.getCidade_pessoa()%></td>
                    <td><%=cliente.getUf_pessoa()%></td>
                    <td><%=cliente.getTelefone_pessoa()%></td>
                    <td><a href="CarregarCliente?id_pessoa=<%=cliente.getId_pessoa()%>"><img src="icones/alterar.png" width="24" height="24"/></a></td>
                    <td><a href="ExcluirCliente?id_pessoa=<%=cliente.getId_pessoa()%>"><img src="icones/excluir.png" width="24" height="24"/></a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <hr/>
        <p/>
    </body>
</html>
<%@include file="rodape.html" %>