<%-- 
    Document   : listarimovel
    Created on : 16/05/2011, 05:53:04
    Author     : jpossatti
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.Imovel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Consulta de Imovel</title>
    </head>
    <body>
        <p/>
        <hr/>
        <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
            <tbody>
                <tr id="texttitlelist">
                     <td><b>Codigo</b></td>
                     <td><b>Endereco</b></td>
                     <td><b>Numero</b></td>
                     <td><b>Bairro</b></td>
                     <td><b>Cidade</b></td>
                     <td><b>Estado</b></td>
                     <td><b>CEP</b></td>
                <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <tr>
                    <td colspan="9" bgcolor="#F9F9F9" height="10px" align="center" >
                        <font color="#4682B4" face="arial">Relação de imoveis cadastrados</font>
                    </td>
                </tr>
                <%
                List<Imovel> imoveis =(List<Imovel>)request.getAttribute("listagem");
                for(Imovel imovel:imoveis){
                    %>
                    <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                        <td id="id_list"><%=imovel.getId_imovel()%></td>
                        <td><%=imovel.getEndereco_imovel()%></td>
                        <td><%=imovel.getNumero_imovel()%></td>
                        <td><%=imovel.getBairro_imovel()%></td>
                        <td><%=imovel.getCidade_imovel()%></td>
                        <td><%=imovel.getUf_imovel()%></td>
                        <td><%=imovel.getCep_imovel()%></td>
                        <td><a href="ExcluirImovel?id_imovel=<%=imovel.getId_imovel()%>"><img src="icones/excluir.png" width="24" height="24"/></a></td>
                         <td><a href="CarregarImovel?id_imovel=<%=imovel.getId_imovel()%>"><img src="icones/alterar.png" width="24" height="24"/></a></td>
                    </tr>
                    <%}%>
            </tbody>
        </table>
            <hr/>
        <p/>
    </body>
</html>
<%@include file="rodape.html" %>
