package app;

import exception.ReservaException;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- DADOS PRÉ-CADASTRADOS PARA A APRESENTAÇÃO ---
        // Testando sobrecarga de construtores em Endereco
        Endereco endHotel = new Endereco("Av. Afonso Pena", "Centro", "Campo Grande", "79002-070", 1500);
        Endereco endSimples = new Endereco("Dourados");

        Hotel hotel = new Hotel("HTL-01", "Hotel Pantanal Palace", endHotel);
        hotel.adicionarQuarto(new Quarto(101, "Simples", 1, 180.00, true));
        hotel.adicionarQuarto(new Quarto(102, "Duplo", 2, 290.00, true));
        hotel.adicionarQuarto(new Quarto(201, "Suíte Luxo", 4, 520.00, true));
        hotel.adicionarQuarto(new Quarto(202, "Família", 5, 600.00, true));

        hotel.adicionarHospede(new Hospede("Carlos Silva", "1234567", "111.222.333-44", "6799999-1111", "10/05/1995", endHotel, "carlos@email.com"));
        hotel.adicionarHospede(new Hospede("Ana Souza", "7654321", "555.666.777-88", "6798888-2222", "22/08/1998", endSimples,  "ana@email.com"));

        ComprovanteReserva<String> comprovante = new ComprovanteReserva<>("COMP-2026-01", hotel);
        int proximoNumReserva = 1;

        // Deixa 1 reserva inicial pronta (Quarto 101 já começa ocupado)
        try {
            Reserva rInicial = new Reserva(hotel.buscarHospede(1),hotel.buscarQuarto(101), "15/11/2026", 3, 1);
            comprovante.adicionarReserva(rInicial);
        } catch (ReservaException e) {
            System.out.println("Erro ao inicializar reserva: " + e.getMessage());
        }

        // --- MENU INTERATIVO DO GERENTE ---
        int opcao;
        do {
            System.out.println("\n=========================================");
            System.out.println("   SISTEMA DE RESERVAS - " + hotel.getNomeHotel());
            System.out.println("=========================================");
            System.out.println("1 - Listar hóspedes cadastrados");
            System.out.println("2 - Listar quartos disponíveis");
            System.out.println("3 - Consultar quartos ocupados");
            System.out.println("4 - Cadastrar novo hóspede");
            System.out.println("5 - Realizar nova reserva");
            System.out.println("6 - Emitir comprovante geral");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpa buffer

            switch (opcao) {
                case 1:
                    System.out.println("\n--- HÓSPEDES CADASTRADOS ---");
                    hotel.listarHospedes();
                    break;

                case 2:
                    System.out.println("\n--- QUARTOS DISPONÍVEIS ---");
                    hotel.listarQuartosDisponiveis();
                    break;

                case 3:
                    System.out.println("\n--- OCUPAÇÃO ATUAL DOS QUARTOS ---");
                    comprovante.listarQuartosOcupados();
                    break;

                case 4:
                    System.out.println("\n--- CADASTRO DE NOVO HÓSPEDE ---");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("RG: ");
                    String rg = sc.nextLine();
                    System.out.print("CPF (11 dígitos): ");
                    String cpf = sc.nextLine();
                    System.out.print("Celular: ");
                    String celular = sc.nextLine();
                    System.out.print("Data de nascimento: ");
                    String dtNasc = sc.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine();
                    System.out.print("E-mail: ");
                    String email = sc.nextLine();

                    Endereco endNovo = new Endereco(cidade);
                    // Se o CPF for inválido, metodo de solicitar novo entra em ação automaticamente
                    Hospede novoHospede = new Hospede(nome, rg, cpf, celular, dtNasc, endNovo, email);
                    hotel.adicionarHospede(novoHospede);
                    System.out.println("Hóspede cadastrado com sucesso! Código: " + novoHospede.getCodHospede());
                    break;

                case 5:
                    System.out.println("\n--- NOVA RESERVA ---");
                    System.out.println("Hóspedes disponíveis:");

                    hotel.listarHospedes();
                    System.out.print("Digite o código do hóspede: ");
                    int codBusca = sc.nextInt();
                    sc.nextLine();

                    Hospede hospedeEscolhido = hotel.buscarHospede(codBusca);
                    if (hospedeEscolhido == null) {
                        System.out.println("Hóspede não encontrado!");
                        break;
                    }

                    System.out.println("\nQuartos livres no momento:");
                    hotel.listarQuartosDisponiveis();

                    System.out.print("\nDigite o número do quarto desejado: ");
                    int numQuarto = sc.nextInt();
                    sc.nextLine();

                    Quarto quartoEscolhido = hotel.buscarQuarto(numQuarto);
                    if (quartoEscolhido == null) {
                        System.out.println("Quarto inexistente!");
                        break;
                    }

                    System.out.print("Data de check-in (dd/mm/aaaa): ");
                    String checkIn = sc.nextLine();
                    System.out.print("Quantidade de dias: ");
                    int dias = sc.nextInt();
                    System.out.print("Quantidade de hóspedes: ");
                    int qtdPessoas = sc.nextInt();
                    sc.nextLine();

                    try {
                        Reserva novaReserva = new Reserva(hospedeEscolhido, quartoEscolhido, checkIn, dias, qtdPessoas);
                        comprovante.adicionarReserva(novaReserva);
                        proximoNumReserva++;
                        System.out.printf("Reserva #%d confirmada! Valor total: R$ %.2f%n",
                                novaReserva.getNumReserva(), novaReserva.calcularValorTotal());
                    } catch (ReservaException e) {
                        System.out.println("Erro ao realizar reserva: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println();
                    comprovante.imprimirComprovante();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}