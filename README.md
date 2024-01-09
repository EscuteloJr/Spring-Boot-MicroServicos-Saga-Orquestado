# Spring-Boot-MicroServicos-Saga-Orquestrado

## Tecnologias Usadas
* Java 17
* Spring Boot 3
* Apache Kafka
* API REST
* PostgreSQL
* Docker
* docker-compose
* Redpanda Console

## Ferramentas utilizadas
* NetBeans Community Edition
* Docker
* Maven

 ## Arquitetura Proposta

 Em nossa arquitetura, teremos 3 serviços:

* Banco-Service (Dois Bancos):
  Os microsserviços responsáveis por disponibilizar, e receber uma notificação sobre os dados de seus clientes. Aqui que teremos endpoints REST para inciar o processo e recuperar os dados dos eventos. O banco de dados utilizado será o PostgresSQL.
* Conecta (Orquestrador-Service):
   microsserviço responsável por orquestrar todo o fluxo de execução da Saga, ele que saberá qual microsserviço foi executado e em qual estado, e para qual será o próximo microsserviço a ser enviado, este microsserviço também irá salvar o processo dos eventos. Este serviço não possui banco de dados.
  
## Execução do projeto
### Execução da main

<code> git clone https://github.com/EscuteloJr/Spring-Boot-MicroServicos-Saga-Orquestado.git  
</code>
<br>
<code>docker compose up</code>

### Execução da Estrutura Revisada

<code> git clone https://github.com/EscuteloJr/Spring-Boot-MicroServicos-Saga-Orquestado.git  
</code>
<br>
<code> git checkout EstruturaRevisada</code>
<br>
<code>docker compose up</code>

