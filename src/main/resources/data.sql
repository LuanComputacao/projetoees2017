-- PROFESSORES
INSERT INTO PROFESSOR ( CPF , NOME , SENHA, MODERADOR)
VALUES
('00011122233', 'Nome1', 'Aaaa.1234', TRUE),
('00011122234', 'Nome2', 'Aaaa.1234', FALSE);

-- DISCIPLINAS
INSERT INTO DISCIPLINA (NOME)
VALUES
('Matemática'),
('Português');

-- MATÉRIAS
INSERT INTO MATERIA (NOME, ID_DISCIPLINA)
VALUES
('Funções', 1),
('Funções Compostas', 1),
('Pretérito Perfeito', 2),
('Sujeito Composto', 2);

-- TIPO DE QUESTÃO
-- Enums 1 || 2
-- FASE DE ENSINO
INSERT INTO FASE_DE_ENSINO
(NOME)
VALUES
('1° ANO DO ENSINO MÉDIO REGULAR'),
('2° ANO DO ENSINO MÉDIO REGULAR');

-- QUESTÕES
INSERT INTO QUESTAO
(CRIADO_EM, ATUALIZADO_EM, ENUNCIADO, ESPACOS, INVALIDADA, NIVEL, PUBLICA, TIPO_DE_QUESTAO, ID_AUTOR, ID_DISCIPLINA, ID_FASE_DE_ENSINO)
VALUES
(current_timestamp(), current_timestamp(), 'Calcule x+2=3', 3, FALSE , 3.0, TRUE , 0, 1, 1, 1),
(current_timestamp(), current_timestamp(), 'Calcule x²+2⁴=3', 5, FALSE , 3.5 , TRUE , 0, 2, 1, 2),
(current_timestamp(), current_timestamp(), 'O que é um sujeito composto', 5, FALSE , 1 , TRUE , 1, 2, 2, 1);

-- OPÇÕES DE QUESTÃO
INSERT INTO OPCAO_DE_QUESTAO
(TEXTO, VALUE, ID_QUESTAO)
VALUES
  ('Sujeito é a pessoa principal de uma oração', FALSE , 3),
  ('Predicado é a pessoa principal de uma oração', FALSE , 3),
  ('Verbo é a pessoa principal de uma oração', TRUE, 3),
  ('Lalala é a pessoa principal de uma oração', FALSE , 3),
  ('Bla Bla Bla é a pessoa principal de uma oração', FALSE , 3);

-- MATÉRIAS DA QUESTÃO
INSERT INTO MATERIA_DE_QUESTAO
(QUESTAO_ID, MATERIA_ID)
VALUES
(1,1),
(2,2),
(3,4);


INSERT INTO PROPOSTA_DE_INVALIDACAO
(ANALISADO_EM, CRIADO_EM, JUSTIFICATIVA, PROPOSTA, STATUS, ID_MODERADOR, ID_PROFESSOR, ID_QUESTAO)
VALUES
(NULL, current_timestamp(), 'Deu vontade', 'Mudar alguma coisa nela', FALSE, 1, 2, 1);


INSERT INTO TESTE
(ATUALIZADO_EM, CRIADO_EM, DESCRICAO, ID_PROFESSOR, ID_DISCIPLINA, ID_FASE_DE_ENSINO)
VALUES
(CURRENT_DATE(), CURRENT_DATE(), 'Funcções de primeiro e segundo graus', 1, 1, 2);
