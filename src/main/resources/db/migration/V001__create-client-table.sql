CREATE TABLE IF NOT EXISTS cliente(
	id_cliente BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
	email VARCHAR(100) UNIQUE,
	PRIMARY KEY (id_cliente)
);