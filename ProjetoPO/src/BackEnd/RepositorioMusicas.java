package BackEnd;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;


public class RepositorioMusicas implements Serializable{

    private final Collection<Musica> musicas;

    public RepositorioMusicas() {
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
