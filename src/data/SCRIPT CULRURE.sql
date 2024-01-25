CREATE TABLE Parcelle(
   id_parcelle SERIAL,
   dimension NUMERIC(15,2) ,
   nb_pieds INTEGER,
   prix NUMERIC(15,2)  ,
   PRIMARY KEY(id_parcelle)
);

insert into Parcelle(dimension,nb_pieds,prix)values(90,100,800000);

CREATE TABLE Categorie_culture(
   id_categorie SERIAL,
   rendement_par_pieds INTEGER,
   Prix_unitaire NUMERIC(15,2),
   PRIMARY KEY(id_categorie)
);

CREATE TABLE Terrain(
   id_terrain SERIAL,
   description VARCHAR(50)  NOT NULL,
   longitude VARCHAR(50),
   latitude VARCHAR(50),
   photo VARCHAR(50) ,
   PRIMARY KEY(id_terrain)
);

insert into terrain(description,longitude,latitude,photo)values('Terrain1','47,507209','-18,910895','img1.jpg');

CREATE TABLE Rendement(
   id_rendement SERIAL,
   quantite NUMERIC(15,2) ,
   PRIMARY KEY(id_rendement)
);

CREATE TABLE utilisateurs(
   id_utilisateur SERIAL,
   nom VARCHAR(50) ,
   sexe VARCHAR(1) ,
   dtn DATE,
   email VARCHAR(100),
   pwd VARCHAR(100),
   PRIMARY KEY(id_utilisateur)
);

insert into utilisateurs(nom,sexe,dtn,email,pwd)values('Toky','M','2004-01-01','tokyramanalina@gmail.com','123');

CREATE TABLE type(
   id_type SERIAL,
   nom_type VARCHAR(50) ,
   id_categorie INTEGER,
   PRIMARY KEY(id_type)
);

CREATE TABLE Parcelle_par_terrain
(
   id_tp SERIAL,
   id_parcelle INTEGER,
   id_terrain INTEGER,
   PRIMARY KEY(id_TP),
   FOREIGN KEY(id_parcelle) REFERENCES Parcelle(id_parcelle),
   FOREIGN KEY(id_terrain) REFERENCES Terrain(id_terrain)
);

insert into Parcelle_par_terrain(id_parcelle,id_terrain)values(1,2);
insert into Parcelle_par_terrain(id_parcelle,id_terrain)values(2,2);

CREATE TABLE Parcelle_utilisateur(
   id_pu SERIAL,
   id_parcelle INTEGER,
   id_utilisateur INTEGER,
   PRIMARY KEY(id_pu),
   FOREIGN KEY(id_parcelle) REFERENCES Parcelle(id_parcelle),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateurs(id_utilisateur)
);


CREATE TABLE categorie_type_parcelle(
   id_CTP SERIAL,
   id_parcelle INTEGER,
   id_categorie INTEGER,
   id_type INTEGER ,
   PRIMARY KEY(id_ctp),
   FOREIGN KEY(id_parcelle) REFERENCES Parcelle(id_parcelle),
   FOREIGN KEY(id_categorie) REFERENCES Categorie_culture(id_categorie),
   FOREIGN KEY(id_type) REFERENCES type(id_type)
);

CREATE TABLE Recolte(
   id_recolte SERIAL,
   id_parcelle INTEGER,
   id_rendement INTEGER,
   Daty TIMESTAMP,
   PRIMARY KEY(id_recolte),
   FOREIGN KEY(id_parcelle) REFERENCES Parcelle(id_parcelle),
   FOREIGN KEY(id_rendement) REFERENCES Rendement(id_rendement)
);