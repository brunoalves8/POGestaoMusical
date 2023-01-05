package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class SetAlbum implements Serializable {

    private Collection<Album> albuns = new HashSet<>();

    public SetAlbum() {
        albuns = new HashSet<>();
    }

    public void adicionarAlbum(Album album) {
        albuns.add(album);
    }


    public void removerAlbum(int cod) {
        for (Album albm : albuns) {
            if (albm.getCodigo() == cod) {
                albuns.remove(albm);
            }
        }
    }

    public void editarDadosAlbum(int codigo) {

        for (Album albm : albuns) {
            if (albm.getCodigo() == codigo) {
                ((Album) albm).setTitulo(albm.getTitulo());
                ((Album) albm).setTipo(albm.getTipo());
                ((Album) albm).setDataEdicao(albm.getDataEdicao());
            }
        }
    }

    public Album consultarDadosAlbum(int codigo) {
        for (Album albm : albuns) {
            if (albm.getCodigo() == codigo) {
                return albm;
            }
        }
        System.out.println("Não existe nenhum album com esse codigo.");
        return null;
    }

    public Album procurarAlbumPorTitulo(String titulo) {

        for (Album a : albuns) {
            if (a.getTitulo().equals(titulo)) {
                return (Album) a;
            }
        }
        return null;
    }
    
    public boolean verificarAlbumPorCod(int codigo) {

        for (Album a : albuns) {
            if (a.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
    
    public Album procurarAlbumPorCod(int codigo) {

        for (Album a : albuns) {
            if (a.getCodigo() == codigo) {
                return a;
            }
        }
        return null;
    }
    
    public Collection<Album> listarAlbunsMusico(Musico musico){
            Collection<Album> albunsMusico = new HashSet<>();
        for(Album a: albuns){
            Collection<Musica> musicasAlbum = new HashSet<>();
            musicasAlbum = a.getMusicasDoAlbum();
            for(Musica m: musicasAlbum){
                Collection<Musico> musicosMusica = new HashSet<>();
                musicosMusica = m.getMusicos();
                for(Musico mu : musicosMusica){
                    if(mu.getNome().equals(musico.getNome())){
                        albunsMusico.add(a);
                        
                    }
                }
            }
            System.out.println(a.toString());
        }
        return albunsMusico;
            
    }
 
    
    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(albuns);

        oos.close();
        fos.close();
    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        albuns = (HashSet<Album>) oin.readObject();
        oin.close();
        file.close();
    }

    @Override
    public String toString() {
        return "SetAlbum{" + "albuns=" + albuns + '}';
    }
    
    
}
