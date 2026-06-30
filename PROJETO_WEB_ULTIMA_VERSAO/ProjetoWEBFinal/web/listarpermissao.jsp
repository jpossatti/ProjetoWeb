<%-- 
    Document   : listarpermissao
    Created on : 16/05/2011, 05:55:23
    Author     : jpossatti
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.Permissao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Consulta de Permissao</title>
    </head>
    <body>
        <p/>
        <hr/>
        <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
            <tbody>
                <tr id="texttitlelist">
                     <td><b>Codigo</b></td>
                     <td><b>Nome</b></td>
                <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <tr>
                    <td colspan="8" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de permissões cadastradas</font>
                    </td>
                </tr>
                <%
                List<Permissao> permissoes =(List<Permissao>)request.getAttribute("listagem");
                for(Permissao permissao:permissoes){
                    %>
                    <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                        <td id="id_list"><%=permissao.getId_permissao()%></td>
                        <td><%=permissao.getNome_permissao()%></td>
                        <td><a href="ExcluirPermissao?id_permissao=<%=permissao.getId_permissao()%>">Exluir</a></td>
                        <td><a href="CarregarPermissao?id_permissao=<%=permissao.getId_permissao()%>">Alterar</a></td>
                    </tr>
                 <%}%>
            </tbody>
        </table>
            <hr/>
        <p/>
    </body>
</html>
<%@include file="rodape.html" %>

