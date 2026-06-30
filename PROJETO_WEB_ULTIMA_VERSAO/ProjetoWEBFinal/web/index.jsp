<%-- 
    Document   : paginaacesso
    Created on : 22/05/2011, 19:19:50
    Author     : jpossatti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <style type="text/css"> /*Isso com CSS*/
            fieldset {
                border-color: #216072;
                -moz-border-radius: 22px; /* Para Firefox */
                -webkit-border-radius: 22px; /*Para Safari e Chrome */
                border-radius: 22px; /* Para Opera 10.5+*/
                width: 390px; /*Largura da Página */
                height: 240px;
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
                                <h5>Digite seu login e senha para acessar o sistema</h5>
                                <table border="0" align="center" cellpadding="0" cellspacing="0">
                                    <form action="LogarUsuario" method="POST">
                                        <tbody>
                                            <tr>
                                                <td><b>Login</b></td>

                                                <td><input type="text" name="login_usuario" value="" size="20" /></td>
                                                <td rowspan="2"><img src="icones/enter.png" width="96" height="96" alt="enter"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><b>Senha</b></td>
                                                <td><input type="password" name="senha_usuario" value="" size="20" /></td>
                                            </tr>
                                            <tr>
                                                <td align="center" colspan="3">
                                                    <input type="submit" value="Acessar o Sistema" name="Acessar" align="center" class="btn" id="btnsumbit"/>
                                                    <input type="hidden" value="logar" name="acao"/> </td>
                                            </tr>
                                            <tr>
                                                <td colspan="3" height="10"><h5 align="center" style="color:white; font-family: sans-serif; ">${mensagem}</h5></td>
                                            </tr>
                                        </tbody>
                                    </form>
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
