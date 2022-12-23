package BackEnd;


public class Sistema {
    
    private final MapUtilizadores users;
    private final SetAlbum albuns;
    private final SetInstrumentos instrumentos;
    private final MapEdicoesAlbum edicoesAlbum;
    
    

    public Sistema() {
        users = new MapUtilizadores();
        albuns = new SetAlbum();
        instrumentos = new SetInstrumentos();
        edicoesAlbum = new MapEdicoesAlbum();
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
    
}
