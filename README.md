# Web per fitxar pels profes:
## Proposta:
Pàgina web que permetrà als professors autenticar-se amb el correu de l’institut per fitxar quan entren a treballar.
Aplicació mòvil (Android) que permetrà fitxar escanejant un codi QR

## Membres del grup:
Roger Pérez  
Adrian Villacis  
Anna Lea  
Sergio Castillero  

## Idea general del funcionament de la web:
La pàgina es servirà de manera local a la xarxa de l’institut, d’aquesta forma un professor que no estigui al centre no podrà accedir a la web per fitxar. 
El codi QR estarà o bé imprés o bé a una pantalla a l'escola per poder escanejar-lo en arribar.

## Funcionalitats:
* Autenticació mitjançant gmail per utilitzar el correu de l'institut.
* Horari dinàmic segons l'usuari (profe) loginejat.  
* Fitxar i desfitxar (per defecte si no desfitxes a última hora es farà sol,pero la possibilitat de fer-ho manualment permetrà que si un professor marxa a meitat del dia, es pugui registrar).
* Recompte d'hores setmanals de classe i comparaciò amb les hores fitxades.
### Ampliacions:
* Fitxar per huella/QR/metodes alternatius

## Problemes/Riscos:
* Dificultats derivades d'utilitzar tecnologies noves.
* Alta probabilitat de no poder desenvolupar les ampliacions degut a la seva complexitat donat que no tenim cap experiencia en el tema.
* Integrar correctament l'aplicació movil i la pàgina web a l'hora.

## Tecnologies:
#### Frontend:
##### WEB:
* HTML
* Javascript
* Sass
* Svelte o Vue - (opcional)
##### APP: 
* Android Studio
* Java

#### Backend:
* Typescript
* Express.js
* Firebase (logins)
* MySQL (dades)

> Rest API montada amb el framework Express.js per fer operacions CRUD
#### Per què Typescript?
Similaritat sintactica amb JavaScript afegint la possibilitat de tipar les dades, que ajuda a la claretat i al debugging del codi
#### Per què Express?
Facilitza el desenvolupament d'una API respecte a fer-lo de forma convencional
#### Per què Sass?
Perque fa que la sintaxi del css sigui molt mès clara
#### Per què Firebase?
Incorpora login amb xarxes socials, que facilitarà autenticar-se amb el correu de l’institut
#### Per que MySQL?
Es el que sabem utilitzar i perque necessitem una base de dades relacional

## Availability:
Roger - 9h  
Adrian - 9h  
Anna - 6.5h  
Sergio - 9h

I hores extres que poguèm fer a casa
