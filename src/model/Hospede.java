package model;

public class Hospede extends Pessoa{
    private int codHospede;
    private String email;

    // ===============Construtor===============
    public Hospede(String nome, String rg, String cpf, String celular, String dtNascimento, Endereco endereco, int codHospede, String email) {
        super(nome, rg, cpf, celular, dtNascimento, endereco);
        this.codHospede = codHospede;
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
