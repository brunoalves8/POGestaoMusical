package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class SetSessoes {
    
    private Collection<Sessao> sessoes = new HashSet<>();

    public SetSessoes() {
        sessoes = new HashSet<>();
    }

    public boolean concluirSessaoGravacao(LocalDate dataSessao) {
        for (Sessao s : sessoes) {
            if ((s.getDiaDeGravacao() == dataSessao) == false) {
                return false;
            }
        }
        return true;
    }
    
    public void adicionarSessao(Sessao sessao){
        sessoes.add(sessao);
    }
    
    public boolean verificarExisteSessao(LocalDate dataSessao) {

        for (Sessao s : sessoes) {
            if (s.getDiaDeGravacao().compareTo(dataSessao) == 0) {
                return true;
            }
        }
        return false;
    }
    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(sessoes);

        oos.close();
        fos.close();
    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        sessoes = (HashSet<Sessao>) oin.readObject();
        oin.close();
        file.close();
    }
}
