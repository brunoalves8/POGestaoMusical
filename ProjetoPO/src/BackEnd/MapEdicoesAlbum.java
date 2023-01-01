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
                if (a.getProdutor() == produtor) {
                    albuns.add(a.getAlbum());
                    System.out.println(a.toString());
                }  
            }
        return albuns;
    }
    
    public EdicaoAlbum procurarEdicaoAlbumPorAlbum(Album album) {
            return edicoesAlbum.get(album);       

    }

    @Override
    public String toString() {
        return "MapEdicoesAlbum{" + "edicoesAlbum=" + edicoesAlbum + '}';
    }
    
    
}
