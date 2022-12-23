package BackEnd;

import java.util.HashMap;

public class MapEdicoesAlbum {
    
    private HashMap<Album, EdicaoAlbum> edicoesAlbum;

    public MapEdicoesAlbum() {
        edicoesAlbum = new HashMap<>();
    }

    public void adicionarEdicaoAlbum(EdicaoAlbum edicaoAlbum) {
        edicoesAlbum.put(edicaoAlbum.getAlbum(), edicaoAlbum);
    }
    
    
}
