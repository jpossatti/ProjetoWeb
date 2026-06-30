<%-- 
    Document   : carrinhocompras
    Created on : 24/11/2010, 22:01:31
    Author     : Lucas
--%>
<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@page import="br.com.projetowebfinal.model.ItemPedidoCompra"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <br/>
        <form name="carrinhofinalizarProduto" action="CarrinhoFinalizarProduto" method="POST">
            <table border="0" align="center" cellspacing="0" cellpadding="9">
                <tr>
                    <td colspan="9" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Carrinho de Compras</font></td>
                </tr>
                <tr>
                    <%
                        HttpSession sessao = request.getSession();
                    %>
                    <td id="textcadastro">Fornecedor</td>
                    <td><input type="text" name="nome_fornecedor" value="<%=sessao.getAttribute("nome_fornecedor")%>" size="40" readonly></td>
                </tr>
                <tr>
                    <td id="textcadastro">${mensagem}</td>
                </tr>
            </table>
            <%
                ArrayList<ItemPedidoCompra> carrinhos = (ArrayList<ItemPedidoCompra>) sessao.getAttribute("carrinho");
                if (carrinhos == null || carrinhos.size() == 0) {%>
            <center><b><font face="arial" size="2pt" color="#0066FF">Não há itens no carrinho!</font></b></center>
            <%        } else {
            %>
            <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
                <thead>
                    <tr id="texttitlelist">
                        <td>Descricao</td>
                        <td>Marca</td>
                        <td>Quantidade</td>
                        <td>Valor</td>
                        <td>Editar</td>
                        <td colspan="3">Excluir Item</td>
                    </tr>
                </thead>
                <tr>
                    <td colspan="9" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de bens adicionados</font>
                    </td>
                </tr>
                <%  int seq = 0;
                    for (ItemPedidoCompra carrinho : carrinhos) {

                %>

                <tr id="textcorplist">
                    <td><%=carrinho.getDescricao_produto()%><input type="hidden" name="descricao_produto<%=seq%>" value="<%=carrinho.getId_produto()%>" size="5"/></td>
                    <td><%=carrinho.getMarca_produto()%></td>
                    <td><%=carrinho.getQuantidade_item_pedido_compra()%></td>
                    <td><input type="text" name="valorunitario_item_pedido_compra<%=seq%>" value="" size="10"></td>
                    <td><a href="CarrinhoAdicionarProduto?id_produto=<%= carrinho.getId_produto()%>&quantidade_item_pedido_compra=1"> +1 </a>
                        <% if (carrinho.getQuantidade_item_pedido_compra() > 1) {%>
                        &nbsp;&nbsp;<a href="CarrinhoRemoverProduto?id_produto=<%= carrinho.getId_produto()%>"> -1 </a></td>
                        <% }%>
                    <td align="center"><a href="CarrinhoRemoverProduto?seq=<%= seq%>"><img src="icones/excluir.png" width="24" height="24"/></a></td>
                </tr>
                <%
                        seq++;
                    }
                %>
            </table>
            <%
                }
            %>
            <table border="0" width="50%" align="center">
                <tr>
                    <td align="center"><input type="button" value="Catalogo de produtos" onclick="location.href='ListarCatalogoProduto'"/></td>

                    <td colspan="7" align="center"><input type="submit" value="Finalizar Compra"/></td>                    
                </tr>
            </table>
        </form>
        <br />
        <hr>        
    </body>
</html>
<%@include file="rodape.html" %>
<%} else
        response.sendRedirect("index.jsp");
%>