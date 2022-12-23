package BackEnd;

public class EdicaoAlbum {
   
    private Album album;
    private Produtor produtor;
    private SetSessoes sessoes;

    public EdicaoAlbum() {
    }

    public EdicaoAlbum(Album album, Produtor produtor) {
        this.album = album;
        this.produtor = produtor;
        this.sessoes = new SetSessoes();
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public SetSessoes getSessoes() {
        return sessoes;
    }

    public void setSessoes(SetSessoes sessoes) {
        this.sessoes = sessoes;
    }
    
    public void adicionarSessao(Sessao sessao){
        sessoes.addSessao(sessao);
    }
    
    
}
