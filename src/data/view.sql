create or replace view v_information_parcelle_par_terrain as
select id_tp,utilisateurs.id_utilisateur,utilisateurs.nom,parcelle.id_parcelle,id_terrain,categorie_culture.id_categorie,categorie_culture.nom_categorie,type.id_type,type.nom_type,rendement_par_pieds,prix_unitaire,dimension,nb_pieds,prix as prix_parcelle 
from parcelle_par_terrain 
join categorie_culture on parcelle_par_terrain.id_Categorie = categorie_culture.id_categorie 
join parcelle on parcelle_par_terrain.id_parcelle = parcelle.id_parcelle
join utilisateurs on parcelle_par_terrain.id_utilisateur=utilisateurs.id_utilisateur
join type on parcelle_par_terrain.id_type=type.id_type;

create or replace view v_prix_rendement_prevision as 
select id_terrain,id_parcelle,id_utilisateur,nom,(dimension * 4) as nb_pieds,((dimension * 4)*prix_unitaire)as montant,id_categorie,nom_categorie,id_type,nom_type 
from v_information_parcelle_par_terrain;

create or replace view v_sum_prix_rendement_prevision as
select id_utilisateur,nom,sum(montant) as sum_montant 
from v_prix_rendement_prevision group by id_utilisateur,nom;

create or replace view v_rendement_par_qte as
select id_terrain,id_utilisateur,nom,sum((rendement_par_pieds*nb_pieds)) 
from v_information_parcelle_par_terrain group by id_terrain,id_utilisateur,nom;


create or replace view v_prix_rendement_reel as
select id_terrain,id_parcelle,id_utilisateur,nom,(dimension * 6) as nb_pieds,((dimension * 6)*prix_unitaire)as montant,id_categorie,nom_categorie,id_type,nom_type
from v_information_parcelle_par_terrain;

create or replace view v_sum_prix_rendement_reel as 
select id_utilisateur,nom,sum(montant) as sum_montant 
from v_prix_rendement_reel group by id_utilisateur,nom;

create or replace view stat_parcelle as 
select (count(id_parcelle)*100/(select count(*) from v_information_parcelle_par_terrain)) as stat_parcelle,id_terrain  
from v_information_parcelle_par_terrain group by id_terrain;



drop view v_information_parcelle_par_terrain;
drop view v_prix_rendement_prevision;
drop view v_sum_prix_rendement_prevision;
 drop view v_rendement_par_qte;
 drop view v_prix_rendement_reel
 drop view v_sum_prix_rendement_reel
 drop view stat_parcelle;