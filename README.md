<p align="center">
  <img src="./images/naat_logo_black.png" alt="logo">
</p>

# Nix

Sitio web para órdenes de comida.

## Requerimientos

En su versión de desarrollo, sólo requiere [_JDK11+_][jdk].

Para la versión de producción, además de _JDK11+_, requiere tener una instancia de [_MySQL_][mysql] corriendo, con una base de datos vacía.

Esta requiere que las credenciales estén configuradas como variables de ambiente.

En Linux esto se logra

```console
$ export <VAR>="<value>"
...
```

Y en Windows

```powershell
> setx <VAR> "<value>"
```

Se requieren de tres variables.

* `SPRING_DATASOURCE_URL`: la dirección, puerto, y nombre donde está corriendo la base de datos.
  Por omisión, es de la forma `jdbc:mysql://localhost:3306/<db_name>`.

* `SPRING_USERNAME`: usuario de la base de datos.

* `SPRING_PASS`: contraseña del usuario de la base de datos.

## Correr

```console
[host@user nix]$ ./gradlew bootRun

> Task :bootRun

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::             (v2.3.0.M4)

...

2020-04-21 19:08:10.641  INFO 12275 --- [main] DeferredRepositoryInitializationListener : Spring Data repositories initialized!
2020-04-21 19:08:10.669  INFO 12275 --- [main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with contex
t path ''
2020-04-21 19:08:10.672  INFO 12275 --- [main] com.naat.nix.NixApplication              : Started NixApplication in 4.232 seconds (JVM running for 4.847)
```

Y como indica, entrar a `localhost:8080/`

## Construir

Esto permite empaquetar todas las dependencias. Es lo que se desplegaría en un servidor.

```console
[host@user nix]$ ./gradlew build
./gradlew build

> Task :test
2020-04-21 19:10:22.813  INFO 12455 --- [extShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence u
nit 'default'
2020-04-21 19:10:22.814  INFO 12455 --- [extShutdownHook] .SchemaDropperImpl$DelayedDropActionImpl : HHH000477: Starting delayed evictData of schema as part of SessionFactory shut-down'
2020-04-21 19:10:22.827 ERROR 12455 --- [extShutdownHook] .SchemaDropperImpl$DelayedDropActionImpl : HHH000478: Unsuccessful: drop table if exists order CASCADE
2020-04-21 19:10:22.832  INFO 12455 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
2020-04-21 19:10:22.833  INFO 12455 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2020-04-21 19:10:22.859  INFO 12455 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

BUILD SUCCESSFUL in 11s
5 actionable tasks: 3 executed, 2 up-to-date
```

Y para correr el ejecutable

```console
$ java -jar build/libs/nix-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::             (v2.3.0.M4)

 ...

 2020-04-21 19:11:56.173  INFO 12548 --- [main] com.naat.nix.NixApplication : Started NixApplication in 7.693 seconds (JVM running for 8.537)
```

[jdk]: https://naat-is-20.github.io/tools/jdk/
[mysql]: https://naat-is-20.github.io/tools/mysql/
