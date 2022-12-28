package BackEnd;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Musica implements Serializable{

    private String titulo;
    private int duracao;
    private Collection<Musico> musicos; 
    
    
    public Musica(String titulo, int duracao, Collection<Musico> musicos) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.musicos = musicos;
    }

    public Musica() {
        musicos = new HashSet<>();
    }
   
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void adicionarMusico(Musico musico){
        musicos.add(musico);
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
        return "Musica{" + "titulo=" + titulo + ", duracao=" + duracao + ", musicos=" + musicos + '}';
    }



}
