package BackEnd;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class RepositorioRequisicoes implements Serializable{
    
    private Collection<Requisicao> requisicoes = new HashSet<>();

    public RepositorioRequisicoes() {
        requisicoes = new HashSet<>();
    }
    
    public void adicionarRequisicao(Requisicao requisicao) {
        requisicoes.add(requisicao);
    }
    
    
    
    
    
}
