# Käyttöohje

Ohjelma on toteutettu ja testattu Javan versiolla 11 Linux käyttöjärjestelmää käyttämällä.

## Ohjelman käynnistäminen

Ohjelma käynnistetään lataamalla viimeisimmän [releasen](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/releases/tag/v.1.0) jar-tiedosto, siirtymällä sen jälkeen ladatun tiedoston sisältävään hakemistoon (esim. Downloads) ja suorittamalla komennon 
```
java -jar RSATool.jar
```
Vaihtoehtoisesti voit myös ladata projektin [zip-tiedoston](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/archive/refs/heads/main.zip) ja käyttää [README-tiedostossa](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/README.md) listattuja komentorivitoimintoja.

## Käyttöliittymä
![koedit](https://user-images.githubusercontent.com/46067482/139589080-d7db9a78-9589-4639-a014-e94ef9e2fa54.png)

1. Generate-nappi
   - Generoi uuden RSA-avainparin
1. RSA-avainparin tiedot
   1. Common modulus
      - avainparin luomisessa käytetty modulo
   2. Public key exponent
      - julkisen avaimen exponentti
   3. Private key exponent
      - yksityisen avaimen eksponentti (pidetään salassa)
1. Salattava teksti
   - Syötä tähän salattava teksti
1. Encrypt-napp
   - Salaa tekstin ja näyttää sen salatun muodon kohdassa 5
1. Salattu teksti
1. Salatun tekstin kopiointinappi
   - Kopioi automaattisesti salatun tekstin kohtaan 7, jotta se voidaan purkaa
1. Purettava teksti
1. Decrypt-nappi
   - Purkaa tekstin ja näyttää sen puretun muodon kohdassa 9
1. Purettu teksti
1. Quit-nappi
   - Sulkee ohjelman

## Tekstin salaaminen ja purkaminen
Tekstissä suluissa olevat numerot viittaavat yllä olevan kuvan numeroihin
1. Paina Generate-nappia (1)
2. Syötä salattava teksti (3)
   - Salattava teksti ei voi olla tyhjä
   - Salaus on tässä ohjelmassa toteutettu 2048-bittisenä. Tämä tarkoittaa sitä, että tällä ohjelmalla voi turvallisesti salata korkeintaan 256 tavun (byte) pituisia merkkijonoja, eli käytännössä 256-merkkisiä viestejä.
4. Paina Decrypt-nappia (4)
5. Kopioi salattu teksti (5) ja liitä se purettavaksi (7) *tai* paina kopiointinappia (6) kopioidaksesi tekstin automaattisesti
   - Purettava teksti ei voi olla tyhjä
7. Paina Decrypt-nappia (8)
8. Teksti näkyy purettuna (9)

Poistu ohjelmasta painamalla Quit-nappia (10)

Voi halutessasi toistaa vaiheet 2-5 mikäli haluat salata/purkaa tekstiä samoilla avaimilla. Vaihtoehtoisesti voit myös luoda uudet avaimet ja salata/purkaa tekstiä niillä toistamalla vaiheet 1-5.
