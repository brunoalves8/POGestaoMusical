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
    public Sessao(EdicaoAlbum albumSerGravado, LocalDate diaDeGravacao, Collection<Requisicao> requisicoes, boolean sessaoConcluida) {
        this.albumSerGravado = albumSerGravado;
        this.diaDeGravacao = diaDeGravacao;
        this.requisicoes = requisicoes;
        this.sessaoConcluida = sessaoConcluida;
    }

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

    public void setAlbumSerGravado(EdicaoAlbum albumSerGravado) {
        this.albumSerGravado = albumSerGravado;
    }
 
    public Collection<Requisicao> getRequisicoes() {
        return requisicoes;
    }

    public void setRequisicoes(Collection<Requisicao> requisicoes) {    
        this.requisicoes = requisicoes;
    }

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
