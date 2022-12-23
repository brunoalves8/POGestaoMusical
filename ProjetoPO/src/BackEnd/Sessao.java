package BackEnd;

import java.time.LocalDate;
import java.util.Collection;

public class Sessao {

    private Album albumSerGravado;
    private LocalDate diaDeGravacao;
    //private ArrayList<Musico> musicosSessaoGravacao = new ArrayList<>();
    private Collection<Requisicao> requisicoes; 
    
    public Sessao(Album albumSerGravado, LocalDate diaDeGravacao) {
        this.albumSerGravado = albumSerGravado;
        this.diaDeGravacao = diaDeGravacao;
    }
    

    /*public Sessao(int codigoSessao, Album albumSerGravado, String dataFinalGravacao) {
        this.codigoSessao = codigoSessao;
        this.albumSerGravado = albumSerGravado;
        this.dataFinalGravacao = dataFinalGravacao;
    }*/

    public Sessao() {
    }

    public Album getAlbumSerGravado() {
        return albumSerGravado;
    }

    public void setAlbumSerGravado(Album albumSerGravado) {
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

}
