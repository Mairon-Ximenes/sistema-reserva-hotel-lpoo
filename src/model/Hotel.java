package model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String codHotel;
    private String nomeHotel;
    private Endereco endereco;
    private List<Quarto> quartos = new ArrayList<>();

    // ===============Construtor===============
    public Hotel(String codHotel, String nomeHotel, Endereco endereco) {
        this.codHotel = codHotel;
        this.nomeHotel = nomeHotel;
        this.endereco = endereco;
    }

    // ===============Getters e Setters===============
    public String getCodHotel() {
        return codHotel;
    }

    public void setCodHotel(String codHotel) {
        this.codHotel = codHotel;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    // ===============Métodos===============
    public void adicionarQuarto (Quarto novoQuarto) {
        quartos.add(novoQuarto);
    }

    public void listarQuartosDisponiveis() {
        boolean achou = false;
        for (Quarto q : quartos) {
            if (q.isDisponivel()) {
                System.out.printf("Quarto %d | Tipo: %s | Capacidade: %d pessoa(s) | Diária: R$ %.2f%n",
                        q.getNumQuarto(), q.getTipo(), q.getCapacidade(), q.getValorDiaria());
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum quarto disponível no momento.");
        }
    }

    public Quarto buscarQuarto(int numQuarto) {
        for (Quarto q : quartos) {
            if (q.getNumQuarto() == numQuarto) {
                return q;
            }
        }
        return null;
    }
}
