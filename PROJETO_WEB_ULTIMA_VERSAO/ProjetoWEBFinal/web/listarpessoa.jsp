<%-- 
    Document   : listarpessoa
    Created on : 16/05/2011, 05:55:36
    Author     : jpossatti
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Pessoa</title>
    </head>
    <body>
        <h1 align="center">Consultar Pessoa</h1>
        <table border="1" align="center">
            <tbody>
                <tr>
                     <td><b>Codigo:</b></td>
                     <td><b>Tipo:</b></td>
                     <td><b>Nome:</b></td>
                     <td><b>CPF:</b></td>
                     <td><b>RG:</b></td>
                     <td><b>Endereco:</b></td>
                     <td><b>Numero:</b></td>
                     <td><b>Bairro:</b></td>
                     <td><b>Complemento:</b></td>
                     <td><b>Cidade:</b></td>
                     <td><b>UF:</b></td>
                     <td><b>CEP:</b></td>
                     <td><b>Telefone:</b></td>
                     <td><b>Celular:</b></td>
                     <td><b>E-mail:</b></td>
                     <td><b>Observacao:</b></td>


                <td align="center" colspan="2" ><b>Editar</b></td>
                </tr>
                <%
                List<Pessoa> pessoas =(List<Pessoa>)request.getAttribute("listagem");
                for(Pessoa pessoa:pessoas){
                    %>
                    <tr>
                        <td id="id_list"><%=pessoa.getId_pessoa()%></td>
                        <td><%=pessoa.getTipo_pessoa()%></td>
                        <td><%=pessoa.getNome_pessoa()%></td>
                        <td><%=pessoa.getCpf_pessoa()%></td>
                        <td><%=pessoa.getRg_pessoa()%></td>
                        <td><%=pessoa.getEndereco_pessoa()%></td>
                        <td><%=pessoa.getNumero_pessoa()%></td>
                        <td><%=pessoa.getBairro_pessoa()%></td>
                        <td><%=pessoa.getComplemento_pessoa()%></td>
                        <td><%=pessoa.getCidade_pessoa()%></td>
                        <td><%=pessoa.getUf_pessoa()%></td>
                        <td><%=pessoa.getCep_pessoa()%></td>
                        <td><%=pessoa.getTelefone_pessoa()%></td>
                        <td><%=pessoa.getCelular_pessoa()%></td>
                        <td><%=pessoa.getEmail_pessoa()%></td>
                        <td><%=pessoa.getObs_pessoa()%></td>


                        <td><a href="ExcluirPessoa?id_pessoa=<%=pessoa.getId_pessoa()%>">Exluir</a></td>
                         <td><a href="CarregarPessoa?id_pessoa=<%=pessoa.getId_pessoa()%>">Alterar</a></td>

                    </tr>
                    <%}%>
            </tbody>
        </table>


    </body>
</html>
