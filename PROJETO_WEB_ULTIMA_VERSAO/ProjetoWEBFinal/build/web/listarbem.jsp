<%-- 
    Document   : listarbem
    Created on : 16/05/2011, 05:46:15
    Author     : jpossatti
--%>

<%@page import="br.com.projetowebfinal.model.Bem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.html" %>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Consulta de Produto</title>
    </head>
    <body>
        <p/>
        <hr/>
        <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
            <tbody>
                <tr id="texttitlelist">
                    <td><b>Codigo</b></td>
                     <td><b>Descricao</b></td>
                     <td><b>Marca</b></td>
                     <td><b>Preco</b></td>   
                <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <tr>
                    <td colspan="8" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de bens cadastrados</font>
                    </td>
                </tr>
                <%
                List<Bem> bens =(List<Bem>)request.getAttribute("listagem");
                for(Bem bem:bens){
                    %>
                    <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                        <td id="id_list"><%=bem.getId_bem()%></td>
                        <td><%=bem.getDescricao_bem()%></td>
                        <td><%=bem.getMarca_bem()%></td>
                        <td><%=bem.getPrecomaodeobra_bem()%></td>                       
                        <td><a href="ExcluirBem?id_bem=<%=bem.getId_bem()%>"><img src="icones/excluir.png" width="24" height="24"/></a></td>
                        <td><a href="CarregarBem?id_bem=<%=bem.getId_bem()%>"><img src="icones/alterar.png" width="24" height="24"/></a></td>
                    </tr>
                    <%}%>
            </tbody>
        </table>
            <hr/>
        <p/>
    </body>
</html>
<%@include file="rodape.html" %>    

