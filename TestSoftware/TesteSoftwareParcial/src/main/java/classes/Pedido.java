package classes;

import java.util.HashMap;
import java.util.Map;

public class Pedido {

    private Map<String, Integer> itens;
    private double valorTotal;

    public Pedido() {
        this.itens = new HashMap<>();
        this.valorTotal = 0.0;
    }

    public void adicionarItem(String item, int quantidade) {
        itens.put(item, itens.getOrDefault(item, 0) + quantidade);
    }

    public void removerItem(String item) {
        itens.remove(item);
    }

    public int obterQuantidadeTotal() {
        return itens.values().stream().mapToInt(Integer::intValue).sum();
    }

    public double calcularValorTotal(double precoPorItem) {
        valorTotal = obterQuantidadeTotal() * precoPorItem;
        return valorTotal;
    }

    public void limparPedido() {
        itens.clear();
        valorTotal = 0.0;
    }

    public Map<String, Integer> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

}
