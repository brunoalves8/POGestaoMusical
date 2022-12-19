package FrontEnd;

/*import BackEnd.Utilizador;
import BackEnd.*/
import BackEnd.Administrador;
import BackEnd.Sistema;
//import java.util.Date;

public class Programa {

    private final Sistema sistema = new Sistema();
    private final Consola consola = new Consola();

    private void autenticarAdministrador() {
        String Username = consola.lerStringEscanResposta("Username: ");
        String password = consola.lerStringEscanResposta("Password: ");

        if (sistema.getUsers().verificarExisteAdministrador(Username, password) == true) {
            consola.escrever("Login com sucesso!");
        } else {
            consola.escreverErro("Nome de utiliazdor ou palavra-chave errados!");
            autenticarAdministrador();
        }
    }

    private void adicionarAdministrador() {
        consola.escrever("Criar Novo Administrador");
        String nome = consola.lerStringEscanResposta("Introduza o nome. ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerStringEscanResposta("Introduza a morada: ");
        //Date. datanasc = consola.lerDecimal("Introduza o salario dia");
        String username = consola.lerStringEscanResposta("Introduza o nome de usuário: ");
        String password = consola.lerStringEscanResposta("Introduza a palavra-chave: ");
        
        sistema.getUsers().adicionarUtilizador(new Administrador(username,password,nome,bi,morada,null));
    }

    public static void main(String[] args) {
        Programa programa = new Programa();

        int opcao;
        String[] opcoes = {
            "Autenticar-se como administrador",
            "Adicionar utilizadores do tipo Músico e do tipo Produtor",
            "Registar álbuns",
            "Registar instrumentos de música",
            "Listar os pedidos de requisição por estado (pendente, atribuído, recusado)",
            "Listar os pedidos de requisição pendentes e conceder ou recusar os mesmos",
            "CListar os álbuns em edição e o seu estado (percentagem de sessões de gravação concluídas)",
            "Mostrar estatísticas totais ou para um determinado mês: a. Total de álbuns em edição b. Média da percentagem de sessões de gravação concluídas c. Total de álbuns concluídos",
            "Sair"};

        do {
            opcao = programa.consola.lerOpcoesMenusInteiros(opcoes);

            switch (opcao) {
                case 1:
                   
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
  
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
 
            }
        } while (opcao != opcoes.length);

    }
}

