-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');


-- Insert de Donos
insert into dono (nome, cpf, sexo) values('Emannuel', '04247466117', 'M');
insert into dono (nome, cpf, sexo) values('Vitória', '22243486114', 'F');


-- Insert de Cachorros
insert into cachorro (nome, idade, cor, raca, porte, sexo, id_dono)
values ('Bob', 3, 'preto', 'vira-lata', 'pequeno', 'M', 1);

insert into cachorro (nome, idade, cor, raca, porte, sexo, id_dono)
values ('Lisa', 5, 'marrom', 'vira-lata', 'pequeno', 'F', 1);

insert into cachorro (nome, idade, cor, raca, porte, sexo, id_dono)
values ('Pluto', 5, 'Amarelo', 'vira-lata', 'pequeno','M', 1);

insert into cachorro (nome, idade, cor, raca, porte, sexo, id_dono)
values ('Nina', 5, 'preto', 'Pinscher', 'pequeno', 'F', 2);

insert into cachorro (nome, idade, cor, raca, porte, sexo, id_dono)
values ('Estrela', 5, 'Amarelo', 'Salsicha', 'pequeno', 'F', 2);

insert into cachorro (nome, idade, cor, raca, porte, sexo, id_dono)
values ('Angel Maria', 5, 'Preto', 'Salsicha', 'pequeno', 'F', 2);