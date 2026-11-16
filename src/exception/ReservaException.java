package exception;

/**
 * Exceção personalizada (checked) lançada quando uma reserva não pode
 * ser realizada, por exemplo: quarto indisponível, capacidade excedida
 * ou quantidade de dias inválida.
**/

public class ReservaException extends Exception{
    public ReservaException(String mensagem) {
        super(mensagem); // Lança a mensagem personalizada.
    }
}
