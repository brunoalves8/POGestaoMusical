package BackEnd;

import java.util.ArrayList;

public class Sessao {

    private int codigoSessao;
    private Album albumSerGravado;
    private String dataFinalGravacao;
    private ArrayList<Musico> musicosSessaoGravacao = new ArrayList<>();

    public Sessao(int codigoSessao, Album albumSerGravado, String dataFinalGravacao) {
        this.codigoSessao = codigoSessao;
        this.albumSerGravado = albumSerGravado;
        this.dataFinalGravacao = dataFinalGravacao;
    }

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

    public String getDataFinalGravacao() {
        return dataFinalGravacao;
    }

    public void setDataFinalGravacao(String dataFinalGravacao) {
        this.dataFinalGravacao = dataFinalGravacao;
    }

    public ArrayList<Musico> getMusicosSessaoGravacao() {
        return musicosSessaoGravacao;
    }

    public void setMusicosSessaoGravacao(ArrayList<Musico> musicosSessaoGravacao) {
        this.musicosSessaoGravacao = musicosSessaoGravacao;
    }

}
