package BackEnd;

import java.util.Collection;
import java.util.TreeSet;

public class SetSessoes {
    
    private Collection<Sessao> sessoes = new TreeSet<>();

    public SetSessoes() {
        sessoes = new TreeSet<>();
    }

    public void iniciarSessaoGravacao(Sessao sessao) {
        sessoes.add(sessao);
    }

    public boolean concluirSessaoGravacao(Sessao sessao) {
        for (Sessao sess : sessoes) {
            if (sessoes.contains(sessao)== true) {
                sessoes.remove(sessao);
            }
        }
        return false;
    }
    
    public void addSessao(Sessao sessao){
        sessoes.add(sessao);
    }

}
