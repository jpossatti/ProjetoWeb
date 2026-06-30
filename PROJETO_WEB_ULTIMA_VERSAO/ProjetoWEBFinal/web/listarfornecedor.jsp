<%-- 
    Document   : listarfornecedor
    Created on : 16/05/2011, 05:51:03
    Author     : jpossatti
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.Fornecedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Consulta de Fornecedor</title>
    </head>
    <body>
        <p/>
        <hr/>
        <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
            <tbody>
                <tr id="texttitlelist">
                    <td><b>Codigo</b></td>
                    <td><b>Nome</b></td>
                    <td><b>Endereco</b></td>
                    <td><b>Cidade</b></td>
                    <td><b>UF</b></td>
                    <td><b>Telefone</b></td>
                    <td><b>Email</b></td>
                    <td align="center" colspan="3" ><b>Editar</b></td>
                </tr>
                <tr>
                    <td colspan="10" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de fornecedores cadastrados</font>
                    </td>
                </tr>
                <%
                    List<Fornecedor> fornecedores = (List<Fornecedor>) request.getAttribute("listagem");
                    for (Fornecedor fornecedor : fornecedores) {
                %>
                <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                    <td id="id_list"><%=fornecedor.getId_fornecedor()%></td>
                    <td><%=fornecedor.getNome_pessoa()%></td>
                    <td><%=fornecedor.getEndereco_pessoa()%></td>
                    <td><%=fornecedor.getCidade_pessoa()%></td>
                    <td><%=fornecedor.getUf_pessoa()%></td>
                    <td><%=fornecedor.getTelefone_pessoa()%></td>
                    <td><%=fornecedor.getEmail_pessoa()%></td>
                    <td><a href="CarregarFornecedor?id_pessoa=<%=fornecedor.getId_pessoa()%>"><img src="icones/alterar.png" width="24" height="24"/></a></td>
                    <td><a href="ExcluirFornecedor?id_pessoa=<%=fornecedor.getId_pessoa()%>"><img src="icones/excluir.png" width="24" height="24"/></a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <p/>
        <hr/>
    </body>
</html>
<%@include file="rodape.html" %>