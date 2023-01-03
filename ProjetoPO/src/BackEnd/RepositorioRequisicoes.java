package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    

    
    
    public Collection<Requisicao> listarRequisicoes(String Estado){ // Estado "Pendente", "Atribuido", "Recusado"
        Collection<Requisicao> requisicoesO = new HashSet<>();
        for(Requisicao r: requisicoes){
            if(r.getEstadoRequisicao().equals(Estado))
                requisicoesO.add(r);         
        }
        return requisicoesO;
    }
    
    
    
    
    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(requisicoes);

        oos.close();
        fos.close();
    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        requisicoes = (HashSet<Requisicao>) oin.readObject();
        oin.close();
        file.close();
    }

    @Override
    public String toString() {
        return "RepositorioRequisicoes{" + "requisicoes=" + requisicoes + '}';
    }
    
    
    
}
