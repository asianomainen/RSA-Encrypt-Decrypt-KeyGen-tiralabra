# RSA-Encrypt-Decrypt-KeyGen-tiralabra

RSA-avainparien luomiseen, viestin salaamiseen ja salauksen purkamiseen käytettävä Java-ohjelma.

## Dokumentaatio
[Määrittelydokumentti](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/maarittelydokumentti.md)  
[Toteutusdokumentti](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/toteutusdokumentti.md)  
[Testausdokumentti](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/testausdokumentti.md)  
[Käyttöohje](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/kayttohje.md)

### Viikkoraportit
[Viikko 1](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/viikkoraportti_vk1.md)  
[Viikko 2](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/viikkoraportti_vk2.md)  
[Viikko 3](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/viikkoraportti_vk3.md)  
[Viikko 4](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/viikkoraportti_vk4.md)  
[Viikko 5](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/viikkoraportti_vk5.md)  
[Viikko 6](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/viikkoraportti_vk6.md)  

## Release

[Loppupalautus](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/releases/tag/v1.1) (katso ohjeet ohjelman käynnistämiseen [käyttöohjeista](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/kayttohje.md)).

## Javan versio

Sovellus on toteutettu ja testattu Javan versiolla 11.

## Komentorivitoiminnot

Komentorivitoimintojen käyttäminen edellyttää niiden suorittamista **projektihakemistossa**.

### Sovelluksen käynnistäminen

Sovelluksen voi käynnistää komennolla

```
mvn compile exec:java -Dexec.mainClass=rsatoolapp.Main
```

### Suoritettavan jar-tiedoston luominen

jar-tiedosto luodaan komennolla

```
mvn package
```

Luotu tiedosto löytyy target-hakemistosta. jar-tiedoston pystyy käynnistämään komennolla

```
java -jar target/RSAtoolApplication-1.0-SNAPSHOT.jar
```

### Testaus

Sovelluksen testit voi ajaa komennolla

```
mvn test
```

Testikattavuusraportin voi luoda komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella projektin juuresta löytyvästä tiedostosta **target/site/jacoco/index.html** tai esimerkiksi Chromium-selaimessa komennolla (edellyttää Chromium-selaimen asennuksen)

```
chromium-browser target/site/jacoco/index.html
```

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/RSAtool/checkstyle.xml) määritellyt, koodin luettavuuteen liittyvät, tarkistukset voi tehdä komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset voi tarkistaa avaamalla selaimella tiedoston _target/site/checkstyle.html_


### JavaDoc

Sovelluksen JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDociin voi perehtyä avaamalla selaimella tiedoston _target/site/apidocs/index.html_
