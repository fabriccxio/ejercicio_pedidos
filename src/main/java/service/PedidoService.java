package service;

import org.apache.log4j.Logger;

import cache.BumexMemcached;
import dao.PedidoDao;
import modelo.Pedido;

public class PedidoService {
	
	PedidoDao pedidoDao;
	BumexMemcached bumexMemcached;
	Logger logger = Logger.getRootLogger();
	
	public Pedido crearPedido(Pedido pedido) {
		bumexMemcached.set(String.valueOf(pedido.getIdPedido()), pedido);

		pedidoDao.insertOrUpdate(pedido);
		return pedido;
	}
	
	public Pedido editarPedido(Pedido pedido) {
		Pedido pedidoPersistente = (Pedido) bumexMemcached.get(String.valueOf(pedido.getIdPedido()));

		if (pedidoPersistente == null) {
			pedidoPersistente = pedidoDao.select(pedido.getIdPedido());
		}
		bumexMemcached.set(String.valueOf(pedido.getIdPedido()), pedido);
		
		pedidoDao.insertOrUpdate(pedidoPersistente);
		return pedidoPersistente;
	}
	
	public Pedido buscarPorId(Integer id) {
		Pedido pedidoEnCache = (Pedido) bumexMemcached.get(String.valueOf(id));
		if (pedidoEnCache != null) {
			return pedidoEnCache;
		}
		return pedidoDao.select(id);
	}
	
	public void borrarPedido(Pedido pedido) {
		if (bumexMemcached.get(String.valueOf(pedido.getIdPedido())) != null) {
			bumexMemcached.delete(String.valueOf(pedido.getIdPedido()));
		}
		pedidoDao.delete(pedido);
	}
}
