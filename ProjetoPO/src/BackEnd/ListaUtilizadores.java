package BackEnd;

import java.util.*;

public class ListaUtilizadores {

    private HashMap<String,Utilizador> utilizadores;

    public ListaUtilizadores() {
        utilizadores = new HashMap<>();
    }

    public void adicionarMusico(Musico Musico) {
        utilizadores.put(Musico.getUsername(), Musico);

    }

    public void removerMusico(int cod) {
        for (Utilizador u : utilizadores.values()) {
            if (u instanceof Musico && u.getBi() == cod) {
                utilizadores.remove(u.getUsername());
            }
        }

    }

    public Utilizador consultarDadosUtilizador(int codigo) {
        for (Utilizador u : utilizadores.values()) {
            if (u.getBi() == codigo) {
                return u;
            }
        }
        System.out.println("Não existe nenhum musico com esse código!");
        return null;
    }

    public void editarDadosMusico(int codigo, Musico musico) {
        
        for (Utilizador u : utilizadores.values()) {
            if (u instanceof Musico && u.getBi() == codigo) {
                ((Musico)u).setBi(musico.getBi());
                ((Musico)u).setNome(musico.getNome());
                ((Musico)u).setMorada(musico.getMorada());
                ((Musico)u).setDataNasc(musico.getDataNasc());

            }
        }
    }
    
    public void adicionarProdutor(Produtor produtor) {
        utilizadores.put(produtor.getUsername(), produtor);

    }
    
    public void removerProdutor(int cod) {
        for (Utilizador u : utilizadores.values()) {
            if (u instanceof Produtor && u.getBi() == cod) {
                utilizadores.remove(u.getUsername());
            }
        }

    }
    
    public void editarDadosProdutor(int codigo, Produtor prod) {
        
        for (Utilizador u : utilizadores.values()) {
            if (u instanceof Produtor && u.getBi() == codigo) {
                ((Produtor)u).setBi(prod.getBi());
                ((Produtor)u).setNome(prod.getNome());
                ((Produtor)u).setMorada(prod.getMorada());
                ((Produtor)u).setDataNasc(prod.getDataNasc());

            }
        }
    }
    
    

}
