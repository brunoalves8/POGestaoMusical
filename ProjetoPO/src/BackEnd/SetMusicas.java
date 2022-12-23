package BackEnd;

import java.util.Collection;
import java.util.TreeSet;

public class SetMusicas {

    private Collection<Musica> musicas;

    public SetMusicas() {
        musicas = new TreeSet<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

  /*  public void removerMusica(int cod) {
        for (Musica m : musicas) {
            if (m.getCodigo() == cod) {
                musicas.remove((Musica) m);
            }
        }
    }
*/

    public Musica consultarDadosMusica(int cod) {
        for (Musica m : musicas) {
            if (m.getCodigo() == cod) {
                return m;
            }
        }
        System.out.println("Não existe nenhuma musica com esse codigo."); //não devemos ter prints dentro de metodos, que já fazem ações.
        return null;
    }
    
    public boolean verificarExisteMusica(int cod) {
        for (Musica m : musicas) {
            if (m.getCodigo() == cod) {
                return true;
            }
        }    
        System.err.println("Não existe nenhuma musica com esse codigo!");
        return false;
    }
    

    public void associarAlbumAmusica(int cod, int codAlbum) {
        for (Musica m : musicas) {
            if (m.getCodigo() == cod) {
                ((Musica) m).setCodigoAlbumAssociado(codAlbum);  
            }
        }
    }

}
