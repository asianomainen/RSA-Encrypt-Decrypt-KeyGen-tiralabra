# Määrittelydokumentti

Tätä ohjelma toteutetaan Java-kielellä ja sitä käytetään RSA-avainparien luomiseen, viestien salaamiseen ja salauksen purkamiseen. Javan lisäksi hallitsen Pythonin ja pystyn tekemään vertaisarviointeja Python-projekteista. Projektin dokumentaatio tullaan tekemään suomenkielellä. Olen tietojenkäsittelytieteen kandiohjelmassa.

## Projektissa käytettävät algoritmit ja tietorakenteet

### Tietorakenteet
- RSA-avaimet perustuvat pohjimmiltaan erittäin suurien positiivisten alkulukujen löytämiseen. Nämä alkuluvut tullaan tallentamaan BigInteger-tyyppisinä.

### Algoritmit
- [Laajennettu Eukleideen algoritmi](https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm) salaisen RSA-avaimen luomiseen.
- Esitestaus alkuluvun oikeellisuuden varmistamiseen.
  - Tämä on nopeahko, todennäköisyyksiin perustuva, tapa tarkistaa mikäli luku on mahdollisesti alkuluku.
  - Testin suorituskertojen määrä riippuu luotavan avaimen vahvuudesta (1024-bittinen: n. 90 kertaa, 2048-bittinen: n. 180 kertaa)
  - Mikäli tämä testi läpäistään, niin siirrytään seuraavaan Miller-Rabinin algoritmiin.
- [Miller-Rabinin algoritmi](https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test)
  - Tarkempi, mutta enemmän aikaa vievä, tapa tarkistaa onko luku alkuluku vai ei.
  - Testin suorituskertojen määrä riippuu luotavan avaimen vahvuudesta (1024-bittinen: 3 kertaa, 2048-bittinen: 2 kertaa)

## Mitä ongelmaa ratkaisen ja miksi valitsin kyseiset algoritmit
Jokaista yllä mainittua algoritmia on ehdottomasti käytettävä varmistaakseen, että RSA-salaus toimii oikein. Koko RSA-salaus perustuu tietoturvaan ja mikäli algoritmeja ei toteuteta oikein, niin salaus ei myöskään toimi, joten se ei ole turvallinen.

RSA-salaus on loistava tapa esimerkiksi lähettää arkaluontoista tekstipohjaista tietoa ja varmistaa, että vain vastaanottaja pystyy lukemaan viestin sisällön. RSA-salauksella ja salauksella ylipäätään on lukuisia käyttötarkoituksia tiedon lähettämisessä ja tämä ohjelma on sen puolesta hyvin monikäyttöinen.

## Syötteet ja niiden käsittely
RSA-avaimien luonnissa ohjelma ei tarvitse käyttäjältä syötettä.

Käyttäjä kirjoittaa käyttöliittymään (tekstipohjaisen, salaamattoman) viestinsä ja ohjelma salaa sen.

Ohjelma salaa viestin ja tulostaa sen käyttäjälle kopioitavaksi ja vastaanottajalle lähetettäväksi.

Käyttäjä voi lähettää tämän salatun viestin vastaanottajalle, joka puolestaan voi syöttää sen ohjelmaan ja purkaa salauksen.

## Tavoitteena olevat aika- ja tilavaativuudet

- Laajennetun Eukleideen algoritmi: 
  - Aikavaativuus: O(n⋅m)
  - Tilavaativuus: O(1)

- RSA-avaimien luominen: 
  - Aikavaativuus: O(n<sup>2</sup>)
  - Tilavaativuus: O(1)

- Alkulukujen laskiminen:
  - Aikavaativuus: O(n)
  - Tilavaativuus: O(1)

- Miller-Rabinin algoritmi: 
  - Aikavaativuus: O(n<sup>2</sup>)
  - Tilavaativuus: O(1)

## Lähteet
https://en.wikipedia.org/wiki/RSA_(cryptosystem)  
https://fi.wikipedia.org/wiki/RSA  
https://crypto.stackexchange.com/questions/6164/how-do-i-derive-the-time-complexity-of-encryption-and-decryption-based-on-modula#6194  
https://ieeexplore.ieee.org/document/6300576  
https://thesai.org/Downloads/Volume12No7/Paper_16-A_Note_on_Time_and_Space_Complexity.pdf
