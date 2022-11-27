package BackEnd;

import java.util.ArrayList;

public class Album {
    
    private String titulo;
    private String dataEdicao;
    private String tipo;
    private int codigo;
    private ArrayList<Musica> musicasDoAlbum;

    public Album() {
    }

    public Album(String titulo, String dataEdicao, String tipo) {
        this.titulo = titulo;
        this.dataEdicao = dataEdicao;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Musica> getMusicasDoAlbum() {
        return musicasDoAlbum;
    }

    public void setMusicasDoAlbum(ArrayList<Musica> musicasDoAlbum) {
        this.musicasDoAlbum = musicasDoAlbum;
    }
      
    public void adicionarMusica(Musica music){
        musicasDoAlbum.add(music);
    }
    
    public String removerMusica(String nomeMusica){
        for (Musica m: musicasDoAlbum) {
            if(m.getTitulo().equals(nomeMusica)){
                musicasDoAlbum.remove(m);
                return "A musica foi removida do albúm";
            }
        }
        return "Não existe nenhuma música no albúm com esse titulo";
    }
    
    
    
}
    
