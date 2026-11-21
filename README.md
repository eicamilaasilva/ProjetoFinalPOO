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
   
   
   
