<%-- 
    Document   : listardependente
    Created on : 16/05/2011, 05:50:27
    Author     : jpossatti
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.Dependente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Dependente</title>
    </head>
    <body>
        <h1 align="center">Consultar Dependente</h1>
        <table border="1" align="center">
            <tbody>
                <tr>
                    <td><b>Codigo:</b></td>
                     <td><b>Id_cliente:</b></td>
                     <td><b>Nome:</b></td>
                     <td><b>Parentesco:</b></td>


                <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <%
                List<Dependente> dependentes =(List<Dependente>)request.getAttribute("listagem");
                for(Dependente dependente:dependentes){
                    %>
                    <tr>
                        <td id="id_list"><%=dependente.getId_dependente()%></td>
                        <td><%=dependente.getId_cliente()%></td>
                        <td><%=dependente.getNome_dependente()%></td>
                        <td><%=dependente.getParentesco_dependente()%></td>

                        <td><a href="ExcluirDependente?id_dependente=<%=dependente.getId_dependente()%>">Exluir</a></td>
                         <td><a href="CarregarDependente?id_dependente=<%=dependente.getId_dependente()%>">Alterar</a></td>

                    </tr>
                    <%}%>
            </tbody>
        </table>


    </body>
</html>
