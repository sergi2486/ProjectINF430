# Resources Management
C'est une application de gestion des réssources dans le but de créer les emplois du temps au sein de l'université de Yaoundé 1.
La création d'emploi de temps est de trois type diverses.
    - Création d'emploi de temps pour les cours magistraux;
    - Création d'emploi de temps pour les examens;
    - et enfin la création d'emploi de temps particulier

# COMMENT UTILISER L'APPLICATION Resources Management
Après lancement de l'application dans un navigateur, on accède à l'interface login. L'application dispose de trois profil à savoir:
    - Le profil Administrateur(Pour y accéder il faut un username et un password)
    - Le profil Enseignant(Pour y accéder il faut également un username et un password)
    - Le profil Etudiant (Qui ne nécessite pas un compte, on y accède en un simple clique sur "accéder sans compte")

        Dans le profil Administrateur, il est possible de faire les actions suivantes:
            -   On peut créer ou affecter les ressources (ex: Ajouter à l'application un nouvel amphy, un projecteur, ou encore un document)
            -   On peut également réserver n'importe quelle ressource en respectant un certain nombre de formalisme, afin d'empêcher les collisions.
                Les réservations consiste à créer des emplois de temps de trois catégories comme ainsi mentionné plus haut.
            -   Ensuite on peut afficher les réservations déjà effectuées durant l'année en cours et reconduire si besoin pour l'année suivante.
        Dans les profil Enseignant, et Etudiant il est possible de:
            -   Afficher l'emploi de temps conservant l'enseignant qui est connecté
            -   Imprimer si besoin
            


#Tecchnologie utilisées
L'application utilise les technologies suivantes:
    -  JAVA EE avec le framework Spring Boot (spring mvc, spring security, spring data);
    -  Javascript avec le framework AngularJS;
    -  HTML5, CSS3, Bootstrap
    -  SQL pour les requête dans la base de données
    -   