-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into Cachorro (id, nome, idade, cor, raca, porte)
values (nextval('hibernate_sequence'), 'Bob', 3, 'preto', 'vira-lata', 'pequeno');

insert into Cachorro (id, nome, idade, cor, raca, porte)
values (nextval('hibernate_sequence'), 'Lisa', 5, 'marrom', 'vira-lata', 'pequeno');