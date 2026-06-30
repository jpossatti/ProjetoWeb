<%-- 
    Document   : cadastrarpessoacliente
    Created on : 08/04/2011, 13:12:46
    Author     : Anderson
--%>
<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@include file="cabecalho.html" %>
<%@page import="br.com.projetowebfinal.model.Cargo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="scripts/wz_tooltip.js"></script>
        <link type="text/css" rel="stylesheet" href="dhtmlgoodies_calendar/dhtmlgoodies_calendar.css?random=20051112" media="screen"></LINK>
        <SCRIPT type="text/javascript" src="dhtmlgoodies_calendar/dhtmlgoodies_calendar.js?random=20060118"></script>
        <SCRIPT language="javascript" src="ajax/ajax.js"></script>
        <title> Cadastro de Funcionario </title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
                <tbody>
                    <tr>
                        <td style="background-color: #87CEFA;"align="center" colspan="3"><div id="titulo">Cadastro de Funcionarios</div></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                    <tr>
                        <td colspan="3" bgcolor="#f9f9f9">
                            <form name="cadastrarfuncionario" action="CadastrarFuncionario" method="POST" onsubmit="return ValidaCadastroFuncionario()">
                                <table border="0" align="center">
                                    <tbody>
                                        <tr>
                                            <td colspan="2" id="textsubtitle">Dados Principais</td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">Nome<font color="red">*</font></td>
                                            <td><input type="text" name="nome_pessoa" value="" size="60"/></td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">Tipo<font color="red">*</font></td>
                                            <td id="textcadastrorbt">
                                                <input type="radio" name="tipo_pessoa" value="fisica" id="fisica"/>Fisica&nbsp;&nbsp;&nbsp;
                                                <input type="radio" name="tipo_pessoa" value="juridica" id="juridica"/>Juridica</td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">CPF/CNPJ<font color="red">*</font></td>
                                            <td><input type="text" name="cpf_pessoa" maxlength="15" id="cpf" value="" size="16" onblur="ValidaCPFFuncionario(this.value); validarDadosFuncionario('cpf_pessoa='+this.value+'&email_pessoa=null&login_cliente=null&op=1');"/><font style="font-family: Tahoma;" size="1pt" color="#FF4500">(apenas números)</font></td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">RG/IE<font color="red">*</font></td>
                                            <td><input type="text" name="rg_pessoa" maxlength="12" value="" size="14"/><font style="font-family: Tahoma;"  size="1pt" color="#FF4500">(apenas números)</font></td>
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
                                            <td id="textcadastro">Complemento<font color="red">*</font></td>
                                            <td><input type="text" name="complemento_pessoa" value="" size="30"/></td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">Cidade<font color="red">*</font></td>
                                            <td><input type="text" name="cidade_pessoa" value="" size="40"/></td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">Estado<font color="red">*</font></td>
                                            <td><select name="uf_pessoa">
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
                                            <td><input type="text" name="telefone_pessoa" value="" size="14" onkeypress="fone(event, this)"/></td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">Celular</td>
                                            <td><input type="text" name="celular_pessoa" value="" size="14" onkeypress="fone(event, this)"/></td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">E-mail</td>
                                            <td><input type="text" name="email_pessoa" value="" size="60" onblur="ValidaEmailFuncionario(this.value); validarDadosFuncionario('cpf_pessoa=null&email_pessoa='+this.value+'&login_cliente=null&op=2');"/></td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">Obervações:</td>
                                            <td><textarea name="obs_pessoa" rows="4" cols="20"></textarea></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" id="textsubtitle" >Contratação</td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">Data Admissao<font color="red">*</font></td>
                                            <td><input type="text" value="24/12/2000" readonly name="dataadmissao_funcionario"><input type="button" value="Calendario" onclick="displayCalendar(document.cadastrarfuncionario.dataadmissao_funcionario,'dd/mm/yyyy',this)"></td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">Salario<font color="red">*</font></td>
                                            <td><input type="text" name="salario_funcionario" value="" size="10"/></td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">Departamento<font color="red">*</font></td>
                                            <td>
                                                <select name="id_departamento_cargo">
                                                    <%
                                                        List<Cargo> cargos = (List<Cargo>) request.getAttribute("cargos");
                                                        for (Cargo cargo : cargos) {
                                                    %>
                                                    <option value="<%= cargo.getId_cargo()%>"> <%= cargo.getNome_cargo()%></option>
                                                    <% }%>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" id="textsubtitle" >Acesso ao Sistema</td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">Login<font color="red">*</font></td>
                                            <td><input type="text" name="login_funcionario" value="" size="10" onblur="validarDadosFuncionario('cpf_pessoa=null&email_pessoa=null&login_cliente='+this.value+'&op=3')"/></td>
                                        </tr>
                                        <tr>
                                            <td id="textcadastro">Senha<font color="red">*</font></td>
                                            <td><input type="password" name="senha_funcionario" value="" size="10"/></td>
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