package BackEnd;

import java.util.ArrayList;


public class Musica {
    
    private String titulo;
    private double duracao;
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
    
    public void adicionarMusico(Musico artist){
        artistas.add(artist);
    }
    
    public void removerMusico(int bi){
        for(Musico m: artistas){
            if(m.getBi() == bi){
                artistas.remove(bi);
            }
        }
    }
    
}
