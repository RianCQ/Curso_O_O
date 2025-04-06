package Sistema_Venda_Ingresso;

import java.util.Date;

public class Venda {
    //Atributos de Venda
    private static int id = 0; // ID da venda
    private int idVenda; // ID único de cada objeto venda
    private Cliente cliente;
    private Evento evento;
    private int quantidadeIngressos;
    private double valorTotal;
    private Date dataVenda;

    //Construtor de Venda
    public Venda(Cliente cliente, Evento evento, int quantidadeIngressos) {
        this.idVenda = id; 
        ++id; // Incrementa o ID da venda
        this.cliente = cliente;
        this.evento = evento;
        this.quantidadeIngressos = quantidadeIngressos;
        this.valorTotal = evento.getValorIngressos() * quantidadeIngressos;
        this.dataVenda = new Date(); 
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
    public void imprimirVenda() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Evento: " + evento.getNome());
        System.out.println("Quantidade de ingressos: " + quantidadeIngressos);
        System.out.println("Valor total: " + valorTotal);
        System.out.println("Data da venda: " + dataVenda);
    }
}
