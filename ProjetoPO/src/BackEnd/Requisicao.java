package BackEnd;

public class Requisicao {

    private Musico requisitor;
    private Instrumento requisitado;
    private String dataRequisicao;
    private Sessao sessaoGravacao;

    public Requisicao() {
    }

    public Requisicao(Musico requisitor, Instrumento requisitado, String dataRequisicao, Sessao sessaoGravacao) {
        this.requisitor = requisitor;
        this.requisitado = requisitado;
        this.dataRequisicao = dataRequisicao;
        this.sessaoGravacao = sessaoGravacao;
    }

    public Musico getRequisitor() {
        return requisitor;
    }

    public void setRequisitor(Musico requisitor) {
        this.requisitor = requisitor;
    }

    public Instrumento getRequisitado() {
        return requisitado;
    }

    public void setRequisitado(Instrumento requisitado) {
        this.requisitado = requisitado;
    }

    public String getDataRequisicao() {
        return dataRequisicao;
    }

    public void setDataRequisicao(String dataRequisicao) {
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
        return "Requisicao{" + "requisitor=" + requisitor + ", requisitado=" + requisitado + ", dataRequisicao=" + dataRequisicao + ", sessaoGravacao=" + sessaoGravacao + '}';
    }

}
