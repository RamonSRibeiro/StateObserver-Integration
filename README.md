# Sistema de Semáforo — State, Observer e Factory Method

Projeto desenvolvido em Java para demonstrar a utilização dos padrões de projeto **State**, **Observer** e **Factory Method**.

## Padrões utilizados

* **State:** controla os estados do semáforo: Verde, Amarelo e Vermelho.
* **Observer:** notifica motoristas e pedestres sempre que o estado do semáforo muda.
* **Factory Method:** cria e configura objetos `Semaforo` por meio de uma fábrica padrão.

## Funcionamento

O semáforo segue o ciclo:

**Verde → Amarelo → Vermelho → Verde**

Os observadores recebem uma mensagem sempre que ocorre uma mudança de estado.

## Testes

Os testes foram implementados com **JUnit 5**, verificando as mudanças de estado, as notificações dos observadores e a criação do semáforo pela Factory.

## Objetivo

Praticar a integração dos padrões **State, Observer e Factory Method** em um exemplo simples e de fácil compreensão.
