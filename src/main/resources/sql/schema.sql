create table vacante
(
    id             uuid default gen_random_uuid() primary key,
    titulo_vacante varchar(255) not null,
);

create table requisito
(
    id          uuid default gen_random_uuid() primary key,
    requisito   varchar(255)                 not null,
    descripcion varchar(255)                 not null,
    fk_vacante  uuid references vacante (id) not null
);

create table habilidad
(
    id                    uuid default gen_random_uuid() primary key,
    habilidad             varchar(255)                 not null,
    descripcion           varchar(255)                 not null,
    anios_de_conocimiento int                          not null,
    fk_vacante            uuid references vacante (id) not null

);

create table oferta
(
    id          uuid default gen_random_uuid() primary key,
    oferta      varchar(255)                 not null,
    descripcion varchar(255)                 not null,
    fk_vacante  uuid references vacante (id) not null

);