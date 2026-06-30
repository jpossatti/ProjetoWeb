<%-- 
    Document   : listarcategoriasubcategoria
    Created on : 16/05/2011, 05:48:36
    Author     : jpossatti
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.CategoriaSubCategoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Categoria Sub-categoria</title>
    </head>
    <body>
        <h1 align="center">Consultar Categoria Sub-categoria</h1>
        <table border="1" align="center">
            <tbody>
                <tr>
                    <td><b>Codigo</b></td>
                     <td><b>Id_categoria</b></td>
                     <td><b>Id_sub_categoria</b></td>


                <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <%
                List<CategoriaSubCategoria> categoriasubcategorias =(List<CategoriaSubCategoria>)request.getAttribute("listagem");
                for(CategoriaSubCategoria categoriasubcategoria:categoriasubcategorias){
                    %>
                    <tr>
                        <td id="id_list"><%=categoriasubcategoria.getId_categoria_sub_categoria()%></td>
                        <td><%=categoriasubcategoria.getId_categoria()%></td>
                        <td><%=categoriasubcategoria.getId_sub_categoria()%></td>

                        <td><a href="ExcluirCategoriaSubCategoria?id_categoria_sub_categoria=<%=categoriasubcategoria.getId_categoria_sub_categoria()%>">Exluir</a></td>
                         <td><a href="CarregarCategoriaSubCategoria?id_categoria_sub_categoria=<%=categoriasubcategoria.getId_categoria_sub_categoria()%>">Alterar</a></td>

                    </tr>
                    <%}%>
            </tbody>
        </table>


    </body>
</html>
