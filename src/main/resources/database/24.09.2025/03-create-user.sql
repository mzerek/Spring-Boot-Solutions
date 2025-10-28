--liquibase formatted sql
--changeset mzerek:2
CREATE TABLE users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(500) NOT NULL
);

CREATE TABLE roles (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    userid BIGINT NOT NULL,
    permission VARCHAR(500) NOT NULL
);

-- ALTER TABLE ONLY roles ADD CONSTRAINT fk_userid_role FOREIGN KEY (userid) REFERENCES users(id);


