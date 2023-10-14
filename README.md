# Todolist Java Spring Boot (java_spring_todolist)
Rocketseat - Curso gratuito e online de Java 2023-10-13

#### Como prepara o ambeinte 
- [Curso Java 2023-10-15 (rocketseat)](https://efficient-sloth-d85.notion.site/Curso-de-Java-2408d11bfc3447e980fe9460b6293976)
- [Curso Java 2023-10-15 (privado)](https://www.notion.so/Curso-de-Java-2023-10-15-53545cf738c54fdba906f5a409f5bd85)

#### Configurações utilizadas

##### Java
````shell
openjdk version "17.0.2" 2022-01-18 LTS
OpenJDK Runtime Environment Zulu17.32+13-CA (build 17.0.2+8-LTS)
OpenJDK 64-Bit Server VM Zulu17.32+13-CA (build 17.0.2+8-LTS, mixed mode, sharing)
````
##### Spring Boot
[start.spring.io](https://start.spring.io/)
![Configuração Spring Boot](docs\images\star.spring.io.png)

##### Libs
````xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
  </dependency>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
  </dependency>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <optional>true</optional>
  </dependency>

  <dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
  </dependency>

  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
  </dependency>

  <dependency>
    <groupId>at.favre.lib</groupId>
    <artifactId>bcrypt</artifactId>
    <version>0.10.2</version>
  </dependency>

</dependencies>
````

#### Anotações
- https://mvnrepository.com/artifact/org.mindrot.bcrypt/bcrypt/0.3
- https://start.spring.io/

#### Outros

##### H2 banco de dados em memória
- http://localhost:8080/h2-console

##### Plataforma de deploy (Plano Free)
- https://render.com/

##### Formas de execução JAVA
````shell
 mvn spring-boot:run
````

