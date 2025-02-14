-- V2: Migration para adicionar a coluna de RECOMPENSA na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN recompensa DECIMAL DEFAULT 0;