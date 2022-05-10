CREATE DATABASE wildlife_tracker;
\c
CREATE TABLE locations(
locationid serial PRIMARY KEY,
locationname VARCHAR,
locationdescription VARCHAR,
image VARCHAR
);

INSERT INTO locations(locationname,locationdescription, image ) VALUES(' Savannah','Dry area in the North Eastern side', '/images/savannah.jpeg') RETURNING locationid;
INSERT INTO locations(locationname,locationdescription, image ) VALUES(' Equatorial','Cool area in the Central region', '/images/equatorial.jpeg') RETURNING locationid;
INSERT INTO locations(locationname,locationdescription, image ) VALUES(' Swampy','Cool area with a lot of moisture in the South Eastern side', '/images/swampy.jpg') RETURNING locationid;
INSERT INTO locations(locationname,locationdescription, image ) VALUES(' Mushy','Watery area in the Western side', '/images/mangroove.jpeg') RETURNING locationid;


CREATE TABLE animals(
animalid serial PRIMARY KEY,
animalname VARCHAR,
animalType VARCHAR,
animalhealth VARCHAR,
rareanimalage VARCHAR
);

INSERT INTO animals(animalname,animaltype , animalhealth, rareanimalage) VALUES(' Cheetah ','Rare Animal',' Sick ', 'New Born') RETURNING animalid;
INSERT INTO animals(animalname,animaltype , animalhealth, rareanimalage) VALUES(' Hyena ','Normal Animal','','') RETURNING animalid;
INSERT INTO animals(animalname,animaltype , animalhealth, rareanimalage ) VALUES(' White Rhino','Rare Animal','Healthy', 'Adult') RETURNING animalid;
INSERT INTO animals(animalname,animaltype , animalhealth, rareanimalage) VALUES(' Gazzelle','Normal Animal', '','') RETURNING animalid;


CREATE TABLE sightings(
sightingId serial PRIMARY KEY,
sightanimalname VARCHAR,
sightanimaltype VARCHAR,
rangername VARCHAR,
locationname VARCHAR,
sightanimalage VARCHAR,
sightanimalhealth VARCHAR,
sightingtime timestamp
);

INSERT INTO sightings(sightanimalname,sightanimaltype , rangername, locationname,sightanimalage, sightanimalhealth, sightingtime ) VALUES(' Cheetah ','Rare Animal','Cheche','Equatorial',' New Born ', 'Sick', now()) RETURNING sightingId;
INSERT INTO sightings(sightanimalname,sightanimaltype , rangername, locationname,sightanimalage, sightanimalhealth, sightingtime ) VALUES(' Gazzelle ','Normal Animal','Muvkin ','Swampy','  ', '', now()) RETURNING sightingId;
INSERT INTO sightings(sightanimalname,sightanimaltype , rangername, locationname,sightanimalage, sightanimalhealth, sightingtime ) VALUES(' Cheetah ','Rare Animal','Cheche','Equatorial',' Young', 'Sick', now()) RETURNING sightingId;
INSERT INTO sightings(sightanimalname,sightanimaltype , rangername, locationname,sightanimalage, sightanimalhealth, sightingtime ) VALUES(' White Rhino ','Normal Animal','Cheche','Equatorial','  ', '', now()) RETURNING sightingId;



CREATE DATABASE wildlife_tracker_test;
\c
CREATE TABLE animals(
animalid serial PRIMARY KEY,
animalname VARCHAR,
animalType VARCHAR,
animalhealth VARCHAR,
rareanimalage VARCHAR
);

CREATE TABLE sightings(
sightingId serial PRIMARY KEY,
sightanimalname VARCHAR,
sightanimaltype VARCHAR,
rangername VARCHAR,
locationname VARCHAR,
sightanimalage VARCHAR,
sightanimalhealth VARCHAR,
sightingtime timestamp
);

CREATE TABLE locations(
locationid serial PRIMARY KEY,
locationname VARCHAR,
locationdescription VARCHAR,
image VARCHAR
);