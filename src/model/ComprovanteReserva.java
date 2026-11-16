package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComprovanteReserva<T> {
    private T numComprovante;
    private Hotel hotel;
    private List<Reserva> listaReservas = new ArrayList<>();
    private double valorTotal;

    public ComprovanteReserva(T numComprovante, Hotel hotel) {
        this.numComprovante = numComprovante;
        this.hotel = hotel;
        this.valorTotal = 0.0;
    }

    public void adicionarReserva (Reserva r) {
        listaReservas.add(r);
        this.valorTotal += r.calcularValorTotal();
    }

    public void imprimirComprovante() {
        Collections.sort(listaReservas);

        System.out.println("=================================================");
        System.out.println("        COMPROVANTE DE RESERVA");
        System.out.println("=================================================");
        System.out.println("Nº Comprovante: " + numComprovante);


        if (hotel != null) {
            System.out.println("Hotel: " + hotel.getNomeHotel());
            System.out.println("Endereço: " + hotel.getEndereco());
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Reservas (ordenadas por nome do hóspede):");
        System.out.println("-------------------------------------------------");

        for (Reserva r : listaReservas) {
            System.out.printf(
                    "Reserva #%d | Hóspede: %s | Quarto: %d | Check-in: %s | Dias: %d | Hóspedes: %d | Valor: R$ %.2f%n",
                    r.getNumReserva(),
                    r.getHospede().getNome(),
                    r.getQuarto().getNumQuarto(),
                    r.getDataCheckIn(),
                    r.getQntdDias(),
                    r.getQntdHospedes(),
                    r.calcularValorTotal()
            );
        }

        System.out.println("-------------------------------------------------");
        System.out.printf("VALOR TOTAL: R$ %.2f%n", valorTotal);
        System.out.println("=================================================");
    }

    public T getNumComprovante() {
        return numComprovante;
    }

    public void setNumComprovante(T numComprovante) {
        this.numComprovante = numComprovante;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

}



