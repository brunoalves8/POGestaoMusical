package BackEnd;

import java.util.ArrayList;

public class Musica {

    private String titulo;
    private double duracao;
    private int codigo; //criei para ser possivel remover uma musica da lista de musicas
    private final ArrayList<Integer> codArtistas;

    public Musica() {
        this.codArtistas = new ArrayList<>();
    }

    public Musica(String titulo, double duracao) {
        this.codArtistas = new ArrayList<>();
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

    public void adicionarMusico(int codigoMusico){
        codArtistas.add(codigoMusico);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Integer> getCodArtistas() {
        return codArtistas;
    }

    public void removerMusico(int bi) {
        for (Integer in : codArtistas) {
            if (in == bi) {
                codArtistas.remove(in);
            }
        }
    }

    @Override
    public String toString() {
        return "Musica{" + "titulo=" + titulo + ", duracao=" + duracao + ", codigo=" + codigo +'}';
    }

}
