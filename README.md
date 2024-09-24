# Choix techniques
## Java 19
J'ai utilisé Java 19, parce que c'est ce qu'IntelliJ propose par défaut, et parce que ça me change du java 8 que je fais au quotidien.

## Maven
Un projet Maven offre un bon compromis entre un projet java brut et l'utilisation d'un framework plus important. L'habitude du TDD fait qu'il est difficile de se passer de Junit, de Harmcrest ou de Mockito.

## Dépendances de test
Junit et Mockito sont des standards du test. Harmcrest facilite la lecture des assertions.

# Choix architecturaux
## Architecture hexagonale
L'un des intérêts d'une architecture hexagonale est la facilitation du remplacement de l'infrastructure, dans ce cas, la lecture des fichiers, par des appels REST ou l'accès à une base de données, par exemple.

Cela peut sembler un peu sur-conçu, mais ce genre d'architecture a surtout l'avantage d'isoler le code métier, ce qui permet d'appliquer du Domain-Driven Design facilement.

# Choix d'implémentation
## Représentation de la carte
La modélisation de la carte m'a fait me poser pas mal de question, et j'ai envisagé différentes pistes :
- Tableau de tableau
- Map avec les coordonées en clé
- Donner la responsabilité à chaque case de connaître ses voisins

J'ai fini sur un compromis entre la performance et l'objet via une liste de liste d'Enum. L'avantage de la solution choisie est la possibilité de faire évoluer

# Lancement

``java -classpath <path>\technicalassessment\target\classes AdventureApplication <path\map> <path\adventure>``

Je n'ai plus l'habitude de lancer une application java en ligne de commande, et pour les besoins de mes tests, je l'ai lancé via mon IDE.  
Si jamais la carte ou l'aventure ne sont pas renseignés dans les arguments, l'application charge la carte et l'aventure présentes dans les ressources.

# Notes
J'y ai passé plus de temps que prévu. J'ai beaucoup aimé l'énoncé, les problèmes qu'il pose.