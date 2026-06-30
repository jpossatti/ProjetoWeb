<%-- 
    Document   : cadastrarestoque
    Created on : 13/05/2011, 19:19:13
    Author     : jpossatti
--%>
<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@page import="br.com.projetowebfinal.model.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="javascript" src="scripts/funcoes.js"></script>
        <script language="javascript">
            function setarData(){
                hoje = new Date()
                dia = hoje.getDate()
                mes = hoje.getMonth()
                ano = hoje.getFullYear()
                data = dia+"/"+(mes+1)+"/"+ano;
                if (dia < 10)
                    dia = "0" + dia
                if (ano < 2000)
                    ano = "19" + ano
                document.getElementById("dt").value = data;
                // document.cadastrarestoque.write.(data).data_movimentacao_estoque;
                //O mes começa em Zero, então soma-se 1
                //alert(dia+"/"+(mes+1)+"/"+ano)
            }
        </script>
        <title> Cadastro de Estoque </title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
                <tr>
                    <td style="background-color: #87CEFA;"align="center" colspan="3"><div id="titulo">Cadastro de Estoque</div></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                <tr>
                    <td colspan="3" bgcolor="#f9f9f9">
                        <form name="cadastrarestoque" action="CadastrarEstoque" method="POST">
                            <table border="0" align="center">
                                <thead>
                                    <tr>
                                        <td colspan="2" id="textsubtitle">Dados Principais</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td id="textcadastro">Quantidade:</td>
                                        <td><input type="text" name="quantidade_estoque" value="" size="10"  onblur="setarData(this.value)"</td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Data movimentacao:</td>
                                        <td><input type="text" name="data_movimentacao_estoque" id="dt" value="" size="10" maxlength="10"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Tipo Movimentacao :</td>
                                        <td><input type="text" name="tipo_movimentacao_estoque" value="" size="15"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Produto:</td>
                                        <td>
                                            <%
                                                List<Produto> estoques = (List<Produto>) request.getAttribute("estoques");
                                            %>
                                            <select name="id_produto">
                                                <%
                                                    for (Produto produto : estoques) {
                                                %>
                                                <option value="<%= produto.getId_produto()%>"><%= produto.getDescricao_produto()%></option>
                                                <% }%>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Margem Lucro</td>
                                        <td><input type="text" name="margemlucro_produto" value="" size="10" maxlength="10"/></td>
                                    </tr>
                                    <tr>
                                        <td align="center" colspan="3">
                                            <input class="btn" type="submit" value="Cadastrar" name="Enviar" id="btnsumbit"/>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </body>
</html>
<%@include file="rodape.html" %>
<%} else
        response.sendRedirect("index.jsp");
%>