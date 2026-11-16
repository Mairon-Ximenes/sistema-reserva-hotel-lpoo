package model;

import exception.ReservaException;

public class Reserva implements Comparable<Reserva>{
    private int numReserva;
    private Hospede hospede;
    private Quarto quarto;
    private String dataCheckIn;
    private int qntdDias;
    private int qntdHospedes;

    // ===============Construtor===============
    public Reserva(int numReserva, Hospede hospede, Quarto quarto,
                   String dataCheckIn, int qntdDias, int qntdHospedes) throws ReservaException {

        if (!quarto.isDisponivel()) { // Se o quarto solicitado não estiver disponível
            throw new ReservaException("O quarto " + quarto.getNumQuarto() + " não está disponível");
        }

        if (qntdHospedes > quarto.getCapacidade()) { // Se a capacidade do quarto estiver maior do que ele suporta
            throw new ReservaException("A quantidade de hóspedes (" + qntdHospedes + ") superou a capacidade do quarto (" +
                    quarto.getCapacidade() + ")");
        }

        if (qntdDias <= 0) { // Se o quantidade de dias de hospadagem for negativo ou igual a zero
            throw new ReservaException("A quantidade de dias deve ser maior que zero");
        }

        this.numReserva = numReserva;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.qntdDias = qntdDias;
        this.qntdHospedes = qntdHospedes;

        quarto.setDisponivel(false);
    }


    public double calcularValorTotal() { //Custo da hospedagem
        return qntdDias * quarto.getValorDiaria();
    }

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
