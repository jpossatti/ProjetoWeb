<%-- 
    Document   : alterarimovel
    Created on : 22/05/2011, 16:27:57
    Author     : jpossatti
--%>
<%@include file="cabecalho.html" %>
<%@page import="br.com.projetowebfinal.model.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="javascript" src="scripts/funcoes.js"></script>
        <title> Alteração de Imovel </title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
                <tr>
                    <td style="background-color: #87CEFA;"align="center" colspan="3"><div id="titulo">Alteração de Imoveis</div></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                <tr>
                    <td colspan="3" bgcolor="#f9f9f9">
                        <form name="alterarimovel" action="AlterarImovel" method="POST">
                            <table border="0" align="center">
                                <thead>
                                    <tr>
                                        <td colspan="2" id="textsubtitle">Dados do Imovel</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td id="textcadastro">Cliente</td>
                                        <td>
                                            <select name="id_cliente">
                                                <%
                                                    List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                                                    for (Cliente cliente : clientes) {
                                                %>
                                                <option selected="selected" value="${imovel.id_cliente}">${imovel.objcliente.nome_pessoa}</option>
                                                <option value="<%= cliente.getId_cliente()%>"> <%= cliente.getNome_pessoa()%></option>
                                                <% }%>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Endereco:</td>
                                        <td><input type="hidden" name="id_imovel" value="${imovel.id_imovel}"/>
                                            <input type="text" name="endereco_imovel" value="${imovel.endereco_imovel}" size="60"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Numero:</td>
                                        <td><input type="text" name="numero_imovel" value="${imovel.numero_imovel}" size="6"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Bairro:</td>
                                        <td><input type="text" name="bairro_imovel" value="${imovel.bairro_imovel}" size="40"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Cidade:</td>
                                        <td><input type="text" name="cidade_imovel" value="${imovel.cidade_imovel}" size="40"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Estado:</td>
                                        <td><select name="uf_imovel">
                                                <option value="${imovel.uf_imovel}" selected>${imovel.uf_imovel}</option>
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
                                                <option value="sp">SP</option>
                                                <option value="se">SE</option>
                                                <option value="to">TO</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">CEP:</td>
                                        <td><input type="text" name="cep_imovel" value="${imovel.cep_imovel}" size="10" maxlength="10" onkeypress="cep(event, this)"/></td>
                                    </tr>                                     
                                    <tr>
                                        <td align="center" colspan="3">
                                            <input class="btn" type="submit" value="Alterar" name="Enviar" id="btnsumbit"/>
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