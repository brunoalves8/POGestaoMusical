package BackEnd;


public class Sistema {
    
    private final MapUtilizadores users;
    private final SetAlbum albuns;
    private final SetMusicas musicas;
    private final SetInstrumentos instrumentos;
    
    

    public Sistema() {
        users = new MapUtilizadores();
        albuns = new SetAlbum();
        musicas = new SetMusicas();
        instrumentos = new SetInstrumentos();
    }
    
    
    public MapUtilizadores getUsers(){
        return users;
    }
    
    public SetAlbum getAlbuns(){
        return albuns;
    }
    
    public SetMusicas getMusicas(){
        return musicas;
    }
    
    public SetInstrumentos getInstrumentos(){
        return instrumentos;
    }
}
