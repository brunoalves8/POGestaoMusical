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

}
