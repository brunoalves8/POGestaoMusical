
package BackEnd;

import java.util.Collection;
import java.util.TreeSet;

public class ListaInstrumentos {
   
    private Collection<Instrumento> instrumentos = new TreeSet<>();

    public ListaInstrumentos() {
    }
    
    public void adicicionarInstrumento(Instrumento instrumento){
        instrumentos.add(instrumento);
    }
    
     public void removerInstrumento(String modelo){
        for(Instrumento inst: instrumentos){
            if(inst.getModelo().equals(modelo)){
                instrumentos.remove(inst);
            }
        }
    }
    
        public void editarDadosAlbum(String modelo){
        
        for(Instrumento inst : instrumentos){
            if(inst.getModelo().equals(modelo)){
                ((Instrumento)inst).setNome(inst.getNome());
                ((Instrumento)inst).setTipo(inst.getTipo());
                ((Instrumento)inst).setMarca(inst.getMarca());
            }
        }
    }
    
        public Instrumento consultarDadosInstrumento(String modelo){
        for (Instrumento inst : instrumentos){
            if(inst.getModelo().equals(modelo)){
                return inst;
            }
        }
        System.out.println("Não existe nenhum modelo desse Instrumento.");
        return null;
    }
    
}
