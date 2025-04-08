package Sistema_Venda_Ingresso;

import java.util.Date;

public class Venda implements Imprimivel {
    //Atributos de Venda
    private static int id = 0; // id, contador estático que gera idVenda indivíduais para cada objeto Venda
    private int idVenda; // id único de cada objeto Venda
    private Cliente cliente;
    private Evento evento;
    private int quantidadeIngressos;
    private double valorTotal;
    private Date dataVenda;

    //Construtor de Venda
    public Venda(Cliente cliente, Evento evento, int quantidadeIngressos) {
        this.idVenda = id; // Atribui o valor atual de id do contador como idVenda
        ++id; // Incrementa o id para ser atribuido ao próximo objeto Venda
        this.cliente = cliente;
        this.evento = evento;
        this.quantidadeIngressos = quantidadeIngressos;
        this.valorTotal = evento.getValorIngressos() * quantidadeIngressos;
        this.dataVenda = new Date(); // Armazena a data e hora do momento da venda
    }
    //Getters de Venda
    public Integer getIdVenda() {
        return idVenda;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Evento getEvento() {
        return evento;
    }
    public int getQuantidadeIngressos() {
        return quantidadeIngressos;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public Date getDataVenda() {
        return dataVenda;
    }
    //Método para imprimir os dados da venda
    //Implementação da interface Imprimivel
    @Override
    public void imprimir() {
        System.out.println("Venda ID: " + idVenda);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Evento: " + evento.getNome());
        System.out.println("Quantidade de ingressos: " + quantidadeIngressos);
        System.out.println("Valor total: " + valorTotal);
        System.out.println("Data da venda: " + dataVenda);
    }
}
