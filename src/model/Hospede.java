package model;


public class Hospede extends Pessoa{
    private static int contadorHospedes = 1; // atributo da classe
    private int codHospede;
    private String email;

    // ===============Construtor===============
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
    @Override
    public String toString() {
        return "Nome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nEmail: " + getEmail() +
                "\nCelular: " + getCelular() +
                "\nCód. Hóspede: " + getCodHospede();
    }
}
