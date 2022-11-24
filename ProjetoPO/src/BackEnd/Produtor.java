package BackEnd;

import java.util.ArrayList;


public class Produtor extends Utilizador{

    private ArrayList<Album> albunsParticipou = new ArrayList<>();
    
    public Produtor() {
    }

    public Produtor(String nome, int bi, String morada, int dataNasc) {
        super(nome, bi, morada, dataNasc);
    }
    
    
    
}
