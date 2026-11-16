package model;

/**
 * Representa um hóspede do hotel.
 * Herda os dados pessoais (nome, rg, cpf, etc.) da classe Pessoa
 * e acrescenta um código único e um e-mail.
 */

public class Hospede extends Pessoa{
    // Atributo da classe (static): compartilhado por todos os hóspedes,
    // usado para gerar códigos sequenciais automaticamente.
    private static int contadorHospedes = 1; // atributo da classe
    private int codHospede;
    private String email;

    // ===============Construtor===============

    /**
     * Cria um hóspede. Os dados pessoais são repassados ao construtor de Pessoa
     * (que valida o CPF) e o código é gerado automaticamente.
     */

    public Hospede(String nome, String rg, String cpf, String celular, String dtNascimento, Endereco endereco, String email) {
        super(nome, rg, cpf, celular, dtNascimento, endereco);
        this.codHospede = contadorHospedes++; // gera 1, 2, 3... sozinho
        this.email = email;
    }

    // ===============Getters e Setters===============
    public int getCodHospede() {
        return codHospede;
    }

    public void setCodHospede(int codHospede) {
        this.codHospede = codHospede;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ===============toString()===============

    /**
     * Retorna os principais dados do hóspede em formato de texto,
     * usado ao listar os hóspedes cadastrados.
     */

    @Override
    public String toString() {
        return "Nome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nEmail: " + getEmail() +
                "\nCelular: " + getCelular() +
                "\nCód. Hóspede: " + getCodHospede();
    }
}
