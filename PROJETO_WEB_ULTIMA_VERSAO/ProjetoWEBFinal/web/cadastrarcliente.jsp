<%-- 
    Document   : cadastrarcliente
    Created on : 01/07/2011, 12:44:56
    Author     : Anderson
--%>

<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
        HttpSession sessao = request.getSession();
        sessao.setAttribute("carrinho", "");
%>
<%@include file="cabecalho.html" %>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="br.com.projetowebfinal.controller.LogarUsuario"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="br.com.projetowebfinal.dao.ClienteDAOImp"%>
<%@page import="br.com.projetowebfinal.dao.ClienteDAO"%>
<%@page import="br.com.projetowebfinal.model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="ajax/ajax.js"></script>
        <script type="text/javascript" src="scripts/wz_tooltip.js"></script>
        <title>Cadastro de Clientes</title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
                <tr>
                    <td style="background-color: #87CEFA;" align="center" colspan="3"><div id="titulo">Cadastro de Clientes</div></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                <tr>
                    <td colspan="3" bgcolor="#f9f9f9">
                        <form name="cadastrarcliente" id="cadastrarcliente" action="CadastrarCliente" method="POST" onsubmit="return ValidaCadastroCliente(); retiraAcentos(this.form); ValidaCPFCliente(); validarDadosCliente('cpf_pessoa='+document.cadastrarcliente.cpf_pessoa.value+'&email_pessoa='+document.cadastrarcliente.email_pessoa.value+'&login_cliente='+document.cadastrarcliente.login_cliente.value+'&op=4');">
                            <table border="0" align="center">
                                <tr>
                                    <td colspan="2" id="textsubtitle">Dados Principais</td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Nome<font color="red">*</font></td>
                                    <td><input type="text" name="nome_pessoa" value="" size="60"/></td>
                                    <td><input type="hidden" name="nome_pessoa" value="" size="60"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Tipo<font color="red">*</font></td>
                                    <td id="textcadastrorbt">
                                        <input type="radio" name="tipo_pessoa" value="fisica" id="fisica"/>Fisica&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="tipo_pessoa" value="juridica" id="juridica"/>Juridica</td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">CPF/CNPJ<font color="red">*</font></td>
                                    <td><input type="text" name="cpf_pessoa" maxlength="15" id="cpf" value="" size="16" onblur="ValidaCPFCliente(this.value); validarDadosCliente('cpf_pessoa='+this.value+'&email_pessoa=null&login_cliente=null&op=1');"/><font style="font-family: Tahoma;" size="1pt" color="#FF4500">(apenas números)</font></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">RG/IE:</td>
                                    <td><input type="text" name="rg_pessoa" maxlength="12" value="" size="14"/><font style="font-family: Tahoma;" size="1pt" color="#FF4500">(apenas números)</font></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Endereco<font color="red">*</font></td>
                                    <td><input type="text" name="endereco_pessoa" value="" size="60"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Numero<font color="red">*</font></td>
                                    <td><input type="text" name="numero_pessoa" value="" size="6"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Bairro<font color="red">*</font></td>
                                    <td><input type="text" name="bairro_pessoa" value="" size="40"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Complemento</td>
                                    <td><input type="text" name="complemento_pessoa" value="" size="30"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Cidade<font color="red">*</font></td>
                                    <td><input type="text" name="cidade_pessoa" value="" size="40"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Estado<font color="red">*</font></td>
                                    <td>
                                        <select name="uf_pessoa">
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
                                    <td><input type="text" name="cep_pessoa" value="" size="10" maxlength="10" onkeypress="cep(event, this)"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Telefone<font color="red">*</font></td>
                                    <td><input type="text" name="telefone_pessoa" value="" size="14" maxlength="13" onkeypress="fone(event, this)"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Celular</td>
                                    <td><input type="text" name="celular_pessoa" value="" size="14" maxlength="13" onkeypress="fone(event, this)"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">E-mail</td>
                                    <td><input type="text" name="email_pessoa" value="" size="60" onblur="ValidaEmailCliente(this.value); validarDadosCliente('cpf_pessoa=null&email_pessoa='+this.value+'&login_cliente=null&op=2');"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Obervações</td>
                                    <td><textarea name="obs_pessoa" rows="4" cols="20"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" id="textsubtitle" >Acesso ao Sistema</td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Login<font color="red">*</font></td>
                                    <td><input type="text" name="login_cliente" value="" size="10" onblur="validarDadosCliente('cpf_pessoa=null&email_pessoa=null&login_cliente='+this.value+'&op=3')"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Senha<font color="red"><font color="red">*</font></font></td>
                                    <td><input type="password" name="senha_cliente" value="" size="10" /></td>
                                </tr>
                                <tr>
                                    <td align="center" colspan="3">
                                        <input class="btn" type="submit" value="Cadastrar" name="Enviar" id="btnsumbit"/>
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