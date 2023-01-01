package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class Sessao implements Serializable{

    private Album albumSerGravado;
    //private EdicaoAlbum albumSerGravado;
    private LocalDate diaDeGravacao;
    //private ArrayList<Musico> musicosSessaoGravacao = new ArrayList<>();
    private Collection<Requisicao> requisicoes; 
    private Collection<Album> albuns;
    private boolean sessaoConcluida;
    
 /*   public Sessao(Album albumSerGravado, LocalDate diaDeGravacao) {
        this.albumSerGravado = albumSerGravado;
        this.diaDeGravacao = diaDeGravacao;
    }
   */
    public Sessao() {
        requisicoes = new HashSet<>();
    }

    public Sessao(LocalDate diaDeGravacao, Collection<Album> albuns, boolean sessaoConcluida) {
        this.diaDeGravacao = diaDeGravacao;
        this.albuns = albuns;
        this.sessaoConcluida = sessaoConcluida;
    }
    
    public Sessao(Album albumSerGravado, LocalDate diaDeGravacao, Collection<Requisicao> requisicoes, boolean sessaoConcluida) {
        this.albumSerGravado = albumSerGravado;
        this.diaDeGravacao = diaDeGravacao;
        this.requisicoes = requisicoes;
        this.sessaoConcluida = sessaoConcluida;
    }

    public Sessao(Album albumSerGravado, LocalDate diaDeGravacao) {
        this.albumSerGravado = albumSerGravado;
        this.diaDeGravacao = diaDeGravacao;
    }
    

    public Sessao(Album albumSerGravado, LocalDate diaDeGravacao, boolean estadoSessao) {
        this.albumSerGravado = albumSerGravado;
        this.diaDeGravacao = diaDeGravacao;
        this.sessaoConcluida = estadoSessao;
    }


    public Album getAlbumSerGravado() {
        return albumSerGravado;
    }

    public void setAlbumSerGravado(Album albumSerGravado) {
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
    
    public void adicionarRequisicao(Requisicao requisicao){
        requisicoes.add(requisicao);
    }
    
    public void adicionarAlbum(Album album){
        albuns.add(album);
    }
    @Override
    public String toString() {
        return "Sessao{" + "albumSerGravado=" + albumSerGravado + ", diaDeGravacao=" + diaDeGravacao + '}';
    }
     
    
}
