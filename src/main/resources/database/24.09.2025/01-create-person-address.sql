--liquibase formatted sql
--changeset mzerek:1
CREATE TABLE person (
   id           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   username     VARCHAR(255)  NOT NULL
);

CREATE TABLE address (
   id       BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   userId   INT           NOT NULL,
   street   VARCHAR(255)  NOT NULL,
   zipCode  VARCHAR(255)  NOT NULL,
   city     VARCHAR(255)  NOT NULL
);