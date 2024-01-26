create or replace view v_information_parcelle as
select id_tp,id_utilisateur,parcelle.id_parcelle,id_terrain,categorie_culture.id_categorie,rendement_par_pieds,prix_unitaire,dimension,nb_pieds,prix as prix_parcelle 
from parcelle_par_terrain 
join categorie_culture on parcelle_par_terrain.id_Categorie = categorie_culture.id_categorie 
join parcelle on parcelle_par_terrain.id_parcelle = parcelle.id_parcelle;


create or replace view v_prix_rendement as 
select id_terrain,id_parcelle,id_utilisateur,(dimension * 4) as nb_pieds,((dimension * 4)*prix_unitaire)as montant,id_categorie 
from v_information_parcelle

create or replace view v_rendement_par_qte as
select id_terrain,sum((rendement_par_pieds*nb_pieds)) 
from v_information_parcelle group by id_terrain;

create or replace view v_sum_prix_rendement as
select id_utilisateur,sum(montant) as sum_montant 
from v_prix_rendement group by id_utilisateur;