/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v6.2.1                     */
/* Target DBMS:           PostgreSQL 8.3                                  */
/* Project file:          banco_joalheria.dez                             */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2011-03-31 16:49                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Tables                                                                 */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "receita"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE ouro
(
  ouro_id serial NOT NULL,
  nome DOUBLE PRECISION,
  CONSTRAINT ouro_pkey PRIMARY KEY (ouro_id)
);


CREATE TABLE site
(
  site_id serial NOT NULL,
  quemsomos text,
  servicos text,
  trabalho text,
  contato text,
  CONSTRAINT site_pkey PRIMARY KEY (site_id)
);


CREATE TABLE receita
(
  receita_id serial NOT NULL,
  cliente_id integer,
  odla DOUBLE PRECISION,
    odlc DOUBLE PRECISION,
    odle DOUBLE PRECISION,
    odli DOUBLE PRECISION,
    odpa DOUBLE PRECISION,
    odpc DOUBLE PRECISION,
    odpe DOUBLE PRECISION,
    odpi DOUBLE PRECISION,
    oela DOUBLE PRECISION,
    oelc DOUBLE PRECISION,
    oele DOUBLE PRECISION,
    oeli DOUBLE PRECISION,
    oepa DOUBLE PRECISION,
    oepc DOUBLE PRECISION,
    oepe DOUBLE PRECISION,
    oepi DOUBLE PRECISION,
  lentes character varying(40),
  observacao character varying(40),
  CONSTRAINT pk_receita PRIMARY KEY (receita_id),
  CONSTRAINT cliente_receita FOREIGN KEY (cliente_id)
      REFERENCES cliente (cliente_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

/* ---------------------------------------------------------------------- */
/* Add table "categoria"                                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE categoria (
    categoria_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(40) ,
    CONSTRAINT PK_categoria PRIMARY KEY (categoria_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "servico"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE servico (
    servico_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(40) ,
    CONSTRAINT PK_servico PRIMARY KEY (servico_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "cliente"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE cliente (
    cliente_id SERIAL   NOT NULL,
    categoria_id INTEGER ,
    pessoa_id INTEGER ,
    nome CHARACTER VARYING(40) ,
    endereco CHARACTER VARYING(40) ,
    bairro CHARACTER VARYING(40) ,
    cidade CHARACTER VARYING(40) ,
    uf CHARACTER(2) ,
    email CHARACTER VARYING(255) ,
    ddd_tel INTEGER ,
    telefone INTEGER ,
    observacao TEXT ,
    cep CHARACTER(8) ,
    CONSTRAINT PK_cliente PRIMARY KEY (cliente_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "ordem_servico"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE ordem_servico (
    ordem_servico_id SERIAL   NOT NULL,
    cliente_id INTEGER ,
    servico_id INTEGER ,
    funcionario_id INTEGER ,
    descricao CHARACTER VARYING(255) ,
    observacao CHARACTER VARYING(255) ,
    valor DOUBLE PRECISION ,
    data DATE ,
    status INTEGER ,
    CONSTRAINT PK_ordem_servico PRIMARY KEY (ordem_servico_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "funcionario"                                                */
/* ---------------------------------------------------------------------- */

CREATE TABLE funcionario (
    funcionario_id SERIAL   NOT NULL,
    nivel_id INTEGER ,
    nome CHARACTER VARYING(255) ,
    endereco CHARACTER VARYING(255) ,
    bairro CHARACTER VARYING(255) ,
    cidade CHARACTER VARYING(255) ,
    uf CHARACTER(2) ,
    ddd_tel INTEGER ,
    telefone INTEGER ,
    observacao CHARACTER VARYING(255) ,
    idt INTEGER ,
    cpf INTEGER ,
    data_admissao DATE ,
    data_demissao DATE ,
    CONSTRAINT PK_funcionario PRIMARY KEY (funcionario_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "fornecedor"                                                 */
/* ---------------------------------------------------------------------- */

CREATE TABLE fornecedor (
    fornecedor_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    endereco CHARACTER VARYING(255) ,
    bairro CHARACTER VARYING(255) ,
    cidade CHARACTER VARYING(255) ,
    uf CHARACTER(2) ,
    ddd_tel INTEGER ,
    telefone INTEGER ,
    email CHARACTER VARYING(255) ,
    dados_bancarios TEXT ,
    cep INTEGER ,
    numero CHARACTER VARYING(40) ,
    CONSTRAINT PK_fornecedor PRIMARY KEY (fornecedor_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "produtos"                                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE produtos (
    produtos_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    preco_venda DOUBLE PRECISION ,
    preco_custo DOUBLE PRECISION ,
    preco_promocional DOUBLE PRECISION ,
    peso DOUBLE PRECISION ,
    indice DOUBLE PRECISION,
    quantidade DOUBLE PRECISION ,
    foto CHARACTER VARYING(255) ,
    descricao TEXT ,
    codigo_barra CHARACTER VARYING(255) ,
    CONSTRAINT PK_produtos PRIMARY KEY (produtos_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "contas_pagar"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE contas_pagar (
    contas_pagar_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    valor DOUBLE PRECISION ,
    data DATE ,
    status INTEGER ,
    CONSTRAINT PK_contas_pagar PRIMARY KEY (contas_pagar_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "contas_receber"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE contas_receber (
    contas_receber_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    valor DOUBLE PRECISION ,
    data DATE ,
    status INTEGER ,
    CONSTRAINT PK_contas_receber PRIMARY KEY (contas_receber_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "vendas"                                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE vendas (
    vendas_id SERIAL   NOT NULL,
    cliente_id INTEGER ,
    data DATE ,
    hora DATE ,
    preco DOUBLE PRECISION ,
    preco_venda DOUBLE PRECISION ,
    desconto DOUBLE PRECISION ,
    CONSTRAINT PK_vendas PRIMARY KEY (vendas_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "item_produto"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE item_produto (
    item_produto_id SERIAL   NOT NULL,
    vendas_id INTEGER ,
    produtos_id INTEGER ,
    quantidade INTEGER ,
    CONSTRAINT PK_item_produto PRIMARY KEY (item_produto_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa"                                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa (
    pessoa_id SERIAL   NOT NULL,
    nome CHARACTER(40) ,
    CONSTRAINT PK_pessoa PRIMARY KEY (pessoa_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "nivel"                                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE nivel (
    nivel_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(40) ,
    CONSTRAINT PK_nivel PRIMARY KEY (nivel_id)
);

/* ---------------------------------------------------------------------- */
/* Foreign key constraints                                                */
/* ---------------------------------------------------------------------- */

ALTER TABLE receita ADD CONSTRAINT cliente_receita 
    FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id);

ALTER TABLE cliente ADD CONSTRAINT categoria_cliente 
    FOREIGN KEY (categoria_id) REFERENCES categoria (categoria_id);

ALTER TABLE cliente ADD CONSTRAINT pessoa_cliente 
    FOREIGN KEY (pessoa_id) REFERENCES pessoa (pessoa_id);

ALTER TABLE ordem_servico ADD CONSTRAINT cliente_ordem_servico 
    FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id);

ALTER TABLE ordem_servico ADD CONSTRAINT servico_ordem_servico 
    FOREIGN KEY (servico_id) REFERENCES servico (servico_id);

ALTER TABLE ordem_servico ADD CONSTRAINT funcionario_ordem_servico 
    FOREIGN KEY (funcionario_id) REFERENCES funcionario (funcionario_id);

ALTER TABLE funcionario ADD CONSTRAINT nivel_funcionario 
    FOREIGN KEY (nivel_id) REFERENCES nivel (nivel_id);

ALTER TABLE vendas ADD CONSTRAINT cliente_vendas 
    FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id);

ALTER TABLE item_produto ADD CONSTRAINT vendas_item_produto 
    FOREIGN KEY (vendas_id) REFERENCES vendas (vendas_id);

ALTER TABLE item_produto ADD CONSTRAINT produtos_item_produto 
    FOREIGN KEY (produtos_id) REFERENCES produtos (produtos_id);


/* altearacoes */
/* ---------------------------------------------------------------------- */
/* Add table "cartoes"                                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE cartoes (
    cartoes_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(40) ,
    CONSTRAINT PK_cartoes PRIMARY KEY (cartoes_id)
);

CREATE TABLE parcelas (
    parcelas_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(40) ,
    CONSTRAINT PK_parcelas PRIMARY KEY (parcelas_id)
);

alter table receita add column armacao varchar(255);
alter table receita add column montagem integer;
alter table receita add column alteracao integer;
alter table receita add column coloracao integer;
alter table receita add column reflexo integer;
alter table receita add column sufassagem integer;
alter table receita add column md varchar(50);
alter table receita add column ta varchar(50);
alter table receita add column mv varchar(50);
alter table receita add column alt varchar(50);
alter table receita add column p varchar(50);
alter table receita add column dnpop varchar(50);
alter table receita add column dnpoe varchar(50);
