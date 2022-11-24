package BackEnd;


public abstract class Utilizador {
    private String nome;
    private int bi;
    private String morada;
    private int dataNasc;

    public Utilizador() {
        
    }

    public Utilizador(String nome, int bi, String morada,int dataNasc) {
        this.nome = nome;
        this.bi = bi;
        this.morada = morada;
        this.dataNasc = dataNasc;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBi() {
        return bi;
    }

    public void setBi(int bi) {
        this.bi = bi;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(int dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "Nome=" + nome + 
               "Bi=" + bi + 
               "Morada=" + morada + 
               "Data Nascimento=" + dataNasc;
    }
    
    
}
