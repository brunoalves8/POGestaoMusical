package FrontEnd;

import BackEnd.MapUtilizadores;
import BackEnd.Musico;
import BackEnd.Produtor;
import BackEnd.Administrador;
import BackEnd.Album;
import BackEnd.EdicaoAlbum;
import BackEnd.Instrumento;
import BackEnd.Musica;
import BackEnd.Requisicao;
import BackEnd.Sessao;
import BackEnd.SetInstrumentos;
import BackEnd.Sistema;
import BackEnd.Utilizador;
import java.io.IOException;
import static java.lang.System.exit;

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
    while(sistema.getInstrumentos().verificarInstrumentoPorNome(nomeInstrumento) == true){
        consola.escreverErro("O instrumento introduzido já existe no sistema");
        nomeInstrumento = consola.lerString("Introduza o novamente um instrumento: ");
    }
    Instrumento instrumento = new Instrumento(nomeInstrumento);
    
    sistema.getInstrumentos().adicicionarInstrumento(instrumento);
    consola.escrever("Instrumento adicionado com sucesso!");
    }
    
    private Instrumento procurarInstrumento(){
        String nomeInstrumento = consola.lerString("Qual é o nome do instrumento que toca?");
        Instrumento instrumento = sistema.getInstrumentos().procurarInstrumentoPorNome(nomeInstrumento);
        while(instrumento == null){
            consola.escrever("O instrumento que introduziu não está no sistema\n\n");
            nomeInstrumento = consola.lerString("Qual é o nome do instrumento que toca?");
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
        String nomeMusico = consola.lerString("Qual o nome do músico?");
        Musico musico = sistema.getUsers().procurarMusicosPorNome(nomeMusico);
        while(musico == null){
            consola.escrever("O músico que introduziu não está no sistema\n\n");
            nomeMusico = consola.lerString("Qual é o nome do músico que pretende adicionar?");
            musico = sistema.getUsers().procurarMusicosPorNome(nomeMusico);
        }
        return musico;
    }
    
    //ALBUM
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
        int codigo = consola.lerInteiro("Introduza um código para o álbum:");
        while(sistema.getAlbuns().verificarAlbumPorCod(codigo) == true){
            consola.escreverErro("Este codigo já está associado a outro álbum, por favor insira outro!");
            codigo = consola.lerInteiro("Introduza um novo código: ");
        } 
        String tipo = consola.lerString("Introduza o tipo: ");
        LocalDate dataEdicao = consola.lerData("Introduza a data de edição(ano-mes-dia): ");      
        int numMusicas = consola.lerInteiro("Por quantas músicas é composto o álbum?");
        Collection<Musica> musicas = new HashSet<>(); 
        for(int i = 0; i< numMusicas; i++){
          musicas.add(criarMusica());
        }
        Album album = new Album(codigo,titulo, dataEdicao, tipo, musicas);
        sistema.getAlbuns().adicionarAlbum(album);

    }
    
    
    public void listarInstrumentos(){
        consola.escrever(sistema.getInstrumentos().toString());
    }
    
    //Ponto 3 produtor
   /* private Sessao criarSessao() {
        consola.escrever("Nova Sessão\n\n");
        String titulo = consola.lerString("Introduza o nome: ");
        //int numDias = consola.lerInteiro("Quantos dias necessita para gravar o álbum?");
        LocalDate dataEdicao = consola.lerData("Em que dia pretende gravar o álbum?(aaaa-mm-dd)");
        for(int i = 0; i<numDias; i++){
            LocalDate dataEdicao = consola.lerData("Em que dia pretende gravar o álbum?(aaaa-mm-dd)");
        }
        Sessao sessao = new Sessao(titulo, dataEdicao);
        Collection<Requisicao> requisicoes = new HashSet<>();
        String opcao = consola.lerString("Pretende requisitar instrumentos?(s/n)");
        if("s".equals(opcao)){
            int numInstrumentos = consola.lerInteiro("Quantos instrumentos pretende requisitar?");
                for(int i = 0; i<numInstrumentos; i++){
                    requisicoes.add(procurarInstrumento());
                } 
        }
        sistema.getSessoes().adicionarSessao(sessao);
        consola.escrever("Música criada com sucesso!");      
        
    }*/
            
    private Album procurarAlbum(){
        String tituloAlbum = consola.lerString("Qual é o nome do álbum que pretende consultar?");
        Album album = sistema.getAlbuns().procurarAlbumPorTitulo(tituloAlbum);
        while(album == null){
            consola.escreverErro("O álbum que introduziu não está no sistema\n\n");
            tituloAlbum = consola.lerString("Qual é o nome do álbum que pretende consultar?");
            album = sistema.getAlbuns().procurarAlbumPorTitulo(tituloAlbum);
        }
        return album;
    }
    
    private Album procurarAlbumPorCod(){
        int codigo = consola.lerInteiro("Qual é o cod do álbum que pretende consultar?");
        Album album = sistema.getAlbuns().procurarAlbumPorCod(codigo);
        while(album == null){
            consola.escreverErro("O codigo que introduziu não corresponde a nenhum álbum do sistema\n\n");
            codigo = consola.lerInteiro("Qual é o cod do álbum que pretende consultar?");
            album = sistema.getAlbuns().procurarAlbumPorCod(codigo);
        }
        return album;
    }
    
    
    private Album procurarAlbumParaConcluirSessao(){
        String tituloAlbum = consola.lerString("Qual é o nome do álbum que pretende concluir sessão?");
        Album album = sistema.getAlbuns().procurarAlbumPorTitulo(tituloAlbum);
        while(album == null){
            consola.escrever("O álbum que introduziu não está no sistema\n\n");
            tituloAlbum = consola.lerString("Qual é o nome do álbum que pretende concluir sessão?");
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
    
    private void iniciarEdicaoAlbumDefinindoSessoes(Produtor utilizador){
        consola.escrever("Edição de Álbum\n\n");
        Album album = procurarAlbum();
        EdicaoAlbum edicaoAlbum = new EdicaoAlbum(album, utilizador);
        sistema.getEdicoesAlbum().adicionarEdicaoAlbum(edicaoAlbum);
        consola.escrever("\nDefinir sessoes\n");
        int numDias = consola.lerInteiro("Quantos dias necessita para gravar o álbum?");
        //LocalDate dataEdicao = consola.lerData("Em que dia pretende gravar o álbum?(aaaa-mm-dd)");
        for(int i = 0; i<numDias; i++){
            LocalDate dataEdicao = consola.lerData("Em que dia pretende gravar o álbum?(aaaa-mm-dd)");
            while(sistema.getSessoes().verificarExisteSessao(dataEdicao) == true){
                consola.escreverErro("Já existe uma sessão marcada para esse dia");
                dataEdicao = consola.lerData("Introduza um dia diferente do anterior(aaaa-mm-dd)");
            }
            Sessao sessao = new Sessao(edicaoAlbum, dataEdicao, false);
            sistema.getSessoes().adicionarSessao(sessao);
        }
        consola.escrever("Sessões agendadas com sucesso!");
    }
    //Ponto 4 PRODUTOR (Concluir Sessoes)
    public void concluirSessaoGravacao(Produtor utilizador){
        consola.escrever("Concluir Sessao de Gravação\n\n");
        //Album album = procurarAlbumParaConcluirSessao();
        LocalDate dataSessao = consola.lerData("Qual é a data da sessão que pretende concluir?(aaaa-mm-dd)");
        while(sistema.getSessoes().verificarExisteSessao(dataSessao) == false){
            consola.escreverErro("Esse álbum não tem nenhuma sessão agendada para esse dia!");
            dataSessao = consola.lerData("Introduza outra data(aaaa-mm-dd):");
        }
        sistema.getSessoes().procurarSessaoParaEditar(dataSessao).setSessaoConcluida(true);
        consola.escrever("Sessao concluida com sucesso");  
    }
    
    
    
    //Listar Sessoes
    
    public Collection<Album> listarAlbunsDoMusico(Musico musico){
       consola.escrever("Àlbuns em que está presente");
    }
    
    public String listarSessoesAgendadas(){
       consola.escrever("Sessões Agendadas");
       return sistema.getSessoes().listarSessoesAgendadas().toString();
       
    }
    
    public String listarSessoesConcluidas(){
       consola.escrever("Sessões Agendadas");
       return sistema.getSessoes().listarSessoesConcluidas().toString();
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
    //Guardar e carregar ficheiros Utilizadores
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
    
    //Guardar e carregar ficheiros Instrumentos
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
    
    //Guardar e carregar ficheiros Albuns
    private void guardarFicheiroAlbuns() {
        String nomeFicheiro = "Albuns";
        try {
            sistema.getAlbuns().guardarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro guardado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel criar o ficheiro: "
                    + ex.getLocalizedMessage());
        }
    }
    
    private void carregarFicheiroAlbuns() {
        String nomeFicheiro = "Albuns";
        try {
            sistema.getAlbuns().carregarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro carregado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel carregar o ficheiro: "
                    + ex.getMessage());
        }
    }
    
    //Guardar e carregar ficheiros Sessoes
    private void guardarFicheiroSessoes() {
        String nomeFicheiro = "Sessoes";
        try {
            sistema.getSessoes().guardarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro guardado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel criar o ficheiro: "
                    + ex.getLocalizedMessage());
        }
    }
    
    private void carregarFicheiroSessoes() {
        String nomeFicheiro = "Sessoes";
        try {
            sistema.getSessoes().carregarFicheiroObjetos(nomeFicheiro);
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
            "Listar Instrumentos",
            "Guardar Ficheiros",
            "Carregar Ficheiros",
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
        
        String[] opcoesMusico5 = {
            "Ver Sessoes Agendadas",
            "Ver Sessoes Concluidas",
            "Voltar"
        };

        programa.consola.escrever("MENU AUTENTICAÇÃO\n");
        
        programa.carregarFicheiroAlbuns();
        programa.carregarFicheiroInstrumentos();
        programa.carregarFicheiroUtilizadores();
        programa.carregarFicheiroSessoes();
        
        
        
        
        //Criar Administardores
        Utilizador admin = new Administrador("admin", "admin", "administrador",5,"Rua", null);
        programa.sistema.getUsers().adicionarUtilizador(admin);
        //Criar Produtoes
        Utilizador prod = new Produtor("prod", "prod", "produtor",4,"Rua", null);
        programa.sistema.getUsers().adicionarUtilizador(prod);
        // Criar Músicos eInstrumentos
        Instrumento inst = new Instrumento("Piano");
        programa.sistema.getInstrumentos().adicicionarInstrumento(inst);
        Instrumento inst2 = new Instrumento("Guitarra");
        programa.sistema.getInstrumentos().adicicionarInstrumento(inst2);
        Instrumento inst3 = new Instrumento("Violino");
        programa.sistema.getInstrumentos().adicicionarInstrumento(inst3);
        Instrumento inst4 = new Instrumento("Pandeireta");
        programa.sistema.getInstrumentos().adicicionarInstrumento(inst4);
        Instrumento inst5 = new Instrumento("Violao");
        programa.sistema.getInstrumentos().adicicionarInstrumento(inst5);
        
        Collection<Instrumento> instrumentosMus1 = new HashSet<>();
        instrumentosMus1.add(inst);
        instrumentosMus1.add(inst2);
        Utilizador mus = new Musico("drake", "drake", "Drake", 1, "Rua", null, instrumentosMus1);
        programa.sistema.getUsers().adicionarUtilizador(mus);
        
        Collection<Instrumento> instrumentosMus2 = new HashSet<>();
        instrumentosMus2.add(inst3);
        instrumentosMus2.add(inst4);       
        Utilizador mus2 = new Musico("ye", "ye", "Kayne West", 2, "Rua", null, instrumentosMus2);
        programa.sistema.getUsers().adicionarUtilizador(mus2);
        
        Collection<Instrumento> instrumentosMus3 = new HashSet<>();
        instrumentosMus3.add(inst5);       
        Utilizador mus3 = new Musico("rhianna", "rhianna", "Rhianna", 3, "Rua", null, instrumentosMus3);
        programa.sistema.getUsers().adicionarUtilizador(mus3);
        
        //Criar Albúm e Musicas
        Collection<Musico> musicos = new HashSet<>();
        musicos.add((Musico) mus2);
        musicos.add((Musico) mus3);
        
        Collection<Musico> musicos2 = new HashSet<>();
        musicos.add((Musico) mus);
        Musica musica = new Musica("Behind Barz",234,musicos);
        programa.sistema.getMusicas().adicionarMusica(musica);
        Musica musica2 = new Musica("Jimmy Cooks",234,musicos2);
        programa.sistema.getMusicas().adicionarMusica(musica2);
        
        Collection<Musica> musicasAlbm1 = new HashSet<>();
        musicasAlbm1.add(musica);
        musicasAlbm1.add(musica2);
  
        Album albm = new Album(12345,"Donda",null,"Rap",musicasAlbm1);
        programa.sistema.getAlbuns().adicionarAlbum(albm);
        
        
        
        
        
        
        
        
        
        
        
        
        
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
                                    programa.guardarFicheiroAlbuns();
                                    programa.guardarFicheiroInstrumentos();
                                    programa.guardarFicheiroUtilizadores();
                                    programa.guardarFicheiroSessoes();

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
                            programa.listarInstrumentos();
                            break;
                        //
                        case 5:
                            programa.guardarFicheiroAlbuns();
                            programa.guardarFicheiroInstrumentos();
                            programa.guardarFicheiroUtilizadores();
                            programa.guardarFicheiroSessoes();
                            break;
                        //
                        case 6:
                            programa.carregarFicheiroAlbuns();
                            programa.carregarFicheiroInstrumentos();
                            programa.carregarFicheiroUtilizadores();
                            break;
                        //
                        case 7:
                            break;
                        //
                        case 8:
                            programa.guardarFicheiroAlbuns();
                            programa.guardarFicheiroInstrumentos();
                            programa.guardarFicheiroUtilizadores();
                            programa.guardarFicheiroSessoes();

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
                                    programa.guardarFicheiroAlbuns();
                                    programa.guardarFicheiroInstrumentos();
                                    programa.guardarFicheiroUtilizadores();
                                    programa.guardarFicheiroSessoes();

                                }
                            } while (opcaoP1 != opcoesProdutor1.length);
                            break;
                        case 2:
                            programa.iniciarEdicaoAlbumDefinindoSessoes((Produtor) utilizador);
                            break;
                        case 3:
                            programa.concluirSessaoGravacao((Produtor) utilizador);
                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:
                            break;
                        case 7:
                        programa.guardarFicheiroAlbuns();
                        programa.guardarFicheiroInstrumentos();
                        programa.guardarFicheiroUtilizadores();
                        programa.guardarFicheiroSessoes();

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
                            int opcaoM5 = 0;
                            do {

                                opcaoM5 = programa.consola.lerOpcoesMenusInteiros(opcoesMusico5);
                                switch (opcaoM5) {
                                    case 1:
                                        programa.listarSessoesAgendadas();
                                        break;
                                    case 2:
                                        programa.listarSessoesConcluidas();
                                        break;
                                    case 3:

                                }
                            } while (opcaoM5 != opcoesMusico1.length);
                            break;
                        case 6:
                        programa.guardarFicheiroAlbuns();
                        programa.guardarFicheiroInstrumentos();
                        programa.guardarFicheiroUtilizadores();
                        programa.guardarFicheiroSessoes();
                        exit(0);

                    }
                }

                break;
                
        }

    }

}
