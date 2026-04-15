# TP Lab 6 — Recettes Pizza (ListView + Adapter + DAO)

## Description

Application Android affichant une liste de recettes de pizza avec navigation vers
une fiche détaillée complète. Le projet est structuré en couches logiques
(DAO / Service / Adapter / UI) pour simuler une architecture professionnelle.

---

## Démonstration
https://github.com/Huuudaa/LAB_6_SAS_Houda/blob/bcf9a0532b2ab8b759a8ff7e0f3710a3486a006c/video/pizza.gif


video/pizza.gif

---

## Fonctionnalités

- Splash Screen animé au démarrage (2 secondes)
- Liste des 10 recettes avec image, nom, durée et prix
- Clic sur une recette → fiche détaillée complète
- Fiche détail : image, titre, composition, description, étapes de préparation
- Architecture en couches : `classes` / `dao` / `service` / `adapter` / `ui`
- Gestion des données en mémoire via le pattern Singleton

---

## Architecture

```
IDao<T>  (interface générique)
    │
    └──  RecetteService  (Singleton — stockage en mémoire)
                │
                └──  RecetteAdapter  (lie les données à la ListView)
                            │
                            └──  ListeRecettesActivity  (affiche la liste)
                                            │
                                            └──  DetailRecetteActivity  (fiche détail)
```

---

## Fichiers principaux

### `classes/Recette.java`

Modèle de données représentant une recette :

| Champ | Type | Rôle |
|---|---|---|
| `id` | `long` | Identifiant auto-incrémenté |
| `titre` | `String` | Nom de la pizza |
| `tarif` | `double` | Prix en euros |
| `photoRes` | `int` | Référence image drawable |
| `tempsPrep` | `String` | Durée de préparation |
| `composition` | `String` | Liste des ingrédients |
| `resume` | `String` | Description courte |
| `preparation` | `String` | Étapes de préparation |

### `dao/IDao.java`

Interface générique CRUD :

| Méthode | Rôle |
|---|---|
| `create(T)` | Ajouter un élément |
| `update(T)` | Modifier un élément |
| `delete(long)` | Supprimer par ID |
| `findById(long)` | Chercher par ID |
| `findAll()` | Récupérer tous les éléments |

### `service/RecetteService.java`

- Pattern **Singleton** : une seule instance partagée via `getInstance()`
- Méthode `initialiser()` : préremplissage des 10 recettes au démarrage
- Données stockées dans une `ArrayList` en mémoire

### `adapter/RecetteAdapter.java`

- Étend `BaseAdapter`
- Méthode `getView()` : inflates `row_recette.xml` pour chaque élément
- Affiche : image, titre, durée et prix de chaque recette

### `ui/SplashActivity.java`

- Affiche un écran de démarrage pendant **2 secondes**
- Lance `ListeRecettesActivity` via un `Thread`
- `finish()` empêche de revenir sur le splash

### `ui/ListeRecettesActivity.java`

- Récupère les recettes via `RecetteService.getInstance().findAll()`
- Lie les données à la `ListView` via `RecetteAdapter`
- `setOnItemClickListener` : navigue vers `DetailRecetteActivity` en passant l'ID

### `ui/DetailRecetteActivity.java`

- Reçoit l'ID via `getIntent().getLongExtra("recette_id", -1)`
- Récupère la recette via `RecetteService.getInstance().findById(id)`
- Affiche tous les champs : image, titre, infos, composition, résumé, préparation

---

## Flux de navigation

```
Démarrage
    ↓
SplashActivity (2 sec)
    ↓
ListeRecettesActivity  ──── clic sur une recette ────▶  DetailRecetteActivity
                                                                │
                                          bouton Retour ◀───────┘
```

---

## AndroidManifest.xml — points importants

- `SplashActivity` est le point d'entrée (`LAUNCHER`)
- Toutes les activities du sous-package `ui` sont déclarées avec `.ui.NomActivity`
- `DetailRecetteActivity` et `ListeRecettesActivity` déclarées sans `exported`

---

## Concepts utilisés

| Concept | Description |
|---|---|
| `BaseAdapter` | Adaptateur personnalisé pour `ListView` |
| `getView()` | Génère la vue de chaque ligne de la liste |
| `ViewHolder` | Optimise le recyclage des vues |
| `Singleton` | Une seule instance de service partagée |
| `AUTO_ID` | Identifiant auto-incrémenté en mémoire |
| `putExtra / getLongExtra` | Passage d'ID entre activités |
| `Thread.sleep()` | Délai du Splash Screen |
| `finish()` | Ferme l'Activity courante |
| `Collections.unmodifiableList` | Protège la liste interne du service |
| `LayoutInflater` | Crée dynamiquement les vues de liste |

---


## Environnement

- **IDE** : Android Studio
- **Langage** : Java
- **Minimum SDK** : API 24 (Android 7.0)
- **API cible** : 36.1
- **Émulateur** : Medium Phone API 36.1
