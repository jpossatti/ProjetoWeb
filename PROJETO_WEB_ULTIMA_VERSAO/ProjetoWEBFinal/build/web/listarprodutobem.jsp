<%-- 
    Document   : listarcliente
    Created on : 16/05/2011, 05:24:51
    Author     : jpossatti
--%>

<%@page import="br.com.projetowebfinal.model.Produto"%>
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
        <title>Consulta de produtos</title>
    </head>
    <body>
        <p/>
        <hr/>
        <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
            <tbody>
                <tr id="texttitlelist">
                    <td><b>Descricao</b></td>
                    <td><b>Quantidade</b></td>
                    <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <tr>
                    <td colspan="8" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de produtos cadastrados</font>
                    </td>
                </tr>
                <%
                    List<Produto> produtos = (List<Produto>) request.getAttribute("listaproduto");
                    for (Produto produto : produtos) {
                %>
            <form action="AdicionarProdutoBem" method="POST">
                <tr id="textcorplist">
                    <td>
                        <input type="hidden" name="id_produto" value="<%=produto.getId_produto()%>" size="10" readonly="readonly" />
                        <%=produto.getDescricao_produto()%>
                        <input type="hidden" name="descricao_produto" value="<%=produto.getDescricao_produto()%>" size="40" readonly="readonly" />                        
                    </td>
                    <td>
                        <input type="text" name="quantidade_produto" value="" size="2" maxlength="2"/>
                    </td>
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