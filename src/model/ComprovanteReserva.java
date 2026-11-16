package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Comprovante que reúne as reservas de um hotel e calcula o valor total.
 * É uma classe genérica: o tipo T do número do comprovante é definido
 * na hora de criar o objeto (ex.: String, Integer).
 * */

public class ComprovanteReserva<T> {
    private T numComprovante;
    private Hotel hotel;
    private final List<Reserva> listaReservas = new ArrayList<>();
    private double valorTotal;

    /**
     * Cria um comprovante vazio, com valor total zerado.
     */

    public ComprovanteReserva(T numComprovante, Hotel hotel) {
        this.numComprovante = numComprovante;
        this.hotel = hotel;
        this.valorTotal = 0.0;
    }

    /**
     * Adiciona uma reserva ao comprovante e soma o valor dela ao total.
     */

    public void adicionarReserva (Reserva r) {
        listaReservas.add(r);
        this.valorTotal += r.calcularValorTotal();
    }

    /**
     * Imprime o comprovante no console: dados do hotel, cada reserva
     * (ordenadas pelo nome do hóspede) e o valor total.
     */

    public void imprimirComprovante() {
        Collections.sort(listaReservas); // ordena usando o compareTo() de Reserva (ordem alfabética do nome do hóspede)

        System.out.println("=================================================");
        System.out.println("        COMPROVANTE DE RESERVA");
        System.out.println("=================================================");
        System.out.println("Nº Comprovante: " + numComprovante);

        System.out.println("-------------------------------------------------");
        System.out.println("Reservas:");
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

    // ===============Métodos===============

    /**
     * Lista no console os quartos ocupados, ou seja, os quartos das
     * reservas registradas, mostrando quem os ocupa e por quantos dias.
     */
    public void listarQuartosOcupados() {
        if (listaReservas.isEmpty()) {
            System.out.println("Nenhum quarto ocupado no momento.");
            return;
        }
        for (Reserva r : listaReservas) {
            System.out.printf("Quarto %d (%s) -> Ocupado por: %s (Check-in: %s | %d dia(s))%n",
                    r.getQuarto().getNumQuarto(),
                    r.getQuarto().getTipo(),
                    r.getHospede().getNome(),
                    r.getDataCheckIn(),
                    r.getQntdDias());
        }
    }
}



