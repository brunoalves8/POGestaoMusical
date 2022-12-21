package BackEnd;


public class Sistema {
    
    private MapUtilizadores users;
    private SetAlbum albuns;
    
    
    
    

    public Sistema() {
        users = new MapUtilizadores();
        albuns = new SetAlbum();
    }
    
    public MapUtilizadores getUsers(){
        return users;
    }
    
    public SetAlbum getAlbuns(){
        return albuns;
    }
    
}
