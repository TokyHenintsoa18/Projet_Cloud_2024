CREATE TABLE Parcelle(
   id_parcelle SERIAL,
   dimension NUMERIC(15,2) ,--en m2
   nb_pieds INTEGER,
   prix NUMERIC(15,2)  ,
   PRIMARY KEY(id_parcelle)
);
--nbr_pieds/diemension = 1m2 = > 4pieds  
insert into Parcelle(dimension,nb_pieds,prix)values(90,100,800000);
insert into Parcelle(dimension,nb_pieds,prix)values(60,50,100000);
insert into Parcelle(dimension,nb_pieds,prix)values(40,100,800000);



CREATE TABLE Categorie_culture(
   id_categorie SERIAL,
   rendement_par_pieds INTEGER,
   Prix_unitaire NUMERIC(15,2),
   PRIMARY KEY(id_categorie)
);

insert into categorie_culture(rendement_par_pieds,Prix_unitaire)values(2,5000);
insert into categorie_culture(rendement_par_pieds,Prix_unitaire)values(4,2000);
insert into categorie_culture(rendement_par_pieds,Prix_unitaire)values(1,5000);

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
   rendement_total NUMERIC(15,2) ,
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
insert into utilisateurs(nom,sexe,dtn,email,pwd)values('Henintsoa','M','2004-01-01','tokyramanalina@gmail.com','123');


CREATE TABLE type(
   id_type SERIAL,
   nom_type VARCHAR(50),
   PRIMARY KEY(id_type)
);

insert into type(nom_type)values('grain');

CREATE TABLE Parcelle_par_terrain
(
   id_tp SERIAL,
   id_utilisateur INTEGER,
   id_parcelle INTEGER,
   id_terrain INTEGER,
   --id_categorie integer
   PRIMARY KEY(id_TP),
   FOREIGN KEY(id_parcelle) REFERENCES Parcelle(id_parcelle),
   FOREIGN KEY(id_terrain) REFERENCES Terrain(id_terrain)
);

insert into Parcelle_par_terrain(id_utilisateur,id_parcelle,id_terrain)values(1,1,1);




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



CREATE TABLE parcelle_rendement(
   id_pr SERIAL,
   id_parcelle INTEGER,
   id_rendement INTEGER,
   Daty TIMESTAMP,
   PRIMARY KEY(id_recolte),
   FOREIGN KEY(id_parcelle) REFERENCES Parcelle(id_parcelle),
   FOREIGN KEY(id_rendement) REFERENCES Rendement(id_rendement)
);
