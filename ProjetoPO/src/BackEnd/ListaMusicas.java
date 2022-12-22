package BackEnd;

import java.util.Collection;
import java.util.TreeSet;

public class ListaMusicas {

    private Collection<Musica> musicas;

    public ListaMusicas() {
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

    public Musica consultarDadosMusica(int cod) {
        for (Musica m : musicas) {
            if (m.getCodigo() == cod) {
                return m;
            }
        }
        System.out.println("Não existe nenhuma musica com esse codigo."); //não devemos ter prints dentro de metodos, que já fazem ações.
        return null;
    }

    public void editarDadosMusica(int cod) {
        for (Musica m : musicas) {
            if (m.getCodigo() == cod) {
                ((Musica) m).setTitulo(m.getTitulo());
                ((Musica) m).setDuracao(m.getDuracao());
                
            }
        }
    }
*/
}
