package ejercicio.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.inject.Inject;
import com.google.j2objc.annotations.AutoreleasePool;

import cache.BumexMemcached;
import modelo.Pedido;
import service.PedidoService;

public class PedidoServiceTest {

	private BumexMemcached bumexMemcached;
	private PedidoService pedidoService=new PedidoService();
	
	@Test
	public void testCrearPedido() {
		
		Pedido pedido = new Pedido();
		
		pedido.setIdPedido(1);
		pedido.setDescuento(50);
		pedido.setMonto(500);
		pedido.setNombre("Prueba Pedido");

//		pedidoService.crearPedido(pedido);
		
//		Assert.assertNotNull(pedidoService.buscarPorId(pedido.getIdPedido()),"Pedido no encontrado.");
		
	}

}
