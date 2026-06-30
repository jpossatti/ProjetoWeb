<%-- 
    Document   : paginaacesso
    Created on : 22/05/2011, 19:19:50
    Author     : jpossatti
--%>
<%
    if (request.getSession().getAttribute("idCliente") != null) {
%>
<%@page import="br.com.projetowebfinal.model.Imovel"%>
<%@page import="br.com.projetowebfinal.model.Imovel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="javascript">
            function confirm(){
                if (window.confirm('Deseja logar no sistema?')) {
                    alert("ok, logando..");
                }
                else { window.alert('Ok, nenhuma ação foi feita!') }

            }
        </script>
        <style type="text/css"> /*Isso com CSS*/
            fieldset {
                border-color: #216072;
                -moz-border-radius: 22px; /* Para Firefox */
                -webkit-border-radius: 22px; /*Para Safari e Chrome */
                border-radius: 22px; /* Para Opera 10.5+*/
                width: 890px; /*Largura da Página */
                height: 200px;
                padding: 5px; /*Distancia da borda para o conteudo*/
            }
            h5{
                font-family: sans-serif;
                color: azure;
                font-size: 10px;
            }
            b{
                font-family: sans-serif;
                color: azure;
                text-align: left;
                font-size: 8pt;
            }
            a:link, a:visited{
                font-family: sans-serif; 
                color: white; 
                font-size: 15px;
                text-decoration: none;
            }
            a:hover{
                text-decoration: none;
                background-image: url('img/linkfundo.png');
                color: black;
            }
            a:active {
                text-decoration: none
            }
        </style>
        <title>Logar</title>
    </head> <%--Abaixo CSS, fazendo o Fielset - Style --%>    
    <body bgcolor="#00688B">
        <table border="0" width="100%" height="100%" cellpadding="0" cellspacing="0">            
            <tbody>
                <tr>
                    <td colspan="3" height="200px" align="right"><div style="margin-right: 50px;"/><img src="img/logo.png"/></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <center>
                            <fieldset>
                                <h5>Selecione um imovel a ser controlado</h5>
                                <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
                                    <tbody>
                                        <tr id="texttitlelist">
                                            <td><b>Endereco</b></td>
                                            <td><b>Numero</b></td>
                                            <td align="center" colspan="2" ><b>Selecionar</b></td>
                                        </tr>
                                        <%
                                            List<Imovel> imoveis = (List<Imovel>) request.getAttribute("imoveiscliente");
                                            for (Imovel imovel : imoveis) {
                                        %>
                                    <form action="ListarBemImovelArduino" method="POST">
                                        <tr id="textcorplist"style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor=''">
                                            <input type="hidden" name="idImovelArduino" value="<%=imovel.getId_imovel()%>"/>
                                            <td ><%=imovel.getEndereco_imovel()%></td>
                                            <td><%=imovel.getNumero_imovel()%></td>                                            
                                            <td>
                                                <input type="submit" value="Selecionar" />
                                            </td>
                                        </tr>
                                    </form>
                                    <%}%>
                                    <tr>
                                        <td colspan="3" align="center"><a href="paginaprincipalcliente.jsp">Voltar</a></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </fieldset>
                        </center>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" height="200px"></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
<%} else
        response.sendRedirect("index.jsp");
%>