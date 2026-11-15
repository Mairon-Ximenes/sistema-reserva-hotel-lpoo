package model;

import interfaces.Verificavel;

import java.util.Scanner;

public abstract class Pessoa implements Verificavel {
    private String nome, rg, cpf, celular, dtNascimento;
    private Endereco endereco;


    // ===============Construtor===============
    public Pessoa(String nome, String rg, String cpf, String celular, String dtNascimento, Endereco endereco) {
        this.nome = nome;
        this.rg = rg;
        setCpf(cpf);
        this.celular = celular;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
    }

    // ===============Getters e setters===============
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (validar(cpf)) this.cpf = cpf;
        else solicitarNovo();
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // ===============Métodos===============

    @Override
    public boolean validar(String codigo) {
        codigo = codigo.replace(".", "").replace("-", "");
        return codigo.matches("\\d{11}");
    }

    @Override
    public void solicitarNovo() {
        Scanner sc = new Scanner(System.in);
        String cpf_novo = "";
        do {
            System.out.print("\nCPF inválido. Por favor, digite um CPF válido: ");
            cpf_novo = sc.nextLine();
        } while (!validar(cpf_novo));
        this.cpf = cpf_novo;
    }
}
