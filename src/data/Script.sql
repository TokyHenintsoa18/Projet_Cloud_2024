CREATE TABLE Categorie_culture
(
   id_categorie SERIAL,
   rendement_par_pieds INTEGER,
   prix_unitaire NUMERIC(15,2)  ,
   PRIMARY KEY(id_categorie)
);

CREATE TABLE Terrain
(
   id_terrain SERIAL,
   description VARCHAR(50)  NOT NULL,
   latitude bigint,
   longitude bigint,
   photo VARCHAR(100),
   prix NUMERIC(15,2),
   PRIMARY KEY(id_terrain)
);

INSERT INTO Terrain (description, latitude, longitude, photo, prix) VALUES('Terrain 1', 123456789012345, 987654321098765, 'photo1.jpg', 1000),

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
   email VARCHAR(40),
   pwd varchar(40),
   PRIMARY KEY(id_utilisateur)
);

insert into utilisateurs(nom,sexe,dtn,email,pwd) values('Toky','M','2023-01-01','Toky@example.com','0000');

CREATE TABLE type_culture
(
   id_type SERIAL,
   nom_type VARCHAR(50) ,
   id_categorie INTEGER,
   PRIMARY KEY(id_type)
);

CREATE TABLE Parcelle
(
   id_parcelle SERIAL PRIMARY key,
   dimension NUMERIC(15,2)  ,
   pieds INTEGER,
   prix NUMERIC(15,2)
  
);

insert into Parcelle(dimension,pieds,prix) values(50,20,1000000);
insert into Parcelle(dimension,pieds,prix) values(20,15,200000);
insert into Parcelle(dimension,pieds,prix) values(80,60,5000000);


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
   FOREIGN KEY(id_type) REFERENCES type_culture(id_type)
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

CREATE TABLE Terrain_parcelle 
(
   id_tp SERIAL PRIMARY KEY,
   id_terrain INTEGER,
   id_parcelle INTEGER,
   FOREIGN KEY(id_terrain) REFERENCES Terrain(id_terrain)
   FOREIGN KEY(id_parcelle) REFERENCES Parcelle(id_parcelle)
);