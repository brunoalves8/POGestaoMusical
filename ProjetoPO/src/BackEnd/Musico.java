package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class Musico extends Utilizador implements Serializable {
    
    private Collection<Instrumento> instrumentosMusicoToca;

    public Musico(String username, String password, String nome) {
        super(username, password, nome);
        instrumentosMusicoToca = new HashSet<>();
    }

    public Musico(String username, String password, String nome, int bi, String morada, LocalDate dataNasc, Collection<Instrumento> instrumentosMusicoToca) {
        super(username, password, nome, bi, morada, dataNasc);
        this.instrumentosMusicoToca = instrumentosMusicoToca;
    }
    
    public Musico(Collection<Instrumento> instrumentosMusicoToca, String nome, int bi, String morada, LocalDate dataNasc) {
        super(nome, bi, morada, dataNasc);
        this.instrumentosMusicoToca = instrumentosMusicoToca;
    }

    public Collection<Instrumento> getInstrumentosMusicoToca() {
        return instrumentosMusicoToca;
    }

    public void setInstrumentosMusicoToca(Collection<Instrumento> instrumentosMusicoToca) {
        this.instrumentosMusicoToca = instrumentosMusicoToca;
    }
    
    public void adicionarInstrumentos(Instrumento instrumento){
        instrumentosMusicoToca.add(instrumento);
    }
    
    @Override
    public String toString() {
        return "Musico" + super.toString() + "\n" +
               "Instrumentos Musico Toca=" + getInstrumentosMusicoToca();
    }
    
    
}
