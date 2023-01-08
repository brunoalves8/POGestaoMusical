package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;

public class Produtor extends Utilizador implements Serializable {

    public Produtor(String username, String password, String nome, int bi, String morada, LocalDate dataNasc) {
        super(username, password, nome, bi, morada, dataNasc);
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Produtor) {
            Produtor outro = (Produtor) o;
            return outro.getUsername().equals(getUsername());
        }
        return false;
    }

}
