package BackEnd;

import java.io.Serializable;

public class Sistema implements Serializable {

    private final RepositorioUtilizadores users;
    private final RepositorioAlbuns albuns;
    private final RepositorioInstrumentos instrumentos;
    private final RepositorioEdicoesAlbum edicoesAlbum;
    private final RepositorioSessoes sessoes;
    private final RepositorioMusicas musicas;
    private final RepositorioRequisicoes requisicoes;

    public Sistema() {
        users = new RepositorioUtilizadores();
        albuns = new RepositorioAlbuns();
        instrumentos = new RepositorioInstrumentos();
        edicoesAlbum = new RepositorioEdicoesAlbum();
        sessoes = new RepositorioSessoes();
        musicas = new RepositorioMusicas();
        requisicoes = new RepositorioRequisicoes();
    }

    public RepositorioUtilizadores getUsers() {
        return users;
    }

    public RepositorioAlbuns getAlbuns() {
        return albuns;
    }

    public RepositorioInstrumentos getInstrumentos() {
        return instrumentos;
    }

    public RepositorioEdicoesAlbum getEdicoesAlbum() {
        return edicoesAlbum;
    }

    public RepositorioSessoes getSessoes() {
        return sessoes;
    }

    public RepositorioRequisicoes getRequisicoes() {
        return requisicoes;
    }

    public RepositorioMusicas getMusicas() {
        return musicas;
    }

}
