# PatrimonioManager

Alunos: 
Matheus Henrique Custodio Rossetti /
Vinicius Maier

Passos para rodar:
1 - Baixar as seguintes dependencias 

 1.1 - NodeJS (necessario para utilizar o npm package manager) - https://nodejs.org/en - Qualquer versão

 1.2 - AngularCLI (necessario para rodar o local do angular) - Apos instalar o node só rodar na sua linha de comando: npm install -g @angular/cli
 
 Em alguns computadores Windows a execução de scripts esta desabilitada, caso o comando acima de algum erro use o seguinte comando:
 Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy RemoteSigned
 
 1.3 - O aplicativo utiliza banco de dados em PostgresSQL - https://www.postgresql.org/download/ - Utilize a versão de acordo com seu computador
 
 1.3.1 - Apos instalar o Postgres crie o banco com o nome: PatrimonioManager
 
 1.3.2 - Antes de rodar o aplicativo navegue até o arquivo server/patrimonio/src/main/resources/application.yml e altere os campos username e password para o seu respectivo usuario do postgres

 1.4 - O aplicativo utiliza o JDK Java 11 - Certifique-se que voce tem essa versão na sua maquina - https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html - Selecione a versão de acordo com sua maquina

 1.5 - Dentro da pasta web, abra uma janela da sua linha de comando de escolha e utilize o comando npm i (para instalar as dependencias do projeto) e aguarde finalizar
 
 1.5 - Apos o download das dependenciar finalizar, rode o comando ng serve (ira subir o frontend para sua porta :4200);

 1.6 - Na pasta server/patrimonio, abra o projeto com sua IDE de escolha, aguarde a IDE indexar e baixar todas as suas dependencias e pode rodar atraves da classe main.

 Tudo pronto, agora só acessar sua porta localhost:4200 e o projeto estara completamente funcional para sua utilização. Caso tenha tido algum erro/duvida nos colocamos a disposição para auxilio através dos contatos:
 
 (44)99709-0799 - WhatsApp
 mh.rossetti2002@gmail.com - Email
 vinicius.69197-2021@aluno.unicv.edu.br - Email 
 matheus.80574-2021@aluno.unicv.edu.br - Email

