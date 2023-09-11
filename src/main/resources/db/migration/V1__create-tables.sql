create table usuario(

    id bigint not null auto_increment,
    nome  varchar(100) not null,
    sobrenome varchar(100) not null,
    nascimento date not null,
    role varchar(20) not null,
    email varchar(100) not null unique,
    senha varchar(100) not null,
    cpf  varchar(15) not null unique,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    uf varchar (20) not null,
    cep varchar (10) not null,

    primary key(id)
);

create table produto(
   
    id bigint not null auto_increment,
    nome varchar(100) not null,
    preco decimal(8.2) not null,
    descricao varchar(150) not null,
    imagem varchar(100),
    qtd_estoque integer not null,

    primary key(id)
);

create table pedido(
    
    id bigint not null auto_increment,
    dataPedido date not null,
    total decimal(8.2) not null,
    
    id_usuario bigint not null,

    primary key(id),
    foreign key(id_usuario) references usuario(id)
);

create table itemPedido(
    
    id bigint not null auto_increment,
    quantidade bigint not null,
    preco_unitario decimal(8.2) not null,
    
    id_pedido bigint not null,
    id_produto bigint not null,

    primary key (id),
    Foreign Key (id_pedido) REFERENCES pedido(id),
    Foreign Key (id_produto) REFERENCES produto(id)
);

create table nota(

    id bigint not null auto_increment,
    cliente varchar (100) not null,
    data_emissao date not null,
    valor_total decimal (8.2),

    id_pedido bigint not null,

    primary key (id),
    Foreign Key (id_pedido) REFERENCES pedido(id)
);