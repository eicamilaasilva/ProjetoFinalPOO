
Intruções SQL para criação do banco de dados e das tabelas 

Criação do banco de dados
CREATE DATABASE IF NOT EXISTS focusup
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

Seleciona o banco de dados
USE focusup;


TABELA: Materia
CREATE TABLE IF NOT EXISTS Materia (
    id_materia INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255)
);


TABELA: Tarefa
CREATE TABLE IF NOT EXISTS Tarefa (
    id_tarefa INT AUTO_INCREMENT PRIMARY KEY,
    id_materia INT NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    data_entrega DATE NOT NULL,
    status ENUM(
        'Pendente',
        'Em andamento',
        'Concluida'
    ) NOT NULL DEFAULT 'Pendente',
    prioridade ENUM(
        'Baixa',
        'Media',
        'Alta'
    ) NOT NULL DEFAULT 'Media',

    CONSTRAINT fk_tarefa_materia
        FOREIGN KEY (id_materia)
        REFERENCES Materia(id_materia)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);


TABELA: Avaliacao
CREATE TABLE IF NOT EXISTS Avaliacao (
    id_avaliacao INT AUTO_INCREMENT PRIMARY KEY,
    id_materia INT NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    data_avaliacao DATE NOT NULL,
    nota DECIMAL(5,2) DEFAULT NULL,
    valor_maximo DECIMAL(5,2) NOT NULL DEFAULT 10.00,

    CONSTRAINT chk_nota
        CHECK (nota IS NULL OR nota >= 0),

    CONSTRAINT chk_valor_maximo
        CHECK (valor_maximo > 0),

    CONSTRAINT fk_avaliacao_materia
        FOREIGN KEY (id_materia)
        REFERENCES Materia(id_materia)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);


Para testar se funcionou 
USE focusup;

SHOW TABLES;

DESCRIBE Materia;
DESCRIBE Tarefa;
DESCRIBE Avaliacao;