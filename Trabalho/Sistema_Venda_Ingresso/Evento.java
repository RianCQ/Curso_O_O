package Sistema_Venda_Ingresso;

public class Evento implements Imprimivel {
    //Atributos privados do Evento
    private Integer id;
    private String nome;
    private String tipo;
    private String descricao;
    private String data;
    private String horario;
    private String local;
    private Double valorIngresso;
    private Integer quantidadeIngressosDisponiveis;
    private Integer quantidadeIngressosVendidos;

    //Construtor de Evento
    public Evento(Integer id, String nome, String tipo, String descricao, String data, String horario, String local, Double valorIngresso, Integer quantidadeIngressosDisponiveis) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.horario = horario;
        this.local = local;
        this.valorIngresso = valorIngresso;
        this.quantidadeIngressosDisponiveis = quantidadeIngressosDisponiveis;
        this.quantidadeIngressosVendidos = 0; // Inicializa com 0
    }
    //Getters de Evento
    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getData() {
        return data;
    }
    public String getHorario() {
        return horario;
    }
    public String getLocal() {
        return local;
    }
    public Double getValorIngressos() {
        return valorIngresso;
    }
    //Métodos para acesso e manipulação da quantidade de ingressos disponíveis e vendidos
    public Integer getQuantidadeIngressosDisponiveis() {
        return quantidadeIngressosDisponiveis;
    }  
    public void setQuantidadeIngressosDisponiveis(int quantidade) {
        this.quantidadeIngressosDisponiveis += quantidade;
    }     
    public Integer getQuantidadeIngressosVendidos() {
        return quantidadeIngressosVendidos;
    }
    public void setQuantidadeIngressosVendidos(int quantidade) {
        this.quantidadeIngressosVendidos += quantidade;
    }
    //Calcular a receita do evento
    public Double receitaEvento(){
        return valorIngresso * quantidadeIngressosVendidos;
    }
    //Imprimir os dados do evento
    //Implementação da interface Imprimivel
    @Override
    public void imprimir(){
        System.out.println("-----Relatório de Evento-----");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horario);
        System.out.println("Local: " + local);
        System.out.println("Valor do ingresso: " + valorIngresso);
        System.out.println("Quantidade de ingressos disponíveis: " + quantidadeIngressosDisponiveis);
        System.out.println("Quantidade de ingressos vendidos: " + quantidadeIngressosVendidos);
        System.out.println("Receita total do evento: " + receitaEvento());
    }

}
