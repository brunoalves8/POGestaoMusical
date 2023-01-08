package BackEnd;

import java.io.Serializable;

public class Instrumento implements Serializable {

    private String nome;

    public Instrumento() {
    }

    public Instrumento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome Instrumento: " + nome;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Instrumento) {
            Instrumento outro = (Instrumento) o;
            return outro.getNome().equals(getNome());
        }
        return false;
    }
}
