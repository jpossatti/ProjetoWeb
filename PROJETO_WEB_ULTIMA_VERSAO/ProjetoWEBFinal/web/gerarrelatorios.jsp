
<%
    if (request.getSession().getAttribute("idCliente") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="javascript">
            function relatorioPessoa(){
                var tipo_pessoa = document.relatorios.tipo_pessoa.value;
                var url = 'Relatorio?tipo_pessoa='+tipo_pessoa;
                window.open(url, "Relatorios", width=800, height=600) ;
            }
            function relatorioCliente(){
                var url = 'RelatorioImovel'
                window.open(url, "Relatorios", width=800, height=600) ;
            }
        </script>
        <title> Relatorios </title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
                <tr>
                    <td style="background-color: #87CEFA;"align="center" colspan="3"><div id="titulo">Gerar Relatorios</div></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                </tr>
                <tr>
                <form name="relatorios">
                    <td colspan="3" bgcolor="#f9f9f9">
                        <table border="0" align="center" width="700px">
                            <tr>
                                <td colspan="2" id="textsubtitle">Relatorios</td>
                            </tr>
                            <tr>
                                <td id="textcadastro">Pessoa&nbsp;&nbsp;</td>
                                <td>
                                    <font size="1pt" color="#333"> TIPO (FISICA, JURIDICA)</font>
                                    <select name="tipo_pessoa">
                                        <option value="FISICA">FISICA</option>
                                        <option value="JURIDICA">JURIDICA</option>
                                    </select>
                                    <input class="btn" type="button" value="Gerar" name="gerar" onclick="return relatorioPessoa();" id="btnsumbit"/>
                                </td>
                            </tr>
                            <tr>
                                <td id="textcadastro">CLIENTE&nbsp;&nbsp;</td>
                                <td>
                                    <input class="btn" type="button" value="Gerar" name="gerar" onclick="return relatorioCliente();" id="btnsumbit"/>
                                </td>
                            </tr>
                        </table>
                </form>
                </td>
                </tr>
            </table>
        </fieldset>
    </body>
</html>
<%@include file="rodape.html" %>
<%} else
        response.sendRedirect("index.jsp");
%>