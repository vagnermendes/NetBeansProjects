
CREATE TABLE orcamento (
    orcamento_id serial primary key,
    cliente character varying(255),
    data date
);

CREATE TABLE item_orcamento (
    item_orcamento_id serial primary key,
    nome character varying(255),
    quantidade integer,
    valor double precision,
    orcamento_id integer,
    FOREIGN KEY (orcamento_id) REFERENCES orcamento(orcamento_id)
);

CREATE TABLE categoria (
    categoria_id serial primary key,
    nome character varying(40)
);

CREATE TABLE pessoa (
    pessoa_id serial primary key,
    nome character(40)
);

CREATE TABLE cliente (
    cliente_id serial primary key,
    categoria_id integer,
    pessoa_id integer,
    nome character varying(40),
    endereco character varying(40),
    bairro character varying(40),
    cidade character varying(40),
    uf character(2),
    email character varying(255),
    ddd_tel integer,
    telefone integer,
    observacao text,
    numero character varying(50),
    cep integer,
    data_nascimento date,
    mae character varying(255),
    pai character varying(255),
    cpf character varying(50),
    rg character varying(50),
    estado_civil character varying(50),
    ddd_cel integer,
    celular integer,
    complemento character varying(300),
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(pessoa_id),
    FOREIGN KEY (categoria_id) REFERENCES categoria(categoria_id)
);

CREATE TABLE empresa (
    empresa_id serial primary key,
    nome character varying(50),
    endereco character varying(50),
    bairro character varying(50),
    numero character varying(50),
    cidade character varying(50),
    email character varying(50),
    uf character(2),
    ddd_tel integer,
    telefone integer,
    observacao text,
    cep character varying(20)
);

CREATE TABLE nivel (
    nivel_id serial primary key,
    nome character varying(40)
);

CREATE TABLE funcionario (
    funcionario_id serial primary key,
    nivel_id integer,
    nome character varying(255),
    endereco character varying(255),
    bairro character varying(255),
    cidade character varying(255),
    uf character(2),
    ddd_tel integer,
    telefone integer,
    login character varying(255),
    senha character varying(255),
    cep integer,
    numero character varying(40),
    idt character varying(50),
    cpf character varying(50),
    data_admissao date,
    FOREIGN KEY (nivel_id) REFERENCES nivel(nivel_id)
);

CREATE TABLE servico (
    servico_id serial primary key,
    nome character varying(40)
);

CREATE TABLE ordem_servico (
    ordem_servico_id serial primary key,
    cliente_id integer,
    servico_id integer,
    funcionario_id integer,
    descricao text,
    observacao text,
    valor double precision,
    data_abertura date,
    status integer,
    data_entrega date,
    produto character varying(255),
    modelo character varying(255),
    referencia character varying(255),
    entrada double precision,
    restante double precision,
    formapagamento character varying(255),
    FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id),
    FOREIGN KEY (funcionario_id) REFERENCES funcionario(funcionario_id),
    FOREIGN KEY (servico_id) REFERENCES servico(servico_id)
);

