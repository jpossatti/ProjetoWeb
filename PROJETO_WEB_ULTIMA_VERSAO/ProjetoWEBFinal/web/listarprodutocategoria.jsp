<%-- 
    Document   : listarprodutocategoria
    Created on : 16/05/2011, 05:56:40
    Author     : jpossatti
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.ProdutoCategoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Produto - Categoria</title>
    </head>
    <body>
        <h1 align="center">Consultar Produto - Categoria</h1>
        <table border="1" align="center">
            <tbody>
                <tr>
                    <td><b>Codigo:</b></td>
                     <td><b>Id_produto:</b></td>
                     <td><b>Id_categoria:</b></td>


                <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <%
                List<ProdutoCategoria> produtocategorias =(List<ProdutoCategoria>)request.getAttribute("listagem");
                for(ProdutoCategoria produtocategoria:produtocategorias){
                    %>
                    <tr>
                        <td id="id_list"><%=produtocategoria.getId_produto_categoria()%></td>
                        <td><%=produtocategoria.getId_produto()%></td>
                        <td><%=produtocategoria.getId_categoria()%></td>

                        <td><a href="ExcluirProdutoCategoria?id_produto_categoria=<%=produtocategoria.getId_produto_categoria()%>">Exluir</a></td>
                         <td><a href="CarregarProdutoCategoria?id_produto_categoria=<%=produtocategoria.getId_produto_categoria()%>">Alterar</a></td>

                    </tr>
                    <%}%>
            </tbody>
        </table>


    </body>
</html>

