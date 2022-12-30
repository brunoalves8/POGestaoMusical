package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class MapUtilizadores implements Serializable{

    private HashMap<String, Utilizador> utilizadores;

    public MapUtilizadores() {
        utilizadores = new HashMap<>();
    }

    public void adicionarUtilizador(Utilizador User) {
        utilizadores.put(User.getUsername(), User);

    }
    
    public void atualizarUtilizador(Utilizador User) {
        utilizadores.replace(User.getUsername(), User);

    }
    
  
    
    public void removerProdutorOuMusico(String username) {
                utilizadores.remove(username);

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

    public Utilizador consultarDadosUser(String Username, String Password) {
        for (Utilizador u : utilizadores.values()) {
            if (u.getUsername().compareTo(Username) == 0 && u.getPassword().compareTo(Password) == 0) {
                return u;
            }
        }
        return null; 
    }

    public void editarDadosMusico(int codigo, Musico musico) {

        for (Utilizador u : utilizadores.values()) {
            if (u instanceof Musico && u.getBi() == codigo) {
                ((Musico) u).setBi(musico.getBi());
                ((Musico) u).setNome(musico.getNome());
                ((Musico) u).setMorada(musico.getMorada());
                ((Musico) u).setDataNasc(musico.getDataNasc());

            }
        }
    }
    
    public void removerProdutor(String username, Produtor produtor) {
        for (Utilizador u : utilizadores.values()) {
            if (u instanceof Produtor && u.getUsername().equals(username)) {
                utilizadores.remove(u.getUsername(), produtor);
            }
        }

    }

    public void editarDadosProdutor(Produtor produtor) {

        for (Utilizador u : utilizadores.values()) {
            if (u instanceof Produtor) {
                ((Produtor) u).setNome(produtor.getNome());
                ((Produtor) u).setBi(produtor.getBi());
                ((Produtor) u).setMorada(produtor.getMorada());
                ((Produtor) u).setDataNasc(produtor.getDataNasc());
            }
        }
    }

    public boolean verificarExisteUser(String username, String password) {

        for (Utilizador u : utilizadores.values()) {
            if (u.getUsername().compareTo(username) == 0 && u.getPassword().compareTo(password) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarExisteProdutor(String username) {

        for (Utilizador u : utilizadores.values()) {
            if (u.getUsername().compareTo(username) == 0 && u instanceof Produtor) {
                return true;
            }
        }
        return false;
    }
    
    public boolean verificarExisteMusico(String username) {

        for (Utilizador u : utilizadores.values()) {
            if (u.getUsername().compareTo(username) == 0 && u instanceof Musico) {
                return true;
            }
        }
        return false;
    }
    public boolean verificarExisteUtilizador(String Username) {

        for (Utilizador u : utilizadores.values()) {
            if (u.getUsername().compareTo(Username) == 0) {
                return true;
            }
        }
        return false;
    }
    
    public Musico procurarMusicosPorNome(String nome) {

        for (Utilizador u : utilizadores.values()) {
            if ((u instanceof Musico) && ((Musico)u).getNome().equals(nome)) {
                return ((Musico)u);
            }
        }
        return null;
    }
    


    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(utilizadores);

        oos.close();
        fos.close();
    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        utilizadores = (HashMap<String, Utilizador>) oin.readObject();
        oin.close();
        file.close();
    }

    //Fonte: ficheiro do professor
    @Override
    public String toString() {
        String texto = "";
        for (Utilizador u : utilizadores.values()) {
            texto += u + "\n";
        }
        return texto;
    }

}
