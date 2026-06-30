<%--
    Document   : listardependente
    Created on : 16/05/2011, 05:50:27
    Author     : jpossatti
--%>

<%
    if(
        request.getSession().getAttribute("idCliente") != null || 
        request.getSession().getAttribute("idFuncionario") != null
      ){
%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.Estoque"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Consulta de Funcionario</title>
    </head>
    <body>
        <p/>
        <hr/>
        <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
            <tbody>
                <tr id="texttitlelist">
                     <td><b>Produto</b></td>
                     <td><b>Quantidade</b></td>
                </tr>
                <tr>
                    <td colspan="9" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de produtos em estoque</font>
                    </td>
                </tr>
                <%
                List<Estoque> estoques =(List<Estoque>)request.getAttribute("listagem");
                for(Estoque estoque:estoques){
                    %>
                    <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                        <td id="id_list"><%=estoque.getObproduto().getDescricao_produto()%></td>
                        <td><%=estoque.getQuantidade_estoque()%></td>
                    </tr>
                    <%}%>
            </tbody>
        </table>
       <hr/>
    </body>
</html>
<%@include file="rodape.html" %>
<%}
    else
        response.sendRedirect("paginaacesso.jsp");
%>
