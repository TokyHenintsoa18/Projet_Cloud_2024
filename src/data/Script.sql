CREATE TABLE Categorie_culture
(
   id_categorie SERIAL,
   rendement_par_pieds INTEGER,
   prix_rendement NUMERIC(15,2)  ,
   PRIMARY KEY(id_categorie)
);

CREATE TABLE Terrain
(
   id_terrain SERIAL,
   description VARCHAR(50)  NOT NULL,
   latitude bigint,
   longitude bigint,
   id_parcelle INTEGER,
   photo VARCHAR(100) ,
   PRIMARY KEY(id_terrain)
);



CREATE TABLE Rendement
(
   id_rendement SERIAL,
   quantite NUMERIC(15,2)  ,
   PRIMARY KEY(id_rendement)
);

CREATE TABLE utilisateurs
(
   id_utilisateur SERIAL,
   nom VARCHAR(100) ,
   sexe VARCHAR(1) ,
   dtn date,
   pwd varchar(40),
   PRIMARY KEY(id_utilisateur)
);

insert into utilisateurs(nom,sexe,dtn,pwd) values('Toky','M','2023-01-01','0000');

CREATE TABLE type
(
   id_type SERIAL,
   nom_type VARCHAR(50) ,
   id_categorie INTEGER,
   PRIMARY KEY(id_type)
);

CREATE TABLE Parcelle
(
   id_parcelle INTEGER,
   dimension NUMERIC(15,2)  ,
   pieds INTEGER,
   prix NUMERIC(15,2)  ,
   id_terrain INTEGER NOT NULL,
   PRIMARY KEY(id_parcelle),
   FOREIGN KEY(id_terrain) REFERENCES Terrain(id_terrain)
);

CREATE TABLE Utilisateur_parcelle
(
   id_parcelle INTEGER,
   id_utilisateur INTEGER,
   PRIMARY KEY(id_parcelle, id_utilisateur),
   FOREIGN KEY(id_parcelle) REFERENCES Parcelle(id_parcelle),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateurs(id_utilisateur)
);

CREATE TABLE categorie_type_parcelle
(
   id_parcelle INTEGER,
   id_categorie INTEGER,
   id_type INTEGER,
   PRIMARY KEY(id_parcelle, id_categorie, id_type),
   FOREIGN KEY(id_parcelle) REFERENCES Parcelle(id_parcelle),
   FOREIGN KEY(id_categorie) REFERENCES Categorie_culture(id_categorie),
   FOREIGN KEY(id_type) REFERENCES type(id_type)
);

CREATE TABLE Rendement_parcelle
(
   id_rendement INTEGER,
   id_parcelle INTEGER,
   Daty TIMESTAMP,
   PRIMARY KEY(id_parcelle, id_rendement),
   FOREIGN KEY(id_parcelle) REFERENCES Parcelle(id_parcelle),
   FOREIGN KEY(id_rendement) REFERENCES Rendement(id_rendement)
);
