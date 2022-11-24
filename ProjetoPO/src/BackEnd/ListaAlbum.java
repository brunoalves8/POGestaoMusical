package BackEnd;

import java.util.Collection;
import java.util.TreeSet;


public class ListaAlbum {
    
    private Collection<Album> albuns = new TreeSet<>();

    public ListaAlbum() {
    }
    
    public void adicionarAlbum(Album album){
        albuns.add(album);
    }
    
    public void removerAlbum(int cod){
        for(Album albm: albuns){
            if(albm.getCodigo()==cod){
                albuns.remove(albm);
            }
        }
    }
}
