# ProjetoFinalPOO
Esse repositório corresponde aos códigos, imagens e processos envolvidos na produção do trabalho final de POO do ano de 2026

# Trabalho Final de POO 2
## FocusUp — Gerenciador de Estudos

**Integrantes da equipe:**
- Camila Pereira Silva
- Emanuelle Leal Prado
- Fernanda Nicolly Zago

### Descrição do sistema

O FocusUp é um sistema computacional desenvolvido com o objetivo de facilitar a organização da rotina acadêmica dos estudantes,
permitindo o gerenciamento de matérias, tarefas, provas, trabalhos e do desempenho escolar. O sistema contará com um painel 
principal que apresentará o cronograma mensal de atividades, os prazos das tarefas e a evolução do estudante ao longo do período 
de estudos.

### Problema ou necessidade que o sistema pretende atender

A quantidade de atividades, avaliações e trabalhos escolares pode dificultar a organização da rotina dos estudantes, especialmente
quando não há uma ferramenta adequada para acompanhar os compromissos e seus respectivos prazos. Essa situação pode resultar em 
esquecimentos, atrasos na entrega de atividades e dificuldades para planejar os estudos.

Além disso, muitos estudantes encontram dificuldades em determinadas matérias ou desejam melhorar seu desempenho em avaliações 
específicas, mas nem sempre conseguem acompanhar sua evolução de maneira organizada.

Diante disso, o FocusUp busca oferecer uma solução prática para centralizar essas informações, facilitar o planejamento acadêmico e 
permitir que os estudantes acompanhem suas atividades e seus resultados em um único sistema.

### Público-alvo

O sistema tem como público-alvo estudantes do ensino fundamental, médio, técnico e superior que desejam organizar melhor sua rotina 
acadêmica, acompanhar prazos e monitorar seu desempenho nas diferentes matérias.

### Objetivo geral

Desenvolver um sistema computacional que auxilie os estudantes na organização de suas atividades acadêmicas, no planejamento dos 
estudos e no acompanhamento de seu desempenho escolar, proporcionando maior praticidade e controle sobre sua rotina.

### Principais funcionalidades

- **Cadastro de matérias:** permitir o registro, a consulta, a edição e a exclusão das matérias estudadas pelo usuário.
- **Gerenciamento de tarefas e avaliações:** possibilitar o cadastro de atividades, provas e trabalhos, incluindo suas descrições,
- datas e matérias relacionadas.
- **Controle de prazos e status:** permitir o acompanhamento das atividades pendentes, em andamento e concluídas, facilitando a
- visualização dos compromissos acadêmicos.
- **Registro de notas:** possibilitar o armazenamento das notas obtidas nas avaliações e a consulta dos resultados por matéria.
- **Painel de acompanhamento:** apresentar um cronograma mensal com as atividades programadas, os prazos próximos e as tarefas pendentes.
- **Acompanhamento do desempenho:** disponibilizar informações sobre as notas e a evolução do estudante por matéria, auxiliando na
- identificação de disciplinas que necessitam de maior atenção.

### Delimitação do sistema

Nesta primeira versão, o FocusUp será voltado ao gerenciamento individual da rotina acadêmica. O sistema permitirá cadastrar e consultar informações, controlar atividades e prazos e acompanhar notas e indicadores básicos de desempenho.

Não farão parte do escopo inicial funcionalidades como integração automática com plataformas escolares, lançamento de notas por professores, sincronização com calendários externos ou utilização de inteligência artificial para criação de planos de estudo. Essas funcionalidades poderão ser consideradas em versões futuras.
_________________________________________________________________________________
### Atualizações

No dia 27/10 foram incluídas as instruções SQL do banco de dados e das tabelas utilizadas no projeto(arquivo presente na pasta SQL, lá estão as instruções SQL e as instruções de como testar após concluir a intalação do banco de dados), além disso foi incluído a estrutura do projeto (presente na pasta imagens, o único arquivo presente dentro da pasta), em relação a organização das pastas.

No dia 10/11 foram concluídas as primeiras versões das interfaces (imagens presentes na pasta imagens, interface1.0), além disso concluímos a organização do GitHub, transferindo todas as pastas e arquivos da estrutura para dentro do projeto presente no sistema. 

No dia 17/11 definimos a paleta de cores a a identidade visual do sistema, escolhendo a logo e os ícones, também iniciamos a produção do relatório. 

No dia 20/11 foram feitas as ultimas atualizações que garantiram a funcionalidade do sistema:
1.comunicação eficiente entre as Views e as controllers permitindo a abertura projeto e a funcionalidade do menu sem erros 

2.contrução dos relatórios e integração deles ao projeto 

O funcionamento, a partir das telas, pode ser conferido na pasta Resultados desse projeto que conta com os seguintes arquivos: 

1.RelatorioDesempenho: corresponde a uma imagem de como está sendo formado o relatório de desempenho 

2.RelatorioTarefa: corresponde a uma imagem de como está sendo formado o relatório de tarefas

3.TelaAjuda: uma imagem de como a tela Ajuda, que corresponde a informações sobre o sistema, está disposta no projeto

4.TelaAvaliações: uma imagem de como a tela Avaliações, que corresponde a tela de cadastro de avaliações, está disposta no projeto

5.TelaInicial: corresponde a Tela apresentada quando o programa é aberto ou quando a tela home é acionada

6.TelaMaterias: uma imagem de como a tela Materias, que corresponde a tela de cadastro de materias, está disposta no projeto

7.TelaTarefas:  uma imagem de como a tela Tarefas, que corresponde a tela de cadastro de tarefas, está disposta no projeto
_________________________________________________________________________________

### Conclusão
O programa foi bem executado e permite a funcionalidade do problema que se propôs a atender além de alcançar os objetivos gerais e as principais funcionalidades descritas da descrição do sistema. 
O cadastro, atualização e exclusão das matérias, tarefas e avaliações está funcionando através da conexão com o banco de dados e a consulta de desempenho e de tarefas, bem como seus status: pendente, concluída, em andamento; estão sendo efetivos pela solicitação dos relatórios. 
O sistema ainda conta com uma carência: a dificuldade em integração da logo dos componentes. O objetivo é concertar essa requisito até o dia da apresentação (24/11/2026), tornando essa entrega compatível com a data final para avaliação da lógica e dos componentes obrigatórios que foram estabelecidos. 
_________________________________________________________________________________
# Como implementar o Projeto

1. Implemente o banco de dados
   Nesse projeto utilizamos o mysql, caso você não tenha em sua máquina será necessário garantir a sua instalação antes de iniciar esse tutorial.
   Abra o mysql no terminal do seu computador ou vá direto no terminal do mysql, no primeiro caso digite o comando:
   sudo mysql -u root -p
   e em seguida coloque sua senha, no caso de ir direto ao mysql será necessário, apenas,colocar a senha.
   Agora, vá até a pasta SQL desse projeto e abra o arquivo, nele terá todas as instruções para criar o banco de dados e as três tabelas necessárias, também terá instruções para testar se os aplicativos estão funcionando.
   

2. Nesse projeto utilizamos o eclipse como IDE, caso você opte por usar também, existe um arquivo dentro da pasta resultados chamado ProjetoFinalP00.zip, nele estão todas as classes necessárias para o funcionamento desse sistema, extrária a pasta executável e adicione ela como projeto na IDE.
 

3. Confugurações

   Para rodar o projeto serão necessários arquivos JARS específicos para o javaFX, mysql e o Jasper, eles estão adicionados a pasta JARS, também dentro da pasta resultados desse projeto.
   
   Para implementá-lo no eclipse você deve:
   
   -clicar com o botão direito em cima do projeto
   
   -selecionar o campo Properties ou usar o atalho Alt+Enter
   
   -no menu lateral, dentro do campo Resource, você deve encontrar um campo chamado Java Build Path, clique com o botão direito
   
   -agora, no menu superior da tela que abrir, procure o campo Libraries, com o ícone de livros ao lado
   
   -selecione o segundo campo, Classpath, com o ícone de setas
   
   -no menu do lado direito da tela, procure o botão Add External JARs.., clique nele
   
   -navegue pelos seus arquivos até encontrar os arquivos Jar que você baixou nesse projeto e selecione todos, depois clique em ok
   
   -por último clique em Apply and Close, o botão presente na parte direita e inferior da tela
   
   Após todo esse processo ainda será possível adicionar o JavaFx ao projeto, para isso é necessário "rodar" o projeto, no eclipse, com a classe que possui uma método main aberto, clique no símbolo de play verde e branco presente na segunda linha de comandos do eclipse.
   
   -clique na seta preta do lado dela e procure um campo nomeado como Run Configurations..., clique nele
   
   -na tela que acabou de ser aberta, procure o menu horizontal no meio da tela e localize o componente Arguments (será o segundo item do menu), clique nele
   
   -agora, no campo de texto presente no segundo espaço da sua tela, em baixo da escrita VW argumentes, cole o comando que indica onde está a sua biblioteca do javaFX
   
   "--module-path "C:\javafx-sdk-21\javafx-sdk-21.0.11\lib" --add-modules javafx.controls,javafx.fxml"
   
   Substitua esse campo: "C:\javafx-sdk-21\javafx-sdk-21.0.11\lib", pela localização da sua pasta, caso ainda não tenha ela, estará disponível para download no site oficial: https://www.oracle.com/java/technologies/javase/javafx21-archive-downloads.html, essa página direciona para a mesma versão que utilizamos no projeto, salve-a e depois guarde o local em que salvou para modificar o campo anterior. 

4. Se tudo ocorreu bem, é só clicar no botão de "rodar" o projeto novamente ( no eclipse, com a classe que possui uma método main aberto, clique no símbolo de play verde e branco presente na segunda linha de comandos do eclipse) e o projeto será executado. 
   
_________________________________________________________________________________
# Atualização Final do Projeto 21/11
foram feitas as mudanças que possibilitaram a implementação dos ícones e da documentação do projeto.
Para a questões do ícone, bastou corrigir o caminho das imagens nas telas de fxml e adicionar um caminho para o menuItem fechar, o projeto estará atualizado na página resultados, utilize sua versão atualizada para implementar na sua máquina. Para conferir o resultado das interfaces após o concerto dos ícones, confira na página resultado e procure as imagens referentes à Tela principal com icones e a tela meteria com icones (exemplo de tela de cadastro). 
Todos os arquivos presentes na pasta src desse projeto também foram atualizados, para atualizar os fxml dos ícones e para implementar os arquivos adeptos as regras de documentação.
Para conferir a documentação instale o arquivo index.html, presente na pasta doc, dentro do projeto zip (PojetoFinalPOO2.0.zip), e abra ele no seu navegador
Outra alteração feita foi a exclusão da tela Principal.fxml que estava "duplicado" com a tela main, fazendo referência a mesma controller, optamos por excluí-la. 

Com essas últimas atualizações o projeto está concluído 

_________________________________________________________________________________
# Análise da proposta e do resultado final 

2. Tecnologias obrigatórias
 Java, utilizando orientação a objetos;
 JavaFX para a interface gráfica;
 MySQL para persistência dos dados;
 JasperReports/Jaspersoft para geração dos relatórios;
 Um instalador ou pacote executável que permita instalar/executar o sistema em outro 
computador;
 Git para versionamento e acompanhamento do desenvolvimento
Todas as tecnologias foram implementadas no projeto, com exceção do instalador de pacote, um conteúdo que não foi dado no bimestre, porém, implementamos um tutorial de implementação do projeto a partir do projeto compactado.
 
A etapa de análise foi concluída contendo: 
4.1. Descrição do sistema
4.2. Diagramas obrigatórios (presentes na pasta documentação desse repositório)

5. Requisitos mínimos de implementação
Item                            Quantidade mínima
Entidades/tabelas principais    Pelo menos 3
CRUDs completos                 Pelo menos 3
Consultas personalizadas        Pelo menos 2
Relatórios JasperReports        Pelo menos 2
Fizemos 3 tabelas principais: tarefas, matérias e avaliações, temos 3 CRUDs completos que foram necessários para a funcionalidade de cada tela de cadastro, em relação as consultas personalizadas e aos relatórios, decidimos uni-los por falta de tempo, temos 2 relatórios completos de tarefa e de desempenho, no relatório de desempenho temos um parâmetro que é calculado como consulta personalizada, que é a porcentagem de desempenho por tarefa. Conteúdo, não conseguimos explorar melhor essa parte da proposta.

6. Requisitos de orientação a objetos
 Uso adequado de classes e objetos;
 Encapsulamento;
 Construtores quando necessários;
 Relacionamentos entre classes;
 Uso de herança e/ou polimorfismo quando houver justificativa no domínio do sistema;
 Organização do código em classes com responsabilidades coerentes;
 Separação adequada entre interface, regras da aplicação e acesso aos dados, de acordo com 
o nível trabalhado na disciplina.
 Documentação com javaDoc
Todos esses requisitos estão presentes no nosso sitema

7. Banco de dados

8. Interface e usabilidade

   Essas são as funcionalidades principais que estão enumeradas de acordo com o arquivo Trabalho_Final_POO2.pdf que contém a proposta do projeto.
   Qualquer dúvida, estamos a disposição.






Dia 23/11, foi feita a última atualização do projeto antes da apresentação do dia 24, decidimos implementar as duas consultas personalizadas separadas do relatório, diferente do que tínhamos entregado anteriormente, a foto da interface de consultas personalizadas pode ser conferida na pasta resultados e o projeto zip também estará atualizado na pasta de resultados. 
Além disso, teremos uma nova pasta, src3.0, que terá os arquivos atualizados, apenas os que foram alterados ou incrementados (na frente, a pasta em que foram incluídos): 

MainView.fxml	src/view/MainView.fxml (atualizado)

MainController.java	src/controller/MainController.java (atualizado)

ConsultasController.java	src/controller/ (incluído)

ConsultaPersonalizadaDao.java	src/dao/ (incluído)

Além disso, adicionamos a pasta compactada doc a pasta principal do projete, porém ela também pode ser consultada no arquivo zip da última versão do projeto 

ConsultaPendenciasMateria.java	src/model/ (incluído)

ConsultaDesempenhoMateria.java	src/model/ (incluído)

ConsultasView.fxml	src/view/ (incluído)
