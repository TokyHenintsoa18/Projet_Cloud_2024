create table personne
(
    id_personne serial primary key,
    nom varchar(40),
    email varchar(50),
    pwd varchar(40)
);

insert into personne (nom,email,pwd) values('Toky','tokyramanalina@gmail.com','0000');