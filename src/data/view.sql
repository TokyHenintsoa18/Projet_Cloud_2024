select * from Parcelle_par_terrain 
join terrain on Parcelle_par_terrain.id_terrain=terrain.id_terrain 
join parcelle on Parcelle_par_terrain.id_parcelle=parcelle.id_parcelle;