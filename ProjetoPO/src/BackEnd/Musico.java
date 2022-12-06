package BackEnd;

import java.util.ArrayList;

public class Musico extends Utilizador {
    
    private ArrayList<Instrumento> instrumentosMusicoToca = new ArrayList<>();
    
    public Musico() {
    }

    public Musico(String username, String password, String nome, int bi, String morada, int dataNasc) {
        super(username, password, nome, bi, morada, dataNasc);
    }


    
    public void adicionarInstrumento(Instrumento instrumento){
        instrumentosMusicoToca.add(instrumento);
    }

    @Override
    public String toString() {
        return "Musico{" + super.toString() +
               "Instrumentos Musico Toca=" + instrumentosMusicoToca;
    }
    
    
}
