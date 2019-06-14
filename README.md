# Esqueleto Ambulante

Uma aplicação mínima em Spring Boot, Vue JS e Postgres

[![CircleCI](https://circleci.com/gh/aceleradora-TW/esqueleto-ambulante/tree/master.svg?style=svg)](https://circleci.com/gh/aceleradora-TW/esqueleto-ambulante/tree/master)

![Caveira](./webservice/src/main/resources/static/images/sneaky.gif)


## Dependências

- Java 11
- Postgres 9.5
- node 11

### Configurando banco de dados local

Por padrão, a aplicação tentará conectar com um banco de dados Postgres ao iniciar. Veja o arquivo `src/main/resources/application-dev.yml` para saber qual usuário e senha será utilizado. 

Você precisará criar um banco de dados vazio antes de iniciar a aplicação. O nome do banco padrão é `esqueleto` (veja o arquivo de configuração mencionado anteriormente). Para criá-lo, execute:

```bash
sudo -u postgres psql -c 'CREATE DATABASE esqueleto'
```

__Usando Postgres via Docker__

Caso não queira instalar o Postgres na sua máquina, é possível utilizá-lo via Docker:

Inicie o container em plano de fundo:

```bash
docker run --rm --name esqueleto-db -p 5432:5432 -e POSTGRES_PASSWORD=esqueleto -d postgres
```

Crie o banco de dados `esqueleto`:

```bash
docker exec -it esqueleto-db psql -U postgres -c 'CREATE DATABASE esqueleto'
```

## As aplicações

### Web Service:
Para inicializar a webservice da aplicação
clique [aqui](./webservice) e sigua os passos descritos no readme.
### Web App
Para rodar o cliente clique [aqui](./webapp) e siga as instruções no readme.