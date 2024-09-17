CREATE TABLE empresas(
                         id SERIAL NOT NULL PRIMARY KEY,
                         cpnj VARCHAR(14) NOT NULL UNIQUE,
                         nome VARCHAR(100) NOT NULL,
                         endereco_id INTEGER NOT NULL REFERENCES enderecos(id)
);

