alter table usuario add ativo tinyint;
update usuario set ativo = 1;
alter table usuario modify ativo tinyint not null;


alter table produto add ativo tinyint;
update produto set ativo = 1;
alter table produto modify ativo tinyint not null;


alter table pedido add ativo tinyint;
update pedido set ativo = 1;
alter table pedido modify ativo tinyint not null;


alter table itemPedido add ativo tinyint;
update itemPedido set ativo = 1;
alter table itemPedido modify ativo tinyint not null;


alter table nota add ativo tinyint;
update nota set ativo = 1;
alter table nota modify ativo tinyint not null;

