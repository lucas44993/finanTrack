CREATE TABLE contrato_por_mes (
                                  meta DECIMAL(10,2) NOT NULL,
                                  contribuicao_empresa DECIMAL(10,2) NOT NULL DEFAULT 0,
                                  contrato_id INTEGER NOT NULL REFERENCES contratos(id),
                                  empresa_id INTEGER NOT NULL REFERENCES empresas(id),
                                  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE rotas_por_contrato (
                                    contrato_id INTEGER NOT NULL REFERENCES contratos(id),
                                    rota_id INTEGER NOT NULL REFERENCES rotas(id),
                                        PRIMARY KEY (contrato_id, rota_id)
);

CREATE TABLE localidade_rota (
                                 rota_id INTEGER NOT NULL REFERENCES rotas(id),
                                 cidade VARCHAR(50) NOT NULL,
                                 somatorio DECIMAL(10,2) NOT NULL DEFAULT 0
);
