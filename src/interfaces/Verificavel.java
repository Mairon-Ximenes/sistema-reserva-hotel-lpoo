package interfaces;

/**
 * Interface que define o contrato para qualquer classe que precise
 * validar um código/documento (ex.: CPF) e pedir um novo valor
 * quando o informado for inválido.
 */

public interface Verificavel {
    boolean validar(String codigo); // Verfica se o CPF é valido
    void solicitarNovo(); // Solicita um novo CPF caso o informado não seja válido
}
