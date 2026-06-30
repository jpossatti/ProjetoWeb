<%-- 
    Document   : cadastrarimovel
    Created on : 11/05/2011, 14:28:51
    Author     : jpossatti
--%>
<%@page import="br.com.projetowebfinal.model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="scripts/wz_tooltip.js"></script>
        <title> Cadastro de Imovel </title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
                <tr>
                    <td style="background-color: #87CEFA;"align="center" colspan="3"><div id="titulo">Cadastro de Imoveis</div></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                <tr>
                    <td colspan="3" bgcolor="#f9f9f9">
                        <form name="cadastrarimovel" action="CadastrarImovel" method="POST" onsubmit="return ValidaCadastroImovel()">
                            <table border="0" align="center">
                                <thead>
                                    <tr>
                                        <td colspan="2" id="textsubtitle">Dados do Imovel</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td id="textcadastro">Cliente<font color="red">*</font></td>
                                        <td>
                                            <select name="id_cliente">
                                                <%
                                                    List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                                                    for (Cliente cliente : clientes) {
                                                %>
                                                <option value="<%= cliente.getId_cliente()%>"> <%= cliente.getNome_pessoa()%></option>
                                                <% }%>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Endereco<font color="red">*</font></td>
                                        <td><input type="text" name="endereco_imovel" value="" size="60"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Numero<font color="red">*</font></td>
                                        <td><input type="text" name="numero_imovel" value="" size="6"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Bairro<font color="red">*</font></td>
                                        <td><input type="text" name="bairro_imovel" value="" size="40"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Cidade<font color="red">*</font></td>
                                        <td><input type="text" name="cidade_imovel" value="" size="40"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Estado<font color="red">*</font></td>
                                        <td><select name="uf_imovel">
                                                <option value="ac">AC</option>
                                                <option value="al">AL</option>
                                                <option value="ap">AP</option>
                                                <option value="ap">AP</option>
                                                <option value="am">AM</option>
                                                <option value="ba">BA</option>
                                                <option value="ce">CE</option>
                                                <option value="df">DF</option>
                                                <option value="es">ES</option>
                                                <option value="go">GO</option>
                                                <option value="ma">MA</option>
                                                <option value="ms">MS</option>
                                                <option value="mt">MT</option>
                                                <option value="mg">MG</option>
                                                <option value="pa">PA</option>
                                                <option value="pb">PB</option>
                                                <option value="pr">PR</option>
                                                <option value="pe">PE</option>
                                                <option value="pi">PI</option>
                                                <option value="rr">RR</option>
                                                <option value="ro">RO</option>
                                                <option value="rj">RJ</option>
                                                <option value="rn">RN</option>
                                                <option value="rs">RS</option>
                                                <option value="sc">SC</option>
                                                <option value="sp" selected="selected">SP</option>
                                                <option value="se">SE</option>
                                                <option value="to">TO</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">CEP<font color="red">*</font></td>
                                        <td><input type="text" name="cep_imovel" value="" size="10" maxlength="10" onkeypress="cep(event, this)"/></td>
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