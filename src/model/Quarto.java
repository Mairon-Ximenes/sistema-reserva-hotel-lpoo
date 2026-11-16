package model;

public class Quarto {
    private int numQuarto;
    private String tipo;
    private int capacidade;
    private double valorDiaria;
    private boolean disponivel;

    // ===============Construtor===============
    public Quarto(int numQuarto, String tipo, int capacidade, double valorDiaria, boolean disponivel) {
        this.numQuarto = numQuarto;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    // ===============Getters e Setters===============
    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
