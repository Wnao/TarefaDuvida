insert into usuario (id, login, senha) values (1, 'admin', 'admin');

insert into semana (id, dia) values (1, 'domingo');
insert into semana (id, dia) values (2, 'segunda');
insert into semana (id, dia) values (3, 'terca');
insert into semana (id, dia) values (4, 'quarta');
insert into semana (id, dia) values (5, 'quinta');
insert into semana (id, dia) values (6, 'sexta');
insert into semana (id, dia) values (7, 'sabado');

insert into cidade (id, nome, latitude, longitude) values (1, 'Sao Paulo', -23.5, -46.6);

insert into clima (id, semana_id, cidade_id, data_hora, temp_min, temp_max, umidade, descricao, icon_name) values (1, 1, 1,  now(), 10, 15, 30, 'previsao domingo', '01d');
insert into clima (id, semana_id, cidade_id, data_hora, temp_min, temp_max, umidade, descricao, icon_name) values (2, 2, 1, now(), 35, 42, 90, 'previsao segunda', '01d');
insert into clima (id, semana_id, cidade_id, data_hora, temp_min, temp_max, umidade, descricao, icon_name) values (3, 3, 1, now(), 30, 45, 98, 'previsao terça', '01d');

 insert into cidade (id, nome, latitude, longitude) values (2, 'Rio de Janeiro', -22.5, -43.1);

 insert into clima (id, semana_id, cidade_id, data_hora, temp_min, temp_max, umidade, descricao, icon_name) values (4, 4, 2, now(), 30, 45, 98, 'previsao quarta', '01d');
 insert into clima (id, semana_id, cidade_id, data_hora, temp_min, temp_max, umidade, descricao, icon_name) values (5, 5, 2, now(), 30, 45, 98, 'previsao quinta', '01d');
 insert into clima (id, semana_id, cidade_id, data_hora, temp_min, temp_max, umidade, descricao, icon_name) values (6, 6, 2, now(), 30, 45, 98, 'previsao sexcta', '01d');

