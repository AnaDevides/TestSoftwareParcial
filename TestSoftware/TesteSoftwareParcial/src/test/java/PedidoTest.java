import classes.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PedidoTest {

    private Pedido pedido;

    @Before
    public void setUp() {
        pedido = new Pedido();
    }

    @Test
    public void testAdicionarItem() {
        pedido.adicionarItem("Item1", 2);
        assertEquals(2, pedido.obterQuantidadeTotal());
        assertTrue(pedido.getItens().containsKey("Item1"));
    }

    @Test
    public void testAdicionarItemQuantidadeZero() {
        pedido.adicionarItem("Item1", 0);
        assertEquals(0, pedido.obterQuantidadeTotal());
    }

    @Test
    public void testRemoverItem() {
        pedido.adicionarItem("Item1", 2);
        pedido.removerItem("Item1");
        assertTrue(pedido.getItens().isEmpty());
    }

    @Test
    public void testRemoverItemNaoExistente() {
        pedido.adicionarItem("Item1", 2);
        pedido.removerItem("ItemNaoExistente");
        assertEquals(2, pedido.obterQuantidadeTotal());
    }

    @Test
    public void testCalcularValorTotal() {
        pedido.adicionarItem("Item1", 3);
        double valorTotal = pedido.calcularValorTotal(10.0);
        assertEquals(30.0, valorTotal, 0.01);
    }

    @Test
    public void testCalcularValorTotalPrecoNegativo() {
        pedido.adicionarItem("Item1", 3);
        double valorTotal = pedido.calcularValorTotal(-10.0);
        assertEquals(-30.0, valorTotal, 0.01);
    }

    @Test
    public void testLimparPedido() {
        pedido.adicionarItem("Item1", 2);
        pedido.limparPedido();
        assertTrue(pedido.getItens().isEmpty());
        assertEquals(0.0, pedido.getValorTotal(), 0.01);
    }

    @Test
    public void testLimparPedidoVazio() {
        pedido.limparPedido();
        assertTrue(pedido.getItens().isEmpty());
        assertEquals(0.0, pedido.getValorTotal(), 0.01);
    }

    @Test
    public void testObterQuantidadeTotal() {
        pedido.adicionarItem("Item1", 3);
        pedido.adicionarItem("Item2", 1);
        assertEquals(4, pedido.obterQuantidadeTotal());
    }

}
