package model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String codHotel;
    private String nomeHotel;
    private Endereco endereco;
    // hotel gerencia os quartos e hospedes
    private List<Quarto> quartos = new ArrayList<>();
    private List<Hospede> hospedes = new ArrayList<>();

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

    // =============== Métodos de Quarto ===============
    public void adicionarQuarto(Quarto novoQuarto) {
        quartos.add(novoQuarto);
    }

    public Quarto buscarQuarto(int numQuarto) {
        for (Quarto q : quartos) {
            if (q.getNumQuarto() == numQuarto) {
                return q;
            }
        }
        return null;
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

    // =============== Métodos de Hóspede ===============
    public void adicionarHospede(Hospede novoHospede) {
        hospedes.add(novoHospede);
    }

    public Hospede buscarHospede(int codHospede) {
        for (Hospede h : hospedes) {
            if (h.getCodHospede() == codHospede) {
                return h;
            }
        }
        return null;
    }

    public void listarHospedes() {
        if (hospedes.isEmpty()) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }
        for (Hospede h : hospedes) {
            System.out.println(h);
            System.out.println("-----------------------------");
        }
    }
}
