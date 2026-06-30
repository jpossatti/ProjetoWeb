<%-- 
    Document   : listarproduto
    Created on : 16/05/2011, 05:56:13
    Author     : jpossatti
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.com.projetowebfinal.model.PedidoVenda"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <style type="text/css">
            #corpo{
                width: auto;
                height: 300px;
                overflow: auto;
                align: center;
            }
        </style>
        <script language="javascript">
            function setarValor(){                              
                if(document.opcao.ativo.checked == true){
                 document.location.href="BuscarPedidoVenda?status_pedido_venda=ATIVO";
                }
                if(document.opcao.finalizado.checked == true){
                 document.location.href="BuscarPedidoVenda?status_pedido_venda=FINALIZADO";
                }
                if(document.opcao.cancelado.checked == true){
                 document.location.href="BuscarPedidoVenda?status_pedido_venda=CANCELADO";
                }
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Consulta de Pedidos Venda</title>
    </head>
    <body>
        <p/>
        <hr/>
        <form action="BuscarPedidoVenda?status" name="opcao" method="POST">
        <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
            <tr>
                <td><div align="center"><input type="radio" name="radio" id="ativo" value="ativo" onclick="setarValor();"/><div id="texto_status">Ativo</div></div></td>
                <td><div align="center"><input type="radio" name="radio" id="finalizado" value="finalizado" onclick="setarValor();"/><div id="texto_status">Finalizado</div></div></td>
                <td><div align="center"><input type="radio" name="radio" id="cancelado" value="finalizado" onclick="setarValor();"/><div id="texto_status">Cancelado</div></div></td>
             </tr>
        </table>
        </form>
        <div id="corpo">
            <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
                <tbody>
                    <tr id="texttitlelist">
                        <td><b>N.Pedido</b></td>
                        <td><b>Cliente</b></td>
                        <td><b>End.Imovel</b></td>
                        <td><b>Status</b></td>
                        <td><b>Total</b></td>
                        <td align="center" colspan="3" ><b>Editar</b></td>
                    </tr>
                    <tr>
                        <td colspan="8" bgcolor="#F9F9F9" height="10px" align="center" >
                            <font color="#4682B4" face="arial">Relação de pedidos cadastrados</font>
                        </td>
                    </tr>
                    <%
                        List<PedidoVenda> vendas = (List<PedidoVenda>) request.getAttribute("vendas");
                        for (PedidoVenda venda : vendas) {
                    %>
                    <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                        <td id="id_list"><%=venda.getId_pedido_venda()%></td>
                        <td><%=venda.getNome_pessoa()%></td>
                        <td><%=venda.getEndereco_imovel()%></td>
                        <td><%=venda.getStatus_pedido_venda()%></td>
                        <td>R$ <%=venda.getValor_pedido_venda()%></td>
                        <td><% if (venda.getStatus_pedido_venda().equals("ATIVO")) {%><a href="CancelarPedidoVenda?id_pedido_venda=<%=venda.getId_pedido_venda()%>"><img src="icones/excluir.png" width="24" height="24" border="0"/></a><%}%></td>
                        <td><% if (venda.getStatus_pedido_venda().equals("FINALIZADO")) {%><a href="EstornarPedidoVenda?id_pedido_venda=<%=venda.getId_pedido_venda()%>"><img src="icones/estornar.png" width="24" height="24" border="0"/></a> <%} 
                               else if (venda.getStatus_pedido_venda().equals("CANCELADO")){%><%}else{%><a href="ConfirmarPedidoVenda?id_pedido_venda=<%=venda.getId_pedido_venda()%>"><img src="icones/confirmar.png" width="24" height="24" border="0"/></a><%}%></td>
                        <td><% if (venda.getStatus_pedido_venda().equals("FINALIZADO")) {%><a href="CarregarPedidoVenda?id_pedido_venda=<%=venda.getId_pedido_venda()%>"><img src="icones/editar.png" width="24" height="24" border="0"/></a><%}%> 
                            <% if(venda.getStatus_pedido_venda().equals("CANCELADO")) {%><font color="#FF4500">CANCELADO</font><%}%>
                            <% if(venda.getStatus_pedido_venda().equals("ATIVO")) {%><font color="#00CD00">CONFIRMAR?</font><%}%>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <hr/>
        <p/>
    </body>
</html>
<%@include file="rodape.html" %>    
