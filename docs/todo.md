# POGestaoMusical

## Back End:
- [ ] Class abstract Utilizador
  - [X] Nome: String
  - [X] BI: int
  - [X] Morada: String
  - [ ] CriarMúsico()
  - [ ] RemoverMusico()
  - [ ] CriarProdutor()
  - [ ] RemoverProdutor()

- [ ] Class Album
  - [X] Titulo: String
  - [X] DataEdição: String
  - [X] codigo: int
  - [X] Tipo: String
  - [X] Array tipo Música
  - [X] AdicionarMusica()
  - [X] RemoverMusica()

- [ ] Class Musica
  - [X] Titulo: String
  - [X] Duração: double
  - [X] Array tipo Músico
  - [X] AdicionarMusico()
  - [X] RemoverMusico()
 
- [ ] Class Instrumento
  - [ ] Nome: String
  - [ ] Tipo: String
  - [ ] Marca: String
  - [ ] Modelo: String
 
- [ ] Class Sessão
  - [X] codSessao: int
  - [X] AlbumASerGravado: Album
  - [X] DataFinalGravação: String
  - [ ] Array tipo Musico
  - [ ] ComeçarSessao()
  - [ ] TerminarSessao()
 
- [ ] Class Requisição
  - [X] Requisitor: Musico
  - [X] Requisitado: Instrumento
  - [X] DataRequisição: String
  - [X] SessaoGravação: Sessao
  
- [ ] Class EdicaoAlbum
  - [ ] produtor: Produtor
  - [ ] sessoes : Sessao[]

- [ ] Class ListaUtilizadores
  - [X] Utilizadores tipo Utilizador[]
  - [ ] RemoverUtilizador()
  - [ ] CriarUtilizador()
  - [ ] EditarUtilizador()
  - [ ] VerificarExisteUtilizador()  
 
- [ ] Class Musico extends Utilizador
  - [X] Array tipo Instrumento
  - [ ] RequisitarInstrumento()
  - [ ] DevolverInstrumento()

- [ ] Class Administrador extends Utilizador
  - [ ] CriarProdutor()
  - [ ] RemoverProdutor()
  - [ ] CriarMusico()
  - [ ] RemoverMusico()
  - [ ] RegistarAlbumEMusicas()
  - [ ] ApagarAlbumEMusicas()
  - [ ] RegistarInstrumentosExistentes()
  - [ ] RemoverInstrumentosExistentes()  

- [ ] Class Produtor extends Utilizador
  - [ ] Array tipo Album
  - [ ] RegistarGravaçãoDeUmAlbum()


- [ ] Class ListaAlbum

- [ ] Class ListaSessao

- [ ] Class ListaRequisição

- [ ] Class ListaInstrumentos

- [ ] Class ListaMusicas

## Front End:
- [ ] Interface 
