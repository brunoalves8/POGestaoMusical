package BackEnd;

import java.io.Serializable;
import java.util.HashMap;

public class MapEdicoesAlbum implements Serializable{
    
    private HashMap<Album, EdicaoAlbum> edicoesAlbum;

    public MapEdicoesAlbum() {
        edicoesAlbum = new HashMap<>();
    }

    public void adicionarEdicaoAlbum(EdicaoAlbum edicaoAlbum) {
        edicoesAlbum.put(edicaoAlbum.getAlbum(), edicaoAlbum);
    }
    
    public HashMap<Album, EdicaoAlbum> listarAlbunsProdutor(Produtor produtor){
        HashMap<Album, EdicaoAlbum> albuns = new HashMap<>();
        for (EdicaoAlbum a : albuns.values()) {
            if (a.getProdutor()== produtor) {
               
                System.out.println(albuns.toString());
            }
        }
        return albuns;
    }

}
