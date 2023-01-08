package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class RepositorioAlbuns implements Serializable {

    private Collection<Album> albuns = new HashSet<>();

    public RepositorioAlbuns() {
        albuns = new HashSet<>();
    }

    public void adicionarAlbum(Album album) {
        albuns.add(album);
    }

    public Album consultarDadosAlbum(int codigo) {
        for (Album albm : albuns) {
            if (albm.getCodigo() == codigo) {
                System.out.println(albm.toString());
                return albm;

            }
        }
        return null;
    }

    public boolean verificarAlbumPorCod(int codigo) {

        for (Album a : albuns) {
            if (a.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public Album procurarAlbumPorCod(int codigo) {

        for (Album a : albuns) {
            if (a.getCodigo() == codigo) {
                return a;
            }
        }
        return null;
    }


    public Collection<Album> listarAlbunsMusico(Musico musico) {
        Collection<Album> albunsMusico = new HashSet<>();
        for (Album a : albuns) {
            for (Musica m : a.getMusicasDoAlbum()) {
                for (Musico mu : m.getMusicos()) {
                    if (mu.equals(musico)) {
                        albunsMusico.add(a);
                        System.out.println(a.toString());
                    }
                }
            }
        }
        return albunsMusico;

    }

    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(albuns);

        oos.close();
        fos.close();
    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        albuns = (HashSet<Album>) oin.readObject();
        oin.close();
        file.close();
    }

    @Override
    public String toString() {
        return "            LISTA ÁLBUNS\n" + "-----------------------------\n" + albuns;
    }

}
