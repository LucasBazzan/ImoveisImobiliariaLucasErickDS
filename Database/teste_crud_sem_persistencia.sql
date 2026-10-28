-- Teste manual reversível: execute no MySQL/MariaDB com o banco já configurado.
-- Não execute junto com o dump original (ele tem DROP TABLE).
USE imobiliariasimoveislucaserickds;
START TRANSACTION;

INSERT INTO imobiliarias (Nome, Telefone, Contato)
VALUES ('IMOB TESTE CRUD', '(19) 99999-9999', 'CONTATO TESTE');
SET @id_imobiliaria_teste = LAST_INSERT_ID();

INSERT INTO imoveis (Descricao, IDImobiliaria, Tipo, Valor, Bairro, Foto, Situacao)
VALUES ('IMOVEL TESTE CRUD', @id_imobiliaria_teste,
        'Casa', 150000.50, 'Centro', '', 'Disponível');
SET @id_imovel_teste = LAST_INSERT_ID();

SELECT * FROM imobiliarias WHERE ID = @id_imobiliaria_teste;
SELECT * FROM imoveis WHERE ID = @id_imovel_teste;

UPDATE imobiliarias SET Contato = 'CONTATO EDITADO' WHERE ID = @id_imobiliaria_teste;
UPDATE imoveis SET Bairro = 'Jardim' WHERE ID = @id_imovel_teste;

SELECT * FROM imobiliarias WHERE ID = @id_imobiliaria_teste;
SELECT * FROM imoveis WHERE ID = @id_imovel_teste;

DELETE FROM imoveis WHERE ID = @id_imovel_teste;
DELETE FROM imobiliarias WHERE ID = @id_imobiliaria_teste;

-- Garantia: desfaz qualquer alteração realizada neste teste.
ROLLBACK;
