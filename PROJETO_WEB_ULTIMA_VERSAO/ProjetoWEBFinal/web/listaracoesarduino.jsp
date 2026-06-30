<%-- 
    Document   : paginaacesso
    Created on : 22/05/2011, 19:19:50
    Author     : jpossatti
--%>
<%
    if (request.getSession().getAttribute("idCliente") != null) {
%>
<%@page import="br.com.projetowebfinal.model.Arduino"%>
<%@page import="br.com.projetowebfinal.model.Imovel"%>
<%@page import="br.com.projetowebfinal.model.Imovel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="ajax/ajax.js"></script>
        <link href="style.css" rel="stylesheet" type="text/css" />
        <style type="text/css"> /*Isso com CSS*/
            fieldset {
                border-color: #216072;
                -moz-border-radius: 22px; /* Para Firefox */
                -webkit-border-radius: 22px; /*Para Safari e Chrome */
                border-radius: 22px; /* Para Opera 10.5+*/
                width: 890px; /*Largura da Página */
                /* height: 400px;*/
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
            <tr>
                <td colspan="3" height="200px" align="right"><div style="margin-right: 50px;"/><img src="img/logo.png"/></td>
            </tr>
            <tr>
                <td colspan="3">
                    <center>
                        <fieldset>
                            <h5>Bem vindo ao módulo de controle!<br/>Abaixo a lista de dispositivos adquiridos</h5>
                            <table border="0" align="center" cellspacing="0" cellpadding="9" class="borda">
                                <tr id="texttitlelist">
                                    <td><b>COMODO</b></td>
                                    <td><b>BEM</b></td>
                                    <td align="center" colspan="2" ><b>COMANDOS</b></td>
                                </tr>
                                <%  int i = 0;
                                    List<Arduino> arduinos = (List<Arduino>) request.getAttribute("arduinobem");
                                    for (Arduino arduino : arduinos) {
                                %>
                                <form name="dispositivos<%=i%>" action="AcaoDispositivoArduino" method="POST">
                                    <tr id="textcorplist"style="cursor:default" onMouseOver="javascript:this.style.backgroundColor='#E8E8E8'" onMouseOut="javascript:this.style.backgroundColor='white'">
                                        <td><%=arduino.getNome_comodo()%></td>
                                        <td><%=arduino.getDescricao_bem()%>
                                            <input type="hidden" name="id_porta_arduino" value="<%=arduino.getId_porta_arduino()%>"/>
                                            <input type="hidden" name="porta_arduino" value="<%=arduino.getNumero_porta()%>"/>
                                        </td> 
                                        <td>
                                            <input type="submit" value="Acionar Disp.">
                                        </td>
                                    </tr>                                    
                                </form>
                                <%}%>    
                                <tr>
                                    <td colspan="4" align="center"><a href="paginaprincipalcliente.jsp">Voltar</a></td>
                                </tr>
                            </table>
                        </fieldset>
                    </center>
                </td>
            </tr>
            <tr>
                <td colspan="3" height="200px" align="center">
                    <form action="LogarUsuario">
                        <input type="hidden" value="logout" name="acao"/>
                        <input type="hidden" value="" name="login_usuario"/>
                        <input type="hidden" value="" name="senha_usuario"/>
                        <div style="margin-left: 50px; margin-top: 10px;">
                            <input type="submit" style="border-width: 0" value="Sair do Sistema"/>
                        </div>                        
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
<%} else
        response.sendRedirect("index.jsp");
%>
