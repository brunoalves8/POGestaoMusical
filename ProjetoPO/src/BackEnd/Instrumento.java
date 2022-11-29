package BackEnd;


public class Instrumento {
    
    private String nome;
    private String tipo;
    private String marca;
    private String modelo;

    public Instrumento() {
    }

    public Instrumento(String nome, String tipo, String marca, String modelo) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Instrumento{" + "nome=" + nome + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + '}';
    }
    
    
}
