<%-- 
    Document   : listardepartamento
    Created on : 16/05/2011, 05:49:46
    Author     : jpossatti
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Consulta de Departamento</title>
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
                        <font color="#4682B4" face="arial">Relação de departamentos cadastrados</font>
                    </td>
                </tr>
                <%
                List<Departamento> departamentos =(List<Departamento>)request.getAttribute("listagem");
                for(Departamento departamento:departamentos){
                    %>
                    <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                        <td id="id_list"><%=departamento.getId_departamento()%></td>
                        <td><%=departamento.getNome_departamento()%></td>
                        <td><a href="ExcluirDepartamento?id_departamento=<%=departamento.getId_departamento()%>"><img src="icones/excluir.png" width="24" height="24"/></a></td>
                        <td><a href="CarregarDepartamento?id_departamento=<%=departamento.getId_departamento()%>"><img src="icones/alterar.png" width="24" height="24"/></a></td>
                    </tr>
                    <%}%>
            </tbody>
        </table>
            <hr/>
        <p/>
    </body>
</html>
<%@include file="rodape.html" %> 
