package FrontEnd;

import BackEnd.Album;
import BackEnd.MapUtilizadores;
import BackEnd.Musica;
import BackEnd.Produtor;
import BackEnd.Sistema;
import java.io.IOException;

import java.time.LocalDate;

public class MainProdutor {

    private final Sistema sistema = new Sistema();
    private final Consola consola = new Consola();

    //A USAR RECURSIVIDADE
    /*
    private void autenticarProdutor() {
        
       String username = consola.lerString("Username: ");
       String password = consola.lerString("Password: ");
       
        if(sistema.getUsers().verificarExisteProdutor(username, password) == false){
            consola.escreverErro("Nome de utilizador ou senha errados!");
            autenticarProdutor();
        }else{
        consola.escrever("Login com sucesso!");
        }
    }*/
   
    //SEM USAR RECURSIVIDADE
    private void autenticarProdutor() {
        
       String username = consola.lerString("Username: ");
       String password = consola.lerString("Password: ");
       
        while(sistema.getUsers().verificarExisteProdutor(username, password) == false){
            consola.escreverErro("Nome de utilizador ou senha errados!");
            username = consola.lerString("Username: ");
            password = consola.lerString("Password: ");
        }
        consola.escrever("Login com sucesso!");
    }
    
    private void adicionarProdutor() {
        consola.escrever("Criar Novo Produtor\n\n");
        String nome = consola.lerString("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerString("Introduza a morada: ");
        LocalDate dataNasc = consola.lerData("Introduza a data de nascimento(ano-mes-dia): ");
        String username = consola.lerString("Introduza o nome de utilizador: ");
        
        //É NECESSÁRIO AO ADICIONAR UM PRODUTOR/MUSICO/aDMIN SE O SEU USERNAME AINDA NÃO ESTÁ NO SISTEMA.
        while(sistema.getUsers().verificarExisteUtilizador(username) == true){
                consola.escreverErro("Este nome de utilizador já existe, por favor insira outro!");
                username = consola.lerString("Introduza o nome de usuário: ");
        }      
        String password = consola.lerString("Introduza a palavra-chave: ");

        sistema.getUsers().adicionarUtilizador(new Produtor(username, password, nome, bi, morada, null));
        consola.escrever("Produtor adicionado com sucesso!");
    }
    
        private void adicionarAlbum() {
        consola.escrever("Adicionar um Álbum\n\n");
        String titulo = consola.lerString("Introduza o nome: ");
        String tipo = consola.lerString("Introduza o tipo: ");
        LocalDate dataEdicao = consola.lerData("Introduza a data(ano-mes-dia): ");
        
       
        sistema.getAlbuns().adicionarAlbum(new Album(titulo, dataEdicao, tipo));
        consola.escrever("Album adicionado com sucesso!");
    }
    
    private void editarDadosProdutor(){
        consola.escrever("Editar dados Produtor\n\n");
        String nome = consola.lerString("Introduza o nome:");
        
        //sistema.getUsers().adicionarUtilizador(new Produtor(username, password, nome, bi, morada, null));
    }
    
    //Ficheiro do professor
    private void guardarFicheiroUtilizadores() {
        String nomeFicheiro = "Utilizadores";
        try {
            sistema.getUsers().guardarFicheiroUtilizadores(nomeFicheiro);
            consola.escrever("Ficheiro guardado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel criar o ficheiro: "
                    + ex.getLocalizedMessage());
        }
    }
    
    private void carregarFicheiroObjectos() {
        String nomeFicheiro = "Utilizadores";
        try {
            sistema.getUsers().carregarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro carregado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel carregar o ficheiro: "
                    + ex.getMessage());
        }
    }
    
    
    
        private void adicionarMusica() {
        consola.escrever("Nova Musica\n\n");
        String titulo = consola.lerString("Introduza o nome: ");
        double duracao = consola.lerDecimal("Introduza a duração da música: ");
        int cod = consola.lerInteiro("Introduza o código da música: ");
        

        sistema.getMusicas().adicionarMusica(new Musica(titulo,duracao,cod));
        consola.escrever("Música adicionada com sucesso!");
        
        // falta colocar/ associar os artistas desta musica
    }

    private void registarAlbum() {
        int numM=0;
        consola.escrever("Registar Álbum\n\n");
        String titulo = consola.lerString("Introduza o nome: ");
        String tipo = consola.lerString("Introduza o tipo: ");
        LocalDate dataEdicao = consola.lerData("Introduza a data de edição(ano-mes-dia): ");      
        int cod = consola.lerInteiro("Introduza o código do álbum: ");
        sistema.getAlbuns().adicionarAlbum(new Album(cod, titulo, dataEdicao, tipo));
        
        numM = consola.lerInteiro("Numero de músicas do álbum: ");
        for (int i = 0; i < numM; i++) {
            boolean TF = false ;
            int codM = 0;
            while(TF == false){
            codM = consola.lerInteiro("Introduzir código da música que pretende associar a este álbum: ");
            TF = sistema.getMusicas().verificarExisteMusica(codM);
            } 
            sistema.getMusicas().associarAlbumAmusica(codM, cod);
            consola.escrever("Album adicionado com sucesso!");
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
       
        MainProdutor mainProdutor = new MainProdutor();

        int opcao;
        int opcao1;
        String[] opcoes = {
            "Adicionar utilizadores do tipo Músico e do tipo Produtor",
            "Autenticar-se como Produtor",
            "registar album",
            "Iniciar/editar a edição de um albúm(definindo as sessões de gravação necessárias)",
            "Concluir sessões de gravação",
            "Aceder a informação relativa à situação atual de um determinado album.",
            "Listar os albuns que está a produzir ou que já produziu",
            "Listar as sessões de gravação agendadas para um dia",
            "Guardar ficheiro",
            "Carregar Ficheiro",
            "Adicionar Album",
            "Sair"};

        String[] opcoes1 = {
            "Adicionar Produtor",
            "Adicionar Músico",
            "Voltar"};

        
        mainProdutor.consola.escrever("MENU AUTENTICAÇÃO\n");
        //programa.autenticarAdministrador(); funciona mas não posso tirar de comentario enquanto o ficheiro não guardar
        
        do {
            opcao = mainProdutor.consola.lerOpcoesMenusInteiros(opcoes);

            switch (opcao) {
                case 1:
                    
                    do {

                        opcao1 = mainProdutor.consola.lerOpcoesMenusInteiros(opcoes1);
                        switch (opcao1) {
                            case 1:
                                mainProdutor.adicionarProdutor();
                                break;
                            case 2:

                            case 3:
                                
                        }
                    } while (opcao1 != opcoes1.length);
                    break;
                case 2:
                    mainProdutor.autenticarProdutor();
                    break;
                case 3:
                    mainProdutor.registarAlbum();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    break;
                case 9:
                    mainProdutor.guardarFicheiroUtilizadores();
                    break;
                case 10:
                    mainProdutor.carregarFicheiroObjectos();
                    break;
                case 11:
                    mainProdutor.adicionarAlbum();
                    break;
            }
        } while (opcao != opcoes.length);
 
    }

}
