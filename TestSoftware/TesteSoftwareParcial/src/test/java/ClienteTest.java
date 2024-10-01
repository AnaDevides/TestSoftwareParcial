import classes.Cliente;
import classes.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {

    private Cliente cliente;
    private Pedido pedido;

    @Before
    public void setUp() {
        cliente = new Cliente("João", "12345678901");
        pedido = new Pedido();
        pedido.adicionarItem("Item1", 2);
    }

    @Test
    public void testGetNomeClienteAtivo() {
        Cliente cliente = new Cliente("Nome Ativo", "12345678901");
        assertEquals("Nome Ativo", cliente.getNome());
    }

    @Test
    public void testGetNomeClienteInativo() {
        Cliente cliente = new Cliente(null, "12345678901");
        assertNull(cliente.getNome());
    }

    @Test
    public void testGetCpfValido() {
        Cliente cliente = new Cliente("Nome", "12345678901");
        assertEquals("12345678901", cliente.getCpf());
    }

    @Test
    public void testGetCpfInvalido() {
        Cliente cliente = new Cliente("Nome", null);
        assertNull(cliente.getCpf());
    }


    @Test
    public void testAdicionarPedido() {
        cliente.adicionarPedido(pedido);
        assertEquals(1, cliente.totalPedidos());
        assertEquals(pedido, cliente.obterUltimoPedido());
    }

    @Test
    public void testRemoverPedido() {
        cliente.adicionarPedido(pedido);
        cliente.removerPedido(pedido);
        assertEquals(0, cliente.totalPedidos());
        assertNull(cliente.obterUltimoPedido());
    }

    @Test
    public void testTotalPedidos() {
        cliente.adicionarPedido(pedido);
        cliente.adicionarPedido(new Pedido());
        assertEquals(2, cliente.totalPedidos());
    }

    @Test
    public void testObterUltimoPedido() {
        cliente.adicionarPedido(pedido);
        assertNotNull(cliente.obterUltimoPedido());
        cliente.removerPedido(pedido);
        assertNull(cliente.obterUltimoPedido());
    }

    @Test
    public void testObterUltimoPedidoSemPedidos() {
        assertNull(cliente.obterUltimoPedido());
    }

    @Test
    public void testListarPedidos() {
        cliente.adicionarPedido(pedido);
        assertFalse(cliente.listarPedidos().isEmpty());
        assertTrue(cliente.listarPedidos().contains(pedido));
    }

    @Test
    public void testListarPedidosVazio() {
        assertTrue(cliente.listarPedidos().isEmpty());
    }

}
