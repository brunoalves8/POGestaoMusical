package BackEnd;


public class Sistema {
    
    private final MapUtilizadores users;
    private final SetAlbum albuns;
    private final SetInstrumentos instrumentos;
    private final MapEdicoesAlbum edicoesAlbum;
    

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
    
   /* public Sistema getSistema(){
        Sistema sistema = new Sistema(getUsers(), getAlbuns(), getInstrumentos(), getEdicoesAlbum());
        return sistema;
    }*/
}
