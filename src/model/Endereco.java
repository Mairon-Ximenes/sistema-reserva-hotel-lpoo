package model;

public class Endereco {
    private String rua, bairro, cidade, cep;
    private int num;

    public Endereco(String rua, String bairro, String cidade, String cep, int num) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.num = num;
    }

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

    @Override
    public String toString() {
        if (rua == null) {
            return cidade;
        }
        return rua + ", " + num + " - " + bairro + ", " + cidade + " (CEP: " + cep + ")";
    }
}
