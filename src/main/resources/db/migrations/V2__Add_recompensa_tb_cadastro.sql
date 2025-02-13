-- V2: Migration para adicionar a colunad e RECOMPENSA na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN recompensa DECIMAL;