# FluffyPet

Sovelluksen idea on kasvattaa lemmikki mahdollisimman korkeaan ikään.

## Dokumentaatio


[komentorivi.txt](https://github.com/Qwecu/ot-harjoitustyo/blob/master/laskarit/viikko1/komentorivi.txt)

[tyoaikakirjanpito.txt](https://github.com/Qwecu/ot-harjoitustyo/blob/master/tyoaikakirjanpito.txt)

[vaatimusmaarittely.md](https://github.com/Qwecu/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

## Releaset

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _OtmTodoApp-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_


