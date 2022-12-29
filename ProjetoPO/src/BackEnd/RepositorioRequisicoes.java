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
    
    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(nomeFicheiro); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            oos.writeObject(requisicoes);
            
        }
    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        requisicoes = (HashSet<Requisicao>) oin.readObject();
        oin.close();
        file.close();
    }
    
    
    
}
