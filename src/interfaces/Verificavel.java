package interfaces;

import java.util.Scanner;

public interface Verificavel {
    boolean validar(String codigo);
    void solicitarNovo();

    void solicitarNovo(Scanner sc);
}
