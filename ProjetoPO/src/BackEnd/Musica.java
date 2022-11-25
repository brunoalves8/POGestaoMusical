package BackEnd;

import java.util.ArrayList;

public class Musica {

    private String titulo;
    private double duracao;
    private int codigo; //criei para ser possivel remover uma musica da lista de musicas
    private ArrayList<Musico> artistas = new ArrayList<>();

    public Musica() {
    }

    public Musica(String titulo, double duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
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

    public void adicionarMusico(Musico artist) {
        artistas.add(artist);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Musico> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Musico> artistas) {
        this.artistas = artistas;
    }

    public void removerMusico(int bi) {
        for (Musico m : artistas) {
            if (m.getBi() == bi) {
                artistas.remove(bi);
            }
        }
    }

    @Override
    public String toString() {
        return "Musica{" + "titulo=" + titulo + ", duracao=" + duracao + ", codigo=" + codigo + ", artistas=" + artistas + '}';
    }

}
