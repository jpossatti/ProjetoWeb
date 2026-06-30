/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetowebfinal.dao;

import br.com.projetowebfinal.model.ItemPedidoCompra;
import br.com.projetowebfinal.model.ItemPedidoVenda;
import br.com.projetowebfinal.model.PedidoCompra;
import br.com.projetowebfinal.model.PedidoVenda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public interface CarrinhoDAO {
    public Integer cadastrarVenda(PedidoVenda pedidovenda);    
    public Integer cadastrarCompra(PedidoCompra pedidocompra);
    
    public void cadastrarItemVenda(ArrayList<ItemPedidoVenda> itens);
    public void cadastrarItemCompra(ArrayList<ItemPedidoCompra> itens);
    
    public List<PedidoVenda> listarVenda();
    public List<PedidoCompra> listarCompra();
    
    public void cancelarPedidoVenda(Integer id_pedido_venda);
    public void cancelarPedidoCompra(Integer id_pedido_compra);
    
    public List<PedidoVenda> consultarPedidoStatusVenda(String status_pedido_venda);  
    public List<PedidoCompra> consultarPedidoStatusCompra(String status_pedido_venda);  
    
    public Integer confirmarPedidoVenda(PedidoVenda pedidovenda);
    
    public Integer estornarPedidoVenda(PedidoVenda pedidovenda);    
    
    public List<ItemPedidoVenda> listarItem(Integer idPedido);
    
}
