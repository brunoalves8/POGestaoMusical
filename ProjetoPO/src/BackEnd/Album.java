package BackEnd;

import java.util.ArrayList;

public class Album {
    
    private String titulo;
    private String dataEdicao;
    private String tipo;
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
    
