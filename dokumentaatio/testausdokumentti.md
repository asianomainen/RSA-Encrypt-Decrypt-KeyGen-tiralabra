# Testausdokumentti

## Yksikkötestaus

### Sovelluslogiikka

Kaikki sovelluslogiikkaan liittyvän luokat testataan automaattisesti JUnit-testeillä.

### Testauskattavuus

Testeissä ei oteta huomioon käyttöliittymän rakentavaa ui-pakkausta.

#### Domain-pakkaus
![domain](https://user-images.githubusercontent.com/46067482/139542840-64bc7355-f60a-42b7-b83d-1093119ca83c.png)

#### KeyGenerator-luokka
[Suoritetut testit](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/RSAtool/src/tests/java/rsatoolapp/KeyGeneratorTest.java)  
KeyGenerator-luokan kuvassa näkyvä rivikattavuuden puutos on ääritapaus, johon päädytään ohjelmassa hyvin harvoin ja tästä syystä sitä ei usein käydä läpi.  
![KeyGenerator](https://user-images.githubusercontent.com/46067482/139542816-18b312b3-1ccd-46a5-9b50-11971c3939ad.png)

#### EncryptDecrypt-luokka
[Suoritetut testit](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/RSAtool/src/tests/java/rsatoolapp/EncryptDecryptTest.java)  
![EncryptDecrypt](https://user-images.githubusercontent.com/46067482/139542820-2a885acb-b79a-4a4a-a131-a555ddc06190.png)

#### RSAKey-luokka
[Suoritetut testit](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/RSAtool/src/tests/java/rsatoolapp/RSAKeyTest.java)  
![RSAKey](https://user-images.githubusercontent.com/46067482/139542822-adfa65e4-065e-4e7e-9b4e-cb8f07ac31a4.png)

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti ja kaikki toiminnot on todeuttu toimivaksi. Huomioitavaa kuitenkin on, että ohjelma heittää virheitä mikäli
  - tekstiä yritetään salata/purkaa ilman avaimia
  - tesktiä ei syötetä ja se yritetään salata/purkaa

![Program](https://user-images.githubusercontent.com/46067482/139543140-5d78b747-aa21-49b3-bd1b-22e3c013c997.png)

## Suorituskykytestaus
Suorituskykytestaus on suoritettu erillisellä ohjelmalla, joka suorittaa vain avaimien luonnin ja mittaa siinä käytetyn ajan.

Ohjelmassa on toteutettu RSA-avainpari **2048-bittisenä**, jonka luominen tällä hetkellä ohjelmassa käytössä olevalla tavalla kestää **3,93s** (keskiarvo kymmenen suorituskerran jälkeen). 2048-bitin pituus on [tällä hetkellä suositeltu vähimmäispituus](https://en.wikipedia.org/wiki/Key_size#Asymmetric_algorithm_key_lengths).

Vertailun vuoksi testataan ohjelmaa neljällä eri pituisella avaimella:

Avaimen pituus bitteinä | Salauksen vahvuus | Keskiarvo (10 suorituskertaa)|
-----|----------|-------------|
512 | Heikko | 0,05s |
1024 | Kohtalainen | 0,43s |
2048 | Vahva | 3,93s |
4096 | Todella vahva | 40,11s |

## Testisyötteet

Testeissä käytetyt syötteet on kuvattu EncryptDecryptTest-luokassa. Syöte on aina salattava viesti.
