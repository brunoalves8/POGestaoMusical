package BackEnd;

import java.util.*;

public class MapUtilizadores {

    private final HashMap<String,Utilizador> utilizadores;

    public MapUtilizadores() {
        utilizadores = new HashMap<>();
    }
    

    public void adicionarUtilizador(Utilizador User) {
        utilizadores.put(User.getUsername(), User);

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
        System.out.println("Não existe nenhum utilizador com esse código!");
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
    
    public boolean verificarExisteAdministrador(String Username, String Password){
        
        for(Utilizador u: utilizadores.values()){
            if(u.getUsername().compareTo(Username) == 0)
                return true;      
        }
        return false;
    }
    
    public boolean verificarExisteProdutor(String username, String password){
        
        for(Utilizador u: utilizadores.values()){
            if(u.getUsername().compareTo(username) == 0 && u.getPassword().compareTo(password) == 0)
                return true;      
        }
        return false;
    }
    
    public boolean verificarExisteUtilizador(String Username){
        
        for(Utilizador u: utilizadores.values()){
            if(u.getUsername().compareTo(Username) == 0)
                return true;      
        }
        return false;
    }

    //Fonte: ficheiro do professor
    @Override
    public String toString() {
        String texto="";
        for(Utilizador u: utilizadores.values()){
            texto += u+"\n";
        }
        return texto;
    }
    
    

}
