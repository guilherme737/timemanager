CREATE SEQUENCE IF NOT EXISTS public.usuario_id_seq;

CREATE TABLE IF NOT EXISTS public.usuario
(
    id bigint NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
    login character varying(255) COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default",
    senha character varying(255) COLLATE pg_catalog."default",
    horas_de_trabalho_preferidas_por_dia integer,
    permissao integer,
    CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.ponto_id_seq;

CREATE TABLE IF NOT EXISTS public.ponto
(
    id bigint NOT NULL DEFAULT nextval('ponto_id_seq'::regclass),
    data date,
    dentro_do_limite_de_horas_preferido boolean,
    horas_trabalhadas integer,
    usuario_id bigint,
    CONSTRAINT ponto_pkey PRIMARY KEY (id),
    CONSTRAINT fk4a2xo7agbjdr58v1o7jh0uf1y FOREIGN KEY (usuario_id)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

INSERT INTO public.usuario(
	login, nome, senha, horas_de_trabalho_preferidas_por_dia, permissao)
	VALUES ('usuario', 'Usuário básico', '$2a$10$Rnr9/kGAZ.3wx2qGA0zTs.SBXQLbDugs7nMoOldf/AN9hGt9oUWGu', 8, 0);