package FrontEnd;

import BackEnd.MapUtilizadores;
import BackEnd.Produtor;
import BackEnd.Sistema;
import java.io.IOException;

import java.time.LocalDate;

public class MainProdutor {

    private final Sistema sistema = new Sistema();
    private final Consola consola = new Consola();

    private void autenticarProdutor() {
        
       String username = consola.lerString("Username: ");
       String password = consola.lerString("Password: ");
       
        while(sistema.getUsers().verificarExisteProdutor(username, password) == false) {
            consola.escreverErro("Nome de utilizador ou senha errados!");
            autenticarProdutor();
        }
        consola.escrever("Login com sucesso!");
    }
        //TENTATIVAS DE TRY CATCH!!!!!!
 /*   private boolean autenticarProdutor1(String username, String password) {
        
      //  String username = consola.lerString("Username: ");
        //String password = consola.lerString("Password: ");
        if(sistema.getUsers().verificarExisteUtilizador(username)){
            try{
                String username = consola.lerString("Username: ");
                if(password == sistena.get)
            }
            catch(Exception e){
            }
        }
        return false;
        }
/*
        while(sistema.getUsers().verificarExisteProdutor(username, password) == false) {
            consola.escreverErro("Nome de utilizador ou senha errados!");
            autenticarProdutor();
        }
        consola.escrever("Login com sucesso!");*/

    private void adicionarProdutor() {
        consola.escrever("Criar Novo Produtor\n\n");
        String nome = consola.lerString("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        String morada = consola.lerString("Introduza a morada: ");
        LocalDate dataNasc = consola.lerData("Introduza a data de nascimento(ano-mes-dia): ");
        String username = consola.lerString("Introduza o nome de usuário: ");
            
        //É NECESSÁRIO AO ADICIONAR UM PRODUTOR/MUSICO/aDMIN SE O SEU USERNAME AINDA NÃO ESTÁ NO SISTEMA.
 /*       while(sistema.getUsers().verificarExisteUtilizador(username) == true){
                consola.escreverErro("Este nome de utilizador já existe, por favor insira outro!");
                String username = consola.lerString("Introduza o nome de usuário: ");
            }*/
        String password = consola.lerString("Introduza a palavra-chave: ");

        sistema.getUsers().adicionarUtilizador(new Produtor(username, password, nome, bi, morada, dataNasc));
        consola.escrever("Produtor adicionado com sucesso!");
    }
    
    private void editarDadosProdutor(){
        consola.escrever("Editar dados Produtor\n\n");
        String nome = consola.lerString("Introduza o nome:");
        
        
        
        
        //sistema.getUsers().adicionarUtilizador(new Produtor(username, password, nome, bi, morada, null));
    }

    
    public static void main(String[] args) {
        
        MainProdutor mainProdutor = new MainProdutor();

        int opcao;
        int opcao1;
        String[] opcoes = {
            "Adicionar utilizadores do tipo Músico e do tipo Produtor",
            "Autenticar-se como Produtor",
            "Ver/editar os seus dados",
            "Iniciar/editar a edição de um albúm(definindo as sessões de gravação necessárias)",
            "Concluir sessões de gravação",
            "Aceder a informação relativa à situação atual de um determinado album.",
            "Listar os albuns que está a produzir ou que já produziu",
            "Listar as sessões de gravação agendadas para um dia",
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
