package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

public class Sessao implements Serializable{

    //private Album albumSerGravado;
    private EdicaoAlbum albumSerGravado;
    private LocalDate diaDeGravacao;
    //private ArrayList<Musico> musicosSessaoGravacao = new ArrayList<>();
    private Collection<Requisicao> requisicoes; 
    private boolean sessaoConcluida;
    
 /*   public Sessao(Album albumSerGravado, LocalDate diaDeGravacao) {
        this.albumSerGravado = albumSerGravado;
        this.diaDeGravacao = diaDeGravacao;
    }
   */

    public Sessao(EdicaoAlbum albumSerGravado, LocalDate diaDeGravacao) {
        this.albumSerGravado = albumSerGravado;
        this.diaDeGravacao = diaDeGravacao;
    }
    

    public Sessao(EdicaoAlbum albumSerGravado, LocalDate diaDeGravacao, boolean estadoSessao) {
        this.albumSerGravado = albumSerGravado;
        this.diaDeGravacao = diaDeGravacao;
        this.sessaoConcluida = estadoSessao;
    }

    public Sessao() {
    }


    public EdicaoAlbum getAlbumSerGravado() {
        return albumSerGravado;
    }

    /*   public Album getAlbumSerGravado() {
    return albumSerGravado;
    }
    public void setAlbumSerGravado(Album albumSerGravado) {
    this.albumSerGravado = albumSerGravado;
    }
     */
    public void setAlbumSerGravado(EdicaoAlbum albumSerGravado) {
        this.albumSerGravado = albumSerGravado;
    }

    /*  public String getDataFinalGravacao() {
    return dataFinalGravacao;
    }
    public void setDataFinalGravacao(String dataFinalGravacao) {
    this.dataFinalGravacao = dataFinalGravacao;
    }
     */
    public LocalDate getDiaDeGravacao() {
        return diaDeGravacao;
    }

    public void setDiaDeGravacao(LocalDate diaDeGravacao) {
        this.diaDeGravacao = diaDeGravacao;
    }

    public boolean isSessaoConcluida() {
        return sessaoConcluida;
    }

    public void setSessaoConcluida(boolean sessaoConcluida) {
        this.sessaoConcluida = sessaoConcluida;
    }

    @Override
    public String toString() {
        return "Sessao{" + "albumSerGravado=" + albumSerGravado + ", diaDeGravacao=" + diaDeGravacao + '}';
    }
     
    
}
