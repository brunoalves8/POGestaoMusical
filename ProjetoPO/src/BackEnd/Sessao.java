package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class Sessao implements Serializable{

    private int codigo;
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
    public Sessao() {
        requisicoes = new HashSet<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
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
    

    public Sessao(int codigo,EdicaoAlbum albumSerGravado, LocalDate diaDeGravacao, boolean estadoSessao) {
        this.codigo = codigo;
        this.albumSerGravado = albumSerGravado;
        this.diaDeGravacao = diaDeGravacao;
        this.sessaoConcluida = estadoSessao;
        requisicoes = new HashSet<>();
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
    
    public void adicionarRequisicao(Requisicao requisicao){
        requisicoes.add(requisicao);
    }

    @Override
    public String toString() {
        return  "\nCodigo Sessao: " + codigo + "\n Dia de Gravação" + diaDeGravacao + "\n Estado Da Sessão" + sessaoConcluida;
    }
    
  
     
    
}
