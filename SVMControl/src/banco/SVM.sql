
/*
TABELA ADMINSTRADOR
*/
create table administrador(
administrador_id serial primary key,
nome varchar(255),
login varchar(255),
senha varchar(255)
);
insert into public.administrador (nome,login,senha) values ('Admin','root','root');

/*CLIENTES*/
create table clientes(
cliente_id serial not null,    
    nome character varying(40),
    endereco character varying(40),
    bairro character varying(40),
    cidade character varying(40),
    uf character(2),
    email character varying(255),
    ddd_tel integer,
    telefone integer,
    ddd_cel integer,
    situacao integer,
    celular integer,
    observacao text,
    numero character varying(50),
    cep integer,
    login character varying(255),
    senha character varying(255),
    esquema character varying(255),
    cpf character varying(50),    
    CONSTRAINT PK_cliente PRIMARY KEY (cliente_id)
);


create table pagamento(
pagamento_id serial not null,
cliente_id integer,
data date,
CONSTRAINT PK_pagamento PRIMARY KEY (pagamento_id),
CONSTRAINT pagamento_clientes FOREIGN KEY (cliente_id) REFERENCES clientes (cliente_id)
);