package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

public class Requisicao implements Serializable{

    private Musico requisitor;
    private Collection<Instrumento> instrumentos;
    private Sessao sessaoGravacao;
    private LocalDate dataRequisicao;
    public Requisicao() {
    }

    public Requisicao(Musico requisitor, Collection<Instrumento> instrumentos, LocalDate dataRequisicao, Sessao sessaoGravacao) {
        this.requisitor = requisitor;
        this.instrumentos = instrumentos;
        this.dataRequisicao = dataRequisicao;
        this.sessaoGravacao = sessaoGravacao;
    }

    public Collection<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(Collection<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }

    public Musico getRequisitor() {
        return requisitor;
    }

    public void setRequisitor(Musico requisitor) {
        this.requisitor = requisitor;
    }

    public LocalDate getDataRequisicao() {
        return dataRequisicao;
    }

    public void setDataRequisicao(LocalDate dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public Sessao getSessaoGravacao() {
        return sessaoGravacao;
    }

    public void setSessaoGravacao(Sessao sessaoGravacao) {
        this.sessaoGravacao = sessaoGravacao;
    }

    @Override
    public String toString() {
        return "Requisicao{" + "requisitor=" + requisitor + ", instrumentos=" + instrumentos + ", dataRequisicao=" + dataRequisicao + ", sessaoGravacao=" + sessaoGravacao + '}';
    }



}
