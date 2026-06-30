/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Arduino;
import java.util.List;

/**
 *
 * @author Anderson
 */
public interface ArduinoDAO {
    public Arduino cadastrarAcao(Integer id, Integer porta);    //MÓDULO CLIENTE
    public void cadastrarMac(Arduino arduino);    //MODULO FUNCIONARIO/ADM
    public List<Arduino> listarArduino(Integer idPedido);     
    
    public void cadastrarPorta(Arduino arduino);    //MODULO FUNCIONARIO/ADM
}
