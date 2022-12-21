package BackEnd;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sessao {

    private int codigoSessao;
    private Album albumSerGravado;
    //private Lo dataFinalGravacao;
    private LocalDate diaDeGravacao;
    private ArrayList<Musico> musicosSessaoGravacao = new ArrayList<>();

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

    public int getCodigoSessao() {
        return codigoSessao;
    }

    public void setCodigoSessao(int codigoSessao) {
        this.codigoSessao = codigoSessao;
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
    public ArrayList<Musico> getMusicosSessaoGravacao() {
        return musicosSessaoGravacao;
    }

    public void setMusicosSessaoGravacao(ArrayList<Musico> musicosSessaoGravacao) {
        this.musicosSessaoGravacao = musicosSessaoGravacao;
    }

    public LocalDate getDiaDeGravacao() {
        return diaDeGravacao;
    }

    public void setDiaDeGravacao(LocalDate diaDeGravacao) {
        this.diaDeGravacao = diaDeGravacao;
    }

}
