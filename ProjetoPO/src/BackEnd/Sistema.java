package BackEnd;


public class Sistema {
    
    private final MapUtilizadores users;
    private final SetAlbum albuns;
    private final SetInstrumentos instrumentos;
    private final MapEdicoesAlbum edicoesAlbum;
    private final SetSessoes sessoes;
    private final SetMusicas musicas;
    private final RepositorioRequisicoes requisicoes;

   /* public Sistema(MapUtilizadores users, SetAlbum albuns, SetInstrumentos instrumentos, MapEdicoesAlbum edicoesAlbum) {
        this.users = users;
        this.albuns = albuns;
        this.instrumentos = instrumentos;
        this.edicoesAlbum = edicoesAlbum;
    }*/

    public Sistema() {
        users = new MapUtilizadores();
        albuns = new SetAlbum();
        instrumentos = new SetInstrumentos();
        edicoesAlbum = new MapEdicoesAlbum();
        sessoes = new SetSessoes();
        musicas = new SetMusicas();
        requisicoes = new RepositorioRequisicoes();
    }
    
    
    public MapUtilizadores getUsers(){
        return users;
    }
    
    public SetAlbum getAlbuns(){
        return albuns;
    }
    
    public SetInstrumentos getInstrumentos(){
        return instrumentos;
    }

    public MapEdicoesAlbum getEdicoesAlbum() {
        return edicoesAlbum;
    }
    
    public SetSessoes getSessoes(){
        return sessoes;
    }
    
    public RepositorioRequisicoes getRequisicoes(){
        return requisicoes;
    }
    
    
   /* public Sistema getSistema(){
        Sistema sistema = new Sistema(getUsers(), getAlbuns(), getInstrumentos(), getEdicoesAlbum());
        return sistema;
    }*/

    public SetMusicas getMusicas() {
        return musicas;
    }

}
