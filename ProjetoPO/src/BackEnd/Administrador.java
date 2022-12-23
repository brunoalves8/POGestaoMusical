package BackEnd;

import java.time.LocalDate;



public class Administrador extends Utilizador {

    public Administrador(String username, String password) {
        super(username, password);
    }

    public Administrador(String username, String password, String nome, int bi, String morada, LocalDate dataNasc) {
        super(username, password, nome, bi, morada, dataNasc);
    }

    

    
}
