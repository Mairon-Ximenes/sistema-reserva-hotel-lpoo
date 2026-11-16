package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o hotel. É a classe que gerencia os quartos e os hóspedes
 * cadastrados (relação de composição/agregação com Quarto e Hospede).
 */

public class Hotel {
    private String codHotel;
    private String nomeHotel;
    private Endereco endereco;
    // hotel gerencia os quartos e hospedes
    private List<Quarto> quartos = new ArrayList<>();
    private List<Hospede> hospedes = new ArrayList<>();

    // ===============Construtor===============

    /**
     * Cria um hotel. As listas de quartos e hóspedes começam vazias
     * e são preenchidas depois com adicionarQuarto() e adicionarHospede().
     */

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
    // Adiciona um novo quarto à lista de quartos do hotel.
    public void adicionarQuarto(Quarto novoQuarto) {
        quartos.add(novoQuarto);
    }

    /**
     * Procura um quarto pelo número.
     *
     * para numQuarto número do quarto desejado
     * retorna o Quarto encontrado ou null se não existir
     */

    public Quarto buscarQuarto(int numQuarto) {
        for (Quarto q : quartos) {
            if (q.getNumQuarto() == numQuarto) {
                return q;
            }
        }
        return null; // percorreu tudo e não achou o quarto desejado.
    }

    /**
     * Imprime no console apenas os quartos que estão disponíveis.
     * Se nenhum estiver livre, exibe uma mensagem informando isso.
     */

    public void listarQuartosDisponiveis() {
        boolean achou = false; // verifica se pelo menos um quarto livre foi encontrado.
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
    // Cadastra um novo hóspede na lista do hotel.
    public void adicionarHospede(Hospede novoHospede) {
        hospedes.add(novoHospede);
    }

    /**
     * Procura um hóspede pelo código.
     *
     * o codHospede é um código gerado automaticamente no cadastro
     * retorna o Hospede encontrado ou null se não existir
     */

    public Hospede buscarHospede(int codHospede) {
        for (Hospede h : hospedes) {
            if (h.getCodHospede() == codHospede) {
                return h;
            }
        }
        return null; // Percorreu tudo e não achou o hóspede desejado.
    }

    /**
     * Imprime no console todos os hóspedes cadastrados
     * (usa o toString() de Hospede). Avisa se a lista estiver vazia.
     */

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
