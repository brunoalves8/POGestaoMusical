package BackEnd;


import java.util.Collection;
import java.util.TreeSet;

public class Musica {

    private String titulo;
    private double duracao;
    private int codigo;
    private int codigoAlbumAssociado;
    private Collection<Musico> musicos; 

    public Musica(String titulo, double duracao, int codigo) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.codigo = codigo;
    }

    public Musica() {
        musicos = new TreeSet<>();
    }
   
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public void adicionarMusico(Musico musico){
        musicos.add(musico);
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodigoAlbumAssociado() {
        return codigoAlbumAssociado;
    }

    public void setCodigoAlbumAssociado(int codigoAlbumAssociado) {
        this.codigoAlbumAssociado = codigoAlbumAssociado;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public void removerMusico(int bi) {
        for (Musico m : musicos) {
            if (m.getBi() == bi) {
                musicos.remove(m);
            }
        }
    }

    @Override
    public String toString() {
        return "Musica{" + "titulo=" + titulo + ", duracao=" + duracao + ", codigo=" + codigo +'}';
    }

}
