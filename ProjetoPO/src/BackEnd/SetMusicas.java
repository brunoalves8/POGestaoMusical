package BackEnd;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class SetMusicas implements Serializable{

    private Collection<Musica> musicas;

    public SetMusicas() {
        musicas = new HashSet<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }
    
    
    public Collection<Musica> listarMusicasPorMusico(Musico musico){
        Collection<Musica> musicasPorMusico = new HashSet();
        for(Musica m: musicas){
            if(m.getMusicos().contains(musico))
            musicasPorMusico.add(m);
        }
        return musicasPorMusico;
    }
}
