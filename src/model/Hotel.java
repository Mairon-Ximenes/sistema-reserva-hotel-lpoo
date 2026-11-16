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

    public void adicionarQuarto (Quarto novoQuarto) {
        quartos.add(novoQuarto);
    }
}
