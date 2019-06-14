# Esqueleto Ambulante

Uma aplicação mínima em Spring Boot.

[![CircleCI](https://circleci.com/gh/aceleradora-TW/esqueleto-ambulante/tree/master.svg?style=svg)](https://circleci.com/gh/aceleradora-TW/esqueleto-ambulante/tree/master)

![Caveira](./src/main/resources/static/images/sneaky.gif)


## Dependências

- Java 11
- Postgres 9.5

## Executando a aplicação

Para inicar o servidor:

```sh
./gradlew bootRun
```

O comando acima executará as migrações do banco de dados (que criarão as tabelas necessárias no banco de dados) antes de iniciar o servidor. 

Para saber quais alterações serão executadas no banco, veja os arquivos de migração em: `src/main/resources/db/migration`

Executando os testes:

```sh
./gradlew test
```

Demais comandos disponíveis:

```sh
./gradlew tasks
```

## Ferramentas

- [Circle CI](https://circleci.com/gh/aceleradora-TW/esqueleto-ambulante)


## Ambientes

__Integração__

Endereço: https://esqueleto-integracao.herokuapp.com

Este ambiente é atualizado toda vez que uma alteração é introduzida no projeto e as verificações automatizados do Circle CI executam exitosamente. Ou seja é o ambiente mais instável e que recebe as alterações mais recentes.
