
CREATE TABLE cartoes (
    cartoes_id serial NOT NULL,
    nome character varying(40)
);



CREATE TABLE categoria (
    categoria_id serial NOT NULL,
    nome character varying(40)
);


CREATE TABLE cliente (
    cliente_id serial NOT NULL,
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
    cpf character varying(50)
);


CREATE TABLE contas_pagar (
    contas_pagar_id serial NOT NULL,
    nome character varying(255),
    valor double precision,
    data date,
    status integer,
    codebar character varying(255)
);

CREATE TABLE contas_receber (
    contas_receber_id serial NOT NULL,
    nome character varying(255),
    valor double precision,
    data date,
    status integer,
    vendas_id integer,
    codebar character varying(255)
);


CREATE TABLE empresa (
    empresa_id serial NOT NULL,
    nome character varying(40),
    endereco character varying(40),
    bairro character varying(40),
    numero character varying(40),
    cidade character varying(40),
    email character varying(40),
    uf character(2),
    ddd_tel integer,
    telefone integer,
    observacao character varying(255),
    cep character varying(20),
	primary key(empresa_id)
);


CREATE TABLE fornecedor (
    fornecedor_id serial NOT NULL,
    nome character varying(255),
    endereco character varying(255),
    bairro character varying(255),
    cidade character varying(255),
    uf character(2),
    ddd_tel integer,
    telefone integer,
    email character varying(255),
    dados_bancarios text,
    cep integer,
    numero character varying(40)
);


CREATE TABLE funcionario (
    funcionario_id serial NOT NULL,
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
    data_admissao date
);


CREATE TABLE item_produto (
    item_produto_id serial NOT NULL,
    vendas_id integer,
    produtos_id integer,
    quantidade double precision
);


CREATE TABLE nivel (
    nivel_id serial NOT NULL,
    nome character varying(40)
);


CREATE TABLE ordem_servico (
    ordem_servico_id serial NOT NULL,
    cliente_id integer,
    servico_id integer,
    funcionario_id integer,
    descricao text,
    observacao text,
    valor double precision,
    restante double precision,
    data_abertura date,
    status integer,
    data_entrega date,
    produto character varying(255),
    modelo character varying(255),
    referencia character varying(255),
    entrada double precision
);


CREATE TABLE ouro (
    ouro_id serial NOT NULL,
    nome double precision
);
ALTER TABLE ONLY ouro
    ADD CONSTRAINT ouro_pkey PRIMARY KEY (ouro_id);


CREATE TABLE parcelas (
    parcelas_id serial NOT NULL,
    nome character varying(40)
);


CREATE TABLE pessoa (
    pessoa_id serial NOT NULL,
    nome character(40)
);


CREATE TABLE produtos (
    produtos_id serial NOT NULL,
    nome character varying(255),
    preco_venda double precision,
    preco_custo double precision,
    preco_promocional double precision,
    peso double precision,
    quantidade double precision,
    foto character varying(255),
    descricao text,
    codigo_barra character varying(255),
    indice double precision
);


CREATE TABLE receita (
    receita_id serial NOT NULL,
    cliente_id integer,
    odla double precision,
    odlc double precision,
    odle double precision,
    odli integer,
    odpa double precision,
    odpc double precision,
    odpe double precision,
    odpi integer,
    oela double precision,
    oelc double precision,
    oele double precision,
    oeli integer,
    oepa double precision,
    oepc double precision,
    oepe double precision,
    oepi integer,
    lentes character varying(40),
    observacao character varying(40),
    armacao character varying(255),
    montagem integer,
    alteracao integer,
    coloracao integer,
    reflexo integer,
    sufassagem integer,
    md character varying(50),
    ta character varying(50),
    mv character varying(50),
    alt character varying(50),
    p character varying(50),
    dnpop character varying(50),
    dnpoe character varying(50)
);

CREATE TABLE servico (
    servico_id serial NOT NULL,
    nome character varying(40)
);


CREATE TABLE site (
    site_id serial NOT NULL,
    quemsomos text,
    home text,
    servicos text,
    trabalho text,
    contato text
);


CREATE TABLE vendas (
    vendas_id serial NOT NULL,
    cliente_id integer,
    data date,
    preco double precision,
    preco_venda double precision,
    desconto double precision,
    hora time without time zone,
    cartoes_id integer,
    parcelas_id integer,
    funcionario_id integer
);



ALTER TABLE ONLY ouro
    ADD CONSTRAINT ouro_pkey PRIMARY KEY (ouro_id);


--
-- Name: pk_cartoes; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY cartoes
    ADD CONSTRAINT pk_cartoes PRIMARY KEY (cartoes_id);


--
-- Name: pk_categoria; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY categoria
    ADD CONSTRAINT pk_categoria PRIMARY KEY (categoria_id);


--
-- Name: pk_cliente; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT pk_cliente PRIMARY KEY (cliente_id);


--
-- Name: pk_contas_pagar; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY contas_pagar
    ADD CONSTRAINT pk_contas_pagar PRIMARY KEY (contas_pagar_id);


--
-- Name: pk_contas_receber; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY contas_receber
    ADD CONSTRAINT pk_contas_receber PRIMARY KEY (contas_receber_id);


--
-- Name: pk_empresa; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY empresa
    ADD CONSTRAINT pk_empresa PRIMARY KEY (empresa_id);


--
-- Name: pk_fornecedor; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT pk_fornecedor PRIMARY KEY (fornecedor_id);


--
-- Name: pk_funcionario; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT pk_funcionario PRIMARY KEY (funcionario_id);


--
-- Name: pk_item_produto; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY item_produto
    ADD CONSTRAINT pk_item_produto PRIMARY KEY (item_produto_id);


--
-- Name: pk_nivel; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY nivel
    ADD CONSTRAINT pk_nivel PRIMARY KEY (nivel_id);


--
-- Name: pk_ordem_servico; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY ordem_servico
    ADD CONSTRAINT pk_ordem_servico PRIMARY KEY (ordem_servico_id);


--
-- Name: pk_parcelas; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY parcelas
    ADD CONSTRAINT pk_parcelas PRIMARY KEY (parcelas_id);


--
-- Name: pk_pessoa; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pk_pessoa PRIMARY KEY (pessoa_id);


--
-- Name: pk_produtos; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY produtos
    ADD CONSTRAINT pk_produtos PRIMARY KEY (produtos_id);


--
-- Name: pk_receita; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY receita
    ADD CONSTRAINT pk_receita PRIMARY KEY (receita_id);


--
-- Name: pk_servico; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY servico
    ADD CONSTRAINT pk_servico PRIMARY KEY (servico_id);


--
-- Name: pk_vendas; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY vendas
    ADD CONSTRAINT pk_vendas PRIMARY KEY (vendas_id);


--
-- Name: site_pkey; Type: CONSTRAINT; Schema: public; Owner: personal; Tablespace: 
--

ALTER TABLE ONLY site
    ADD CONSTRAINT site_pkey PRIMARY KEY (site_id);


--
-- Name: cartoes_vendas; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY vendas
    ADD CONSTRAINT cartoes_vendas FOREIGN KEY (cartoes_id) REFERENCES cartoes(cartoes_id);


--
-- Name: categoria_cliente; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT categoria_cliente FOREIGN KEY (categoria_id) REFERENCES categoria(categoria_id);


--
-- Name: cliente_ordem_servico; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY ordem_servico
    ADD CONSTRAINT cliente_ordem_servico FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id);


--
-- Name: cliente_receita; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY receita
    ADD CONSTRAINT cliente_receita FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id);


--
-- Name: cliente_vendas; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY vendas
    ADD CONSTRAINT cliente_vendas FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id);


--
-- Name: funcionario_ordem_servico; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY ordem_servico
    ADD CONSTRAINT funcionario_ordem_servico FOREIGN KEY (funcionario_id) REFERENCES funcionario(funcionario_id);


--
-- Name: funcionario_vendas; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY vendas
    ADD CONSTRAINT funcionario_vendas FOREIGN KEY (funcionario_id) REFERENCES funcionario(funcionario_id);


--
-- Name: nivel_funcionario; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT nivel_funcionario FOREIGN KEY (nivel_id) REFERENCES nivel(nivel_id);


--
-- Name: parcelas_vendas; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY vendas
    ADD CONSTRAINT parcelas_vendas FOREIGN KEY (parcelas_id) REFERENCES parcelas(parcelas_id);


--
-- Name: pessoa_cliente; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT pessoa_cliente FOREIGN KEY (pessoa_id) REFERENCES pessoa(pessoa_id);


--
-- Name: produtos_item_produto; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY item_produto
    ADD CONSTRAINT produtos_item_produto FOREIGN KEY (produtos_id) REFERENCES produtos(produtos_id);


--
-- Name: servico_ordem_servico; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY ordem_servico
    ADD CONSTRAINT servico_ordem_servico FOREIGN KEY (servico_id) REFERENCES servico(servico_id);


--
-- Name: vendas_contas_receber; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY contas_receber
    ADD CONSTRAINT vendas_contas_receber FOREIGN KEY (vendas_id) REFERENCES vendas(vendas_id);


--
-- Name: vendas_item_produto; Type: FK CONSTRAINT; Schema: public; Owner: personal
--

ALTER TABLE ONLY item_produto
    ADD CONSTRAINT vendas_item_produto FOREIGN KEY (vendas_id) REFERENCES vendas(vendas_id);


insert into nivel (nome) values('Administrador');
insert into funcionario (nivel_id,nome,login,senha) values(1,'Administrador','root','root');