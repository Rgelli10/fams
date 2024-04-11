create table dadosfams(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    genero varchar(100) not null,
    descricao varchar(100) not null,
    temporadas varchar(100) not null,
    classificacao varchar(100) not null,

    primary key(id)
);