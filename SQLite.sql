CREATE TABLE clients(
  NIF text PRIMARY KEY,
  nom text,
  ciutat text,
  edat integer
);

INSERT INTO clients(NIF, nom, ciutat, edat) VALUES ("124A","UAB","Bellaterra",50);
INSERT INTO clients(NIF, nom, ciutat, edat) VALUES ("743V","RENFE","Cerdanyola",100);

----------------------------------------------------

SELECT *
FROM clients
WHERE ciutat="Bellaterra" AND edat>=50
-- WHERE ciutat="Bellaterra" OR ciutat="Cerdanyola"

----------------------------------------------------

SELECT COUNT(*) as num_clinets FROM clients
WHERE ciutat="Bellaterra"

----------------------------------------------------

SELECT ciutat,avg(edat) AS mitja_edat, COUNT(*) as num_clinets FROM clients
WHERE edat > 30
GROUP BY ciutat
HAVING num_clinets>=2
ORDER by mitja_edat ASC

----------------------------------------------------

CREATE TABLE IF not EXISTS vendes (
  id integer PRIMARY KEY AUTOINCREMENT,
  clients text,
  producte text,
  data text
);
INSERT INTO vendes(clients,producte,data) VALUES ("123A","1", "2022-11-22");
INSERT INTO vendes(clients,producte,data) VALUES ("743V","2", "2022-11-22");
INSERT INTO vendes(clients,producte,data) VALUES ("145S","1", "2022-11-21");
INSERT INTO vendes(clients,producte,data) VALUES ("741P","2", "2022-11-20");

SELECT data,clients.nom,productes.nom from vendes, productes
WHERE producte=ean AND vendes.clients = clients.nif
order by data

----------------------------------------------------

SELECT * from vendes;
--- to change the value of row 
UPDATE vendes set data="2022-11-01" WHERE id=2;
SELECT * from vendes

----------------------------------------------------

SELECT * from clients;
--- to change the value of row 
DELETE FROM clients WHERE nif="743V";
SELECT * from clients