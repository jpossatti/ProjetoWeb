<%-- 
    Document   : listarbem
    Created on : 16/05/2011, 05:46:15
    Author     : jpossatti
--%>

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
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Consulta de Produto</title>
    </head>
    <body>
        <p/>
        <hr/>
        
        <input type="text" name="id_pedido" value="" size="5"/>
        <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
            <tbody>
                <tr id="texttitlelist">
                    <td><b>Codigo</b></td>
                    <td><b>Descricao</b></td>
                    <td><b>Marca</b></td>
                    <td><b>Preco</b></td>
                    <td><b>Quantidade</b></td>
                    <td><b>Comodo</b></td>
                    <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <tr>
                    <td colspan="8" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de bens cadastrados</font>
                    </td>
                </tr>
                <%
                    List<Bem> bens = (List<Bem>) request.getAttribute("listagem");
                    
                    for (Bem bem : bens) {
                %>
                <form name="cadastrar" id="cadastrar" action="CarrinhoAdicionar" method="POST">
                <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                    <td id="id_list"><%=bem.getId_bem()%><input type="hidden" name="id_bem" value="<%=bem.getId_bem()%>" size="5"/></td>
                    <td><%=bem.getDescricao_bem()%><input type="hidden" name="descricao_bem" value="<%=bem.getDescricao_bem()%>" size="5"/></td>
                    <td><%=bem.getMarca_bem()%><input type="hidden" name="marca_bem" value="<%=bem.getMarca_bem()%>" size="5"/></td>
                    <td><%=bem.getPrecomaodeobra_bem()%><input type="hidden" name="precomaodeobra_bem" value="<%=bem.getPrecomaodeobra_bem()%>" size="5"/></td>
                    <td><input type="text" name="quantidade_pedido" value="" size="5"/></td>
                    <td>
                        <%
                            List<Comodo> comodos = (List<Comodo>) request.getAttribute("comodos");
                        %>
                        <select name="id_comodo">
                            <%
                                for (Comodo comodo : comodos) {
                            %>
                            <option value="<%= comodo.getId_comodo()%>"><%= comodo.getNome_comodo()%></option>
                            <% }%>
                        </select>
                    </td>
                    <td><input type="submit" value="listar" /></td>
                    </form>
                </tr>
                <%}%>
            </tbody>
        </table>
        
        <hr/>
        <p/>
    </body>
</html>
<%@include file="rodape.html" %>    

