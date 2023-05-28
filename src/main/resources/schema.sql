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