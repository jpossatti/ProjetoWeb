<%-- 
    Document   : listarproduto
    Created on : 16/05/2011, 05:56:13
    Author     : jpossatti
--%>



<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.html" %>
<%@page import="br.com.projetowebfinal.model.Arduino"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.ItemPedidoVenda"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="javascript" src="scripts/funcoes.js"></script>
        <title>Cadastrar acoes</title>
    </head>
    <body>
        <p/>
        <hr/>
        <table border="0" align="center" cellspacing="0" cellpadding="9">

            <tbody>
                <tr id="texttitlelist">
                    <td align="center" colspan="3"><b>MAC</b></td>
                </tr>
                <tr>
                    <td colspan="8" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Definição de portas</font>
                    </td>
                </tr>
            <form action="CadastrarPortasDispositivo" name="acaodispositivo" method="POST">
                <tr>
                    <td colspan="3" align="center"><input type="text" name="mac_arduino" value="" maxlength="17" size="16" onkeypress="mac(event, this)"/></td>                
                </tr>
                <%
                    List<Arduino> arduinos = (List<Arduino>) request.getAttribute("arduinos");
                    for (Arduino arduino : arduinos) {
                %>
                <tr id="textcorplist">
                <input type="hidden" name="id_arduino" value="<%=arduino.getId_arduino()%>" size="10">
                <input type="hidden" name="id_pedido_venda" value="<%=arduino.getId_pedido_venda()%>" size="10">
                <input type="hidden" name="id_produto" value="<%=arduino.getId_produto()%>" size="10"><!--ID DO ARDUINO NO ESTOQUE-->
                </tr>
                <%}%>
                <tr id="texttitlelist">
                    <td><b>Comodo</b></td>
                    <td><b>Bem</b></td>
                    <td><b>Porta</b></td>
                </tr>
                <%
                    ArrayList<ItemPedidoVenda> itens = (ArrayList<ItemPedidoVenda>) request.getAttribute("itens");
                    int cont = 0;
                    int porta = 1;
                    for (ItemPedidoVenda item : itens) {
                        int i = item.getQuantidade_item_pedido_venda();
                        for (int qtd = 0; i > qtd; i--) {

                %>
                <tr>
                    <td><input type="hidden" name="quantidade<%=cont%>" value="<%=item.getQuantidade_item_pedido_venda()%>" readonly size="20"/>
                        <input type="hidden" name="id_comodo<%=cont%>" value="<%=item.getId_comodo()%>" readonly size="20"/>
                        <input type="text" name="nome_comodo" value="<%=item.getNome_comodo()%>" readonly size="20"/></td>
                    <td><input type="hidden" name="id_bem<%=cont%>" value="<%=item.getId_bem()%>" readonly size="20"/>
                        <input type="text" name="descricao_bem" value="<%=item.getDescricao_bem()%>" readonly size="20"/></td>
                    <td><input type="text" name="numero_porta<%=cont%>" value="<%=porta%>" readonly size="1"/></td>
                </tr>
                <%
                            cont++;
                            porta++;
                        }
                    }%>
                <input type="hidden" name="cont" value="<%=cont%>" readonly size="20"/>
                <td colspan="3" align="center"><input type="submit" value="Gravar"/></td>
            </form>
        </tbody>
    </table>
    <hr/>
    <p/>
</body>
</html>
<%@include file="rodape.html" %>    
