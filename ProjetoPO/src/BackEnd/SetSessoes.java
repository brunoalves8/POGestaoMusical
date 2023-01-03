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
    
    public void adicionarRequisicoesAumaSessao(Sessao sessao){
        for(Sessao s: sessoes){
            if(s.getCodigo()== sessao.getCodigo()){
                s.setRequisicoes(sessao.getRequisicoes());        
            }
        }
            
    }
    

    public boolean verificarExisteSessao(int cod) {

        for (Sessao s : sessoes) {
            if (s.getCodigo() == cod ) {
                return true;
            }
        }
        return false;
    }
    

    
    public Sessao procurarSessao(int cod) {

        for (Sessao s : sessoes) {
            if (s.getCodigo() == cod) {
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
    
    public Collection<Sessao> listarSessoesAgendadasPorDia(LocalDate data){
        Collection<Sessao> sessoesAgendadas= new HashSet<>();
        for (Sessao s : sessoes) {
            if (s.isSessaoConcluida()==false && (s.getDiaDeGravacao().compareTo(data)) == 0) {
                sessoesAgendadas.add(s);
                System.out.println(s.toString());
            }
        }
        return sessoesAgendadas;
    }
    
    
    
    
    public Collection<Sessao> listarSessoesAgendadasPorMusico(Musico musico){
        Collection<Sessao> sessoesAgendadas= new HashSet<>();
        for (Sessao s : sessoes) {
            if (s.isSessaoConcluida()==false && s.getRequisicoes().contains(musico) == true) {
                sessoesAgendadas.add(s);
                System.out.println(s.toString());
            }
        }
        return sessoesAgendadas;
    }
    
    public Collection<Sessao> listarSessoesAgendadasPorProdutor(){
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
