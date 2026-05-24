# Lab 11 - Application de Cartographie (MapApp11)
**Auteur :** Zaynab Bellafrikh (4IIR-G2)  
**Institution :** EMSI - École Marocaine des Sciences de l'Ingénieur

## Description
Cette application Android est un projet de laboratoire (Lab 11) qui permet d'afficher une carte interactive, d'identifier la position de l'utilisateur et d'ajouter des marqueurs géographiques. Elle utilise la bibliothèque **OSMDroid** pour l'affichage des cartes OpenStreetMap.

## Fonctionnalités
- Affichage d'une carte interactive (OSMDroid).
- Centrage automatique sur une position par défaut (Alger).
- Localisation en temps réel de l'utilisateur (Point bleu).
- Gestion des permissions Android (Localisation et Stockage).
- Zoom et contrôles multi-touch.

## Technologies Utilisées
- **Langage** : Java
- **Bibliothèque de Cartographie** : OSMDroid (6.1.18)
- **Services Google** : Play Services Maps & Location (pour la précision)
- **Permissions** : Fine Location, Coarse Location, Internet, Write External Storage.

## Configuration et Installation

### 1. Clé API Google
Bien que l'application utilise principalement OSMDroid, une clé API Google Maps a été configurée dans le fichier `AndroidManifest.xml` pour les services de géolocalisation :
```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="AIzaSyAvxFQeb5lPZQrKbDR2hYqhTKsEWxG_1bk" />
```

### 2. Configuration du Manifest
Pour permettre le téléchargement des tuiles de la carte, l'option `usesCleartextTraffic` est activée dans le `AndroidManifest.xml` :
```xml
<application
    ...
    android:usesCleartextTraffic="true">
```

### 3. Permissions
L'application demande dynamiquement au démarrage les permissions suivantes :
- `ACCESS_FINE_LOCATION`
- `WRITE_EXTERNAL_STORAGE` (pour le cache de la carte)

## Comment utiliser l'application
1. Lancez l'application sur un émulateur ou un appareil réel.
2. Acceptez les demandes de permissions de localisation.
3. La carte s'affichera par défaut sur Alger.
4. Si le GPS est activé, un point bleu apparaîtra pour indiquer votre position actuelle.


https://github.com/user-attachments/assets/b462acc2-73c4-4a2b-a352-94596c612ff1
