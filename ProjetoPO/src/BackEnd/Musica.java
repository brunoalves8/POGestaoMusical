package BackEnd;


import java.util.Collection;
import java.util.TreeSet;

public class Musica {

    private String titulo;
    private double duracao;
    private int codigo;
    private Collection<Musico> musicos; 

    public Musica(String titulo, double duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
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

  /*  public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
*/

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
