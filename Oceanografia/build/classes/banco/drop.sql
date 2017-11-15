/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v6.2.1                     */
/* Target DBMS:           PostgreSQL 8.3                                  */
/* Project file:          Projeto_Oficial.dez                             */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database drop script                            */
/* Created on:            2012-06-08 11:40                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Drop foreign key constraints                                           */
/* ---------------------------------------------------------------------- */

ALTER TABLE animal DROP CONSTRAINT usuario_animal;

ALTER TABLE animal DROP CONSTRAINT especie_animal;

ALTER TABLE animal DROP CONSTRAINT area_animal;

ALTER TABLE animal DROP CONSTRAINT sexo_animal;

ALTER TABLE animal DROP CONSTRAINT status_animal;

ALTER TABLE anestesia DROP CONSTRAINT animal_anestesia;

ALTER TABLE anestesia DROP CONSTRAINT medicacao_anestesia;

ALTER TABLE idade DROP CONSTRAINT animal_idade;

ALTER TABLE recaptura DROP CONSTRAINT tiporecaptura_recaptura;

ALTER TABLE recaptura DROP CONSTRAINT animal_recaptura;

ALTER TABLE recaptura DROP CONSTRAINT epoca_recaptura;

ALTER TABLE epoca DROP CONSTRAINT temporada_epoca;

ALTER TABLE bigodes DROP CONSTRAINT animal_bigodes;

ALTER TABLE bigodes DROP CONSTRAINT local_coleta_bigodes;

ALTER TABLE carrapato DROP CONSTRAINT animal_carrapato;

ALTER TABLE animal_tag DROP CONSTRAINT tag_animal_tag;

ALTER TABLE animal_tag DROP CONSTRAINT animal_animal_tag;

ALTER TABLE censo_animal DROP CONSTRAINT animal_censo_animal;

ALTER TABLE censo_animal DROP CONSTRAINT censo_censo_animal;

ALTER TABLE gordura DROP CONSTRAINT gordura_destino_gordura;

ALTER TABLE gordura DROP CONSTRAINT local_coleta_gordura;

ALTER TABLE parentesco DROP CONSTRAINT pai;

ALTER TABLE parentesco DROP CONSTRAINT animal_parentesco;

ALTER TABLE sangue DROP CONSTRAINT animal_sangue;

ALTER TABLE bioquimico DROP CONSTRAINT sangue_bioquimico;

ALTER TABLE tag DROP CONSTRAINT cor_tag_tag;

ALTER TABLE censo DROP CONSTRAINT data_censo;

ALTER TABLE censo DROP CONSTRAINT sexo_censo;

ALTER TABLE censo DROP CONSTRAINT especie_censo;

ALTER TABLE censo DROP CONSTRAINT area_censo;

ALTER TABLE censo DROP CONSTRAINT status_censo;

ALTER TABLE contaminantes DROP CONSTRAINT sangue_contaminantes;

ALTER TABLE isotopos DROP CONSTRAINT sangue_isotopos;

/* ---------------------------------------------------------------------- */
/* Drop table "censo_animal"                                              */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE censo_animal DROP CONSTRAINT PK_censo_animal;

/* Drop table */

DROP TABLE censo_animal;

/* ---------------------------------------------------------------------- */
/* Drop table "recaptura"                                                 */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE recaptura DROP CONSTRAINT PK_recaptura;

/* Drop table */

DROP TABLE recaptura;

/* ---------------------------------------------------------------------- */
/* Drop table "isotopos"                                                  */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE isotopos DROP CONSTRAINT PK_isotopos;

/* Drop table */

DROP TABLE isotopos;

/* ---------------------------------------------------------------------- */
/* Drop table "contaminantes"                                             */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE contaminantes DROP CONSTRAINT PK_contaminantes;

/* Drop table */

DROP TABLE contaminantes;

/* ---------------------------------------------------------------------- */
/* Drop table "censo"                                                     */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE censo DROP CONSTRAINT PK_censo;

/* Drop table */

DROP TABLE censo;

/* ---------------------------------------------------------------------- */
/* Drop table "bioquimico"                                                */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE bioquimico DROP CONSTRAINT PK_bioquimico;

/* Drop table */

DROP TABLE bioquimico;

/* ---------------------------------------------------------------------- */
/* Drop table "sangue"                                                    */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE sangue DROP CONSTRAINT PK_sangue;

/* Drop table */

DROP TABLE sangue;

/* ---------------------------------------------------------------------- */
/* Drop table "parentesco"                                                */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE parentesco DROP CONSTRAINT PK_parentesco;

/* Drop table */

DROP TABLE parentesco;

/* ---------------------------------------------------------------------- */
/* Drop table "gordura"                                                   */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE gordura DROP CONSTRAINT PK_gordura;

/* Drop table */

DROP TABLE gordura;

/* ---------------------------------------------------------------------- */
/* Drop table "animal_tag"                                                */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE animal_tag DROP CONSTRAINT PK_animal_tag;

/* Drop table */

DROP TABLE animal_tag;

/* ---------------------------------------------------------------------- */
/* Drop table "carrapato"                                                 */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE carrapato DROP CONSTRAINT PK_carrapato;

/* Drop table */

DROP TABLE carrapato;

/* ---------------------------------------------------------------------- */
/* Drop table "bigodes"                                                   */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE bigodes DROP CONSTRAINT PK_bigodes;

/* Drop table */

DROP TABLE bigodes;

/* ---------------------------------------------------------------------- */
/* Drop table "epoca"                                                     */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE epoca DROP CONSTRAINT PK_epoca;

/* Drop table */

DROP TABLE epoca;

/* ---------------------------------------------------------------------- */
/* Drop table "idade"                                                     */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE idade DROP CONSTRAINT PK_idade;

/* Drop table */

DROP TABLE idade;

/* ---------------------------------------------------------------------- */
/* Drop table "anestesia"                                                 */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE anestesia DROP CONSTRAINT PK_anestesia;

/* Drop table */

DROP TABLE anestesia;

/* ---------------------------------------------------------------------- */
/* Drop table "animal"                                                    */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE animal DROP CONSTRAINT PK_animal;

/* Drop table */

DROP TABLE animal;

/* ---------------------------------------------------------------------- */
/* Drop table "local_coleta"                                              */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE local_coleta DROP CONSTRAINT PK_local_coleta;

/* Drop table */

DROP TABLE local_coleta;

/* ---------------------------------------------------------------------- */
/* Drop table "gordura_destino"                                           */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE gordura_destino DROP CONSTRAINT PK_gordura_destino;

/* Drop table */

DROP TABLE gordura_destino;

/* ---------------------------------------------------------------------- */
/* Drop table "data"                                                      */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE data DROP CONSTRAINT PK_data;

/* Drop table */

DROP TABLE data;

/* ---------------------------------------------------------------------- */
/* Drop table "tag"                                                       */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE tag DROP CONSTRAINT PK_tag;

/* Drop table */

DROP TABLE tag;

/* ---------------------------------------------------------------------- */
/* Drop table "cor_tag"                                                   */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE cor_tag DROP CONSTRAINT PK_cor_tag;

/* Drop table */

DROP TABLE cor_tag;

/* ---------------------------------------------------------------------- */
/* Drop table "sexo"                                                      */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE sexo DROP CONSTRAINT PK_sexo;

/* Drop table */

DROP TABLE sexo;

/* ---------------------------------------------------------------------- */
/* Drop table "especie"                                                   */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE especie DROP CONSTRAINT PK_especie;

/* Drop table */

DROP TABLE especie;

/* ---------------------------------------------------------------------- */
/* Drop table "area"                                                      */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE area DROP CONSTRAINT PK_area;

/* Drop table */

DROP TABLE area;

/* ---------------------------------------------------------------------- */
/* Drop table "tiporecaptura"                                             */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE tiporecaptura DROP CONSTRAINT PK_tiporecaptura;

/* Drop table */

DROP TABLE tiporecaptura;

/* ---------------------------------------------------------------------- */
/* Drop table "temporada"                                                 */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE temporada DROP CONSTRAINT PK_temporada;

/* Drop table */

DROP TABLE temporada;

/* ---------------------------------------------------------------------- */
/* Drop table "status"                                                    */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE status DROP CONSTRAINT PK_status;

/* Drop table */

DROP TABLE status;

/* ---------------------------------------------------------------------- */
/* Drop table "medicacao"                                                 */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE medicacao DROP CONSTRAINT PK_medicacao;

/* Drop table */

DROP TABLE medicacao;

/* ---------------------------------------------------------------------- */
/* Drop table "usuario"                                                   */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE usuario DROP CONSTRAINT PK_usuario;

/* Drop table */

DROP TABLE usuario;
