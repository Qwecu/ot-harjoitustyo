# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on peli, jossa käyttäjä voi hoitaa lemmikkiä. Lemmikille on valittavissa useita "hoito-ohjelmia", joiden vaikutus arvotaan pelin alussa, ja ideana on, että käyttäjä joutuu päättelemään, mikä ohjelma tekee mitäkin ja tavoitteena on tasapainolla eri ohjelmien välillä niin, että mikään lemmikin tarve ei tule yli- tai alitäytetyksi. Toiminnallisuus on vuoropohjainen.

## Käyttäjät

Pelissä ei ole varsinaisia käyttäjärooleja. Pelin jälkeen käyttäjä saa antaa nimensä high scores -listaan.

## Käyttöliittymäluonnos

Sovellus koostuu neljästä eri näkymästä

<img src="https://raw.githubusercontent.com/qwecu/ot-harjoitustyo/master/dokumentaatio/vaatimusmaarittely.png" width="750">

Sovellus aukeaa uusi peli -näkymään, josta siirrytään peliin painamalla "uusi peli". Pelissä on näkyvissä lemmikin senhetkiset statit, kuva lemmikistä sekä nappulat, joista voi valita eri hoito-ohjelmia. Pelin päätyttyä pelaajan nimeä kysytään ja nimen ilmoittamisen jälkeen peli näyttää high scores -listan. Tästä näkymästä peli sulkeutuu Exit-nappulasta.

### Pelin kulku

Pelin alussa kaikki statit ovat ihannetasolla. Pelaaminen koostuu eri hoito-ohjelmien valitsemisesta. Aina kun pelaaja valitsee ohjelman, peli etenee yhden päivän, statit pienenevät vakiomäärän ja lopuksi niihin lisätään hoito-ohjelman mukainen arvo. Tavoitteena on pitää kaikki arvot sallitun maksimin ja minimin välillä. Peli päättyy, kun joku maksimiarvoista ylittyy tai minimiarvoista alittuu kahtena peräkkäisenä päivänä.

## Jatkokehitysideoita

- pelin tallentaminen ja tallennetun pelin lataaminen
- erilaiset asetukset ja vaikeusasteet: eri määrä statteja, helpompi/vaikeampi kuolla
- tunnelmaelementit: lemmikille generoidaan nimi, ulkonäkö ja luonnehdinta, hoito-ohjelmille generoidaan nimet
- kauppa, josta voi ostaa esineitä, joilla korjataan yhtä stattia kerrallaan tai vaihdetaan hyödytön hoito-ohjelma toiseksi
- vaikeusasteen muuttuminen lemmikin ikääntymisen myötä
