# Testausdokumentti

## Yksikkötestaus

### Sovelluslogiikka

Kaikki sovelluslogiikkaan liittyvän luokat testataan automaattisesti JUnit-testeillä.

### Testauskattavuus

Testeissä ei oteta huomioon käyttöliittymän rakentavaa ui-pakkausta.

#### Domain-pakkaus
![domain](https://user-images.githubusercontent.com/46067482/139542840-64bc7355-f60a-42b7-b83d-1093119ca83c.png)

#### KeyGenerator-luokka
KeyGenerator-luokan kuvassa näkyvä rivikattavuuden puutos on ääritapaus, johon päädytään ohjelmassa hyvin harvoin ja tästä syystä sitä ei usein käydä läpi.  
![KeyGenerator](https://user-images.githubusercontent.com/46067482/139542816-18b312b3-1ccd-46a5-9b50-11971c3939ad.png)

#### EncryptDecrypt-luokka
![EncryptDecrypt](https://user-images.githubusercontent.com/46067482/139542820-2a885acb-b79a-4a4a-a131-a555ddc06190.png)

#### RSAKey-luokka
![RSAKey](https://user-images.githubusercontent.com/46067482/139542822-adfa65e4-065e-4e7e-9b4e-cb8f07ac31a4.png)

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.  
![Program](https://user-images.githubusercontent.com/46067482/139543140-5d78b747-aa21-49b3-bd1b-22e3c013c997.png)


## Testisyötteet

Testeissä käytetyt syötteet on kuvattu EncryptDecryptTest-luokassa. Syöte on aina salattava viesti.
