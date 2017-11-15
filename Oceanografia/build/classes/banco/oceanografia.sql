/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v6.2.1                     */
/* Target DBMS:           PostgreSQL 8.3                                  */
/* Project file:          Projeto_Oficial.dez                             */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2012-06-08 11:40                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Tables                                                                 */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "usuario"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE usuario (
    usuario_id SERIAL   NOT NULL,
    nome CHARACTER(255) ,
    login CHARACTER(40) ,
    senha CHARACTER(40) ,
    nivel INTEGER ,
    CONSTRAINT PK_usuario PRIMARY KEY (usuario_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "animal"                                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE animal (
    animal_id SERIAL   NOT NULL,
    especie_id INTEGER ,
    status_id INTEGER ,
    area_id INTEGER ,
    sexo_id INTEGER ,
    usuario_id INTEGER ,
    data DATE ,
    peso_total DOUBLE PRECISION ,
    peso_rede DOUBLE PRECISION ,
    massa DOUBLE PRECISION ,
    comprimento DOUBLE PRECISION ,
    circuferencia DOUBLE PRECISION ,
    condicao DOUBLE PRECISION ,
    peso_estimado DOUBLE PRECISION ,
    pele INTEGER ,
    instrumento CHARACTER VARYING(255) ,
    dente INTEGER ,
    hora TIME ,
    repr DOUBLE PRECISION ,
    id CHARACTER(255) ,
    simbolo CHARACTER VARYING(255) ,
    CONSTRAINT PK_animal PRIMARY KEY (animal_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "anestesia"                                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE anestesia (
    anestesia SERIAL   NOT NULL,
    animal_id INTEGER ,
    medicacao_id INTEGER ,
    quantidade DOUBLE PRECISION ,
    hora DATE ,
    concentracao DOUBLE PRECISION ,
    CONSTRAINT PK_anestesia PRIMARY KEY (anestesia)
);

/* ---------------------------------------------------------------------- */
/* Add table "medicacao"                                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE medicacao (
    medicacao_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    concentracao DOUBLE PRECISION ,
    CONSTRAINT PK_medicacao PRIMARY KEY (medicacao_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "status"                                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE status (
    status_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_status PRIMARY KEY (status_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "idade"                                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE idade (
    idade_id SERIAL   NOT NULL,
    animal_id INTEGER ,
    data_captura DATE ,
    data_desmame DATE ,
    idade INTEGER ,
    CONSTRAINT PK_idade PRIMARY KEY (idade_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "recaptura"                                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE recaptura (
    recaptura_id SERIAL   NOT NULL,
    tiporecaptura_id INTEGER ,
    epoca_id INTEGER ,
    animal_id INTEGER ,
    data DATE ,
    CONSTRAINT PK_recaptura PRIMARY KEY (recaptura_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "epoca"                                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE epoca (
    epoca_id SERIAL   NOT NULL,
    temporada_id INTEGER ,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_epoca PRIMARY KEY (epoca_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "temporada"                                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE temporada (
    temporada_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_temporada PRIMARY KEY (temporada_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "tiporecaptura"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE tiporecaptura (
    tiporecaptura_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_tiporecaptura PRIMARY KEY (tiporecaptura_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "bigodes"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE bigodes (
    bigodes_id SERIAL   NOT NULL,
    local_coleta_id INTEGER ,
    animal_id INTEGER ,
    data DATE ,
    CONSTRAINT PK_bigodes PRIMARY KEY (bigodes_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "carrapato"                                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE carrapato (
    carrapato_id SERIAL   NOT NULL,
    animal_id INTEGER ,
    data DATE ,
    quantidade DOUBLE PRECISION ,
    CONSTRAINT PK_carrapato PRIMARY KEY (carrapato_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "animal_tag"                                                 */
/* ---------------------------------------------------------------------- */

CREATE TABLE animal_tag (
    animal_tag SERIAL   NOT NULL,
    animal_id INTEGER ,
    tag_id INTEGER ,
    CONSTRAINT PK_animal_tag PRIMARY KEY (animal_tag)
);

/* ---------------------------------------------------------------------- */
/* Add table "censo_animal"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE censo_animal (
    censo_animal_id SERIAL   NOT NULL,
    censo_id INTEGER ,
    animal_id INTEGER ,
    CONSTRAINT PK_censo_animal PRIMARY KEY (censo_animal_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "area"                                                       */
/* ---------------------------------------------------------------------- */

CREATE TABLE area (
    area_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_area PRIMARY KEY (area_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "especie"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE especie (
    especie_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_especie PRIMARY KEY (especie_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "sexo"                                                       */
/* ---------------------------------------------------------------------- */

CREATE TABLE sexo (
    sexo_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_sexo PRIMARY KEY (sexo_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "gordura"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE gordura (
    gordura_id SERIAL   NOT NULL,
    local_coleta_id INTEGER ,
    gordura_destino INTEGER ,
    gordura_destino_id INTEGER ,
    animal_id INTEGER ,
    CONSTRAINT PK_gordura PRIMARY KEY (gordura_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "parentesco"                                                 */
/* ---------------------------------------------------------------------- */

CREATE TABLE parentesco (
    parentesco_id SERIAL   NOT NULL,
    pai_id INTEGER ,
    mae_id INTEGER ,
    CONSTRAINT PK_parentesco PRIMARY KEY (parentesco_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "sangue"                                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE sangue (
    sangue_id SERIAL   NOT NULL,
    animal_id INTEGER ,
    hmtc DOUBLE PRECISION ,
    rbc DOUBLE PRECISION ,
    vcm DOUBLE PRECISION ,
    leuco DOUBLE PRECISION ,
    hmc DOUBLE PRECISION ,
    hmg DOUBLE PRECISION ,
    cetonas DOUBLE PRECISION ,
    CONSTRAINT PK_sangue PRIMARY KEY (sangue_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "bioquimico"                                                 */
/* ---------------------------------------------------------------------- */

CREATE TABLE bioquimico (
    bioquimico SERIAL   NOT NULL,
    sangue_id INTEGER ,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_bioquimico PRIMARY KEY (bioquimico)
);

/* ---------------------------------------------------------------------- */
/* Add table "cor_tag"                                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE cor_tag (
    cor_tag_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_cor_tag PRIMARY KEY (cor_tag_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "tag"                                                        */
/* ---------------------------------------------------------------------- */

CREATE TABLE tag (
    tag_id SERIAL   NOT NULL,
    cor_tag_id INTEGER ,
    cod_id CHARACTER VARYING(255) ,
    tag CHARACTER VARYING(255) ,
    CONSTRAINT PK_tag PRIMARY KEY (tag_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "censo"                                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE censo (
    censo_id SERIAL   NOT NULL,
    especie_id INTEGER ,
    sexo_id INTEGER ,
    data_id INTEGER ,
    area_id INTEGER ,
    status_id INTEGER ,
    quantidade DOUBLE PRECISION ,
    observacao CHARACTER VARYING(255) ,
    correcao CHARACTER VARYING(255) ,
    CONSTRAINT PK_censo PRIMARY KEY (censo_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "data"                                                       */
/* ---------------------------------------------------------------------- */

CREATE TABLE data (
    data_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_data PRIMARY KEY (data_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "gordura_destino"                                            */
/* ---------------------------------------------------------------------- */

CREATE TABLE gordura_destino (
    gordura_destino SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_gordura_destino PRIMARY KEY (gordura_destino)
);

/* ---------------------------------------------------------------------- */
/* Add table "local_coleta"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE local_coleta (
    local_coleta_id SERIAL   NOT NULL,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_local_coleta PRIMARY KEY (local_coleta_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "contaminantes"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE contaminantes (
    contaminantes_id SERIAL   NOT NULL,
    sangue_id INTEGER ,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_contaminantes PRIMARY KEY (contaminantes_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "isotopos"                                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE isotopos (
    isotopos_id SERIAL   NOT NULL,
    sangue_id INTEGER ,
    nome CHARACTER VARYING(255) ,
    CONSTRAINT PK_isotopos PRIMARY KEY (isotopos_id)
);

/* ---------------------------------------------------------------------- */
/* Foreign key constraints                                                */
/* ---------------------------------------------------------------------- */

ALTER TABLE animal ADD CONSTRAINT usuario_animal 
    FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id);

ALTER TABLE animal ADD CONSTRAINT especie_animal 
    FOREIGN KEY (especie_id) REFERENCES especie (especie_id);

ALTER TABLE animal ADD CONSTRAINT area_animal 
    FOREIGN KEY (area_id) REFERENCES area (area_id);

ALTER TABLE animal ADD CONSTRAINT sexo_animal 
    FOREIGN KEY (sexo_id) REFERENCES sexo (sexo_id);

ALTER TABLE animal ADD CONSTRAINT status_animal 
    FOREIGN KEY (status_id) REFERENCES status (status_id);

ALTER TABLE anestesia ADD CONSTRAINT animal_anestesia 
    FOREIGN KEY (animal_id) REFERENCES animal (animal_id);

ALTER TABLE anestesia ADD CONSTRAINT medicacao_anestesia 
    FOREIGN KEY (medicacao_id) REFERENCES medicacao (medicacao_id);

ALTER TABLE idade ADD CONSTRAINT animal_idade 
    FOREIGN KEY (animal_id) REFERENCES animal (animal_id);

ALTER TABLE recaptura ADD CONSTRAINT tiporecaptura_recaptura 
    FOREIGN KEY (tiporecaptura_id) REFERENCES tiporecaptura (tiporecaptura_id);

ALTER TABLE recaptura ADD CONSTRAINT animal_recaptura 
    FOREIGN KEY (animal_id) REFERENCES animal (animal_id);

ALTER TABLE recaptura ADD CONSTRAINT epoca_recaptura 
    FOREIGN KEY (epoca_id) REFERENCES epoca (epoca_id);

ALTER TABLE epoca ADD CONSTRAINT temporada_epoca 
    FOREIGN KEY (temporada_id) REFERENCES temporada (temporada_id);

ALTER TABLE bigodes ADD CONSTRAINT animal_bigodes 
    FOREIGN KEY (animal_id) REFERENCES animal (animal_id);

ALTER TABLE bigodes ADD CONSTRAINT local_coleta_bigodes 
    FOREIGN KEY (local_coleta_id) REFERENCES local_coleta (local_coleta_id);

ALTER TABLE carrapato ADD CONSTRAINT animal_carrapato 
    FOREIGN KEY (animal_id) REFERENCES animal (animal_id);

ALTER TABLE animal_tag ADD CONSTRAINT tag_animal_tag 
    FOREIGN KEY (tag_id) REFERENCES tag (tag_id);

ALTER TABLE animal_tag ADD CONSTRAINT animal_animal_tag 
    FOREIGN KEY (animal_id) REFERENCES animal (animal_id);

ALTER TABLE censo_animal ADD CONSTRAINT animal_censo_animal 
    FOREIGN KEY (animal_id) REFERENCES animal (animal_id);

ALTER TABLE censo_animal ADD CONSTRAINT censo_censo_animal 
    FOREIGN KEY (censo_id) REFERENCES censo (censo_id);

ALTER TABLE gordura ADD CONSTRAINT gordura_destino_gordura 
    FOREIGN KEY (gordura_destino) REFERENCES gordura_destino (gordura_destino);

ALTER TABLE gordura ADD CONSTRAINT local_coleta_gordura 
    FOREIGN KEY (local_coleta_id) REFERENCES local_coleta (local_coleta_id);

ALTER TABLE parentesco ADD CONSTRAINT pai 
    FOREIGN KEY (pai_id) REFERENCES animal (animal_id);

ALTER TABLE parentesco ADD CONSTRAINT animal_parentesco 
    FOREIGN KEY (mae_id) REFERENCES animal (animal_id);

ALTER TABLE sangue ADD CONSTRAINT animal_sangue 
    FOREIGN KEY (animal_id) REFERENCES animal (animal_id);

ALTER TABLE bioquimico ADD CONSTRAINT sangue_bioquimico 
    FOREIGN KEY (sangue_id) REFERENCES sangue (sangue_id);

ALTER TABLE tag ADD CONSTRAINT cor_tag_tag 
    FOREIGN KEY (cor_tag_id) REFERENCES cor_tag (cor_tag_id);

ALTER TABLE censo ADD CONSTRAINT data_censo 
    FOREIGN KEY (data_id) REFERENCES data (data_id);

ALTER TABLE censo ADD CONSTRAINT sexo_censo 
    FOREIGN KEY (sexo_id) REFERENCES sexo (sexo_id);

ALTER TABLE censo ADD CONSTRAINT especie_censo 
    FOREIGN KEY (especie_id) REFERENCES especie (especie_id);

ALTER TABLE censo ADD CONSTRAINT area_censo 
    FOREIGN KEY (area_id) REFERENCES area (area_id);

ALTER TABLE censo ADD CONSTRAINT status_censo 
    FOREIGN KEY (status_id) REFERENCES status (status_id);

ALTER TABLE contaminantes ADD CONSTRAINT sangue_contaminantes 
    FOREIGN KEY (sangue_id) REFERENCES sangue (sangue_id);

ALTER TABLE isotopos ADD CONSTRAINT sangue_isotopos 
    FOREIGN KEY (sangue_id) REFERENCES sangue (sangue_id);
