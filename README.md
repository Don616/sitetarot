# Projeto: Site Tarot ![GitHub Workflow Status](https://img.shields.io/github/workflow/status/Don616/sitetarot/Site%20Tarot?style=plastic)


## Instalação com Docker:

> Requisitos

- Docker;

> Clonagem do Repositório

- Dê o comando `git clone https://github.com/Don616/sitetarot` em um terminal de sua preferência;

> Comandos

- Dê os comandos abaixo na pasta raiz do repositório (./sitetarot) e execute os comandos abaixo, seja no powershell (windows) ou no terminal (linux):

1. Para criar um network: `docker network create rede-tarot`
2. Para fazer o build do mysql: `docker build -t mysql-tarot-image ./Site/api/api-site/src/database/.`
3. Para rodar o container mysql: `docker run -d -p 3306:3306 --net=rede-tarot --name mysql-tarot mysql-tarot-image`
4. Para iniciar o container mysql (caso não tenha iniciado): `docker start mysql-tarot`
5. Para fazer o build da aplicação do site: `docker build -t site-tarot-image ./Site/api/api-site/.`
6. Para iniciar a aplicação do site: `docker run -d -p 3000:3000 --net=rede-tarot --link=mysql-tarot --name site-tarot site-tarot-image`

---
## Documentação do Projeto Pessoal - V1.0

>Justificativa

Ao longo dos séculos, a humanidade sempre buscou respostas para aquilo que estava fora do seu escopo de conhecimento. Cientistas, alquimistas, médicos e demais estudiosos sempre se debruçaram sobre assuntos relacionados à morte, tempo, origem da vida e destino. Com o passar das décadas, fomos desvendando alguns destes mistérios, mas ainda há outras cujo questionamento ainda se mantém. Há um objetivo para a vida? Existe um propósito para nossa existência? Nosso destino está escrito em algum lugar?
O *tarot* ressurge nos conhecimentos da humanidade para respostar estas perguntas e muito mais. Não é relevante para o momento e nem para este projeto explicar ou se fixar na questão de que o *tarot* funciona ou não. O que importa é que a maneira como o mesmo foi construído reflete com incrível precisão a psiquê humana.  
Cada carta do *tarot*- ou cada Arcano, como é chamado - consegue imprimir um espectro da consciência humana, colocando uma espécie de símbolo universal - arquetípico - de forma que mesmo que a pessoa não entenda o símbolo de maneira racional, alguma parte da sua mente consegue absorver o conteúdo e processar a mensagem. Pensando nisso, o projeto do **Site Tarot** visa explicar o simbolismo de cada arcano, de maneira simples e moderna, mostrando uma visão mais direta para que o usuário, ao tirar uma carta online, consiga absorver sua mensagem e desenvolver algum tipo de sabedoria com elas.

> Objetivo

Criar uma página online onde o usuário cadastrado é capaz de simular uma tiragem de cartas de tarot, onde a mesma irá lhe mostrar uma mensagem explicando o significado da carta, seus símbolos, seu contexto histórico e a visão particular do autor do site sobre a mesma. É possível também acessar um relatório em dashboard com alguns dados das tiragens e consultar cada arcano de forma individual.

> Planejamento do Projeto

* Estrutura do código e versionamento armazenada no Github;
* Kambam organizado no Github Projects;
* Documentação escrita em Markdown e colocada no README.md do repositório do Github;
* Site estático utilizando JavaScript, CSS e HTML;
* Imagens dos arcanos do tarot, preferencialmente open source;
* Banco de dados no MySQL com modelagem de dados criada;
* Criação de uma Dashboard para visualização dos dados;
* Implementação da API para Login / Cadastro do usuario;

> Escopo

 - [x] Criação da Home Page;
 - [x] Criação do Quem Somos;
 - [x] Criação do Sobre Mim;
 - [x] Criação da DashBoard;
 - [x] Criação da  Login / Cadastro;
 - [x] Criação do Banco de Dados (Modelagem);
 - [x] Criação do Banco de Dados (Script);
 - [x] Escrita da Documentação;
 - [x] Kanbam Implementado;
 - [x] API integrada;
 - [x] Slide com ligação com socioemocional;
 
> Marcos do Projeto
 - [x] (07/11) - Finalização da Documentação e Backlog;
 - [x] (10/11) - Finalização da Estrutura básica (HTML) do site;
 - [x] (13/11) - Finalização do CSS do site + Conteúdo;
 - [x] (15/11) - Finalização da parte Lógica (JS) do site;
 - [x] (18/11) - Finalização da Dashboard em funcionamento + Slide;
 - [x] (21/11) - Finalização da API para login + Banco de dados;

> Restrições

 - Prazo Limite: (21/11/2021);
 - Uso do banco de dados MySQL;
 - Uso da API em NodeJS;
 - Tela de Login / Cadastro obrigatória;
 - Dashboard obrigatória;
 - Tema do projeto com relação pessoal;
 - Tema do projeto com vínculo socioemocional;
 - Apresentação em PowerPoint (slide);
 - Apresentação em no máximo 10 minutos;
 - Projeto 100% individual;
 
 > Premissas do Projeto
 
- Notebooks com internet Wi-Fi e demais tecnologias imbutidas, como IDE para arduino, VSCode, etc;
- Auxílio de professores e monitores na realização do projeto, assim como o tempo de resposta de dúvidas dentro do prazo;
- Disponibilidade do edifício Digital Building das 8h AM até 22h PM de segunda à sexta, assim como as demais dependencias do mesmo (salas e biblioteca) para uso da equipe
- Equipamento de apresentação (data show) assim como demais cabos (HDMI) disponibilizados pelas salas da BandTec;
- Funcionamento adequado das plataformas Moodle e Outlook, evitando o impedimento da comunicação com os professores;
- Equipe com disponibilidade diária de pelo menos duas horas extras, extra-classe, para a execução do projeto;

> Equipe Envolvida

O objetivo do projeto é que seja individual, onde o aluno obrigatoriamente será seu próprio Scrum Master e Project Owner, além de ser a equipe, designer e programador.

> Arquitetura

- Banco de dados relacional MySQL;
- Protótipo do site escrito em tecnologia web básica (HTML, CSS, JavaScript) e Char.JS;
- Notebooks DELL com OS Ubuntu ou HP com OS Windows 10;
- Software de gestão de projetos Github Projects (online);
- Software de prototipagem Figma (se precisar);
- Equipamentos periféricos como mouse, pendrive (flashdrive) e celulares (opcionais);
- Pacote Office preferencialmente com Word e Powerpoint para realização de apresentações e escrita de documentação. Disponível na nuvem;
- Editor de código Visual Studio Code (VSCode);
- Sistema de controle de versão Git assim como seu repositório na nuvem; 

> Sustentação

 - Manutenção do banco de dados;
 - Atualização constante do site;



