<%-- 
    Document   : listarproduto
    Created on : 16/05/2011, 05:56:13
    Author     : jpossatti
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.com.projetowebfinal.model.PedidoCompra"%>
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
                if(document.opcao.finalizado.checked == true){
                 document.location.href="BuscarPedidoCompra?status_pedido_compra=finalizado";
                }
                if(document.opcao.cancelado.checked == true){
                 document.location.href="BuscarPedidoCompra?status_pedido_compra=cancelado";
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
        <form action="BuscarPedidoCompra?status" name="opcao" method="POST">
        <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
            <tr>
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
                        <td><b>Fornecedor</b></td>
                        <td><b>Data Compra</b></td>
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
                        List<PedidoCompra> compras = (List<PedidoCompra>) request.getAttribute("compras");
                        for (PedidoCompra compra : compras) {
                    %>
                    <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                        <td id="id_list"><%=compra.getId_pedido_compra()%></td>
                        <td><%=compra.getNome_pessoa()%></td>
                        <td><%=compra.getData_pedido_compra()%></td>
                        <td><%=compra.getStatus_pedido_compra()%></td>
                        <td>R$ <%= compra.getValor_total()%></td>
                        <td><%if(compra.getStatus_pedido_compra().equals("FINALIZADO")){%><a href="CancelarPedidoCompra?id_pedido_compra=<%=compra.getId_pedido_compra()%>"><img src="icones/excluir.png" width="24" height="24" border="0"/><%}else{%><font color="#FF4500">CANCELADO</font><%}%></a></td>
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
