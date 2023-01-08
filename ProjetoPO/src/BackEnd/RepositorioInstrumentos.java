package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class RepositorioInstrumentos implements Serializable {

    private Collection<Instrumento> instrumentos = new HashSet<>();

    public RepositorioInstrumentos() {
        instrumentos = new HashSet<>();
    }

    public void adicicionarInstrumento(Instrumento instrumento) {
        instrumentos.add(instrumento);
    }

    public boolean verificarInstrumentoPorNome(String nome) {

        for (Instrumento i : instrumentos) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public Instrumento procurarInstrumentoPorNomeEMusico(String nome, Musico musico) {

        for (Instrumento i : instrumentos) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                Collection<Instrumento> instrumentosMusico = new HashSet<>();
                instrumentosMusico = musico.getInstrumentosMusicoToca();
                for (Instrumento inst : instrumentosMusico) {
                    if (inst.equals(i)) {
                        return inst;
                    }
                }

            }
        }
        return null;
    }

    public Instrumento procurarInstrumentoPorNome(String nome) {

        for (Instrumento i : instrumentos) {
            if (i.getNome().equalsIgnoreCase(nome)) {
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

    @Override
    public String toString() {
        return "            LISTA INSTRUMENTOS\n" + "-----------------------------\n" + instrumentos.toString() + "\n";
    }

}
