package BackEnd;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MapEdicoesAlbum implements Serializable{
    
    private HashMap<Album, EdicaoAlbum> edicoesAlbum;

    public MapEdicoesAlbum() {
        edicoesAlbum = new HashMap<>();
    }

    public void adicionarEdicaoAlbum(EdicaoAlbum edicaoAlbum) {
        edicoesAlbum.put(edicaoAlbum.getAlbum(), edicaoAlbum);
    }
    
    public Collection<Album> listarAlbunsProdutor(Produtor produtor){
        Collection<Album> albuns = new HashSet<>();
            for (EdicaoAlbum a : edicoesAlbum.values()) {
                if (a.getProdutor()== produtor) {
                    albuns.add(a.getAlbum());               
                }  
            }
        return albuns;
    }
    


    @Override
    public String toString() {
        return "MapEdicoesAlbum{" + "edicoesAlbum=" + edicoesAlbum + '}';
    }
    
    
}
