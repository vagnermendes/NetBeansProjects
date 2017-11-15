/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v6.2.1                     */
/* Target DBMS:           PostgreSQL 8.3                                  */
/* Project file:          banco_joalheria.dez                             */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2011-03-13 19:22                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Tables                                                                 */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "receita"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE receita (
    receita_id SERIAL   NOT NULL,
    cliente_id INTEGER ,
    descricao CHARACTER VARYING(40) ,
    CONSTRAINT PK_receita PRIMARY KEY (receita_id)
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
    nome CHARACTER VARYING(40) ,
    endereco CHARACTER VARYING(40) ,
    bairro CHARACTER VARYING(40) ,
    cidade CHARACTER VARYING(40) ,
    uf CHARACTER(2) ,
    ddd_tel INTEGER ,
    telefone INTEGER ,
    observacao TEXT ,
    cep CHARACTER(8) ,
    CONSTRAINT PK_cliente PRIMARY KEY (cliente_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "empresa"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE empresa (
    empresa_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(40) ,
    endereco CHARACTER VARYING(40) ,
    bairro CHARACTER VARYING(40) ,
    cidade CHARACTER VARYING(40) ,
    uf CHARACTER(2) ,
    cep CHARACTER(8) ,
    ddd_tel INTEGER ,
    telefone INTEGER ,
    observacao CHARACTER VARYING(255) ,
    CONSTRAINT PK_empresa PRIMARY KEY (empresa_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "ordem_servico"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE ordem_servico (
    ordem_servico_id SERIAL   NOT NULL,
    cliente_id INTEGER ,
    empresa_id INTEGER ,
    servico_id INTEGER ,
    funcionario_id INTEGER ,
    descricao CHARACTER VARYING(255) ,
    observacao CHARACTER VARYING(255) ,
    CONSTRAINT PK_ordem_servico PRIMARY KEY (ordem_servico_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "funcionario"                                                */
/* ---------------------------------------------------------------------- */

CREATE TABLE funcionario (
    funcionario_id SERIAL   NOT NULL,
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
    CONSTRAINT PK_contas_receber PRIMARY KEY (contas_receber_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "vendas"                                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE vendas (
    vendas_id SERIAL   NOT NULL,
    cliente_id INTEGER ,
    produtos_id integer,
    data DATE ,
    quantidade INTEGER ,
    preco DOUBLE PRECISION ,
    preco_venda DOUBLE PRECISION ,
    desconto DOUBLE PRECISION ,
    CONSTRAINT PK_vendas PRIMARY KEY (vendas_id)
);

/* ---------------------------------------------------------------------- */
/* Foreign key constraints                                                */
/* ---------------------------------------------------------------------- */

ALTER TABLE receita ADD CONSTRAINT cliente_receita 
    FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id);

ALTER TABLE cliente ADD CONSTRAINT categoria_cliente 
    FOREIGN KEY (categoria_id) REFERENCES categoria (categoria_id);

ALTER TABLE ordem_servico ADD CONSTRAINT cliente_ordem_servico 
    FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id);

ALTER TABLE ordem_servico ADD CONSTRAINT empresa_ordem_servico 
    FOREIGN KEY (empresa_id) REFERENCES empresa (empresa_id);

ALTER TABLE ordem_servico ADD CONSTRAINT servico_ordem_servico 
    FOREIGN KEY (servico_id) REFERENCES servico (servico_id);

ALTER TABLE ordem_servico ADD CONSTRAINT funcionario_ordem_servico 
    FOREIGN KEY (funcionario_id) REFERENCES funcionario (funcionario_id);

ALTER TABLE vendas ADD CONSTRAINT cliente_vendas 
    FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id);

ALTER TABLE vendas ADD CONSTRAINT produtos_vendas 
    FOREIGN KEY (produtos_id) REFERENCES produtos (produtos_id);
