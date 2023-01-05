package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class Requisicao implements Serializable{

    private Musico requisitor;
    private Collection<Instrumento> instrumentos;
    private Sessao sessaoGravacao;
    private LocalDate dataRequisicao;
    private String estadoRequisicao;
    
    public Requisicao() {
        instrumentos = new HashSet<>();
    }

    public Requisicao(Musico requisitor, Collection<Instrumento> instrumentos, LocalDate dataRequisicao, Sessao sessaoGravacao, String estadoRequisicao) {
        this.requisitor = requisitor;
        this.instrumentos = instrumentos;
        this.dataRequisicao = dataRequisicao;
        this.sessaoGravacao = sessaoGravacao;
        this.estadoRequisicao = estadoRequisicao;
    }

    public String getEstadoRequisicao() {
        return estadoRequisicao;
    }

    public void setEstadoRequisicao(String estadoRequisicao) {
        this.estadoRequisicao = estadoRequisicao;
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
    
    public void adicionarInstrumento(Instrumento instrumento){
        instrumentos.add(instrumento);
    }
    @Override
    public String toString() {
        return "Requisicao{" + "requisitor=" + requisitor + ", instrumentos=" + instrumentos + ", dataRequisicao=" + dataRequisicao + ", sessaoGravacao=" + sessaoGravacao + '}';
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Requisicao) {
            Requisicao outro = (Requisicao) o;
            return outro.getEstadoRequisicao().equals(getEstadoRequisicao());
        }
        return false;
    }

}
