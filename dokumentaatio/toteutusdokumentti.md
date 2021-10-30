# Toteutusdokumentti
RSA-algoritmille on eri toteutustapoja ja tässä ohjelmassa niistä on toteutettu yksi. Tästä lisää alla.

## Ohjelman yleisrakenne
Ohjelma on toteutettu Java-kielellä olio-ohjelmointia käyttäen.  

Ohjelman RSAToolUi-luokka alustaa MainMenuUi-luokan käyttöliittymän, jonka kautta käyttäjä hallinnoi ohjelman toimintoja.

Ohjelman sovelluslogiikka koostuu kolmesta luokasta:
   1. KeyGenerator 
      - Luokka RSA-avainparin luomiseen
      - Metodit:
        - generateKeys
          - Luo uudet RSA-avaimet 
        - isPrime
          - Tarkistaa onko annettu luku alkuluku
        - millerRabin
          - suorittaa Miller-Rabinin testin
        - getPublicKey
          - palauttaa julkisen avaimen
        - getPrivateKey
          - palauttaa yksityisen avaimen 
   2. RSAKey
      - Luokka RSA-avaimen luomiseen
      - Konstruktori:
        - RSAKey, joka saa muuttujana avaimen modulon ja eksponentin
      - Metodit:
        - getModulus
          - palauttaa avaimen modulon, eli jakojäännöksen
        - getExponent
          - palauttaa avaimen eksponentin
   3. EncryptDecrypt
      - Luokka viestien salaamiseen ja salauksen purkamiseen
      - Metodit:
        - encrypt, joka saa muuttujana modulon, julkisen avaimen eksponentin ja salattavan viestin
          - salaa muuttujana annetun viestin
        - decrypt, joka saa muuttujana modulon, yksityinsen avaimen eksponentin ja salatun viestin
          - purkaa salatun viestin
        - getEncryptedMessage
          - palauttaa salatun viestin
        - getDecryptedMessage
          - palauttaa puretun viestin

## Aikavaativuudet ja käytetyt tietorakenteet
Tärkein tietorakenne tässä ohjelmassa RSA-salauksen kannalta on Javan BigInteger. 

RSA-avaimien luomisessa tarvitaan kaksi erittäin suurta alkulukua p ja q, niin että p ≠ q. Ohjelmassa on luotu nämä numerot generoimalla satunnaisia hyvin suuria BigInteger-tyyppisiä lukuja, joille sen jälkeen suoritetaan 40 [Miller-Rabinin testiä](https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test), 
jonka aikavaativuus on O(k log(n)<sup>3</sup>). Tämä toteutus on todennäköisyyksiin perustuva: tuloksena saatu luku **ei ole** alkuluku alle 1/4<sup>40</sup> todennäköisyydellä.
On myös tapa varmasti alkuluku käyttämällä [AKS-alkulukutestiä](https://en.wikipedia.org/wiki/AKS_primality_test), mutta sen aikavaativuus on Õ(log(n)<sup>6</sup>), eli <br> O(log(n log<sup>k</sup> n)<sup>6</sup>).
Ottaen huomioon AKS-alkulukutestin suuremman aikavaativuuden ja Miller-Rabinin testin todennäköisyyden, tässä ohjelmassa on päätetty käyttää Miller-Rabinin testiä.

Miller-Rabinin testin suorittamisen jälkeen RSA-avaimien luomiseen tarvitaan myös [laajennettua Eukleideen algoritmia](https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm), jonka aikavaativuus on O(nm).

## Tilavaativuudet
RSA-salauksessa käytetyt algoritmit tarvitsevat vain yksittäisiä muuttujia, joten kaikkien käytettyjen algoritmien tilavaativuus on O(1).

## Suorituskykyvertailu eri pituisilla avaimilla
Ohjelmassa on toteutettu RSA-avainpari **2048-bittisenä**, jonka luominen tällä hetkellä ohjelmassa käytössä olevalla tavalla kestää **3,79s** (keskiarvo kymmenen suorituskerran jälkeen). 2048-bitin pituus on [tällä hetkellä suositeltu vähimmäispituus](https://en.wikipedia.org/wiki/Key_size#Asymmetric_algorithm_key_lengths).

Vertailun vuoksi testataan ohjelmaa myös **4096-bittisillä avaimilla**, joka vastaa jo yli 128-bitin symmetristä salausta. Tällöin avaimien luominen kestää **38,56s** (keskiarvo kymmenen suorituskerran jälkeen).

## Ohjelman mahdolliset kehityskohteet
RSA-avaimien generoinnissa avaimet usein enkoodataan X509- (julkinen avain) tai PKCS8-muotoon (yksityinen avain), jotta niitä voi jakaa. Ohjelmassa enkoodausta ei ole suoritettu ja sen voisi toteuttaa.  

Ohjelmassa ei toistaiseksi pysty salata viestiä yksityisellä avaimella, jota voisi käyttää viestin lähettäjän tunnistamiseen. 

## Lähteet
[Miller-Rabinin testi](https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test)  
[AKS-alkulukutesti](https://en.wikipedia.org/wiki/AKS_primality_test)  
[RSA-avaimien pituus](https://en.wikipedia.org/wiki/Key_size#Asymmetric_algorithm_key_lengths)
