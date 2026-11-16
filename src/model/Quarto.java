package model;

/**
 * Representa um quarto do hotel, com tipo, capacidade, valor da diária
 * e situação (disponível ou ocupado).
 */

public class Quarto {
    private int numQuarto;
    private String tipo;
    private int capacidade;
    private double valorDiaria;
    private boolean disponivel;

    /**
     * Cria um quarto.
     * Obs.: o parâmetro "disponivel" é recebido, mas o quarto sempre começa
     * como disponível (this.disponivel = true), independentemente do valor passado.
     */

    // ===============Construtor===============
    public Quarto(int numQuarto, String tipo, int capacidade, double valorDiaria, boolean disponivel) {
        this.numQuarto = numQuarto;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.valorDiaria = valorDiaria;
        this.disponivel = true; // Todo quarto começa livre.
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

    // Retorna true se o quarto estiver livre para reserva.
    public boolean isDisponivel() {
        return disponivel;
    }
    // Altera a situação do quarto (a classe Reserva usa para marcá-lo como ocupado).
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
