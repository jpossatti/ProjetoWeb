/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function verificaNav(){
    var xmlhttp = null;
    try { 
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP"); 
    } catch (e) { 
        try { 
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); 
        } catch (E) { 
            xmlhttp = false; 
        } 
    } 

    if  (!xmlhttp && typeof  XMLHttpRequest != 'undefined' ) { 
        try  { 
            xmlhttp = new  XMLHttpRequest(); 
        } catch  (e) { 
            xmlhttp = false ; 
        } 
    }
    return xmlhttp;
}

function validarDadosCliente(parameters) {
    var url = "ValidaDados?"+parameters
    var xmlhttp = verificaNav();
    valid0 = document.cadastrarcliente.cpf_pessoa;
    valid1 = document.cadastrarcliente.email_pessoa;
    valid2 = document.cadastrarcliente.login_cliente;
        
    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader('Content-Type','text/xml');
    xmlhttp.setRequestHeader('encoding','ISO-8859-1');
    xmlhttp.send(null);
        
    xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4) { // Completo 
            if (xmlhttp.status == 200) { // resposta do servidor OK 
                mensagem = xmlhttp.responseText;     
                if(mensagem.toString().search("Este")==-1){
                    //não faz nada    
                    return true;
                }
                else {
                    alert(mensagem);
                    if(mensagem.substring(5, 8) == "CPF"){
                        valid0.focus();
                        document.cadastrarcliente.cpf_pessoa.value="";
                        
                    }
                    else if(mensagem.substring(5, 10) == "Email"){
                        valid1.focus();
                        document.cadastrarcliente.email_pessoa.value="";
                        
                    }
                    else if(mensagem.substring(5, 10) == "Login"){
                        valid2.focus();
                        document.cadastrarcliente.login_cliente.value="";
                        
                    }
                }               
            } else { 
                alert( "Problema: " + xmlhttp.statusText );  
                return false;
            } 
        }
    }
}    
function validarDadosFuncionario(parameters) {
    var url = "ValidaDados?"+parameters
    var xmlhttp = verificaNav();
    valid0 = document.cadastrarfuncionario.cpf_pessoa;
    valid1 = document.cadastrarfuncionario.email_pessoa;
    valid2 = document.cadastrarfuncionario.login_funcionario;
        
    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader('Content-Type','text/xml');
    xmlhttp.setRequestHeader('encoding','ISO-8859-1');
    xmlhttp.send(null);
        
    xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4) { // Completo 
            if (xmlhttp.status == 200) { // resposta do servidor OK 
                mensagem = xmlhttp.responseText;     
                if(mensagem.toString().search("Este")==-1){
                    //não faz nada    
                    return true;
                }
                else {
                    alert(mensagem);
                    if(mensagem.substring(5, 8) == "CPF"){
                        valid0.focus();
                        document.cadastrarfuncionario.cpf_pessoa.value="";
                        
                    }
                    else if(mensagem.substring(5, 10) == "Email"){
                        valid1.focus();
                        document.cadastrarfuncionario.email_pessoa.value="";
                        
                    }
                    else if(mensagem.substring(5, 10) == "Login"){
                        valid2.focus();
                        document.cadastrarfuncionario.login_funcionario.value="";                        
                    }
                }               
            } else { 
                alert( "Problema: " + xmlhttp.statusText );  
                return false;
            } 
        }
    } 
}
function validarDadosFornecedor(parameters) {
    var url = "ValidaDados?"+parameters
    var xmlhttp = verificaNav();
        
    valid0 = document.cadastrarfornecedor.cpf_pessoa;
    valid1 = document.cadastrarfornecedor.email_pessoa;
    
    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader('Content-Type','text/xml');
    xmlhttp.setRequestHeader('encoding','ISO-8859-1');
    xmlhttp.send(null);
        
    xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4) { // Completo 
            if (xmlhttp.status == 200) { // resposta do servidor OK 
                mensagem = xmlhttp.responseText;     
                if(mensagem.toString().search("Este")==-1){
                    //não faz nada    
                    return true;
                }
                else {
                    alert(mensagem);
                        
                    if(mensagem.substring(5, 8) == "CPF"){
                        valid0.focus();
                        document.cadastrarfornecedor.cpf_pessoa.value="";
                        
                    }
                    else if(mensagem.substring(5, 10) == "Email"){
                        valid1.focus();
                        document.cadastrarfornecedor.email_pessoa.value="";                        
                    }
                }               
            } else { 
                alert( "Problema: " + xmlhttp.statusText );  
                return false;
            } 
        }
    }
}
function ligaDispositivo() {
    var url = 'http://192.168.227.2/clp.php?l=2';
    //var url = 'http://189.111.145.234:8089/clp.php?l=2';
    var xmlhttp = verificaNav();  

    xmlhttp.onreadystatechange = function(){
        if(xmlhttp.readyState==1){
            document.getElementById('div1').innerHTML='Ligado';
        }
        if(xmlhttp.readyState==4){
            document.getElementById('div1').innerHTML=xmlhttp.responseText;
        }
    }
    
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader('Content-Type','text/xml');
    xmlhttp.setRequestHeader('encoding','ISO-8859-1');
    xmlhttp.send(null);
}
function desligaDispositivo() {
    var url = 'http://192.168.227.2/clp.php?d=2';
    //var url = 'http://189.111.145.234:8089/clp.php?d=2';
    var xmlhttp = verificaNav();  

    xmlhttp.onreadystatechange = function(){
        if(xmlhttp.readyState==1){
            document.getElementById('div1').innerHTML='Desligado';
        }
        if(xmlhttp.readyState==4){
            document.getElementById('div1').innerHTML=xmlhttp.responseText;
        }
    }
    
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader('Content-Type','text/xml');
    xmlhttp.setRequestHeader('encoding','ISO-8859-1');
    xmlhttp.send(null);    
}
function verificaEstoque(parameters) {
    var url = "VerificaEstoque?"+parameters
    var xmlhttp = verificaNav();
        
    valid = document.listarcatalogobem.quantidade_pedido_compra.value;
    
    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader('Content-Type','text/xml');
    xmlhttp.setRequestHeader('encoding','ISO-8859-1');
    xmlhttp.send(null);
        
    xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4) { // Completo 
            if (xmlhttp.status == 200) { // resposta do servidor OK 
                mensagem = xmlhttp.responseText;     
                if(mensagem.toString().search("Este")==-1){
                    //não faz nada    
                    return true;
                }
                else {
                    alert(mensagem);
                }               
            } else { 
                alert( "Problema: " + xmlhttp.statusText );  
                return false;
            } 
        }
    }
}