drop table DescripteurVedette;

drop table Concept;

drop table Contributeur;

drop type DescripteurVedette_t;

drop type ensemble_synonyme;

drop type DescripteurSynonyme;

drop type ensemble_specialisation;

drop type ens_descr;

drop type Descripteur_t;

drop type Concept_t;

drop type Contributeur_t;


create or replace type Contributeur_t as OBJECT
	(email VARCHAR2(40),
	motDePasse VARCHAR2(10),
	nombrePublications NUMBER,
	dateInscription VARCHAR2(10),
	derniereVisite VARCHAR2(10))
/



create or replace type Concept_t as OBJECT
	(nomConcept VARCHAR2(40),
	dateCreation VARCHAR2(10),
	nombreConsultations NUMBER,
	definition_concept VARCHAR2(4000),
	contributeur_concept REF Contributeur_t
	--libelle_concept VARCHAR2(40)
	--concept_descripteurVedette DescripteurVedette_t
	)
/



create or replace type Descripteur_t as Object
	(libelle VARCHAR2(40),
	dateCreation VARCHAR2(10),
	nombreConsultations NUMBER,
	definition VARCHAR2(4000),
	contributeur_descripteur ref Contributeur_t)
NOT FINAL
/


create or replace type ens_descr under Descripteur_t
()
FINAL
/

create or replace type ensemble_specialisation as table of ens_descr
/

create or replace type DescripteurSynonyme under Descripteur_t
()
FINAL
/

create or replace type ensemble_synonyme as table of DescripteurSynonyme
/

create or replace type DescripteurVedette_t under Descripteur_t
	(nomConcept VARCHAR2(40),
	descripteur_gen ref DescripteurVedette_t,
	descripteur_spec ensemble_specialisation,
	ensemble_synonymes ensemble_synonyme)
FINAL
/

create table Contributeur of Contributeur_t
	(CONSTRAINT PK_CONTRIBUTEUR PRIMARY KEY (email))
/


create table Concept of Concept_t
	(CONSTRAINT PK_concept PRIMARY KEY (nomConcept)
	)
/

create table DescripteurVedette of DescripteurVedette_t
	(CONSTRAINT PK_DescripteurVedette PRIMARY KEY (libelle),
	CONSTRAINT FK_nomconcept FOREIGN KEY(nomConcept) references Concept(nomConcept))
NESTED TABLE descripteur_spec store as specialisation
NESTED TABLE ensemble_synonymes store as synonymes
/
--ALTER TABLE synonymes add CONSTRAINT nom_unique unique(libelle);


--Insertion dans contributeur
--INSERT INTO Contributeur VALUES ('gilles', 'test', 1, 'test', 'test');

--Select contributeur
--SELECT * from Contributeur;

--Insertion dans Concept
--INSERT INTO Concept VALUES ('Auto', '04122012', 1, 'okok', (select ref(p) from Contributeur p  where email= 'gilles'));

--INSERT INTO Concept VALUES ('Bagnole', '04122012', 1, 'okok', (select ref(p) from Contributeur p  where email= 'gilles'));

--Select concept

--SELECT * from Concept;
--SELECT nomConcept from Concept;

--Insertion dans DescripteurVedette (sans synonyme; sans généralisation et sans spécialiation)

--INSERT INTO DescripteurVedette values ('Auto', '04122012', 0, 'une voiture', (select ref(p) from Contributeur p  where email= 'gilles'),
--'Auto', NULL, NULL, NULL);

--Insertion avec généraliation
--INSERT INTO DescripteurVedette values ('Blabla', '04122012', 0, 'une voiture', (select ref(p) from Contributeur p  where email= 'gilles'),'Bagnole', (select ref(p) from DescripteurVedette p  where libelle= 'Auto'), NULL, NULL);


--Select DescripteurVedette

--select libelle, nomConcept from DescripteurVedette;
--select t.libelle from DescripteurVedette d ,table (d.ensemble_synonymes) t where d.libelle='Auto';
 
--Insertion dans nested table synonymes 
-- Si table imbriqué synonyme est vide : update..., sinon insert
--UPDATE DescripteurVedette set ensemble_synonymes = (ensemble_synonyme(DescripteurSynonyme('test', '04122012', 0, 'test',(select ref(p) from Contributeur p  where p.email= 'gilles')))) where libelle = 'Auto';

--INSERT INTO TABLE (select ensemble_synonymes from DescripteurVedette where libelle='Auto') VALUES (DescripteurSynonyme('Bl', '04122012', 0, 'Bla',(select ref(p) from Contributeur p  where p.email= 'gilles')));

--INSERT INTO TABLE (select ensemble_synonymes from DescripteurVedette where libelle='Auto') VALUES (DescripteurSynonyme('abc', '04122012', 0, 'aaaa', (select ref(p) from Contributeur p where email= 'gilles')));

--UPDATE DescripteurVedette set descripteur_spec = (ensemble_specialisation(ens_descr('tutu', '04122012', 0, 'Bla', (select ref(p) from Contributeur p  where email= 'gilles')))) where libelle = 'Auto';

--INSERT INTO TABLE (select descripteur_spec from DescripteurVedette where libelle='Auto') VALUES (ens_descr('tutu', '04122012', 0, 'Bla', (select ref(p) from Contributeur p  where email= 'gilles')));
		
--INSERTION COMPLETE:

--INSERT INTO DescripteurVedette values ('Blaaaaaabla', '04122012', 0, 'une voiture', (select ref(p) from Contributeur p  where email= 'gilles'),'Auto', (select ref(p) from DescripteurVedette p  where libelle= 'Auto'), (ensemble_specialisation(ens_descr('tutu', '04122012', 0, 'Bla', (select ref(p) from Contributeur p  where email= 'gilles')))), (ensemble_synonyme(DescripteurSynonyme('tutu', '04122012', 0, 'Bla', (select ref(p) from Contributeur p  where email= 'gilles')))));
	
--Supprimer contenu nested table
	
--DELETE TABLE (select ensemble_synonymes from DescripteurVedette where libelle='Auto') WHERE libelle='Bla';

