create table tb_endereco (

    id bigint not null auto_increment,
    logradouro varchar(50) not null,
    bairro varchar(50) not null,
    localidade varchar(50) not null,
    numero varchar(25) not null,

    primary key (id)

);