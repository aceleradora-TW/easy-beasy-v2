# Easy Beasy

## Dependências

- Java 11
- Postgres 9.5
- Node 12

### Configurando banco de dados local

Por padrão, a aplicação tentará conectar com um banco de dados Postgres ao iniciar. Veja o arquivo `webservice/src/main/resources/application-dev.yml` para saber qual usuário e senha será utilizado. 

Você precisará criar um banco de dados vazio antes de iniciar a aplicação. O nome do banco padrão é `easybeasy` (veja o arquivo de configuração mencionado anteriormente). Para criá-lo, execute:

```bash
sudo -u postgres psql -c 'CREATE DATABASE easybeasy'
```

__Usando Postgres via Docker__

Caso não queira instalar o Postgres na sua máquina, é possível utilizá-lo via Docker:

Inicie o container em plano de fundo:

```bash
docker run \ 
  --rm \
  --detach \
  --name easybeasy-db \
  --publish 5432:5432 \
  --env POSTGRES_PASSWORD=123456 \
  postgres
```

Crie o banco de dados `esqueleto`:

```bash
docker exec -it esqueleto-db psql -U postgres -c 'CREATE DATABASE easybeasy'
```

## Desenvolvimento local

Antes de mais nada, as dependências do front-end devem ser instaladas:

```java
./gradlew yarnInstall
```

É importante manipular o Yarn através do Gradle, pois utilizamos um plugin do Gradle que instalará sua própria instalação do Node. Isto é
necessário para que a aplicação possa ser construída no Heroku utilizando apenas o buildpack do Gradle. Pela ordem em que a aplicação é
construída, não foi possível utilizar dois buildpacks separados, por isso a decisão de utilizar uma versão embutida do Node.

Para construir a aplicação a cada mudança, execute em um terminal:

```java
./gradlew -t build buildForDevelopment
```

Enquanto a construção contínua (o comando acima) executa em um terminal, em outro, execute a aplicação:

```java
./gradlew bootrun
```

Com estes dois comandos rodando simultaneamente, a aplicação será reconstruída e reiniciará a cada mudança, tanto de front-end quanto de back-end.

## Heroku 

http://easy-beasy-test.herokuapp.com
