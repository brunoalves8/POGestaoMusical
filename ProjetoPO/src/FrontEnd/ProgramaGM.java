package FrontEnd;

import BackEnd.Musico;
import BackEnd.Produtor;
import BackEnd.Administrador;
import BackEnd.Album;
import BackEnd.EdicaoAlbum;
import BackEnd.Instrumento;
import BackEnd.Musica;
import BackEnd.Requisicao;
import BackEnd.Sessao;
import BackEnd.Sistema;
import BackEnd.Utilizador;
import java.io.IOException;
import static java.lang.System.exit;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class ProgramaGM {

    private final Sistema sistema = new Sistema();
    private final Consola consola = new Consola();

    public static final String ANSI_VERDE = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

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

    //Instrumento
    public void adicionarInstrumento() {
        consola.escrever("Criar Novo Instrumento\n\n");
        String nomeInstrumento = consola.lerString("Introduza o nome do instrumento: ");
        while (sistema.getInstrumentos().verificarInstrumentoPorNome(nomeInstrumento) == true) {
            consola.escreverErro("O instrumento introduzido já existe no sistema");
            consola.escrever("\n");
            nomeInstrumento = consola.lerString("Introduza novamente o nome do instrumento: ");
        }
        Instrumento instrumento = new Instrumento(nomeInstrumento);

        sistema.getInstrumentos().adicicionarInstrumento(instrumento);
        consola.escrever("\n" + ANSI_VERDE + "Instrumento adicionado com sucesso!" + ANSI_RESET);
    }

    private Instrumento procurarInstrumento() {
        String nomeInstrumento = consola.lerString("Nome do instrumento que toca: ");
        Instrumento instrumento = sistema.getInstrumentos().procurarInstrumentoPorNome(nomeInstrumento);
        while (instrumento == null) {
            consola.escreverErro("O instrumento que introduziu não está no sistema\n\n");
            consola.escrever("\n");
            nomeInstrumento = consola.lerString("Introduza novamente o nome de instrumento que o músico toca: ");
            instrumento = sistema.getInstrumentos().procurarInstrumentoPorNome(nomeInstrumento);
        }
        return instrumento;
    }

    public void listarInstrumentos() {
        consola.escrever(sistema.getInstrumentos().toString());
    }

    //Musico
    private void adicionarMusico() {
        consola.escrever("Criar Novo Musico\n\n");
        String nome = consola.lerString("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        while (sistema.getUsers().verificarExisteUtilizadorPorCC(bi) == true) {
            consola.escreverErro("O cc introzido já está associado a um utilizador");
            consola.escrever("\n");
            bi = consola.lerInteiro("Introduza o número de CC diferente: ");
        }
        String morada = consola.lerString("Introduza a morada: ");
        LocalDate dataNasc = consola.lerData("Introduza a data de nascimento(DD/MM/AAAA): ");
        while (dataNasc.isAfter(LocalDate.now())) {
            consola.escreverErro("Data introduzida inválida");
            consola.escrever("\n");
            dataNasc = consola.lerData("Introduza uma data válida(DD/MM/AAAA): ");
        }
        String username = consola.lerString("Introduza o nome de utilizador: ");

        while (sistema.getUsers().verificarExisteUtilizador(username) == true) {
            consola.escreverErro("Este nome de utilizador já existe, por favor insira outro!");
            username = consola.lerString("Introduza o nome de usuário: ");
        }
        String password = consola.lerString("Introduza a palavra-chave: ");
        int numInstrumentos = consola.lerInteiro("Quantos instrumentos toca o músico:");
        Collection<Instrumento> instrumentos = new HashSet<>();
        for (int i = 0; i < numInstrumentos; i++) {
            instrumentos.add(procurarInstrumento());
        }
        sistema.getUsers().adicionarUtilizador(new Musico(username, password, nome, bi, morada, dataNasc, instrumentos));
        consola.escrever("\n" + ANSI_VERDE + "Musico adicionado com sucesso!" + ANSI_RESET);
    }

    private void removerMusico() {
        consola.escrever("Remover Musico\n\n");
        String username = consola.lerString("Introduza o nome de utilizador do musico a remover: ");
        while (sistema.getUsers().verificarExisteMusico(username) == false) {
            consola.escreverErro("Não existe nenhum musico com esse nome de utilizador, por favor insira outro!");
            consola.escrever("\n");
            username = consola.lerString("Introduza o nome de utilizador: ");
        }
        sistema.getUsers().removerProdutorOuMusico(username);
        consola.escrever("\n" + ANSI_VERDE + "Músico removido com sucesso!" + ANSI_RESET);
    }

    private void editarDadosMusico(Musico musico) {
        consola.escrever("Editar dados Musico\n\n");
        Collection<Instrumento> instrumentos = new HashSet<>();
        String nome = consola.lerString("Introduza o nome:");
        musico.setNome(nome);
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        musico.setBi(bi);
        String morada = consola.lerString("Introduza a morada: ");
        musico.setMorada(morada);
        LocalDate dataNascimento = consola.lerData("Introduza a data de nascimento(DD/MM/AAAA): ");
        musico.setDataNasc(dataNascimento);
        int resposta = 0;
        resposta = consola.lerInteiro("Pretende alterar os instrumentos que o músico toca?\n1-Sim \n2-Não");
        while (resposta != 1 || resposta != 2) {

            if (resposta == 1) {
                int numInstrumentos = consola.lerInteiro("Quantos instrumentos toca o músico?");
                for (int i = 0; i < numInstrumentos; i++) {
                    instrumentos.add(procurarInstrumento());
                    musico.setInstrumentosMusicoToca(instrumentos);
                }
                break;
            } else if (resposta == 2) {
                break;
            }
            consola.escreverErro("Opção Inválida");
            resposta = consola.lerInteiro("Introduza uma das opções");
        }
        consola.escrever("\n" + ANSI_VERDE + "Dados editados com sucesso!" + ANSI_RESET);
    }

    private Musico procurarMusico() {
        String nomeMusico = consola.lerString("Insira o nome do músico:");
        Musico musico = sistema.getUsers().procurarMusicosPorNome(nomeMusico);
        while (musico == null) {
            consola.escrever("O músico que introduziu não está no sistema\n\n");
            consola.escrever("\n");
            nomeMusico = consola.lerString("Introduza novamente o nome do músico");
            musico = sistema.getUsers().procurarMusicosPorNome(nomeMusico);
        }
        return musico;
    }

    private void consultarDadosMusico(Musico musico) {
        consola.escrever("Dados do Músico\n");
        consola.escrever(musico.toString());
    }

    //Produtor
    private void adicionarProdutor() {
        consola.escrever("Criar Novo Produtor\n\n");
        String nome = consola.lerString("Introduza o nome: ");
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        while (sistema.getUsers().verificarExisteUtilizadorPorCC(bi) == true) {
            consola.escreverErro("O cc introzido já está associado a um utilizador");
            consola.escrever("\n");
            bi = consola.lerInteiro("Introduza o número de CC diferente: ");
        }
        String morada = consola.lerString("Introduza a morada: ");
        LocalDate dataNascimento = consola.lerData("Introduza a data de nascimento(DD/MM/AAAA): ");
        while (dataNascimento.isAfter(LocalDate.now())) {
            consola.escreverErro("Data introduzida inválida");
            consola.escrever("\n");
            dataNascimento = consola.lerData("Introduza uma data válida(DD/MM/AAAA): ");
        }
        String username = consola.lerString("Introduza o nome de utilizador: ");
        while (sistema.getUsers().verificarExisteUtilizador(username) == true) {
            consola.escreverErro("Este nome de utilizador já existe, por favor insira outro!");
            username = consola.lerString("Introduza o nome de utilizador: ");
        }
        String password = consola.lerString("Introduza a palavra-chave: ");

        sistema.getUsers().adicionarUtilizador(new Produtor(username, password, nome, bi, morada, dataNascimento));
        consola.escrever("\n" + ANSI_VERDE + "Produtor adicionado com sucesso!" + ANSI_RESET);
    }

    private void removerProdutor() {
        consola.escrever("Remover Produtor\n\n");
        String username = consola.lerString("Introduza o nome de utilizador do produtor a remover: ");
        while (sistema.getUsers().verificarExisteProdutor(username) == false) {
            consola.escreverErro("Não existe nenhum produtor com esse nome de utilizador, por favor insira outro!");
            username = consola.lerString("Introduza o nome de utilizador: ");
        }
        sistema.getUsers().removerProdutorOuMusico(username);
        consola.escrever("\n" + ANSI_VERDE + "Produtor removido com sucesso!" + ANSI_RESET);
    }

    private void consultarDadosProdutor(Produtor produtor) {
        consola.escrever("Dados do Produtor\n\n");
        consola.escrever(produtor.toString());
    }

    private void editarDadosProdutor(Produtor produtor) {
        consola.escrever("Editar dados Produtor\n\n");
        String nome = consola.lerString("Introduza o nome:");
        produtor.setNome(nome);
        int bi = consola.lerInteiro("Introduza o número do CC: ");
        produtor.setBi(bi);
        String morada = consola.lerString("Introduza a morada: ");
        produtor.setMorada(morada);
        LocalDate dataNascimento = consola.lerData("Introduza a data de nascimento(DD/MM/AAAA): ");
        produtor.setDataNasc(dataNascimento);
        consola.escrever("\n" + ANSI_VERDE + "Dados editados com sucesso!" + ANSI_RESET);
    }

    //ALBUM
    private Musica criarMusica() {
        consola.escrever("Nova Musica\n\n");
        String titulo = consola.lerString("Introduza o nome: ");
        int duracao = consola.lerInteiro("Introduza a duração da música(em segundos): ");
        int numMusicos = consola.lerInteiro("Quantos músicos fazem parte da música?");
        Collection<Musico> musicos = new HashSet<>();
        for (int i = 0; i < numMusicos; i++) {
            musicos.add(procurarMusico());
        }
        Musica musica = new Musica(titulo, duracao, musicos);
        consola.escrever("\n" + ANSI_VERDE + "Musica adicionada com sucesso!" + ANSI_RESET);;
        return musica;
    }

    private void registarAlbum() {
        consola.escrever("Registar Álbum\n\n");
        String titulo = consola.lerString("Introduza o titulo do álbum: ");
        int codigo = consola.lerInteiro("Introduza um código para o álbum: ");
        while (sistema.getAlbuns().verificarAlbumPorCod(codigo) == true) {
            consola.escreverErro("Este codigo já está associado a outro álbum, por favor insira outro!");
            consola.escrever("\n");
            codigo = consola.lerInteiro("Introduza um novo código: ");
        }
        String tipo = consola.lerString("Introduza o tipo: ");
        int numMusicas = consola.lerInteiro("Por quantas músicas é composto o álbum?");
        Collection<Musica> musicas = new HashSet<>();
        for (int i = 0; i < numMusicas; i++) {
            musicas.add(criarMusica());
        }
        Album album = new Album(codigo, titulo, null, tipo, musicas);
        sistema.getAlbuns().adicionarAlbum(album);
    }

    private Album procurarAlbumPorCod() {
        int codigo = consola.lerInteiro("Insira o código do álbum que pretende consultar: ");
        Album album = sistema.getAlbuns().procurarAlbumPorCod(codigo);
        while (album == null) {
            consola.escreverErro("O codigo que introduziu não corresponde a nenhum álbum do sistema\n\n");
            consola.escrever("\n");
            codigo = consola.lerInteiro("Insira um código de um álbum existente: ");
            album = sistema.getAlbuns().procurarAlbumPorCod(codigo);
        }
        return album;
    }

    public String informacaoAlbum(Produtor produtor) {
        consola.escrever("Informações Album\n\n");
        int codigo = consola.lerInteiro("Introduza o codigo do album que pretende consultar:");
        while (sistema.getEdicoesAlbum().verificarAlbumProdutorPorCod(produtor, codigo) == false) {
            consola.escreverErro("Não existe nenhum álbum com esse código no sistema ou o produtor não está associado a esse álbum!");
            consola.escrever("\n");
            codigo = consola.lerInteiro("Insira um código de um álbum existente: ");
        }
        return sistema.getEdicoesAlbum().retornarAlbumProdutorPorCod(produtor, codigo).toString();
    }

    //Edição Álbum
    private void iniciarEdicaoAlbum(Produtor utilizador) {
        consola.escrever("Edição de Álbum\n\n");
        Album album = procurarAlbumPorCod();
        while (sistema.getEdicoesAlbum().verificarExisteEdicaoAlbumParaUmAlbum(album) == true) {
            consola.escreverErro("Já foi iniciada uma edição para esse albúm");
            consola.escrever("\n");
            album = procurarAlbumPorCod();
        }
        album.setDataEdicao(LocalDate.now());
        EdicaoAlbum edicaoAlbum = new EdicaoAlbum(album, utilizador);
        sistema.getEdicoesAlbum().adicionarEdicaoAlbum(edicaoAlbum);
        consola.escrever("\n" + ANSI_VERDE + "Edição de álbum iniciada com sucesso!" + ANSI_RESET);
    }

    private EdicaoAlbum procurarEdicaoAlbum() {
        Album album = procurarAlbumPorCod();
        EdicaoAlbum edicaoAlbum = sistema.getEdicoesAlbum().procurarEdicaoAlbumPorAlbum(album);
        while (edicaoAlbum == null) {
            consola.escrever("O Album que introduziu não tem a sua edição iniciada.\n");
            consola.escrever("\n");
            album = procurarAlbumPorCod();
            edicaoAlbum = sistema.getEdicoesAlbum().procurarEdicaoAlbumPorAlbum(album);
        }
        return edicaoAlbum;
    }

    //Sessao
    private void DefinirSessao() {
        consola.escrever("Definir Sessao\n\n");
        EdicaoAlbum edicaoAlbum = procurarEdicaoAlbum();
        int numDias = consola.lerInteiro("Quantos dias necessita para gravar o álbum?");

        for (int i = 0; i < numDias; i++) {
            int codigo = consola.lerInteiro("Introduza um código para a sessão: ");
            while (sistema.getSessoes().verificarExisteSessao(codigo) == true) {
                consola.escreverErro("Este codigo já está associado a uma sessão, por favor insira outro!");
                consola.escrever("\n");
                codigo = consola.lerInteiro("Introduza um código diferente para a sessão ");
            }
            LocalDate dataEdicao = consola.lerData("Em que dia pretende gravar o álbum?(DD/MM/AAAA)");
            while(dataEdicao.isBefore(LocalDate.now())){
                consola.escreverErro("Não é possivel definir uma sessão para um dia que já passou!");
                consola.escrever("\n");
                dataEdicao = consola.lerData("Em que dia pretende gravar o álbum?(DD/MM/AAAA)");
            }
            Sessao sessao = new Sessao(codigo, edicaoAlbum, dataEdicao, false);
            edicaoAlbum.adicionarSessao(sessao);
            sistema.getEdicoesAlbum().removerEdicaoAlbum(edicaoAlbum);
            sistema.getEdicoesAlbum().adicionarEdicaoAlbum(edicaoAlbum);
            sistema.getSessoes().adicionarSessao(sessao);
        }

    }

    public void concluirSessaoGravacao(Produtor produtor) {
        consola.escrever("Concluir Sessao de Gravação\n\n");

        int codigo = consola.lerInteiro("Introduza o código da sessão que pretende concluir: ");
        while (sistema.getSessoes().verificarExisteSessaoProdutor(codigo, produtor) == false) {
            consola.escreverErro("O código introduzido não corresponde a nenhuma sessão agendada para este produtor!");
            consola.escrever("\n");
            codigo = consola.lerInteiro("Introduza um código válido: ");
        }

        sistema.getEdicoesAlbum().concluirSessao(codigo);
        sistema.getSessoes().procurarSessao(codigo).setSessaoConcluida(true);
        consola.escrever("\n" + ANSI_VERDE + "Sessão concluida com sucesso!" + ANSI_RESET);
    }

    //Requisição
    private Sessao procurarSessaoParaRequisitar(Musico musico) {
        int codigo = consola.lerInteiro("Introduza o codigo da sessão para a qual pretende requisitar instrumentos: ");
        Sessao sessao = sistema.getSessoes().procurarSessaoPorMusico(codigo, musico);
        while (sessao == null) {
            consola.escreverErro("Não há nenhuma sessão associada a esse código para este músico!");
            consola.escrever("\n");
            codigo = consola.lerInteiro("Introduza o codigo da sessão para a qual pretende requisitar instrumentos: ");
            sessao = sistema.getSessoes().procurarSessaoPorMusico(codigo, musico);
        }
        return sessao;
    }

    private Instrumento procurarInstrumentoParaRequisitar(Musico musico) {
        String nomeInstrumento = consola.lerString("Introduza o nome do instrumento que pretende requisitar");
        Instrumento instrumento = sistema.getInstrumentos().procurarInstrumentoPorNomeEMusico(nomeInstrumento, musico);
        while (instrumento == null) {
            consola.escreverErro("Não há nenhum instrumento com esse nome. Ou o músico não sabe tocar esse instrumento!");
            consola.escrever("\n");
            nomeInstrumento = consola.lerString("Qual é o instrumento que pretende requisitar:");
            instrumento = sistema.getInstrumentos().procurarInstrumentoPorNomeEMusico(nomeInstrumento, musico);
        }
        return instrumento;
    }

    public void RequisitarInstrumentosParaSessao(Musico musico) {
        consola.escrever("Pedido Para Requisitar Instrumentos\n\n");
        Sessao sessao = procurarSessaoParaRequisitar(musico);
        int codigo = consola.lerInteiro("Introduza o código que pretende associar à requisição: ");
        while (sistema.getRequisicoes().verificarExisteRequisicao(codigo) == true) {
            consola.escreverErro("Este codigo já está associado a uma requisição, por favor insira outro!");
            consola.escrever("\n");
            codigo = consola.lerInteiro("Introduza o código que pretende associar à requisição: ");
        }
        int numInstrumentos = consola.lerInteiro("Quantos instrumentos pretende requisitar?");
        Collection<Instrumento> instrumentos = new HashSet<>();
        for (int i = 0; i < numInstrumentos; i++) {
            instrumentos.add(procurarInstrumentoParaRequisitar(musico));
        }

        Requisicao requisicao = new Requisicao(musico, instrumentos, LocalDate.now(), sessao, "Pendente", codigo);
        sessao.adicionarRequisicao(requisicao);
        sistema.getRequisicoes().adicionarRequisicao(requisicao);
        sistema.getSessoes().adicionarRequisicoesAumaSessao(sessao);

        consola.escrever("\n" + ANSI_VERDE + "Pedido de requisição enviado com sucesso!" + ANSI_RESET);
    }

    public void aceitarPedidoRequisicao() {
        consola.escrever("Aceitar pedidos de requisição\n\n");
        int codigo = consola.lerInteiro("Introduza o código da requisição que pretende aceitar.");
        while (sistema.getRequisicoes().verificarExisteRequisicao(codigo) == false) {
            consola.escreverErro("Este codigo não corresponde a nenhum pedido de requisição!");
            codigo = consola.lerInteiro("Qual o código da requisição que pretende aceitar? ");
        }
        sistema.getRequisicoes().aceitarRequisicao(codigo);
        consola.escrever("\n" + ANSI_VERDE + "Requisição aceite!" + ANSI_RESET);
    }

    public void recusarPedidoRequisicao() {
        consola.escrever("Aceitar pedidos de requisição\n\n");
        int codigo = consola.lerInteiro("Introduza o código da requisição que pretende recusar: ");
        while (sistema.getRequisicoes().verificarExisteRequisicao(codigo) == false) {
            consola.escreverErro("Este codigo não corresponde a nenhum pedido de requisição!");
            codigo = consola.lerInteiro("Introduza o código da requisição que pretende recusar: ");
        }
        sistema.getRequisicoes().recusarRequisicao(codigo);
        consola.escrever("\n" + ANSI_VERDE + "Requisição recusada!" + ANSI_RESET);
    }

    //Listagens
    public String listarRequisicoesPorEstado(String Estado) {
        consola.escrever("Requisicoes " + Estado);
        return sistema.getRequisicoes().listarRequisicoes(Estado).toString();

    }

    public String listarAlbunsDoMusico(Musico musico) {
        consola.escrever("Álbuns em que está presente");
        return sistema.getAlbuns().listarAlbunsMusico(musico).toString();
    }

    public String listarSessoesAgendadasMusico(Musico musico) {
        consola.escrever("Sessões Agendadas");
        return sistema.getSessoes().listarSessoesAgendadasPorMusico(musico).toString();

    }

    public String listarEstadoSessoesPorMusico(Musico musico) {
        consola.escrever("Sessões Agendadas");
        return sistema.getSessoes().listarEstadoSessoesPorMusico(musico).toString();

    }

    public String listarSessoesConcluidas() {
        consola.escrever("Sessões Concluidas");
        return sistema.getSessoes().listarSessoesConcluidas().toString();
    }

    public String listarAlbunsProdutor(Produtor produtor) {
        consola.escrever("Álbuns Produzidos");
        return sistema.getEdicoesAlbum().listarAlbunsProdutor(produtor).toString();
    }

    public String listarSessoesAgendadasPorDia(Produtor produtor) {
        LocalDate data = consola.lerData("Pretende ver as sessões agendadas de que dia?");
        while (data == null) {
            consola.escrever("Data Inválida");
            data = consola.lerData("Pretende ver as sessões agendadas de que dia?");
        }
        consola.escrever("Sessoes Agendadas " + data);
        return sistema.getSessoes().listarSessoesAgendadasPorDia(produtor, data).toString();

    }

    public void listarEstatisticasGlobais() {
        consola.escrever("Estatisticas Totais\n");

        consola.escrever("Total albúns concluidos: ");
        int totC = sistema.getEdicoesAlbum().totalAlbunsConcluidos();
        System.out.println(totC);
        consola.escrever("Média percentagem sessões concluidas: ");
        double media = sistema.getEdicoesAlbum().mediaPercentagemSessoesConcluidas();
        System.out.println(media);
        consola.escrever("Total albúns em edição: ");
        int totE = sistema.getEdicoesAlbum().totalAlbunsEmEdicao();
        System.out.println(totE);
    }
    
    public void listarEstatisticasMes() {
        int mes=0;
        mes = consola.lerInteiro("Pretende consultar as estatisticas de que mês(1-12):");
        while(mes<1 || mes>12){
            
        }
        consola.escrever("Total albúns concluidos: ");
        int totC = sistema.getEdicoesAlbum().totalAlbunsConcluidosMes(mes);
        System.out.println(totC);
        consola.escrever("Média percentagem sessões concluidas: ");
        double media = sistema.getEdicoesAlbum().mediaPercentagemSessoesConcluidasMes(mes);
        System.out.println(media);
        consola.escrever("Total albúns em edição: ");
        int totE = sistema.getEdicoesAlbum().totalAlbunsEmEdicaoMes(mes);
        System.out.println(totE);
    }
    
    public String listarAlbunsEstadoEPercentagem(){
       consola.escrever("Estado Albuns");
       return sistema.getEdicoesAlbum().listarAlbunsEstadoERespetivasPercentagens().toString();

    }
    
    //Fonte:Guardar e Carregar ficheiro do professor Bruno
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

    //Guardar e carregar ficheiros Requisicoes
    private void guardarFicheiroRequisicoes() {
        String nomeFicheiro = "Requisicoes";
        try {
            sistema.getRequisicoes().guardarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro guardado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel criar o ficheiro: "
                    + ex.getLocalizedMessage());
        }
    }

    private void carregarFicheiroRequisicoes() {
        String nomeFicheiro = "Requisicoes";
        try {
            sistema.getRequisicoes().carregarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro carregado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel carregar o ficheiro: "
                    + ex.getMessage());
        }
    }

    //Guardar e carregar ficheiros Edicao de Album
    private void guardarFicheiroEdicoesAlbum() {
        String nomeFicheiro = "EdicoesAlbum";
        try {
            sistema.getEdicoesAlbum().guardarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro guardado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel criar o ficheiro: "
                    + ex.getLocalizedMessage());
        }
    }

    private void carregarFicheiroEdicoesAlbum() {
        String nomeFicheiro = "EdicoesAlbum";
        try {
            sistema.getEdicoesAlbum().carregarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro carregado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel carregar o ficheiro: "
                    + ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {

        ProgramaGM programa = new ProgramaGM();

        //Opções para menu administrador
        String[] opcoesAdministrador = {
            "Adicionar/Apagar Músico/Produtor",
            "Registar Álbum",
            "Registar instrumentos de música",
            "Listar os pedidos de requisição por estado (pendente, atribuído, recusado)",
            "Listar os pedidos de requisição pendentes e conceder ou recusar os mesmos.",
            "Listar os álbuns em edição e o seu estado (percentagem de sessões de gravação concluídas)",
            "Estatisticas",
            "Sair"};

        String[] opcoesAdministrador1 = {
            "Adicionar Musico",
            "Adicionar Produtor",
            "Apagar Produtor",
            "Apagar Músico",
            "Voltar"};

        String[] opcoesAdministrador2 = {
            "Estatisticas Totais",
            "Estatisticas de um determinado mês",
            "Voltar"};

        String[] opcoesAdministrador4 = {
            "Listar pedidos de requisição pendentes",
            "Listar pedidos de requisição aceites",
            "Listar pedidos de requisição recusados",
            "Voltar"};
        String[] opcoesAdministrador5 = {
            "Aceitar pedidos de requisição",
            "Recusar pedidos de requisição",
            "Voltar"};

        //Opções para menu Produtor
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

        String[] opcoesProdutor2 = {
            "Iniciar Edição de Álbum",
            "Definir sessões de gravação",
            "Voltar"
        };

        //Opções para menu músico
        String[] opcoesMusico = {
            "Ver/editar os seus dados",
            "Ver albuns a que esta associado",
            "Ver as sessoes gravações que tem agendadas",
            "Fazer pedido de requisição de instrumentos para uma determinada sessão",
            "Ver o estado das sessoes de gravação",
            "Sair"};

        String[] opcoesMusico1 = {
            "Ver dados Músico",
            "Editar dados Músico",
            "Voltar"
        };

        programa.consola.escrever("MENU AUTENTICAÇÃO\n");

        programa.carregarFicheiroAlbuns();
        programa.carregarFicheiroInstrumentos();
        programa.carregarFicheiroUtilizadores();
        programa.carregarFicheiroSessoes();
        programa.carregarFicheiroRequisicoes();
        programa.carregarFicheiroEdicoesAlbum();

        //Criar Administardor Base
        Utilizador admin = new Administrador("admin", "admin", "administrador", 5, "Rua", null);
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
                                        programa.removerProdutor();
                                        break;
                                    case 4:
                                        programa.removerMusico();
                                        break;
                                    case 5:
                                        programa.guardarFicheiroAlbuns();
                                        programa.guardarFicheiroInstrumentos();
                                        programa.guardarFicheiroUtilizadores();
                                        programa.guardarFicheiroSessoes();
                                        programa.guardarFicheiroEdicoesAlbum();
                                        programa.guardarFicheiroRequisicoes();

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
                        case 4: {
                            int opcaoA4 = 0;
                            do {
                                opcaoA4 = programa.consola.lerOpcoesMenusInteiros(opcoesAdministrador4);
                                switch (opcaoA4) {
                                    case 1:
                                        programa.listarRequisicoesPorEstado("Pendente");
                                        break;
                                    case 2:
                                        programa.listarRequisicoesPorEstado("Atribuido");
                                        break;
                                    case 3:
                                        programa.listarRequisicoesPorEstado("Recusado");
                                        break;
                                    case 4:

                                }
                            } while (opcaoA4 != opcoesAdministrador4.length);
                        }
                        break;
                        // Listar os pedidos de requisição pendentes e conceder ou recusar os mesmos.
                        case 5: {
                            int opcaoA5 = 0;
                            do {
                                opcaoA5 = programa.consola.lerOpcoesMenusInteiros(opcoesAdministrador5);
                                switch (opcaoA5) {
                                    case 1:
                                        programa.listarRequisicoesPorEstado("Pendente");
                                        programa.aceitarPedidoRequisicao();
                                        break;
                                    case 2:
                                        programa.listarRequisicoesPorEstado("Pendente");
                                        programa.recusarPedidoRequisicao();
                                        break;
                                    case 3:

                                }
                            } while (opcaoA5 != opcoesAdministrador5.length);
                        }
                        break;
                        //Listar os álbuns em edição e o seu estado (percentagem de sessões de gravação concluídas)
                        case 6:
                            programa.listarAlbunsEstadoEPercentagem();
                            break;
                        //Mostrar estatísticas totais ou para um determinado mês
                        case 7: {
                            int opcaoA2 = 0;
                            do {
                                opcaoA2 = programa.consola.lerOpcoesMenusInteiros(opcoesAdministrador2);
                                switch (opcaoA2) {
                                    case 1:
                                        programa.listarEstatisticasGlobais();
                                        break;
                                    case 2:
                                        programa.listarEstatisticasMes();
                                        break;
                                    case 3:

                                }
                            } while (opcaoA2 != opcoesAdministrador2.length);
                        }
                        break;

                        case 8:
                            programa.guardarFicheiroAlbuns();
                            programa.guardarFicheiroInstrumentos();
                            programa.guardarFicheiroUtilizadores();
                            programa.guardarFicheiroSessoes();
                            programa.guardarFicheiroRequisicoes();

                    }
                }
                break;

            //Produtor
            case 2:
                int opcaoP = 0;
                while (opcoesProdutor.length != opcaoP) {
                    opcaoP = programa.consola.lerOpcoesMenusInteiros(opcoesProdutor);

                    switch (opcaoP) {
                        //Ver/editar os seus dados 
                        case 1:
                            int opcaoP1 = 0;
                            do {

                                opcaoP1 = programa.consola.lerOpcoesMenusInteiros(opcoesProdutor1);
                                switch (opcaoP1) {
                                    case 1:
                                        programa.consultarDadosProdutor((Produtor) utilizador);
                                        break;
                                    case 2:
                                        programa.editarDadosProdutor((Produtor) utilizador);
                                        break;
                                    case 3:
                                        programa.guardarFicheiroAlbuns();
                                        programa.guardarFicheiroInstrumentos();
                                        programa.guardarFicheiroUtilizadores();
                                        programa.guardarFicheiroSessoes();
                                        programa.guardarFicheiroEdicoesAlbum();
                                        programa.guardarFicheiroRequisicoes();

                                }
                            } while (opcaoP1 != opcoesProdutor1.length);
                            break;
                        //Iniciar/editar a edição de um álbum, definindo as sessões de gravação necessárias 
                        case 2:
                            int opcaoP2 = 0;
                            do {
                                opcaoP2 = programa.consola.lerOpcoesMenusInteiros(opcoesProdutor2);
                                switch (opcaoP2) {
                                    case 1:
                                        programa.iniciarEdicaoAlbum((Produtor) utilizador);
                                        break;
                                    case 2:
                                        programa.DefinirSessao();
                                        break;
                                    case 3:
                                        programa.guardarFicheiroAlbuns();
                                        programa.guardarFicheiroInstrumentos();
                                        programa.guardarFicheiroUtilizadores();
                                        programa.guardarFicheiroSessoes();
                                        programa.guardarFicheiroEdicoesAlbum();
                                        programa.guardarFicheiroRequisicoes();

                                }
                            } while (opcaoP2 != opcoesProdutor2.length);
                            break;
                        //Concluir sessões de gravação
                        case 3:
                            programa.concluirSessaoGravacao((Produtor) utilizador);
                            break;
                        //Aceder a informação relativa à situação atual (estado, sessões de gravação, etc.) de um determinado álbum
                        case 4:
                            programa.informacaoAlbum((Produtor) utilizador);
                            break;
                        //Listar os álbuns que produz ou produziu
                        case 5:
                            programa.listarAlbunsProdutor((Produtor) utilizador);
                            break;
                        //Listar as sessões de gravação agendadas para um dia
                        case 6:
                            programa.listarSessoesAgendadasPorDia((Produtor) utilizador);
                            break;
                        case 7:
                            programa.guardarFicheiroAlbuns();
                            programa.guardarFicheiroInstrumentos();
                            programa.guardarFicheiroUtilizadores();
                            programa.guardarFicheiroSessoes();
                            programa.guardarFicheiroRequisicoes();
                            programa.guardarFicheiroEdicoesAlbum();

                    }
                }

                break;

            //Musico
            case 3:
                int opcaoM = 0;
                while (opcoesProdutor.length != opcaoM) {
                    opcaoM = programa.consola.lerOpcoesMenusInteiros(opcoesMusico);

                    switch (opcaoM) {
                        //Ver/editar os seus dados
                        case 1:
                            int opcaoM1 = 0;
                            do {

                                opcaoM1 = programa.consola.lerOpcoesMenusInteiros(opcoesMusico1);
                                switch (opcaoM1) {
                                    case 1:
                                        programa.consultarDadosMusico((Musico) utilizador);
                                        break;
                                    case 2:
                                        programa.editarDadosMusico((Musico) utilizador);
                                        break;
                                    case 3:

                                }
                            } while (opcaoM1 != opcoesMusico1.length);
                            break;
                        //Ver os álbuns a que está associado
                        case 2:
                            programa.listarAlbunsDoMusico((Musico) utilizador);
                            break;
                        //Ver as sessões gravações que tem agendadas
                        case 3:
                            
                            programa.listarSessoesAgendadasMusico((Musico) utilizador);
                            break;
                        //Fazer a requisição de instrumentos para uma determinada sessão de gravação
                        case 4:
                            programa.RequisitarInstrumentosParaSessao((Musico) utilizador);
                            programa.guardarFicheiroRequisicoes();
                            break;
                        //Ver o estado das sessões de gravação (agendada ou concluída)
                        case 5:
                            programa.listarEstadoSessoesPorMusico((Musico) utilizador);
                            break;
                        case 6:
                            programa.guardarFicheiroAlbuns();
                            programa.guardarFicheiroInstrumentos();
                            programa.guardarFicheiroUtilizadores();
                            programa.guardarFicheiroSessoes();
                            programa.guardarFicheiroRequisicoes();
                            programa.guardarFicheiroEdicoesAlbum();

                            exit(0);

                    }
                }

                break;

        }

    }

}
