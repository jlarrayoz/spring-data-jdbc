# spring-data-jdbc
En este proyecto vamos a agregar el uso de persistencia (SPRING-DATA-JDBC) al proyecto de pedidos de pizza


**Vamos a trabajar con SPRING-DATA-JDBC y a grandes rasgos vamos a realizar los siguientes pasos:**

<ol>
	<li>Agregar la dependencia de spring DATA sJDBC</li>
	<li>Remover la dependencia de JDBC Template, ya no la vamos a necesitar</li>
	<li>Vamos a borrar las impementaciones anteriores (inmemory y jdbc) de las interfaces de los repositorios y acomodar las clases que fallen por falta de dependencias</li>
	<li>Vamos a modificar las interfaces para que extiendan de CrudRepository</li>
	<li>Vamos a anotar las clases para que spring pueda generar la impementación de las interfaces en runtime (@Table, @Id)</li>
	<li>Vamos a cambiar la manera de cargar los datos a la BD</li>
	<li>Vamos a realizar algunos cambios en schema.sql para soportar lo requerido por data-jdbc</li>
</ol>


1 - Debemos agregar en el pom.xml las siguientes dependencias:

```xml
<!-- Dependencia para usar DATA-JDBC -->
<dependency>
	<groupId>org.springframework.boot</groupId> 
	<artifactId>spring-boot-starter-data-jdbc</artifactId>
</dependency>

```

2 - Remover la dependencia de JDBC Template

Vamos a remover la siguiente dependencia:

```xml
<dependency> 
	<groupId>org.springframework.boot</groupId> 
	<artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

Mantenderemos la dependencia de H2, ya que vamos a necesitar el motor de BD:

```xml
<!-- Dependecia para utilizar el DBMS H2 -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

**RECORDAR:**

Para acceder a la consola, una vez levantada la app debemos ir a la siguiente URL en el browser:

[http://localhost:8080/h2-console/](http://localhost:8080/h2-console/)


La URL de acceso a la bd del proyecto es la siguiente:

jdbc:h2:mem:pizzadb


6 - En la clase CursoSpringApplication vamos a agregar el siguiente método:


```java
@Bean
CommandLineRunner dataLoader(IngredienteRepository repo) {
	...
}	
```

Vamos a borrar el archivo data.sql ya que hemos cambiado la manera de cargar los datos.


7 - A continuación se puede apreciar la nueva definicion de las tablas:

```sql
create table if not exists Orden_Pizza (
  id identity,
  nombrePersona varchar(50) not null,
  ciudad varchar(50) not null,
  barrio varchar(50) not null,
  direccion varchar(50) not null,
  nroTarjeta varchar(16) not null,
  fecVencimiento varchar(5) not null,
  codigoCVV varchar(3) not null
);

create table if not exists Pizza (
  id identity,
  nombre varchar(50) not null,
  orden_pizza bigint not null,
  orden_pizza_key bigint not null
);


create table if not exists Ingrediente (
  id varchar(4) not null,
  nombre varchar(25) not null,
  tipo varchar(10) not null
);


create table if not exists Ingrediente_Pizza (
  ingrediente varchar(4) not null,
  pizza bigint not null,
  pizza_key bigint not null
);


ALTER TABLE Ingrediente ADD PRIMARY KEY (id);
alter table Pizza add foreign key (orden_pizza) references Orden_Pizza(id);
alter table Ingrediente_Pizza add foreign key (ingrediente) references Ingrediente(id);
```