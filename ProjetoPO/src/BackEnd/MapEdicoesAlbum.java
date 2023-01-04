package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MapEdicoesAlbum implements Serializable {

    private HashMap<Album, EdicaoAlbum> edicoesAlbum;

    public MapEdicoesAlbum() {
        edicoesAlbum = new HashMap<>();
    }

    public void adicionarEdicaoAlbum(EdicaoAlbum edicaoAlbum) {
        edicoesAlbum.put(edicaoAlbum.getAlbum(), edicaoAlbum);
    }

    public Collection<Album> listarAlbunsProdutor(Produtor produtor) {
        Collection<Album> albuns = new HashSet<>();
        for (EdicaoAlbum a : edicoesAlbum.values()) {
            if (a.getProdutor().equals(produtor)) {
                albuns.add(a.getAlbum());
                System.out.println(a.toString());
            }
        }
        return albuns;
    }

    public EdicaoAlbum procurarEdicaoAlbumPorAlbum(Album album) {
        return edicoesAlbum.get(album);

    }


    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(edicoesAlbum);

        oos.close();
        fos.close();

    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        edicoesAlbum = (HashMap<Album, EdicaoAlbum>) oin.readObject();
        oin.close();
        file.close();
    }

    @Override
    public String toString() {
        return "MapEdicoesAlbum{" + "edicoesAlbum=" + edicoesAlbum + '}';
    }

}
