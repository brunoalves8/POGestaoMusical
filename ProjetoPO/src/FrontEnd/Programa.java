package FrontEnd;

import BackEnd.Utilizador;
import BackEnd.Musico;
import BackEnd.Produtor;
import BackEnd.Administrador;
import BackEnd.Sistema;
//import java.util.Date;

public class Programa {

    private final Sistema sistema = new Sistema();
    private final Consola consola = new Consola();

    private void autenticarAdministrador() {
        String Username = consola.lerStringEscanResposta("Username: ");
        String password = consola.lerStringEscanResposta("Password: ");

        while(sistema.getUsers().verificarExisteAdministrador(Username, password) == false) {
            consola.escreverErro("Nome de utilizador ou senha errados!");
            autenticarAdministrador();
        }
        consola.escrever("Login com sucesso!");
    }

    private void adicionarMúsico() {
        consola.escrever("Criar Novo Musico\n\n");
        String nome = consola.lerStringEscanResposta("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerStringEscanResposta("Introduza a morada: ");
        //Date. datanasc = consola.lerDecimal("Introduza o salario dia");
        String username = consola.lerStringEscanResposta("Introduza o nome de usuário: ");
        String password = consola.lerStringEscanResposta("Introduza a palavra-chave: ");

        sistema.getUsers().adicionarUtilizador(new Musico(username, password, nome, bi, morada, null));
        consola.escrever("Musico adicionado com sucesso!");
    }

    private void adicionarProdutor() {
        consola.escrever("Criar Novo Produtor\n\n");
        String nome = consola.lerStringEscanResposta("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerStringEscanResposta("Introduza a morada: ");
        //Date. datanasc = consola.lerDecimal("Introduza o salario dia");
        String username = consola.lerStringEscanResposta("Introduza o nome de usuário: ");
        String password = consola.lerStringEscanResposta("Introduza a palavra-chave: ");

        sistema.getUsers().adicionarUtilizador(new Produtor(username, password, nome, bi, morada, null));
        consola.escrever("Produtor adicionado com sucesso!");
    }

    public static void main(String[] args) {
        Programa programa = new Programa();

        int opcao;
        int opcao1;
        String[] opcoes = {
            "Adicionar utilizadores do tipo Músico e do tipo Produtor",
            "Autenticar-se como administrador",
            "Registar álbuns",
            "Registar instrumentos de música",
            "Listar os pedidos de requisição por estado (pendente, atribuído, recusado)",
            "Listar os pedidos de requisição pendentes e conceder ou recusar os mesmos",
            "CListar os álbuns em edição e o seu estado (percentagem de sessões de gravação concluídas)",
            "Mostrar estatísticas totais ou para um determinado mês: a. Total de álbuns em edição b. Média da percentagem de sessões de gravação concluídas c. Total de álbuns concluídos",
            "Sair"};

        String[] opcoes1 = {
            "Adicionar Musico",
            "Adicionar Produtor",
            "Voltar"};

        
        programa.consola.escrever("MENU AUTENTICAÇÃO\n");
        //programa.autenticarAdministrador(); funciona mas não posso tirar de comentario enquanto o ficheiro não guardar
        
        do {
            opcao = programa.consola.lerOpcoesMenusInteiros(opcoes);

            switch (opcao) {
                case 1:
                    do {

                        opcao1 = programa.consola.lerOpcoesMenusInteiros(opcoes1);
                        switch (opcao1) {
                            case 1:
                                programa.adicionarMúsico();
                                break;
                            case 2:
                                programa.adicionarProdutor();
                                break;
                            case 3:
                        }
                    } while (opcao1 != opcoes1.length);
                    break;
                case 2:
                    programa.autenticarAdministrador();
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

                    break;
                case 8:

            }
        } while (opcao != opcoes.length);

    }
}
