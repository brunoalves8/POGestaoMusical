package BackEnd;


public class Sistema {
    
    private final MapUtilizadores users;
    private final SetAlbum albuns;
    private final SetMusicas musicas;
    
    
    

    public Sistema() {
        users = new MapUtilizadores();
        albuns = new SetAlbum();
        musicas = new SetMusicas();
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
    
}
