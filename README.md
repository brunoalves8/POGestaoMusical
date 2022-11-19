# POGestaoMusical

Pretende-se desenvolver um programa para ajudar na gestão de uma editora de
músicas. A Editora dedica-se à edição de álbuns de artistas portugueses. Cada álbum
tem um título, a data em que foi editado e um tipo, que o caracteriza em termos de
estilo (música ligeira, rock, etc.). Cada álbum que é editado integra diversas músicas.
Para cada música, é registado o seu título, a sua duração e o músico, ou músicos, que
participam na mesma. Para cada músico, é registado o seu nome, data de nascimento,
morada, número de bilhete de identidade e, ainda, o instrumento (ou instrumentos) que
o mesmo toca.
A edição de um álbum tem associado um produtor, podendo um produtor estar
associado à produção de mais do que um álbum. Para a edição de um dado álbum é
necessário proceder à gravação do mesmo, tarefa que pode ser realizada em várias
sessões de gravação (em dias diferentes). Para a realização de uma dada sessão de
gravação é necessário que os diversos músicos procedam, previamente, à requisição dos
diversos instrumentos que serão necessários (um músico pode tocar vários
instrumentos, pelo que poderá requisitar mais do que um instrumento). Para cada
requisição, é registada a sessão de gravação a que diz respeito, o músico que procede à
requisição e a data da requisição. Para cada sessão de gravação realizada, é também
registado o álbum que está a ser gravado e a data final da gravação, quando for
concluída.
A aplicação tem um administrador que tem como papel principal criar utilizadores do
tipo Músico ou Produtor, registar álbuns e respetivas músicas, e registar os instrumentos
existentes no estúdio de gravação. O utilizador do tipo Produtor tem como papel
principal o registo das gravações realizadas relativamente a cada álbum que produz. Um
Músico pode fazer requisições de instrumentos para cada sessão de gravação agendada. 

Funcionalidades
A aplicação informática deverá ser composta por duas partes: a parte de back-end que
suporta o funcionamento do sistema, e a parte de front-end que suporta a interface que
permite a interação com o utilizador.
O back-end e o front-end deverão estar implementados em pacotes distintos, ou seja,
todas as classes que digam respeito à interface deverão estar arrumadas num pacote e
as classes respeitantes ao negócio, noutro.
A entrada e saída de dados deve ser realizada recorrendo a uma interface em linha de
comandos (do género da que foi usada em AED1 e AED2). Pretende-se ainda que a
aplicação tenha capacidade de persistência, ou seja, que tenha capacidade de guardar
em ficheiro o estado do sistema num determinado momento e recuperá-lo quando
pretendido. Refere-se que não é permitida a utilização de bases de dados. Ainda em
relação à entrada e saída de dados importa referir que se pretende que o sistema tenha
níveis de robustez adequados, ou seja, que seja capaz de se comportar adequadamente 
em situações de erro (nomeadamente aquando da introdução de dados por parte dos
utilizadores).
A seguir estão listadas as funcionalidades que deverão ser implementadas por tipo de
ator/utilizador:

Músico
1. Autenticar
2. Ver/editar os seus dados
3. Ver os álbuns a que está associado
4. Ver as sessões gravações que tem agendadas
5. Fazer a requisição de instrumentos para uma determinada sessão de gravação
6. Ver o estado das sessões de gravação (agendada ou concluída)

Administrador
1. Autenticar-se como administrador
2. Adicionar/apagar utilizadores do tipo Músico e do tipo Produtor
3. Registar álbuns
4. Registar instrumentos de música
5. Listar os pedidos de requisição por estado (pendente, atribuído, recusado)
6. Listar os pedidos de requisição pendentes e conceder ou recusar os mesmos.
7. Listar os álbuns em edição e o seu estado (percentagem de sessões de gravação
concluídas)
8. Mostrar estatísticas totais ou para um determinado mês:
a. Total de álbuns em edição
b. Média da percentagem de sessões de gravação concluídas
c. Total de álbuns concluídos

Produtor
1. Autenticar
2. Ver/editar os seus dados
3. Iniciar/editar a edição de um álbum, definindo as sessões de gravação
necessárias
4. Concluir sessões de gravação
5. Aceder a informação relativa à situação atual (estado, sessões de gravação,
etc.) de um determinado álbum
6. Listar os álbuns que produz ou produziu
7. Listar as sessões de gravação agendadas para um dia

Valorização
A aplicação dos conceitos e dos princípios fundamentais subjacentes ao paradigma de
programação orientada aos objetos será amplamente valorizada.
A classificação dos trabalhos terá ainda em consideração aspetos como: 
 Qualidade da execução do programa (com ou sem erros, validações,
testes, …)
 Qualidade da satisfação dos requisitos
 Facilidade de utilização do sistema
 Adequação da conceção e organização das classes
 Qualidade do código fonte apresentado
o Correção (avaliação se o código está coerente com a
especificação do enunciado e se não tem erros)
o Design (avalia a forma como o código está escrito (eficiente,
elegante, reutilizável))
o Estilo (avalia a legibilidade do código (comentado, indentado,
nomes de variáveis e funções adequadas,...))
 Desempenho do grupo no decorrer da apresentação 
