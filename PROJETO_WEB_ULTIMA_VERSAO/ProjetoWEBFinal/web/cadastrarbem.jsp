

<%
    if (request.getSession().getAttribute("administrador") != null
            || request.getSession().getAttribute("idFuncionario") != null) {
%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetowebfinal.model.ProdutoBem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.projetowebfinal.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.projetowebfinal.controller.LogarUsuario"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="br.com.projetowebfinal.model.Permissao"%>
<%@page import="br.com.projetowebfinal.model.SubCategoria"%>
<%@page import="br.com.projetowebfinal.model.Bem"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="cabecalho.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="javascript">
            function gravaSessao(){
                var p1 = document.cadastrarbem.descricao_bem.value;
                var p2 = document.cadastrarbem.marca_bem.value;
                var p3 = document.cadastrarbem.precomaodeobra_bem.value;
                var p4 = document.cadastrarbem.id_categoria.value;
                location.href='GravaSessaoBem?descricao_bem='+p1+'&marca_bem='+p2+'&precomaodeobra_bem='+p3+'&id_categoria='+p4;
            }
        </script>
        <title> Cadastro de Bem </title>
    </head>
    <body>
        <fieldset>
            <table border="0" align="center" width="100%">
                <tr>
                    <td style="background-color: #87CEFA;" align="center" colspan="3"><div id="titulo">Cadastro de Bens</div></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><font size="2pt" color="#FF4500">Os campos com (*) são de preenchimento obrigatório</font></td>
                </tr>
                <tr>
                    <td colspan="3" bgcolor="#f9f9f9">
                        <%
                            HttpSession sessao = request.getSession();
                        %>
                        <form name="cadastrarbem" action="CadastrarBem" method="POST" onsubmit="return ValidaCadastroBem()">
                            <table border="0" align="center">
                                <tr>
                                    <td colspan="2" id="textsubtitle">Dados Principais</td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Descricao</td>
                                    <td><input type="text" name="descricao_bem" value="<%= sessao.getAttribute("descricaoBem")%>" size="60"/></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Marca</td>
                                    <td><input type="text" name="marca_bem" value="<%= sessao.getAttribute("marcaBem")%>" size="10"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Preco mao de obra</td>
                                    <td><input type="text" name="precomaodeobra_bem" value="<%= sessao.getAttribute("precomaodeobraBem")%>" size="10"/></td>
                                </tr>
                                <tr>
                                    <td id="textcadastro">Sub-Categoria</td>
                                    <td>
                                        <%
                                            List<SubCategoria> subcategorias = (List<SubCategoria>) request.getAttribute("categorias");
                                        %>
                                        <select name="id_categoria">
                                            <%
                                                for (SubCategoria subcategoria : subcategorias) {
                                            %>
                                            <option value="<%= subcategoria.getId_sub_categoria()%>"><%= subcategoria.getNome_sub_categoria()%></option>
                                            <% }%>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center" colspan="3">
                                        <input class="btn" type="button" value="Incluir novo item" name="incluir" onclick="gravaSessao();" id="btnsumbit"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <%
                                            ArrayList<ProdutoBem> produtosBem = (ArrayList<ProdutoBem>) sessao.getAttribute("produtoBem");
                                            if (produtosBem == null || produtosBem.size() == 0) {%>
                                        <center><b><font face="arial" size="2pt" color="#0066FF">Não há produtos adicionados!</font></b></center>
                                        <%        } else {
                                        %>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <table border="1" align="center" cellspacing="0" cellpadding="9" class="bordaProduto">
                                            <tr id="texttitlelist">
                                                <td>Codigo</td>
                                                <td>Descrição</td>
                                                <td>Quantidade</td>
                                                <td colspan="2">Editar</td>
                                            </tr>
                                            <% int seq = 0;
                                                for (ProdutoBem produtoBem : produtosBem) {
                                            %>
                                            <tr id="textcorplist" style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                                                <td><div id="id_list"><input type="hidden" name="id_produto_bem<%=seq%>" value="<%=produtoBem.getId_produto_bem()%>">
                                                        <%=produtoBem.getId_produto_bem()%></div></td>
                                                <td><%=produtoBem.getDescricao_produto_bem()%></td>
                                                <td><input type="hidden" name="quantidade_produto_bem" value="<%=produtoBem.getQuantidade_produto_bem()%>">
                                                    <%=produtoBem.getQuantidade_produto_bem()%></td>
                                                <td colspan="2"><a href="AdicionarProdutoBem?id_produto=<%= produtoBem.getId_produto_bem()%>&quantidade_produto=1"> +1 </a>
                                                    <% if (produtoBem.getQuantidade_produto_bem() > 1) {%>
                                                    &nbsp;&nbsp;<a href="RemoverProdutoBem?id_produto=<%= produtoBem.getId_produto_bem()%>"> -1 </a>
                                                    <% }%>
                                                    &nbsp;&nbsp;<a href="RemoverProdutoBem?seq=<%= seq%>"><img src="icones/excluir.png" width="24" height="24"/></a></td>
                                            </tr>
                                            <%
                                                    seq++;
                                                }
                                            %>
                                        </table>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                                <tr>
                                    <td align="center" colspan="3">
                                        <input class="btn" type="submit" value="Cadastrar" name="Enviar" id="btnsumbit"/>
                                    </td>
                                </tr>
                        </form>
            </table>
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