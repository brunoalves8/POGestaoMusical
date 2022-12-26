package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class SetInstrumentos {

    private Collection<Instrumento> instrumentos = new HashSet<>();

    public SetInstrumentos() {
        instrumentos = new HashSet<>();
    }

    public void adicicionarInstrumento(Instrumento instrumento) {
        instrumentos.add(instrumento);
    }

    public void removerInstrumento(String nome) {
        for (Instrumento inst : instrumentos) {
            if (inst.getNome().equals(nome)) {
                instrumentos.remove(inst);
            }
        }
    }

    /*
    public void editarDadosAlbum(String modelo) {

        for (Instrumento inst : instrumentos) {
            if (inst.getNome().equals(modelo)) {
                ((Instrumento) inst).setNome(inst.getNome());
            }
        }
    }

    
    
        public Instrumento consultarDadosInstrumento(String modelo) {
        for (Instrumento inst : instrumentos) {
            if (inst.getModelo().equals(modelo)) {
                return inst;
            }
        }
        System.out.println("Não existe nenhum modelo desse Instrumento.");
        return null;
    }
     */
    
    
    public Instrumento procurarInstrumentoPorNome(String nome) {

        for (Instrumento i : instrumentos) {
            if (i.getNome().equals(nome)) {
                return i;
            }
        }
        return null;
    }

    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(instrumentos);

        oos.close();
        fos.close();
    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        instrumentos = (HashSet<Instrumento>) oin.readObject();
        oin.close();
        file.close();
    }
}
