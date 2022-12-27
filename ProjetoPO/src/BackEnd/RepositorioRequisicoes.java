package BackEnd;

import java.util.Collection;
import java.util.HashSet;

public class RepositorioRequisicoes {
    
    private Collection<Requisicao> requisicoes = new HashSet<>();

    public RepositorioRequisicoes() {
        requisicoes = new HashSet<>();
    }
    
    public void adicionarRequisicao(Requisicao requisicao) {
        requisicoes.add(requisicao);
    }
    
    
    
    
    
}
