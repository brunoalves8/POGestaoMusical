package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class SetSessoes implements Serializable {

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

    public void adicionarSessao(Sessao sessao) {
        sessoes.add(sessao);
    }

    public boolean verificarExisteSessao(LocalDate dataSessao) {

        for (Sessao s : sessoes) {
            if (s.getDiaDeGravacao().compareTo(dataSessao) == 0 ) {
                return true;
            }
        }
        return false;
    }
    

    
    public Sessao procurarSessao(LocalDate dataSessao) {

        for (Sessao s : sessoes) {
            if (s.getDiaDeGravacao().compareTo(dataSessao) == 0) {
                return (Sessao) s;
            }
        }
        return null;
    }
   
    
    
    public Collection<Sessao> listarSessoesAgendadas(){
        Collection<Sessao> sessoesAgendadas= new HashSet<>();
        for (Sessao s : sessoes) {
            if (s.isSessaoConcluida()==false) {
                sessoesAgendadas.add(s);
                System.out.println(s.toString());
            }
        }
        return sessoesAgendadas;
    }
    
    public Collection<Sessao> listarSessoesAgendadasPorMusico(Musico musico){
        Collection<Sessao> sessoesAgendadas= new HashSet<>();
        for (Sessao s : sessoes) {
            if (s.isSessaoConcluida()==false) {
                sessoesAgendadas.add(s);
                System.out.println(s.toString());
            }
        }
        return sessoesAgendadas;
    }
    
    public Collection<Sessao> listarSessoesConcluidas(){
        Collection<Sessao> sessoesConcluidas = new HashSet<>();
        for (Sessao s : sessoes) {
            if (s.isSessaoConcluida()==true) {
                sessoesConcluidas.add(s);
                System.out.println(s.toString());
            }
        }
        return sessoesConcluidas;
    }

    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(nomeFicheiro); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            oos.writeObject(sessoes);
            
        }
    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        sessoes = (HashSet<Sessao>) oin.readObject();
        oin.close();
        file.close();
    }

    @Override
    public String toString() {
        return "Sessoes" + sessoes.toString() + '}';
    }
    
}
