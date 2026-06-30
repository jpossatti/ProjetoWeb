<%-- 
    Document   : listarsubcategoria
    Created on : 16/05/2011, 05:57:20
    Author     : jpossatti
--%>

<%@page import="br.com.projetowebfinal.model.SubCategoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Consulta de Sub-Categoria</title>
    </head>
    <body>
        <p/>
        <hr/>
        <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
            <tbody>
                <tr id="texttitlelist">
                     <td><b>Codigo</b></td>
                     <td><b>Descricao</b></td>
                     <td><b>Seq. Contabil</b></td>
                <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <tr>
                    <td colspan="8" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de sub-categorias cadastradas</font>
                    </td>
                </tr>
                <%
                List<SubCategoria> subcategorias =(List<SubCategoria>)request.getAttribute("listagem");
                for(SubCategoria subcategoria:subcategorias){
                    %>
                    <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                        <td id="id_list"><%=subcategoria.getId_sub_categoria()%></td>
                        <td><%=subcategoria.getNome_sub_categoria()%></td>
                        <td><%=subcategoria.getSequencia_subcategoria()%></td>                        
                        <td><a href="ExcluirSubCategoria?id_sub_categoria=<%=subcategoria.getId_sub_categoria()%>"><img src="icones/excluir.png" width="24" height="24"/></a></td>
                        <td><a href="CarregarSubCategoria?id_sub_categoria=<%=subcategoria.getId_sub_categoria()%>"><img src="icones/alterar.png" width="24" height="24"/></a></td>
                    </tr>
                    <%}%>
            </tbody>
        </table>
            <hr/>
        <p/>
    </body>
</html>
<%@include file="rodape.html" %> 

