<%-- 
    Document   : paginaacesso
    Created on : 22/05/2011, 19:19:50
    Author     : jpossatti
--%>
<%
    if (request.getSession().getAttribute("idCliente") != null) {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <link href="css/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="ajax/ajax.js"></script>
        <style type="text/css"> /*Isso com CSS*/
            fieldset {
                border-color: #216072;
                -moz-border-radius: 22px; /* Para Firefox */
                -webkit-border-radius: 22px; /*Para Safari e Chrome */
                border-radius: 22px; /* Para Opera 10.5+*/
                width: 390px; /*Largura da Página */
                height: 220px;
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
            .divInnerHtml{
                text-align: center;
                text-transform: uppercase;
                font-size: 15px;
                color: white;
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
                                <h5>Os comandos abaixo são uma demonstração de como pode-se desligar um<br/> dispositivo 
                                    utilizando um hardware de comunicação serial conectado a um servidor
                                </h5>
                                <hr>
                                <table border="0" align="center" cellpadding="10" cellspacing="10">
                                    <tr>
                                        <td><input type="button" name="l" value="Ligar" onclick="return ligaDispositivo();"/></td>
                                        <td><input type="button" name="d" value="Desligar" onclick="return desligaDispositivo();"/></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" align="center"><hr><a href="paginaprincipalcliente.jsp">Voltar</a></td>
                                    </tr>
                                </table>
                                <div id="div1" class="divInnerHtml"></div>
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