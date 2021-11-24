# Web per fitxar pels profes:
## Proposta:
Pàgina web que permetrà als professors autenticar-se amb el correu de l’institut per fitxar quan entren a treballar.

## Idea general del funcionament de la web:
La pàgina es servirà de manera local a la xarxa de l’institut, d’aquesta forma un professor que no estigui al centre no podrà accedir a la web per fitxar.  

## Funcionalitats:
* Autenticació mitjançant gmail per utilitzar el correu de l'institut.
* Horari dinàmic segons l'usuari (profe) loginejat.  
* Fitxar i desfitxar (per defecte si no desfitxes a última hora es farà sol,pero la possibilitat de fer-ho manualment permetrà que si un professor marxa a meitat del dia, es pugui registrar).
* Recompte d'hores setmanals de classe i comparaciò amb les hores fitxades.

## Tecnologies:
#### Frontend:
* HTML
* Javascript
* Sass
* Svelte o Vue - (opcional)
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
