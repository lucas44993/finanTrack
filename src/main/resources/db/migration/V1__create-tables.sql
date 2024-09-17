CREATE TABLE contratos(
                          id SERIAL NOT NULL PRIMARY KEY,
                          nome VARCHAR(50) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE rotas(
                      id SERIAL NOT NULL PRIMARY KEY,
                      nome VARCHAR(100) NOT NULL
);

CREATE TABLE enderecos(
                          id SERIAL NOT NULL PRIMARY KEY,
                          logradouro VARCHAR(255),
                          complemento VARCHAR(255),
                          bairro VARCHAR(255),
                          numero INT,
                          cidade VARCHAR(255),
                          cep VARCHAR(8) NOT NULL,
                          estado VARCHAR(22),
                          pais VARCHAR(190)
);

