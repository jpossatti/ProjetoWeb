/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.Imovel;
import java.util.List;

/**
 *
 * @author jpossatti
 */
public interface ImovelDAO {
    public void cadastrarImovel(Imovel imovel);
    public List<Imovel> listar();
    public List<Imovel> consultarImovel(Integer idCliente);
    public List<Imovel> imovelCliente(Integer id_cliente);
    public List<Imovel> consultarImovelCliente(Integer idCliente, Integer idImovel);
    public void excluirImovel(Integer id_imovel);
    public Imovel listarImovel (Integer id_imovel);
    public List<Imovel> listarImovelCliente (Integer id_cliente);
    public void alterarImovel(Imovel imovel);
    
}
