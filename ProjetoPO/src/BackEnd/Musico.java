package BackEnd;

import java.time.LocalDate;

public class Musico extends Utilizador {
    
    private SetInstrumentos instrumentosMusicoToca;
    
    public Musico(){
    }

    public Musico(String username, String password, String nome, int bi, String morada, LocalDate dataNasc, SetInstrumentos instrumentosMusicoToca) {
        super(username, password, nome, bi, morada, dataNasc);
        this.instrumentosMusicoToca = instrumentosMusicoToca;
    }
   

    @Override
    public String toString() {
        return "Musico{" + super.toString() +
               "Instrumentos Musico Toca=" + instrumentosMusicoToca;
    }
    
    
}
