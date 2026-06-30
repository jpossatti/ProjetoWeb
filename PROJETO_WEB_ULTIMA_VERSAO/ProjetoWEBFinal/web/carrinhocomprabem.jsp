<%-- 
    Document   : carrinhocompras
    Created on : 24/11/2010, 22:01:31
    Author     : Lucas
--%>
<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@page import="br.com.projetowebfinal.dao.ComodoDAOImp"%>
<%@page import="br.com.projetowebfinal.model.Comodo"%>
<%@page import="br.com.projetowebfinal.dao.ComodoDAO"%>
<%@page import="br.com.projetowebfinal.model.ItemPedidoVenda"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <script language="javascript" src="scripts/funcoes.js"></script>
    </head>
    <body>
        <br/>
        <form name="carrinhofinalizarbem" action="CarrinhoFinalizarBem" method="POST">
            <table border="0" align="center" cellspacing="0" cellpadding="9">
                <tr>
                    <td colspan="9" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Carrinho de Compras</font></td>
                </tr>
                <tr>
                    <%
                        HttpSession sessao = request.getSession();
                        Date dataatual = new Date();
                        String data = dataatual.toLocaleString();
                    %>
                    <td id="textcadastro">Cliente</td>
                    <td><input type="text" name="nome_cliente" value="<%=sessao.getAttribute("nome_cliente")%>" size="40" readonly></td>
                </tr>            
                <tr>
                    <td id="textcadastro">Data </td>
                    <td id="textcadastrohidden"><input type="hidden" name="data_venda" value="<%=data%>" size="5"/><%=data%></td>
                </tr>
                <tr>
                    <td id="textcadastro">End. Imovel</td>
                    <td><input type="text" name="endereco_imovel" value="<%=sessao.getAttribute("endereco_imovel")%>" size="40"></td>
                </tr>
                <tr>
                    <td id="textcadastro">${mensagem}</td>
                </tr>
            </table>
            <%
                DecimalFormat df = new DecimalFormat("#,###.00");
                ArrayList<ItemPedidoVenda> carrinhos = (ArrayList<ItemPedidoVenda>) sessao.getAttribute("carrinho");
                if (carrinhos == null || carrinhos.size() == 0) {%>
            <center><b><font face="arial" size="2pt" color="#0066FF">Não há itens no carrinho!</font></b></center>
            <%        } else {
            %>
            <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
                <thead>
                    <tr id="texttitlelist">
                        <td>Nome</td>
                        <td>Valor</td>
                        <td>Quantidade</td>
                        <td>Comodo</td>
                        <td>Total Itens</td>
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
                    for (ItemPedidoVenda carrinho : carrinhos) {
                        ComodoDAO dao = new ComodoDAOImp();
                        Comodo comodo = new Comodo();
                        comodo = dao.listarComodo(carrinho.getId_comodo());
                %>

                <tr id="textcorplist">
                    <td><%=carrinho.getDescricao_bem()%></td>
                    <td><%=df.format(carrinho.getPrecomaodeobra_bem())%></td>
                    <td><%=carrinho.getQuantidade_item_pedido_venda()%></td>
                    <td><%=comodo.getNome_comodo()%></td>                
                    <td><%=df.format(carrinho.getTotal_item_pedido_venda())%></td>
                    <td><a href="CarrinhoAdicionarBem?id_bem=<%= carrinho.getId_bem()%>&quantidade_pedido_compra=1&id_comodo=<%=carrinho.getId_comodo()%>"> +1 </a>
                        <% if (carrinho.getQuantidade_item_pedido_venda() > 1) {%>
                        &nbsp;&nbsp;<a href="CarrinhoRemoverBem?id_bem=<%= carrinho.getId_bem()%>&id_comodo=<%=carrinho.getId_comodo()%>"> -1 </a></td>
                        <% }%>
                    <td align="center"><a href="CarrinhoRemoverBem?seq=<%= seq%>"><img src="icones/excluir.png" width="24" height="24"/></a></td>
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
                    <td align="center"><input type="button" value="Catalogo de Bens" onclick="location.href='ListarCatalogoBem'"/></td>
                    &nbsp; 
                    <td colspan="7" align="center"><input type="submit" value="Finalizar Venda"/></td>                    
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