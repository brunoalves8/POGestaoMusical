package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

public class Musico extends Utilizador implements Serializable {
    
    private Collection<Instrumento> instrumentosMusicoToca;

    public Musico(String username, String password) {
        super(username, password);
    }
    

    public Musico(String username, String password, String nome, int bi, String morada, LocalDate dataNasc, Collection<Instrumento> instrumentosMusicoToca) {
        super(username, password, nome, bi, morada, dataNasc);
        this.instrumentosMusicoToca = instrumentosMusicoToca;
    }
   

    @Override
    public String toString() {
        return "Musico{" + super.toString() +
               "Instrumentos Musico Toca=" + instrumentosMusicoToca;
    }
    
    
}
