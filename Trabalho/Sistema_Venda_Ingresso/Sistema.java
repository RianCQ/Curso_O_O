package Sistema_Venda_Ingresso;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Sistema implements Imprimivel {
    //Atributos Estáticos do Sistema
    //Agregação de Evento, Cliente e Venda
    private static Map<Integer, Evento> eventos;
    private static Map<Integer, Cliente> clientes;
    private static List<Venda> vendasIngressos;

    //Construtor do Sistema
    public Sistema() {
        Sistema.eventos = new HashMap<>();
        Sistema.clientes = new HashMap<>();
        Sistema.vendasIngressos = new ArrayList<>();
    }
    //Métodos para cadastrar e remover eventos e clientes
    public void cadastrarEvento(Evento evento) {
        eventos.put(evento.getId(),evento);
    }
    public void cancelarEvento(Evento evento) {
        if(eventos.get(evento.getId()) == null) {
            System.out.println("Evento não cadastrado.");
            return;
        }
        eventos.remove(evento.getId());
    }
    public void cadastrarCliente(Cliente cliente) {
        clientes.put(cliente.getId(),cliente);
    }
    public void removerCliente(Cliente cliente) {
        if(clientes.get(cliente.getId()) == null) {
            System.out.println("Cliente não cadastrado.");
            return;
        }
        clientes.remove(cliente.getId());
    }
    //Getters do Sistema
    public Evento getEventos(Integer id) {
        if (eventos.get(id) == null) {
            System.out.println("Evento não cadastrado.");
            return null;
        }
        return eventos.get(id);
    }
    //Sobrecarregar o método getEventos para retornar o ID do evento
    public Integer getEventos(Evento evento) {
        if (eventos.get(evento.getId()) == null) {
            System.out.println("Evento não cadastrado.");
            return null;
        }
        return eventos.get(evento.getId()).getId();
    }
    public Cliente getClientes(Integer id) {
        if (clientes.get(id) == null) {
            System.out.println("Cliente não cadastrado.");
            return null;
        }
        return clientes.get(id);
    }
    //Sobrecarregar o método getClientes para retornar o ID do cliente
    public Integer getClientes(Cliente cliente) {
        if (eventos.get(cliente.getId()) == null) {
            System.out.println("Evento não cadastrado.");
            return null;
        }
        return eventos.get(cliente.getId()).getId();
    }
    public Venda getVendas(Integer id) {
        if (vendasIngressos.get(id) == null) {
            System.out.println("Venda não cadastrada.");
            return null;
        }
        return vendasIngressos.get(id);
    }
    //Sobrecarregar o método getVendasIngressos para retornar o ID da venda
    public Integer getVendas(Venda venda) {
        if (eventos.get(venda.getIdVenda()) == null) {
            System.out.println("Evento não cadastrado.");
            return null;
        }
        return eventos.get(venda.getIdVenda()).getId();
    }
    //Registra a venda de ingressos para um evento
    public Venda comprar(Cliente cliente, String senha, Evento evento, Integer quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade de ingressos inválida.");
            return null;
        }
        if(clientes.getOrDefault(cliente.getId(), null) == null){
            System.out.println("Cliente não cadastrado.");
            return null;
        }
        if(eventos.getOrDefault(evento.getId(), null) == null){
            System.out.println("Evento não cadastrado.");
            return null;
        }
        if(cliente.verificarSenha(senha)){
            if (quantidade <= evento.getQuantidadeIngressosDisponiveis()) {
                evento.setQuantidadeIngressosDisponiveis(-quantidade);
                evento.setQuantidadeIngressosVendidos(quantidade);
                Venda venda = new Venda(cliente, evento, quantidade);
                vendasIngressos.add(venda);
                System.out.println("Compra de " + quantidade + " ingressos para " + evento.getNome() + " realizada com sucesso em nome de " + cliente.getNome() + ".");
                System.out.println("Total a pagar: " + (evento.getValorIngressos() * quantidade));
                return venda;
            } else {
                System.out.println("Quantidade de ingressos indisponível.");
                return null;
            }
        } else{
            System.out.println("Senha incorreta.");
            return null;
        }   
    }
    //Auditar quantos ingressos ainda estão disponíveis para um evento
    public Integer ingressosDisponiveis(Evento evento) {
        if (eventos.get(evento.getId()) == null) {
            System.out.println("Evento não cadastrado.");
            return null;
        }
        if (evento.getQuantidadeIngressosDisponiveis() == 0) {
            System.out.println("Ingressos esgotados.");
            return null;
        }
        return eventos.get(evento.getId()).getQuantidadeIngressosDisponiveis();
    }
    //Calcular a receita de um evento
    public Double calcularReceita(Evento evento) {
        if (eventos.get(evento.getId()) == null) {
            System.out.println("Evento não cadastrado.");
            return null;
        }
        if (evento.getQuantidadeIngressosVendidos() == 0) {
            System.out.println("Nenhum ingresso vendido. Saldo: R$ 0.00.");
            return 0.0;
        }
        return eventos.get(evento.getId()).receitaEvento();
    }
    //Imprime um relatório geral de todos os eventos e clientes cadastrados no sistema
    //Implementação da interface Imprimivel
    @Override
    public void imprimir(){
        System.out.println("--------Relatório Geral de Eventos--------");
        for (Integer id : eventos.keySet()) {
            Evento evento = eventos.get(id);
            evento.imprimir();
        }
        System.out.println("--------Relatório Geral de Clientes--------");
        for (Integer id : clientes.keySet()) {
            Cliente cliente = clientes.get(id);
            cliente.imprimir();
        }
    }
}
