CREATE TABLE sindicato(
	nmembro integer NOT NULL,
	CONSTRAINT sindicato_pkey PRIMARY KEY (nmembro)
);

CREATE TABLE aeroporto(
	nome character varying(50) NOT NULL,
	endereco character varying(500) NOT NULL,
	naviões integer NOT NULL,
	CONSTRAINT aeroporto_pkey PRIMARY KEY (nome)
);

CREATE TABLE modelo(
	capacidade integer NOT NULL,
	peso float NOT NULL,
	codmodelo character varying(20) NOT NULL,
	registro integer NOT NULL,
	CONSTRAINT modelo_pkey PRIMARY KEY (codmodelo)
);

CREATE TABLE aviao(
	registro integer NOT NULL,
	nome character varying(50) NOT NULL,
	codmodelo character varying(20) NOT NULL,
	CONSTRAINT aviao_pkey PRIMARY KEY (registro),
	CONSTRAINT aviao_nome_fkey FOREIGN KEY (nome) REFERENCES aeroporto (nome),
	CONSTRAINT aviao_codmodelo_fkey FOREIGN KEY (codmodelo) REFERENCES modelo (codmodelo)
);

CREATE TABLE controlado_aereo(
	exame date NOT NULL,
	nmembro integer NOT NULL,
	CONSTRAINT contraldor_aereo_nmembro_fkey FOREIGN KEY (nmembro) REFERENCES sindicato (nmembro)
);

CREATE TABLE tecnico(
	nmatricula integer NOT NULL,
	telefone char(10) NOT NULL,
	salario float,
	endereço character varying(500) NOT NULL,
	nmembro integer NOT NULL,
	nome character varying(50) NOT NULL,
	codmodelo character varying(20) NOT NULL,
	CONSTRAINT tecnico_pkey PRIMARY KEY (nmatricula),
	CONSTRAINT tecnico_nome_fkey FOREIGN KEY (nome) REFERENCES aeroporto (nome),
	CONSTRAINT tecnico_nmembro_fkey FOREIGN KEY (nmembro) REFERENCES sindicato (nmembro)
);

CREATE TABLE testes(
	n_ANAC integer NOT NULL,
	nome character varying(50) NOT NULL,
	datateste date NOT NULL,
	nhoras float,
	pontuação float,
	nmatricula integer NOT NULL,
	CONSTRAINT testes_pkey PRIMARY KEY (n_ANAC),
	CONSTRAINT testes_nmatricula_fkey FOREIGN KEY (nmatricula) REFERENCES tecnico (nmatricula)
);

-- Remove tecnicos com matricula repetida
create or replace function validaTecnico(pnmatricula int) returns void as
$$
declare
begin
	DELETE FROM tecnico a USING (SELECT MIN(ctid) as ctid, nmatricula FROM tecnico GROUP BY nmatricula HAVING COUNT(*) > 1) b WHERE a.nmatricula = b.nmatricula AND a.ctid <> b.ctid
end;
$$
language plpgsql;

--Impede a insercao ou atualizacao de Tecnicos com a mesma matricula.
create or replace function verificaMatricula() returns trigger as
$$
begin
	if TG_OP = 'INSERT' then
		if (select count(1) from tecnico where nmatricula=new.nmatricula)>0 then
			raise exception 'Matricula j� cadastrada';
		end if;
	elsif TG_OP = 'UPDATE' then
		if (new.nmatricula<>old.nmatricula) then
			if (select count (1) from tecnico where nmatricula=new.nmatricula)>0 then
				raise exception 'Matricula j� cadastrada';
			end if;
		end if;
	end if;
	return new;
end;
$$
language plpgsql;
create trigger verificaMatricula before insert or update on tecnico for row execute procedure verificaMatricula();

--Ao inserir, atualizar ou remover um modelo refletido na tabela Aviao.
create sequence aviao_registro_seq start 20;
create or replace function atualizaModeloAviao() returns trigger as
$$
begin
	if TG_OP = 'INSERT' then
		insert into aviao values (nextval('aviao_registro_seq'), new.registro, new.nome, new.codmodelo);
	elsif TG_OP='UPDATE' then
		if (select 1 from aviao where registro=new.registro) then
			update aviao set nome = new.nome, codmodelo=new.codmodelo where registro=new.registro;
		else
			insert into cliente values (nextval('aviao_registro_seq'), new.registro, new.nome, new.codmodelo);
		end if;
	elsif TG_OP = 'DELETE' then
		delete from aviao where registro=old.registro;
	end if;
	return null;
end;
$$
language plpgsql;
create trigger atualizaModeloAviao after insert or update or delete on modelo for each row execute procedure atualizaModeloAviao();