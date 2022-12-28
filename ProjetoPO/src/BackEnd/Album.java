package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Album implements Serializable{
    
    private int codigo;
    private String titulo;
    private LocalDate dataEdicao;
    private String tipo;
    private Collection<Musica> musicasDoAlbum;

    public Album() {
        musicasDoAlbum = new HashSet<>();
    }

    public Album(int codigo,String titulo, LocalDate dataEdicao, String tipo, Collection<Musica> musicasDoAlbum) {
        this.codigo=codigo;
        this.titulo = titulo;
        this.dataEdicao = dataEdicao;
        this.tipo = tipo;
        this.musicasDoAlbum = musicasDoAlbum;
    }
    

    public Album(int codigo, String titulo, LocalDate dataEdicao, String tipo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.dataEdicao = dataEdicao;
        this.tipo = tipo;
    }

    public Album(String titulo, LocalDate dataEdicao, String tipo) {
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

    public LocalDate getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(LocalDate dataEdicao) {
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

   /* public ArrayList<Musica> getMusicasDoAlbum() {
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
    
    */
    
  

    public void adicionarMusica(Musica musica){
        musicasDoAlbum.add(musica);
    }
    
    public Collection<Musica> getMusicasDoAlbum() {
        return musicasDoAlbum;
    }

    public void setMusicasDoAlbum(Collection<Musica> musicasDoAlbum) {
        this.musicasDoAlbum = musicasDoAlbum;
    }

    @Override
    public String toString() {
        return "Album{" + "codigo=" + codigo + ", titulo=" + titulo +'}';
    }
    
    
}
    
