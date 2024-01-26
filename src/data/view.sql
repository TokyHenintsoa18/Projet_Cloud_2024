create or replace view v_list_parcelle_terrain as
select id_tp,id_utilisateur,id_parcelle,terrain.id_terrain,description,longitude,latitude,photo from Parcelle_par_terrain 
join terrain on Parcelle_par_terrain.id_terrain=terrain.id_terrain ;