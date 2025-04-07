package Sistema_Venda_Ingresso;

// Utilizando o Sistema de Venda de Ingressos
public class Teste {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Evento eventoA = new Evento(1, "Show de Rock", "Show", "Um show incrível!", "2023-10-01", "20:00", "Estádio", 100.0, 100);  
        Evento eventoB = new Evento(2, "Peça Chapeuzinho Amarela", "Teatro", "Uma peça emocionante!", "2023-10-02", "19:00", "Teatro Municipal", 50.0, 50);
        Cliente clienteOne = new Cliente(4, "Ruan Borges", "197.892.632-97", "(32) 99930-4850", "ruan.borges@hotmail.com", "20243902");
        Cliente clienteTwo = new Cliente(7, "Maria Sakata", "202.450.109-80", "(32) 99870-6510", "sakata.maria@gmail.com", "Gato1234");
        sistema.cadastrarEvento(eventoA);
        sistema.cadastrarEvento(eventoB);
        sistema.cadastrarCliente(clienteOne);
        sistema.cadastrarCliente(clienteTwo);
        sistema.comprar(clienteOne, "20243902", eventoB, 2);
        sistema.comprar(clienteTwo, "Gato1234", eventoA, 3);
        sistema.comprar(clienteTwo, "Gato1234", eventoA, 3);
        sistema.comprar(clienteTwo, "Cao1234", eventoB, 3);
        sistema.getVendas(0).imprimir();
        System.out.println(sistema.calcularReceita(eventoB));
        System.out.println(sistema.getVendas(2).getDataVenda());
    }
}
