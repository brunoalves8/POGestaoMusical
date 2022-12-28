package BackEnd;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;

public class SetMusicas implements Serializable{

    private Collection<Musica> musicas;

    public SetMusicas() {
        musicas = new TreeSet<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

}
