package BackEnd;

import java.util.Collection;
import java.util.HashSet;

public class SetAlbum {

    private Collection<Album> albuns = new HashSet<>();

    public SetAlbum() {
        albuns = new HashSet<>();
    }

    public void adicionarAlbum(Album album) {
        albuns.add(album);
    }

    public void removerAlbum(int cod) {
        for (Album albm : albuns) {
            if (albm.getCodigo() == cod) {
                albuns.remove(albm);
            }
        }
    }

    public void editarDadosAlbum(int codigo) {

        for (Album albm : albuns) {
            if (albm.getCodigo() == codigo) {
                ((Album) albm).setTitulo(albm.getTitulo());
                ((Album) albm).setTipo(albm.getTipo());
                ((Album) albm).setDataEdicao(albm.getDataEdicao());
            }
        }
    }

    public Album consultarDadosAlbum(int codigo) {
        for (Album albm : albuns) {
            if (albm.getCodigo() == codigo) {
                return albm;
            }
        }
        System.out.println("Não existe nenhum album com esse codigo.");
        return null;
    }

    public Album procurarAlbumPorTitulo(String titulo) {

        for (Album a : albuns) {
            if (a.getTitulo().equals(titulo)) {
                return (Album) a;
            }
        }
        return null;
    }
}
