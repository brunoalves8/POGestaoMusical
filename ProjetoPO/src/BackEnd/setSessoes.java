package BackEnd;

import java.util.Collection;
import java.util.TreeSet;

public class setSessoes {
    
    private Collection<Sessao> sessoes = new TreeSet<>();

    public setSessoes() {
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

}
