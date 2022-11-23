# POGestaoMusical

## Back End:
- [ ] Class abstract Utilizador
  - [ ] Nome: String
  - [ ] BI: int
  - [ ] Morada: String
  - [ ] CriarMúsico()
  - [ ] RemoverMusico()
  - [ ] CriarProdutor()
  - [ ] RemoverProdutor()

- [ ] Class Album
  - [ ] Titulo: String
  - [ ] DataEdição: String
  - [ ] Tipo: String
  - [ ] Array tipo Música
  - [ ] AdicionarMusica()
  - [ ] RemoverMusica()

- [ ] Class Musica
  - [ ] Titulo: String
  - [ ] Duração: double
  - [ ] Array tipo Músico
  - [ ] AdicionarMusico()
  - [ ] RemoverMusico()
 
- [ ] Class Instrumento
  - [ ] Nome: String
  - [ ] Tipo: String
  - [ ] Marca: String
  - [ ] Modelo: String
 
- [ ] Class Sessão
  - [ ] codSessao: int
  - [ ] AlbumASerGravado: Album
  - [ ] DataFinalGravação: String
  - [ ] Array tipo Musico
  - [ ] ComeçarSessao()
  - [ ] TerminarSessao()
 
- [ ] Class Requisição
  - [ ] Requisitor: Musico
  - [ ] Requisitado: Instrumento
  - [ ] DataRequisição: String
  - [ ] SessaoGravação: Sessao
  
- [ ] Class EdicaoAlbum
  - [ ] produtor: Produtor
  - [ ] sessoes : Sessao[]

- [ ] Class ListaUtilizadores
  - [ ] Utilizadores tipo Utilizador[]
  - [ ] RemoverUtilizador()
  - [ ] CriarUtilizador()
  - [ ] EditarUtilizador()
  - [ ] VerificarExisteUtilizador()  
 
- [ ] Class Musico extends Utilizador
  - [ ] Array tipo Instrumento
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
