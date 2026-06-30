<%-- 
    Document   : listarbem
    Created on : 16/05/2011, 05:46:15
    Author     : jpossatti
--%>
<%
    if (request.getSession().getAttribute("idCliente") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@page import="br.com.projetowebfinal.model.Produto"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.Vector"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.projetowebfinal.model.Comodo"%>
<%@page import="br.com.projetowebfinal.model.Bem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.html" %>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="scripts/wz_tooltip.js"></script>
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
                    <td><b>Quantidade</b></td>
                    <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <tr>
                    <td colspan="8" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de bens cadastrados</font>
                    </td>
                </tr>
                <%
                    int i = 0;
                    List<Produto> produtos = (List<Produto>) request.getAttribute("listagem");                    
                    for (Produto produto : produtos) {
                %>
            <form name="catalogoproduto<%=i%>" id="cadastrar" action="CarrinhoAdicionarProduto" method="POST">
                <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                    <td id="id_list"><%=produto.getId_produto()%><input type="hidden" name="id_produto" value="<%=produto.getId_produto()%>" size="5"/></td>
                    <td><%=produto.getDescricao_produto()%><input type="hidden" name="descricao_produto" value="<%=produto.getDescricao_produto()%>" size="5"/></td>
                    <td><%=produto.getMarca_produto()%><input type="hidden" name="marca_produto" value="<%=produto.getMarca_produto()%>" size="5"/></td>
                    <td><input type="text" name="quantidade_item_pedido_compra" value="" size="5"/></td>
                    <td><input type="submit" value="Adicionar"/></td>
                    </form>
                </tr>
                <%i++;
                    }%>
            </tbody>
        </table>
        
        <hr/>
        <p/>
    </body>
</html>
<%@include file="rodape.html" %>    
<%} else
        response.sendRedirect("paginaacesso.jsp");
%>
