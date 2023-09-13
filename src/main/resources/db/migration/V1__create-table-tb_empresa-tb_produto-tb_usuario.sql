create table tb_empresa (

    id bigint not null auto_increment,
    nome_empresa varchar(50) not null,
    sede_empresa varchar(50) not null,
    cnpj_empresa varchar(50) not null,

    primary key (id)

);

create table tb_produto (

    id bigint not null auto_increment,
    empresa_id bigint not null,
    data_fabricação_produto Date not null,
    nome_produto varchar(50) not null,
    preco_produto double not null,
    nota_produto double not null,

    primary key (id),
    constraint fk_tb_produto_id_empresa foreign key(empresa_id) references tb_empresa(id)
);

create table tb_usuario (

    id bigint not null auto_increment,
    nome_usuario varchar(50) not null,
    email_usuario varchar(50) not null,
    sexo_usuario varchar(1) not null,
    nascimento_usuario Date not null,

    primary key (id)

);

create table tb_feedback (

    id bigint not null auto_increment,
    usuario_id bigint not null,
    produto_id bigint not null,
    data_feedback Date not null,
    texto_feedback varchar(255) not null,

    primary key (id),
    constraint fk_tb_feedback_id_usuario foreign key(usuario_id) references tb_usuario(id),
    constraint fk_tb_feedback_id_produto foreign key(produto_id) references tb_produto(id)

);