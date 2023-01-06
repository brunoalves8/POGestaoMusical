package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MapEdicoesAlbum implements Serializable {

    private HashMap<Album, EdicaoAlbum> edicoesAlbum;

    public MapEdicoesAlbum() {
        edicoesAlbum = new HashMap<>();
    }

    public void adicionarEdicaoAlbum(EdicaoAlbum edicaoAlbum) {
        edicoesAlbum.put(edicaoAlbum.getAlbum(), edicaoAlbum);
    }

    public void removerEdicaoAlbum(EdicaoAlbum edicao) {
        edicoesAlbum.remove(edicao.getAlbum());
    }

    public Collection<Album> listarAlbunsProdutor(Produtor produtor) {
        Collection<Album> albuns = new HashSet<>();
        for (EdicaoAlbum a : edicoesAlbum.values()) {
            if (a.getProdutor().equals(produtor)) {
                albuns.add(a.getAlbum());
                System.out.println(a.toString());
            }
        }
        return albuns;
    }

    public boolean verificarAlbumProdutorPorCod(Produtor produtor, int codigo) {
        Collection<Album> albuns = new HashSet<>();
        for (EdicaoAlbum a : edicoesAlbum.values()) {
            if (a.getProdutor().equals(produtor) && a.getAlbum().getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public Album retornarAlbumProdutorPorCod(Produtor produtor, int codigo) {
        Collection<Album> albuns = new HashSet<>();
        for (EdicaoAlbum a : edicoesAlbum.values()) {
            if (a.getProdutor().equals(produtor) && a.getAlbum().getCodigo() == codigo) {
                System.out.println(a.toString());
                return a.getAlbum();

            }
        }
        return null;
    }

    public boolean verificarExisteEdicaoAlbumParaUmAlbum(Album album) {
        for (EdicaoAlbum ea : edicoesAlbum.values()) {
            if (ea.getAlbum().equals(album)) {
                return true;
            }
        }
        return false;
    }

    public EdicaoAlbum procurarEdicaoAlbumPorAlbum(Album album) {
        for (EdicaoAlbum a : edicoesAlbum.values()) {
            if (a.getAlbum().equals(album)) {
                return a;
            }
        }
        return null;
    }

    //////////////////////////////////////////////////////////
    public double percentagemSessoesConcluidasPorAlbum(Album album) {
        int totalSessoes = 0;
        int numSessoesConcluidas = 0;
        double percentagem = 0.0;
        for (EdicaoAlbum ed : edicoesAlbum.values()) {
            if (ed.getAlbum().equals(album)) {
                Collection<Sessao> sessoesAlbum = new HashSet<>();
                sessoesAlbum = ed.getSessoes();
                for (Sessao s : sessoesAlbum) {
                    totalSessoes++;
                    if (s.isSessaoConcluida() == true) {
                        numSessoesConcluidas++;
                    }
                }

            }
        }
        percentagem = (numSessoesConcluidas * 100) / totalSessoes;
        return percentagem;

    }

    public Collection<Album> listarAlbunsEstadoERespetivasPercentagens() {
        Collection<Album> albuns = new HashSet<>();

        for (EdicaoAlbum ed : edicoesAlbum.values()) {
            albuns.add(ed.getAlbum());

            System.out.println(ed.getAlbum().getCodigo() + " - "
                    + ed.getAlbum().getTitulo()
                    + "       (" + percentagemSessoesConcluidasPorAlbum(ed.getAlbum()) + "%) Concluido");
        }
        return albuns;
    }

    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(edicoesAlbum);

        oos.close();
        fos.close();

    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        edicoesAlbum = (HashMap<Album, EdicaoAlbum>) oin.readObject();
        oin.close();
        file.close();
    }

    @Override
    public String toString() {
        return "MapEdicoesAlbum{" + "edicoesAlbum=" + edicoesAlbum + '}';
    }

}
