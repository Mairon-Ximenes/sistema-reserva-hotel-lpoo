package model;

/**
 * Representa um endereço, usado tanto pelo hotel quanto pelos hóspedes.
 * Possui dois construtores (sobrecarga): um completo e outro simplificado,
 * que recebe apenas a cidade.
 */

public class Endereco {
    private String rua, bairro, cidade, cep;
    private int num;

    /**
     * Construtor completo: usado quando todos os dados do endereço são conhecidos.
     */

    public Endereco(String rua, String bairro, String cidade, String cep, int num) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.num = num;
    }

    /**
     * Construtor simplificado: usado quando só a cidade é informada
     * (ex.: cadastro rápido de hóspede). Os demais campos ficam nulos/zero.
     */

    public Endereco(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Retorna o endereço como texto.
     * Se a rua for nula (endereço criado só com a cidade), devolve apenas a cidade;
     * caso contrário, devolve o endereço completo formatado.
     */

    @Override
    public String toString() {
        if (rua == null) {
            return cidade;
        }
        return rua + ", " + num + " - " + bairro + ", " + cidade + " (CEP: " + cep + ")";
    }
}
