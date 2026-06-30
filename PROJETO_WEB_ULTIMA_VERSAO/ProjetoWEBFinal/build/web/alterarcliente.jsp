<%-- 
    Document   : cadastrarcliente
    Created on : 01/07/2011, 12:44:56
    Author     : Anderson
--%>
<%
    if (request.getSession().getAttribute("idCliente") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@include file="cabecalho.html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="javascript" src="scripts/wz_tooltip.js"></script>
        <script type="text/javascript" src="ajax/ajax.js"></script>
        <title>Alteração de Clientes</title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
               <tr>
                     <td style="background-color: #87CEFA;"align="center" colspan="3"><div id="titulo">Alteração de Cliente</div></td>
                    </tr>
                <tr>
                    <td align="center"><h5 align="center">${mensagem}</h5><br/><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="3" bgcolor="#f9f9f9">
                        <form name="alterarcliente" id="cadastrarcliente" action="AlterarCliente" method="POST" onsubmit="return ValidaCadastroCliente();">
                            <table border="0" align="center">
                                <tr>
                                    <td colspan="2" id="textsubtitle">Dados Principais</td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Nome<font color="red">*</font></td>
                                    <td><input type="hidden" name="id_pessoa" value="${cliente.id_pessoa}" size="60"/><input type="text" name="nome_pessoa" value="${cliente.nome_pessoa}" size="60"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Endereco<font color="red">*</font></td>
                                    <td><input type="text" name="endereco_pessoa" value="${cliente.endereco_pessoa}" size="60"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Numero<font color="red">*</font></td>
                                    <td><input type="text" name="numero_pessoa" value="${cliente.numero_pessoa}" size="6"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Bairro<font color="red">*</font></td>
                                    <td><input type="text" name="bairro_pessoa" value="${cliente.bairro_pessoa}" size="40"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Complemento</td>
                                    <td><input type="text" name="complemento_pessoa" value="${cliente.complemento_pessoa}" size="30"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Cidade<font color="red">*</font></td>
                                    <td><input type="text" name="cidade_pessoa" value="${cliente.cidade_pessoa}" size="40"/></td>
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
                                    <td><input type="text" name="cep_pessoa" value="${cliente.cep_pessoa}" size="10" maxlength="10" onkeypress="cep(event, this)"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Telefone<font color="red">*</font></td>
                                    <td><input type="text" name="telefone_pessoa" value="${cliente.telefone_pessoa}" size="14" maxlength="13" onkeypress="fone(event, this)"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Celular</td>
                                    <td><input type="text" name="celular_pessoa" value="${cliente.celular_pessoa}" size="14" maxlength="13" onkeypress="fone(event, this)"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">E-mail</td>
                                    <td><input type="text" name="email_pessoa" value="${cliente.email_pessoa}" readonly  size="60" onblur="ValidaEmailCliente(this.value); validarDadosCliente('cpf_pessoa=null&email_pessoa='+this.value+'&login_cliente=null');"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Obervações</td>
                                    <td><textarea name="obs_pessoa" rows="4" cols="20">${cliente.obs_pessoa}</textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" id="textsubtitle" >Acesso ao Sistema</td>
                                </tr>
                                <!--<tr>
                                    <td id="textcadastro">Login<font color="red"><font color="red">*</font></font></td>
                                    <td><input type="text" name="login_cliente" value="" readonly="true" size="10"/></td>
                                </tr>-->
                                <tr>
                                    <td id="textcadastro">Senha<font color="red"><font color="red">*</font></font></td>
                                    <td><input type="password" name="senha_cliente" value="${cliente.senha_cliente}" size="10"/></td>
                                </tr>
                                <tr>
                                    <td align="center" colspan="3">
                                        <input class="btn" type="submit" value="Alterar" name="Enviar" id="btnsumbit"/>
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