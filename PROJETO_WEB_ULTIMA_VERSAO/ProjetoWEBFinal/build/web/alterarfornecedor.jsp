<%-- 
    Document   : alterarfornededo
    Created on : 22/05/2011, 16:26:50
    Author     : jpossatti
--%>
<%    
    if (request.getSession().getAttribute("idCliente") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@include file="cabecalho.html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="javascript" src="ajax/ajax.js"></script>
        <title> Alteração de Fornecedor </title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
                <tr>
                    <td style="background-color: #87CEFA;"align="center" colspan="3"><div id="titulo">Alteração de Fornecedores</div></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                <tr>
                    <td colspan="3" bgcolor="#f9f9f9">
                        <form name="alterarfornecedor" action="AlterarFornecedor" method="POST">
                            <table border="0" align="center">
                                <tbody>
                                    <tr>
                                        <td colspan="2" id="textsubtitle">Dados Principais</td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Nome<font color="red">*</font></td>
                                        <td><input type="hidden" name="id_pessoa" value="${fornecedor.id_pessoa}"/><input type="text" name="nome_pessoa" value="${fornecedor.nome_pessoa}" size="60"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Endereco<font color="red">*</font></td>
                                        <td><input type="text" name="endereco_pessoa" value="${fornecedor.endereco_pessoa}" size="60"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Numero<font color="red">*</font></td>
                                        <td><input type="text" name="numero_pessoa" value="${fornecedor.numero_pessoa}" size="6"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Bairro<font color="red">*</font></td>
                                        <td><input type="text" name="bairro_pessoa" value="${fornecedor.bairro_pessoa}" size="40"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Complemento</td>
                                        <td><input type="text" name="complemento_pessoa" value="${fornecedor.complemento_pessoa}" size="30"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Cidade<font color="red">*</font></td>
                                        <td><input type="text" name="cidade_pessoa" value="${fornecedor.cidade_pessoa}" size="40"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Estado<font color="red">*</font></td>
                                        <td><select name="uf_pessoa">
                                                <option value="${fornecedor.uf_pessoa}" selected>${fornecedor.uf_pessoa}</option>
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
                                        <td id="textcadastro">CEP<font color="red">*</font></td>
                                        <td><input type="text" name="cep_pessoa" value="${fornecedor.cep_pessoa}" size="10" maxlength="10" onkeypress="cep(event, this)"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Telefone<font color="red">*</font></td>
                                        <td><input type="text" name="telefone_pessoa" value="${fornecedor.telefone_pessoa}" size="14" onkeypress="fone(event, this)"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Celular<font color="red">*</font></td>
                                        <td><input type="text" name="celular_pessoa" value="${fornecedor.celular_pessoa}" size="14" onkeypress="fone(event, this)"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">E-mail<font color="red">*</font></td>
                                        <td><input type="text" name="email_pessoa" value="${fornecedor.email_pessoa}" size="60" onblur="ValidaEmailFornecedor(this.value); validarDadosFornecedor('cpf_pessoa=null&email_pessoa='+this.value+'&login_cliente=null');"/></td>
                                    </tr>
                                    <tr>
                                        <td id="textcadastro">Obervações</td>
                                        <td><textarea name="obs_pessoa" rows="4" cols="20">${fornecedor.obs_pessoa}</textarea>
                                        </td>
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
<%} else
        response.sendRedirect("index.jsp");
%>