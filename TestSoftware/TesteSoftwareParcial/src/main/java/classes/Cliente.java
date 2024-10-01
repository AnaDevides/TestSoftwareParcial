package classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private List<Pedido> pedidos;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pedidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public int totalPedidos() {
        return pedidos.size();
    }

    public Pedido obterUltimoPedido() {
        if (pedidos.isEmpty()) {
            return null;
        }
        return pedidos.get(pedidos.size() - 1);
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

}
