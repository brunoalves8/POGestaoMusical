package FrontEnd;

import BackEnd.MapUtilizadores;
import BackEnd.Musico;
import BackEnd.Produtor;
import BackEnd.Administrador;
import BackEnd.Sistema;
import BackEnd.Utilizador;
import java.io.IOException;

import java.time.LocalDate;

public class ProgramaGM {

    ////////////////////////////////////////////////////////////////////////////
    // PARTE DO BRUNO
    ////////////////////////////////////////////////////////////////////////////
    private final Sistema sistema = new Sistema();
    private final Consola consola = new Consola();

    private Utilizador autenticar() {

        String username = consola.lerString("Username: ");
        String password = consola.lerString("Password: ");

        while (sistema.getUsers().verificarExisteProdutor(username, password) == false) {
            consola.escreverErro("Nome de utilizador ou senha errados!");
            username = consola.lerString("Username: ");
            password = consola.lerString("Password: ");

        }
        consola.escrever("Login com sucesso!");
        return sistema.getUsers().consultarDadosUser(username, password);

    }

    private void adicionarMúsico() {
        consola.escrever("Criar Novo Musico\n\n");
        String nome = consola.lerString("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerString("Introduza a morada: ");
        LocalDate datanasc = LocalDate.parse(consola.lerString("Introduza a data de nascimento(ano-mes-dia): "));
        String username = consola.lerString("Introduza o nome de usuário: ");
        while(sistema.getUsers().verificarExisteUtilizador(username) == true){
            consola.escreverErro("Este nome de utilizador já existe, por favor insira outro!");
            username = consola.lerString("Introduza o nome de usuário: ");
        }
        String password = consola.lerString("Introduza a palavra-chave: ");

        sistema.getUsers().adicionarUtilizador(new Musico(username, password, nome, bi, morada, datanasc));
        consola.escrever("Musico adicionado com sucesso!");
        System.out.println(datanasc);
    }

    private void adicionarProdutor() {
        consola.escrever("Criar Novo Produtor\n\n");
        String nome = consola.lerString("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerString("Introduza a morada: ");
        LocalDate datanasc = consola.lerData("Introduza a data de nascimento(ano-mes-dia): ");
        String username = consola.lerString("Introduza o nome de utilizador: ");
        while(sistema.getUsers().verificarExisteUtilizador(username) == true){
            consola.escreverErro("Este nome de utilizador já existe, por favor insira outro!");
            username = consola.lerString("Introduza o nome de usuário: ");
        }  
        String password = consola.lerString("Introduza a palavra-chave: ");

        sistema.getUsers().adicionarUtilizador(new Produtor(username, password, nome, bi, morada, null));
        consola.escrever("Produtor adicionado com sucesso!");
    }

    private void registarAlbum() {

        consola.escrever("Registar Albúm\n\n");
        String tituloAlbm = consola.lerString("Introduza o nome da música: ");

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
    // PARTE DO KIKO
    ////////////////////////////////////////////////////////////////////////////
    private void autenticarProdutor() {

        String username = consola.lerString("Username: ");
        String password = consola.lerString("Password: ");

        while (sistema.getUsers().verificarExisteProdutor(username, password) == false) {
            consola.escreverErro("Nome de utilizador ou senha errados!");
            username = consola.lerString("Username: ");
            password = consola.lerString("Password: ");
        }
        consola.escrever("Login com sucesso!");
    }

    /*private void adicionarProdutor() {
        consola.escrever("Criar Novo Produtor\n\n");
        String nome = consola.lerString("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerString("Introduza a morada: ");
        //LocalDate dataNasc = consola.lerData("Introduza a data de nascimento(ano-mes-dia): ");
        String username = consola.lerString("Introduza o nome de utilizador: ");
        
        //É NECESSÁRIO AO ADICIONAR UM PRODUTOR/MUSICO/aDMIN SE O SEU USERNAME AINDA NÃO ESTÁ NO SISTEMA.
        while(sistema.getUsers().verificarExisteUtilizador(username) == true){
                consola.escreverErro("Este nome de utilizador já existe, por favor insira outro!");
                username = consola.lerString("Introduza o nome de usuário: ");
        }      
        String password = consola.lerString("Introduza a palavra-chave: ");

        sistema.getUsers().adicionarUtilizador(new Produtor(username, password, nome, bi, morada, null));
        consola.escrever("Produtor adicionado com sucesso!");
    }*/
    private void editarDadosProdutor() {
        consola.escrever("Editar dados Produtor\n\n");
        String nome = consola.lerString("Introduza o nome:");

        //sistema.getUsers().adicionarUtilizador(new Produtor(username, password, nome, bi, morada, null));
    }

    //Ficheiro do professor
    private void guardarFicheiroObjectos() {
        String nomeFicheiro = consola.lerString("Introduza o nome do ficheiro");
        try {
            sistema.getUsers().guardarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro guardado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel criar o ficheiro: "
                    + ex.getLocalizedMessage());
        }
    }

    private void carregarFicheiroObjectos() {
        String nomeFicheiro = consola.lerString("Introduza o nome do ficheiro");
        try {
            sistema.getUsers().carregarFicheiroObjetos(nomeFicheiro);
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

        String[] opcoesProdutor = {   
            "Ver/editar os seus dados",
            "Iniciar/editar a edição de um albúm(definindo as sessões de gravação necessárias)",
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
        programa.carregarFicheiroObjectos();
        Utilizador tipo = programa.autenticar();

        int TipoInteger = 0;
        if (tipo instanceof Musico) {
            TipoInteger = 1;
        } else if (tipo instanceof Produtor) {
            TipoInteger = 2;
        } else if (tipo instanceof Administrador) {
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
                                        programa.adicionarMúsico();
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
                            break;
                        //Registar instrumento
                        case 3:
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
                            programa.guardarFicheiroObjectos();

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
                                        
                                        break;
                                    case 2:

                                    case 3:

                                }
                            } while (opcaoP1 != opcoesProdutor1.length);
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
                        programa.guardarFicheiroObjectos();

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
                        programa.guardarFicheiroObjectos();

                    }
                }

                break;
                
        }

    }

}
