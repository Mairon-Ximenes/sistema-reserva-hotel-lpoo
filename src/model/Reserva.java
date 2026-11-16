package model;

import exception.ReservaException;

/**
 * Representa a reserva de um quarto por um hóspede.
 * Implementa Comparable para que as reservas possam ser ordenadas
 * pelo nome do hóspede (usado em Collections.sort no comprovante).
 */

public class Reserva implements Comparable<Reserva>{
    // Atributo da classe (static): contador compartilhado que gera o número das reservas
    private static int contadorReservas = 1; // atributo da classe
    private int numReserva;
    private Hospede hospede;
    private Quarto quarto;
    private String dataCheckIn;
    private int qntdDias;
    private int qntdHospedes;

    // ===============Construtor===============
/**
 * Cria uma reserva, validando as regras de negócio antes.
 * Se alguma regra for violada, lança ReservaException e a reserva NÃO é criada.
 * Se tudo estiver certo, o quarto é marcado como indisponível.
 **/

    public Reserva(Hospede hospede, Quarto quarto,
                   String dataCheckIn, int qntdDias, int qntdHospedes) throws ReservaException {

        if (!quarto.isDisponivel()) { // Se o quarto solicitado não estiver disponível
            throw new ReservaException("O quarto " + quarto.getNumQuarto() + " não está disponível");
        }

        if (qntdHospedes > quarto.getCapacidade()) { // Se a capacidade do quarto estiver maior do que ele suporta
            throw new ReservaException("A quantidade de hóspedes (" + qntdHospedes + ") superou a capacidade do quarto (" +
                    quarto.getCapacidade() + ")");
        }

        if (qntdDias <= 0) { // Se a quantidade de dias de hospadagem for negativo ou igual a zero
            throw new ReservaException("A quantidade de dias deve ser maior que zero");
        }

        this.numReserva = contadorReservas++;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.qntdDias = qntdDias;
        this.qntdHospedes = qntdHospedes;

        quarto.setDisponivel(false); // Quarto fica ocupado.
    }

    // Calculo valor da hospedagem.
    public double calcularValorTotal() { //Custo da hospedagem
        return qntdDias * quarto.getValorDiaria();
    }

    // Organiza o nome dos hóspedes em ordem alfabética, ignorando diferença entre maiúsculas e minúsculas.
    @Override
    public int compareTo (Reserva outro) { // Ordenar o nome dos hospedes em ordem alfabética
        return this.hospede.getNome().compareToIgnoreCase(outro.getHospede().getNome());
    }

    // ===============Getters e Setters===============
    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(String dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public int getQntdDias() {
        return qntdDias;
    }

    public void setQntdDias(int qntdDias) {
        this.qntdDias = qntdDias;
    }

    public int getQntdHospedes() {
        return qntdHospedes;
    }

    public void setQntdHospedes(int qntdHospedes) {
        this.qntdHospedes = qntdHospedes;
    }
}
