package Sistema_Venda_Ingresso;

public class Cliente implements Imprimivel {
    //Atributos privados de Cliente
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;

    //Construtor de Cliente
    public Cliente(Integer id, String nome, String cpf, String telefone, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
    //Getters de Cliente
    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    //Autentificador de senha, utilizado na verificação se a senha informada é igual à registrada para o cliente
    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }
    //Imprimir os dados da conta do cliente
    //Implementação da interface Imprimivel
    @Override
    public void imprimir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }
}
