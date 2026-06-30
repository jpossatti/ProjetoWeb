<%-- 
    Document   : listarfuncionario
    Created on : 16/05/2011, 05:52:50
    Author     : jpossatti
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.Funcionario"%>
<%@include file="cabecalho.html" %>
<html>
    <link href="style.css" rel="stylesheet" type="text/css" />
    <title>Consulta de Funcionario</title>
</head>
<body>
    <p/>
    <hr/>
    <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
        <tbody>
            <tr id="texttitlelist">
                <td><b>Codigo</b></td>
                <td><b>Tipo</b></td>
                <td><b>Nome</b></td>
                <td><b>Endereço</b></td>
                <td><b>Cidade</b></td>
                <td><b>UF</b></td>
                <td><b>Telefone</b></td>
                <td align="center" colspan="3" ><b>Editar</b></td>
            </tr>
            <tr>
                <td colspan="10" bgcolor="#F9F9F9" height="10px" align="center" >
                    <font color="#4682B4" face="arial">Relação de funcionarios cadastrados</font>
                </td>
            </tr>
            <%
                List<Funcionario> funcionarios = (List<Funcionario>) request.getAttribute("listagem");
                for (Funcionario funcionario : funcionarios) {
            %>
            <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                <td id="id_list"><%=funcionario.getId_funcionario()%></td>
                <td><%=funcionario.getTipo_pessoa()%></td>
                <td><%=funcionario.getNome_pessoa()%></td>
                <td><%=funcionario.getEndereco_pessoa()%></td>
                <td><%=funcionario.getCidade_pessoa()%></td>
                <td><%=funcionario.getUf_pessoa()%></td>
                <td><%=funcionario.getTelefone_pessoa()%></td>
                <td><a href="CarregarFuncionario?id_pessoa=<%=funcionario.getId_pessoa()%>"><img src="icones/alterar.png" width="24" height="24"/></a></td>
                <td><a href="ExcluirFuncionario?id_pessoa=<%=funcionario.getId_pessoa()%>"><img src="icones/excluir.png" width="24" height="24"/></a></td>
            </tr>
            <%}%>
        </tbody>
    </table>
    <hr/>
</body>
</html>
<%@include file="rodape.html" %>
