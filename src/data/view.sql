create or replace view v_list_parcelle_terrain as
select id_tp,id_utilisateur,id_parcelle,terrain.id_terrain,description,longitude,latitude,photo from Parcelle_par_terrain 
join terrain on Parcelle_par_terrain.id_terrain=terrain.id_terrain ;

create or replace view v_parcelle as
select id_tp,utilisateurs.id_utilisateur,nom,parcelle.id_parcelle,id_terrain,dimension,nb_pieds 
from parcelle_par_terrain 
join parcelle on parcelle_par_terrain.id_parcelle=parcelle.id_parcelle 
join utilisateurs on parcelle_par_terrain.id_utilisateur=utilisateurs.id_utilisateur;

select * 
from parcelle_par_terrain 
join parcelle on parcelle_par_terrain.id_parcelle=parcelle.id_parcelle 
join utilisateurs on parcelle_par_terrain.id_utilisateur=utilisateurs.id_utilisateur;