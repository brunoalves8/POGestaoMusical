package BackEnd;

import java.io.Serializable;


public class Instrumento implements Serializable{
    
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
}
