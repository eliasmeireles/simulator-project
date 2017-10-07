DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE categoria (
  id   CHAR(36)    NOT NULL UNIQUE,
  nome VARCHAR(50) NOT NULL UNIQUE
);

ALTER TABLE categoria
  ADD CONSTRAINT pk_categoria PRIMARY KEY (id);

CREATE TABLE fabricante (
  id   CHAR(36)    NOT NULL UNIQUE,
  nome VARCHAR(50) NOT NULL UNIQUE
);

ALTER TABLE fabricante
  ADD CONSTRAINT pk_fabricante PRIMARY KEY (id);

CREATE TABLE produto_estoque (
  id      CHAR(36) NOT NULL UNIQUE,
  quantia INT      NOT NULL
);

ALTER TABLE produto_estoque
  ADD CONSTRAINT pk_produto_estoque PRIMARY KEY (id);

CREATE TABLE produto (
  id                 CHAR(36)     NOT NULL UNIQUE,
  nome               VARCHAR(200) NOT NULL UNIQUE,
  valor              DECIMAL      NOT NULL,
  categoria_id       CHAR(36)     NOT NULL,
  fabricante_id      CHAR(36)     NOT NULL,
  produto_estoque_id CHAR(36)     NOT NULL
);

ALTER TABLE produto
  ADD CONSTRAINT pk_produto PRIMARY KEY (id);

ALTER TABLE produto
  ADD CONSTRAINT fk_produto_categoria_id FOREIGN KEY (categoria_id) REFERENCES categoria (id);

ALTER TABLE produto
  ADD CONSTRAINT fk_produto_fabricante_id FOREIGN KEY (fabricante_id) REFERENCES fabricante (id);

ALTER TABLE produto
  ADD CONSTRAINT fk_produto_produto_estoque_id FOREIGN KEY (produto_estoque_id) REFERENCES produto_estoque (id);

CREATE TABLE produto_descricao (
  id         CHAR(36) NOT NULL UNIQUE,
  titulo     VARCHAR(150),
  produto_id CHAR(36) NOT NULL
);

ALTER TABLE produto_descricao
  ADD CONSTRAINT pk_produto_descricao PRIMARY KEY (id);

ALTER TABLE produto_descricao
  ADD CONSTRAINT fk_produto_descricao_produto_id FOREIGN KEY (produto_id) REFERENCES produto (id);

CREATE TABLE descricao_informacao (
  produto_descricao_id CHAR(36) NOT NULL,
  informacao           TEXT     NOT NULL
);

ALTER TABLE descricao_informacao
  ADD CONSTRAINT fk_descricao_informacao_produto_descricao_id FOREIGN KEY (produto_descricao_id) REFERENCES produto_descricao (id);

CREATE TABLE produto_propaganda (
  produto_id CHAR(36)     NOT NULL,
  titulo     VARCHAR(150) ,
  imagem     VARCHAR(200) ,
  descricao  TEXT
);

ALTER TABLE produto_propaganda
  ADD CONSTRAINT fk_produto_propaganda_produto_id FOREIGN KEY (produto_id) REFERENCES produto (id);

CREATE TABLE imagens (
  produto_id CHAR(36)     NOT NULL,
  imagem     VARCHAR(300) NOT NULL
);

ALTER TABLE imagens
  ADD CONSTRAINT fk_imagens_produto_id FOREIGN KEY (produto_id) REFERENCES produto (id);

INSERT INTO fabricante VALUES
  ('d51543a7-b982-45f4-a1b6-c15d3782b071', 'Samsungue'),
  ('d51543a7-b982-45f4-a1b6-c15d3782b073', 'Asus'),
  ('d51543a7-b982-45f4-a1b6-c15d3782b076', 'LG'),
  ('d51543a7-b982-45f4-a1b6-c15d3782b475', 'MSI'),
  ('d51543a7-b982-45f4-a1b6-c15d3782b077', 'Apple'),
  ('d51543a7-b982-45f4-a1b6-c15d3782b079', 'Lenovo'),
  ('d51543a7-b982-45f4-a1b6-c15d3782b072', 'Motorola');

INSERT INTO categoria VALUES
  ('d51543a7-b982-45f4-a1b6-c15d3782b071', 'HD'),
  ('d51543a7-b982-45f4-a1b6-c15d3782b073', 'SSD'),
  ('d51543a7-b982-45f4-a1b6-c15d3782b257', 'Placa de Video'),
  ('d51543a7-b982-45f4-a1b6-c15d3782b087', 'Monitor'),
  ('d51543a7-b982-45f4-a1b6-c15d3782b072', 'Pen Drive');