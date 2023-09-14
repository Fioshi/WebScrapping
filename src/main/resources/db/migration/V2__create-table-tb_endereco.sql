create table tb_endereco (

    id bigint not null auto_increment,
    cep varchar(25) not null,
    logradouro varchar(50) not null,
    bairro varchar(50) not null,
    localidade varchar(50) not null,


    primary key (id)

);

alter table tb_empresa
add constraint tb_empresa_endereco_fk foreign key (endereco_id)
references tb_endereco(id);