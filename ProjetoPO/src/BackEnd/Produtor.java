package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;


public class Produtor extends Utilizador implements Serializable{

    public Produtor(String username, String password) {
        super(username, password);
    }
    
    public Produtor(String username, String password, String nome, int bi, String morada, LocalDate dataNasc) {
        super(username, password, nome, bi, morada, dataNasc);
    }
    
    public Produtor(String nome, int bi, String morada, LocalDate dataNasc) {
        super(nome, bi, morada, dataNasc);
    }

    
    
    
}
