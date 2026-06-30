<%-- 
    Document   : listarprodutofornecedor
    Created on : 16/05/2011, 05:56:57
    Author     : jpossatti
--%>

<%@page import="br.com.projetowebfinal.model.ProdutoFornecedor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Produto - Fornecedor</title>
    </head>
    <body>
        <h1 align="center">Consultar Produto Fornecedor</h1>
        <table border="1" align="center">
            <tbody>
                <tr>
                    <td><b>Codigo:</b></td>
                     <td><b>Id_produto:</b></td>
                     <td><b>Id_fornecedor:</b></td>


                <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <%
                List<ProdutoFornecedor> produtofornecedores =(List<ProdutoFornecedor>)request.getAttribute("listagem");
                for(ProdutoFornecedor produtofornecedor: produtofornecedores){
                    %>
                    <tr>
                        <td id="id_list"><%=produtofornecedor.getId_produto_fornecedor()%></td>
                        <td><%=produtofornecedor.getId_produto()%></td>
                        <td><%=produtofornecedor.getId_fornecedor()%></td>

                        <td><a href="ExcluirProdutoFornecedor?id_produto_fornecedor=<%=produtofornecedor.getId_produto_fornecedor()%>">Exluir</a></td>
                         <td><a href="CarregarProdutoFornecedor?id_produto_fornecedor=<%=produtofornecedor.getId_produto_fornecedor()%>">Alterar</a></td>

                    </tr>
                    <%}%>
            </tbody>
        </table>


    </body>
</html>

