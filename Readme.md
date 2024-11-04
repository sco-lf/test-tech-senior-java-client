# Bienvenue dans notre test technique lesfurets (Business Partners).

## Introduction au contexte du test

### Ce test présente un cas d'utilisation *proche de notre réalité*:
- Notre comparateur collecte des informations sur un visiteur via un Formulaire. Ces informations (nom, date de naissance, vehicule, ...) sont stockées dans une classe **Project**.
- Ce Project est transmis à un **Orchestrator**.
- Cet **Orchestrator** collecte :
  - toutes les **Formules** (offres)  d'assurance recensées par notre application
  - certaines **Formules** peuvent être exclues de la suite du processus
  - pour chaque **Formule** est constitué un objet **Tarification**, qui symbolisera un appel de WebService externe
  - ces **Tarification** sont distribuées dans des _Backends_ (un par Partenaire Assureur), Chaque Backend possède un **BackendService** et un **MapperService**.
  - chaque **BackendService** va gérer l'envoi d'une requête de tarification (demande de tarif) à son WebService externe associé. Cet appel se fera selon un process imposé par le modèle parent, et dans le détail des modèles, URL et caractéristiques de connexion propres au WebService du partenaire.
  
### L'enchainement est ainsi le suivant :

1. **Orchestrator**
   1. constitue une liste de Formule
   2. filtre les Formule a conserver
   3. crée un objet Tarification par Formule
   4. fait un appel "doQuotation" pour chaque Tarification
2. **BackenService**
   1. la tarification est transmise au BackendService du bon partenaire (associé à la Formule).
   2. un mapping du modele lesFurets (Project) vers un spécifique au Partenaire est effectué
   3. un appel de WebService est effectué, utilisant pour Payload la sortie du précédent **Mapping**
   4. le WS fournit une réponse
   5. un **mapping** sortant est effectué sur le retour de WebService externe, pour le conformer au modèle interne des Furets (inverse du précédent procédé)

**Résumé :**

```
        Orchestator.computeQuotation(Project)
                        ||
Liste d'objets Tarification, associant Project et Formule
                        ||
     un appel au doQuotation d'un BackendService
          pour chaque objet Tarification
                        ||
BackendService appelle MapperService mappingTarificationMapperIn
    BackendService appelle le WS avec la pauload recupérée
BackendService traite la réponse via mappingTarificationMapperOut
```

## Format du projet Maven :
_Le projet Maven est organisé en différents Modules afin de symboliser le découpage de l'application._

- **orchestator**:
Les classes d'execution centrales. L'orchestrateur est le Service appelé lors d'une demande de Tarification, à la fin de notre Formulaire, lorsque le client demande à "Voir les Offres" via un clic de CTA.
- **backends**:
Le Module encapsulant :
  - **common**: un Module commun à tous les backends, définissant les structures à maintenir pour tous les backends et fournissant les interfaces nécessaires pour rendre générique le service de ces backends
  - **jma**: un Backend d'exemple pour un assureur fictif (JMA = Jean Michel Assurance). Contient aussi quelques ressources du partenaires, comme des flux d'exemple.
- **tunnel**: Tout ce qui touche au formulaire lesfurets et aux entité utlisées en amont de l'Orchestrateur
- **test_client**: Un Module hébergeant un Main.java, qui simulera notre contexte d'execution (Run) hors tests unitaires.



## Questions à traiter
- _Vous traiterez les questions suivantes à votre guise, dans l'ordre qui vous plaira._
- _Veuillez garder un commit par sujet._
- _Ce test est une étude de cas guidée. Vous serez évalué(e) sur la base du nombre de questions correctement traitées mais avant tout sur la qualité de vos remarques et choix techniques._
- _N'hésitez pas à commenter votre code. Celà ouvrira les discussions lors de l'entretien de debrief._


### A : GENERATION DE CODE:
##### 1 - les Exclusions
Dans l'enum Java **EExclusion**, vous trouverez un certain nombre de Predicate.
Ces derniers peuvent être utilisés dans **EExclusionFilter** pour ex-filtré des Formules d'une liste.

**Ajoutez à ExclusionFiltersRegistry le code permettant d'appliquer ces filtres, puis assurez vous de leur bon fonctionnement via un test Unitaire (dans ExclusionFiltersRegistryTest).**

_Remarque : Ce schéma permet d'éviter les appels HTTP pour des Profil n'interessant pas un partenaire Assureur_


##### 2 - remontée d'erreur
Le BackendService de Jean Michel Assurance (voir **JmaBackendService**) effecture des mapping entrants et sortants, des appels HTTP, manipule des objects, ...
Le code proposé évite la plupart des précautions sur les null check, les contrôles de formats de données, ... Il peut donc à tout moment déclencher une exception.

**Proposez un format de catching et de remontée des exceptions pour ce BackendService (et les classes qu'il utilise) qui puisse permettre de trier les erreurs survenues, sans interrompre le process de Tarification**
**A l'issu de ces modifications le Main doit pouvoir traiter l'erreur de WebService sans échouer, tout en informant sur l'origine du problème**


##### 3 - redécoupage (optionnel)
Le code de mappingTarificationIn (**JmaMapperService**) est dense et peu lisible.

**Proposez un re-découpage.**

##### 4 - Ajout d'une information a la Tarification IN de Jean Michel Assurance (optionnel)
Notre modèle contient la civilité (M./Mme/Mlle). Celle-ci n;est pas transmise lors des tarifications a notre partenaire JMA.

Ce dernier voudrait désormais ajouter à son json un champs "sexe" dans le champs "souscripteur". 

Ce nouveau champs prendra les valeurs "H" (correspondant au "Mr." du modèle lesfurets) et "F" (pour les 2 autres cas)

**Implémentz ce changement**


### TESTING:

#####  1 - Mocking
Dans **JmaBackendServiceTest**, implémenter des tests afin de couvrir la classe JmaBackendService de JMA.

**Ajouter un Mock du mapperService**
**cela pourra nécessiter de retoucher les classes BackendService MappingService, afin de ne plus subir les Singletons**
**Proposer un format permettant de construire habilement des objets Projet, pour faire varier les profils**

#####  2 - JmaMapperServiceTest
JmaMapperServiceTest est partiellement implémenté.

**retoucher la classe de test pour y faire du test parametré, ou lire des profil json**
**ameliorer le testing et sa lisibilité en retouchant la classe de mapping**

#####  3 - Flux de test (optionnel)
Des flux de test ont été fournis par le partenaire (repertoire TestingProfiles du backend JMA).

**utilisez-les dans des exemples de Test unitaires pertinents. L'utilisation de tests Paramétrés est un plus**


### ARCHITECTURE:

#####  1 - Injection de dépendance
Pour approfondir la mise en place de Mock faite dans la première partie, il serait utile de généraliser l'utilisation de version mock de certains Services dans selon les contexte d'execution.

**Implémentez une solution permettant d'utiliser des classes réelles (dans Main.java par exemple) ou des classes de Mock (dans certains tests unitaires). Toute implémentation : manuelle, injection de dépendance, couche Spring ... sera acceptée.**

#####  2 - Injection de dépendance
Les enums EFormules et EFormulesJMA représentent respectivement le modèle de Formule commun et la liste des formules propres à JMA.

**Proposez une implémentation permettant de ne plus utiliser d'enums, tout en gardant la hierarchie et l'immuabilité. Vous pourrez à loisir utiliser les Records ou les Sealed Classes si celà vous semble approprié**

#####  3 - Classes utilitaires à revoir (optionnel)
ExclusionFiltersRegistry et FormulesRegistry sont des singletons, mal articulés, et placés artificiellement en haut de la hierarchie de Module Maven.
Ce format perturbe la structure de projet multi-module, les dépendances, et pollue la testabilité.

**Proposez une structure permettant de les supprimer, remplacer par de l'injection de dépendance, ou des classes utilitaires plus habilement placées**



##Annexe:
Notre formulaire génère des structures Project, contenant les informations suivantes :

**NOM** (String)

**PRENOM** (String)

**DATE DE MAISSANCE** (LocalDate : jj/mm/aaaa)

**CIVILITE** (enum ECivilite)

**EMAIL** (String)

**PROFESSION** (enum EStatutProfessionnel) // Des catégories de travailleurs

**VEHICULE**

- **IDRSA** (int) // unid de vehicule dans la base RSA (base commune a tous les assureurs permettant d'identifier par un id unique chaque vehicule a travers sa marque, son modele, sa motorisation et sa version)

- **PLAQUE D'IMMATRICULATION** (String)

- **DATE DE MISE EN CIRCULATION** (Date : jj/mm/aaaa) // lisible sur la carte grise, c'est l'age du vehicule, au dela des reventes d'occasion

**ADRESSE** (string)

**COMMUNE** (string)

**CODE POSTAL** (string)

**TYPE DE COUVERTURE** (enum ETypeCouverture) // 3 types de Couvertures, impliquant chacune des niveaux de garanties différents