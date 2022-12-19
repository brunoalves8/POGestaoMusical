package BackEnd;

import java.util.HashMap;

public class MapAlbum {
    private final HashMap<String, Album> repositorio;

    public MapAlbum() {
        repositorio = new HashMap<>();
    }
    
    public void adicionarAlbum(Album album){
        repositorio.put(album.getCodigoS(), album);
    }
    
    public void removerAlbum(String cod){
        for(Album albm: repositorio.values()){
            if(albm.getCodigoS().equals(cod)){
                repositorio.remove(albm);
            }
        }
    }
}
    