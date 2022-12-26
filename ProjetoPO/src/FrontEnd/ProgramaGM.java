package FrontEnd;

import BackEnd.MapUtilizadores;
import BackEnd.Musico;
import BackEnd.Produtor;
import BackEnd.Administrador;
import BackEnd.Album;
import BackEnd.EdicaoAlbum;
import BackEnd.Instrumento;
import BackEnd.Musica;
import BackEnd.SetInstrumentos;
import BackEnd.Sistema;
import BackEnd.Utilizador;
import java.io.IOException;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class ProgramaGM {

    ////////////////////////////////////////////////////////////////////////////
    // PARTE DO BRUNO
    ////////////////////////////////////////////////////////////////////////////
    private final Sistema sistema = new Sistema();
    private final Consola consola = new Consola();

    private Utilizador autenticar() {

        String username = consola.lerString("Username: ");
        String password = consola.lerString("Password: ");

        while (sistema.getUsers().verificarExisteUser(username, password) == false) {
            consola.escreverErro("Nome de utilizador ou senha errados!");
            username = consola.lerString("Username: ");
            password = consola.lerString("Password: ");

        }
        consola.escrever("Login com sucesso!");
        return sistema.getUsers().consultarDadosUser(username, password);

    }

    public void adicionarInstrumento(){
    consola.escrever("Criar Novo Instrumento");
    String nomeInstrumento = consola.lerString("Introduza o nome do instrumento: ");
    Instrumento instrumento = new Instrumento(nomeInstrumento);
    
    sistema.getInstrumentos().adicicionarInstrumento(instrumento);
    consola.escrever("Instrumento adicionado com sucesso!");
    }
    
    private Instrumento procurarInstrumento(){
        String nomeInstrumento = consola.lerString("Qual é o nome do instrumento que pretende adicionar?");
        Instrumento instrumento = sistema.getInstrumentos().procurarInstrumentoPorNome(nomeInstrumento);
        while(instrumento == null){
            consola.escrever("O instrumento que introduziu não está no sistema\n\n");
            nomeInstrumento = consola.lerString("Qual é o nome do instrumento que pretende adicionar?");
            instrumento = sistema.getInstrumentos().procurarInstrumentoPorNome(nomeInstrumento);
        }
        return instrumento;
    }
    
    
    
    //######################################ADICIONAR MUSICO KIKO###############################################
    
    private void adicionarMusico() {
        consola.escrever("Criar Novo Musico\n\n");
        String nome = consola.lerString("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerString("Introduza a morada: ");
        LocalDate dataNasc = consola.lerData("Introduza a data de nascimento(ano-mes-dia): ");
        String username = consola.lerString("Introduza o nome de utilizador: ");
        
        while(sistema.getUsers().verificarExisteUtilizador(username) == true){        //É NECESSÁRIO AO ADICIONAR UM PRODUTOR/MUSICO/aDMIN SE O SEU USERNAME AINDA NÃO ESTÁ NO SISTEMA.
                consola.escreverErro("Este nome de utilizador já existe, por favor insira outro!");
                username = consola.lerString("Introduza o nome de usuário: ");
        }      
        String password = consola.lerString("Introduza a palavra-chave: ");
        int numInstrumentos = consola.lerInteiro("Quantos instrumentos toca o músico:");
        Collection<Instrumento> instrumentos = new HashSet<>();
        for (int i = 0; i < numInstrumentos; i++) {
            instrumentos.add(procurarInstrumento());
        }
        sistema.getUsers().adicionarUtilizador(new Musico(username, password, nome, bi, morada, dataNasc, instrumentos ));
        consola.escrever("Musico adicionado com sucesso!");
    }
  /*  
    private void adicionarMusico() {
        consola.escrever("Criar Novo Musico\n\n");
        String nome = consola.lerString("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerString("Introduza a morada: ");
        LocalDate dataNasc = consola.lerData("Introduza a data de nascimento(ano-mes-dia): ");
        String username = consola.lerString("Introduza o nome de utilizador: ");
        
        while(sistema.getUsers().verificarExisteUtilizador(username) == true){        //É NECESSÁRIO AO ADICIONAR UM PRODUTOR/MUSICO/aDMIN SE O SEU USERNAME AINDA NÃO ESTÁ NO SISTEMA.
                consola.escreverErro("Este nome de utilizador já existe, por favor insira outro!");
                username = consola.lerString("Introduza o nome de usuário: ");
        }      
        String password = consola.lerString("Introduza a palavra-chave: ");
        consola.escrever("Insira os instrumentos que o músico toca:");
        String nomeInstrumento = consola.lerString("Introduza o nome do instrumento: ");
        String tipoInstrumento = consola.lerString("Introduza o tipo do instrumento: ");
        String marcaInstrumento = consola.lerString("Introduza a marca do instrumento: ");
        String modeloInstrumento = consola.lerString("Introduza o modelo do instrumento: ");
        Instrumento instrumento = new Instrumento(nomeInstrumento);
        Collection<Instrumento> instrumentos = new HashSet<>();
        instrumentos.add(instrumento);
        sistema.getUsers().adicionarUtilizador(new Musico(username, password, nome, bi, morada, dataNasc, instrumentos ));
        
        sistema.getInstrumentos().adicicionarInstrumento(instrumento);
        consola.escrever("Musico adicionado com sucesso!");
    }
*/
    private void adicionarProdutor() {
        consola.escrever("Criar Novo Produtor\n\n");
        String nome = consola.lerString("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerString("Introduza a morada: ");
        LocalDate dataNascimento = consola.lerData("Introduza a data de nascimento(ano-mes-dia): ");
        String username = consola.lerString("Introduza o nome de utilizador: ");
        while(sistema.getUsers().verificarExisteUtilizador(username) == true){
            consola.escreverErro("Este nome de utilizador já existe, por favor insira outro!");
            username = consola.lerString("Introduza o nome de usuário: ");
        }  
        String password = consola.lerString("Introduza a palavra-chave: ");

        sistema.getUsers().adicionarUtilizador(new Produtor(username, password, nome, bi, morada, dataNascimento));
        consola.escrever("Produtor adicionado com sucesso!");
    }
    
    private Musico procurarMusico(){
        String nomeMusico = consola.lerString("Qual é o nome do músico que pretende adicionar?");
        Musico musico = sistema.getUsers().procurarMusicosPorNome(nomeMusico);
        while(musico == null){
            consola.escrever("O músico que introduziu não está no sistema\n\n");
            nomeMusico = consola.lerString("Qual é o nome do músico que pretende adicionar?");
            musico = sistema.getUsers().procurarMusicosPorNome(nomeMusico);
        }
        return musico;
    }
    
    private Musica criarMusica() {
        consola.escrever("Nova Musica\n\n");
        String titulo = consola.lerString("Introduza o nome: ");
        int duracao = consola.lerInteiro("Introduza a duração da música: ");
        int numMusicos = consola.lerInteiro("Quantos músicos fazem parte da música?");
        Collection<Musico> musicos = new HashSet<>();
        for(int i = 0; i<numMusicos; i++){
            musicos.add(procurarMusico());
        } 
        Musica musica = new Musica(titulo, duracao, musicos);
        consola.escrever("Música criada com sucesso!");      
        return musica;
    }
    
    private void registarAlbum() {
        consola.escrever("Registar Álbum\n\n");
        String titulo = consola.lerString("Introduza o nome: ");
        String tipo = consola.lerString("Introduza o tipo: ");
        LocalDate dataEdicao = consola.lerData("Introduza a data de edição(ano-mes-dia): ");      
        Album album = new Album(titulo, dataEdicao, tipo);
        int numMusicas = consola.lerInteiro("Quantas músicas pretende adicionar ao álbum?");
        Collection<Musica> musicas = new HashSet<>(); 
        for(int i = 0; i< numMusicas; i++){
          musicas.add(criarMusica());
        }
        
        sistema.getAlbuns().adicionarAlbum(album);

    }
    
    //Ponto 3 produtor
    
    private Album procurarAlbum(){
        String tituloAlbum = consola.lerString("Qual é o nome do álbum que pretende editar?");
        Album album = sistema.getAlbuns().procurarAlbumPorTitulo(tituloAlbum);
        while(album == null){
            consola.escrever("O álbum que introduziu não está no sistema\n\n");
            tituloAlbum = consola.lerString("Qual é o nome do álbum que pretende editar?");
            album = sistema.getAlbuns().procurarAlbumPorTitulo(tituloAlbum);
        }
        return album;
    }
    
    private void iniciarEdicaoAlbum(Produtor utilizador){
        consola.escrever("Edição de Álbum\n\n");
        Album album = procurarAlbum();
        EdicaoAlbum edicaoAlbum = new EdicaoAlbum(album, utilizador);
        sistema.getEdicoesAlbum().adicionarEdicaoAlbum(edicaoAlbum);
    }
  
////////////////////////////////////////////Kiko////////////////////////////////////////////////////////////
    private void consultarDadosProdutor(Produtor produtor){
        consola.escrever("Dados do Produtor\n");
        consola.escrever(produtor.toString());
    }
    
    private void consultarDadosMusico(Musico musico){
        consola.escrever("Dados do Músico\n");
        consola.escrever(musico.toString());
    }
    
    private void editarDadosProdutor(Produtor produtor) {
        consola.escrever("Editar dados Produtor\n\n");
        String nome = consola.lerString("Introduza o nome:");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerString("Introduza a morada: ");
        LocalDate dataNascimento = consola.lerData("Introduza a data de nascimento(ano-mes-dia): ");
        //sistema.getUsers().editarDadosProdutor(produtor);
        sistema.getUsers().atualizarProdutor(new Produtor(nome, bi, morada, dataNascimento));
        consola.escrever("Dados editados com sucesso!");
    }

    //Fonte:Guardar e Carregar ficheiro do professor TPS
    private void guardarFicheiroUtilizadores() {
        String nomeFicheiro = "Utilizadores";
        try {
            sistema.getUsers().guardarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro guardado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel criar o ficheiro: "
                    + ex.getLocalizedMessage());
        }
    }
    
    private void carregarFicheiroUtilizadores() {
        String nomeFicheiro = "Utilizadores";
        try {
            sistema.getUsers().carregarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro carregado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel carregar o ficheiro: "
                    + ex.getMessage());
        }
    }
    
    
    private void guardarFicheiroInstrumentos() {
        String nomeFicheiro = "Instrumentos";
        try {
            sistema.getInstrumentos().guardarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro guardado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel criar o ficheiro: "
                    + ex.getLocalizedMessage());
        }
    }
    
    private void carregarFicheiroInstrumentos() {
        String nomeFicheiro = "Instrumentos";
        try {
            sistema.getInstrumentos().carregarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro carregado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel carregar o ficheiro: "
                    + ex.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    // PARTE DA MARIANA
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////   
    public static void main(String[] args) {

        ProgramaGM programa = new ProgramaGM();
        
        String[] opcoesAdministrador = {
            "Adicionar Músico/Produtor",
            "Registar Álbum",
            "Registar instrumentos de música",
            "Listar os pedidos de requisição por estado (pendente, atribuído, recusado)",
            "Listar os pedidos de requisição pendentes e conceder ou recusar os mesmos",
            "CListar os álbuns em edição e o seu estado (percentagem de sessões de gravação concluídas)",
            "Mostrar estatísticas totais ou para um determinado mês: a. Total de álbuns em edição b. Média da percentagem de sessões de gravação concluídas c. Total de álbuns concluídos",
            "Sair"};

        String[] opcoesAdministrador1 = {
            "Adicionar Musico",
            "Adicionar Produtor",
            "Voltar"};
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

        /*String[] opcoesProdutor = {   
            "Ver/editar os seus dados",
            "Registar Album",
            "Iniciar/editar a edição de um albúm(definindo as sessões de gravação necessárias)",
            "Concluir sessões de gravação",
            "Aceder a informação relativa à situação atual de um determinado album.",
            "Listar os albuns que está a produzir ou que já produziu",
            "Listar as sessões de gravação agendadas para um dia",
            "Sair"};
*/
        //Opcoes teste
        String[] opcoesProdutor = {   
            "Ver/editar os seus dados",
            "Iniciar/editar a edição de um álbum, definindo as sessões de gravação necessárias",
            "Concluir sessões de gravação",
            "Aceder a informação relativa à situação atual de um determinado album.",
            "Listar os albuns que está a produzir ou que já produziu",
            "Listar as sessões de gravação agendadas para um dia",
            "Sair"};
        
        String[] opcoesProdutor1 = {
            "Ver dados Produtor",
            "Editar dados Produtor",
            "Voltar"
        };
        
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

        String[] opcoesMusico = {   
            "Ver/editar os seus dados",
            "Ver albuns a que esta associado",
            "Ver as sessoes gravações que tem agendadas",
            "Fazer a requisição de instrumentos para uma determinada sessão",
            "Ver o estado das sessoes de gravação",
            "Sair"};

        String[] opcoesMusico1 = {
            "Ver dados Produtor",
            "Editar dados Produtor",
            "Voltar"
        };

        programa.consola.escrever("MENU AUTENTICAÇÃO\n");
        
        programa.carregarFicheiroInstrumentos();
        programa.carregarFicheiroUtilizadores();
        Utilizador admin = new Administrador("admin", "admin");
        programa.sistema.getUsers().adicionarUtilizador(admin);
        Utilizador utilizador = programa.autenticar();

        int TipoInteger = 0;
        if (utilizador instanceof Administrador) {
            TipoInteger = 1;
        } else if (utilizador instanceof Produtor) {
            TipoInteger = 2;
        } else if (utilizador instanceof Musico) {
            TipoInteger = 3;
        }

        switch (TipoInteger) {
            //Administrador
            case 1:
                int opcaoA = 0;
                while (opcaoA != opcoesAdministrador.length) {
                    opcaoA = programa.consola.lerOpcoesMenusInteiros(opcoesAdministrador);
                    switch (opcaoA) {
                        //Adicionar Musico/Produtor
                        case 1: {
                            int opcao1;
                            do {
                                opcao1 = programa.consola.lerOpcoesMenusInteiros(opcoesAdministrador1);
                                switch (opcao1) {
                                    case 1:
                                        programa.adicionarMusico();
                                        break;
                                    case 2:
                                        programa.adicionarProdutor();
                                        break;
                                    case 3:

                                }
                            } while (opcao1 != opcoesAdministrador1.length);
                        }
                        break;
                        //Registar Álbum
                        case 2:
                            programa.registarAlbum();
                            break;
                        //Registar instrumento
                        case 3:
                            programa.adicionarInstrumento();
                            break;
                        //Listar os pedidos de requisição por estado (pendente, atribuído, recusado)
                        case 4:
                            break;
                        //
                        case 5:
                            break;
                        //
                        case 6:
                            break;
                        //
                        case 7:
                            break;
                        //
                        case 8:
                            programa.guardarFicheiroInstrumentos();
                            programa.guardarFicheiroUtilizadores();

                    }
                }
                break;
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////           
    //Produtor
            case 2:
                int opcaoP = 0;
                 while (opcoesProdutor.length != opcaoP){
                    opcaoP = programa.consola.lerOpcoesMenusInteiros(opcoesProdutor);

                    switch (opcaoP) {
                        case 1:
                            int opcaoP1 = 0;
                            do {

                                opcaoP1 = programa.consola.lerOpcoesMenusInteiros(opcoesProdutor1);
                                switch (opcaoP1) {
                                    case 1:
                                        programa.consultarDadosProdutor((Produtor) utilizador);
                                        break;
                                    case 2:
                                        programa.editarDadosProdutor((Produtor)utilizador);
                                        break;
                                    case 3:

                                }
                            } while (opcaoP1 != opcoesProdutor1.length);
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            programa.iniciarEdicaoAlbum((Produtor) utilizador);
                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:
                        programa.guardarFicheiroUtilizadores();

                    }
                }

                break;
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    //Musico
            case 3:
                int opcaoM = 0;
                 while (opcoesProdutor.length != opcaoM){
                    opcaoM = programa.consola.lerOpcoesMenusInteiros(opcoesMusico);

                    switch (opcaoM) {
                        case 1:
                            int opcaoM1 = 0;
                            do {

                                opcaoM1 = programa.consola.lerOpcoesMenusInteiros(opcoesMusico1);
                                switch (opcaoM1) {
                                    case 1:
                                        programa.consultarDadosMusico((Musico) utilizador);
                                        break;
                                    case 2:

                                    case 3:

                                }
                            } while (opcaoM1 != opcoesMusico1.length);
                            break;
                        case 2:
                            
                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:

                            break;
                        case 7:
                        programa.guardarFicheiroInstrumentos();
                        programa.guardarFicheiroUtilizadores();

                    }
                }

                break;
                
        }

    }

}
