
package BackEnd;

import java.util.*;

public class ListaUtilizadores {
    
    private Collection<Utilizador> utilizadores;

    public ListaUtilizadores() {
        utilizadores = new TreeSet<>();
    }
    
   
    public void removerUtilizador(Utilizador utilizador){
        
    }
    
    public void criarUtilizador(){
        
    }
    
    public void editarUtilizador(Utilizador utilizador){
        
    }
    
    public void verificarExisteUtilizador(Utilizador utilizador){
        
    }
    
    public void adicionarMusico(Musico Musico){
       utilizadores.add(Musico);
        
    }
    
    public void removerMusico(int cod){
       for(Utilizador u: utilizadores){
           if(u.getBi()== cod){
             utilizadores.remove(u);
           }
       }
        
    }
        
    public Utilizador consultarDadosMusico(int codigo ){
        for(Utilizador u: utilizadores){
            if(u instanceof Musico && u.getBi()== codigo){
                return u;
            }
        }
        System.out.println("Não existe nenhum musico com esse código!");
        return null;
    }
    
    public void editarDadosMusico(int codigo, Musico musico){
        consultarDadosMusico(codigo);
        for(Utilizador u: utilizadores){
            if(u instanceof Musico && u.getBi()== codigo){
                
            }
        }
    }
    
}
