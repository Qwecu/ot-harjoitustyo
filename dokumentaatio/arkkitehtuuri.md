

# Arkkitehtuurikuvaus

## Rakenne

Ohjelmassa on kolmitasoinen arkkitehtuuri, jonka rakenne on seuraava:

fluffypet.ui -> fluffypet.domain -> fluffypet.io

<img src="https://raw.githubusercontent.com/qwecu/ot-harjoitustyo/master/dokumentaatio/arkkitehtuuri.png" width="750">

Ui sisältää käyttöliittymän koodin, domain sovelluslogiikan ja io tietojen tallennuksen.

## Käyttöliittymä

Käyttöliittymä sisältää neljä näkymää
- aloitusikkuna
- pelinäkymä
- Peli päättyi, anna nimesi -näkymä
- high scores -lista

Näkymät on toteutettu erillisinä javafx.scene-olioina, ja yksi kerrallaan on näkyvissä.

## Sovelluslogiikka

Sovellus toimii niin, että käyttäjä painaa haluamansa hoito-ohjelman nappulaa. FluffyGame-olio ottaa tiedon vastaan ja välittää sen Pet-oliolle. Tämän jälkeen tiedot Pet-olion Stats-listan arvoista välitetään käyttöliittymään, ja uudet arvot lisätään käyttäjän näkyville graafiin.

## Tietojen tallennus tiedostoon

fluffypet.io huolehtii tietojen tallennuksesta. Tallennettavia tietoja ovat
-high scores

Tiedot tallennetaan .txt-tiedostoon.

### Tiedostot

Tiedot tallennetaan .txt-tiedostoon. Ohjelma luo hiScores.txt-nimisen tiedoston, jonne korkeimmat pisteet saavuttaneet tulokset tallennetaan muodossa

nimi;pisteet

, missä nimi on pelaajan nimi ja pisteet kokonaisluku.


#### Uusi peli

Pelaaja voi aloittaa uuden pelin.

#### Pelin kulku

Pelinäkymässä pelaaja voi valita erilaisista vaihtoehdoista, minkä hoito-ohjelman mukaan lemmikkiä hoidetaan.

#### High scores

Peli pitää kirjaa korkeimmista pistesaavutuksista.
