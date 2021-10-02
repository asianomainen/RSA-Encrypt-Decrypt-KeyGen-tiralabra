### [Tuntikirjanpito](https://github.com/asianomainen/RSA-Encrypt-Decrypt-KeyGen-tiralabra/blob/main/dokumentaatio/tuntikirjanpito.md)

## Mitä olen tehnyt
Kolmas viikko kului viestien salaamisen ja salauksen purkamisen käyttöliittymän ja sovelluslogiikan luomiseen. Ohjelma on nyt valmis, mutta käyttää toistaiseksi valmiita kirjastoja sovelluslogiikassa. 

## Ohjelman edistyminen
Ohjelman päätoiminnallisuudet on nyt kaikki implementoitu.

## Mitä opin tällä viikolla
Opin implementoimaan viestien salaamisen ja purkamisen. Perehdyin lisäksi siihen, että mitä tietorakenteita minun tulee toteuttaa itse ja miten se tehdään.

## Mitä jäi epäselväksi tai on tuottanut vaikeuksia
Olen epävarma siitä, että onko toteutukseni RSA-avaimien luomiseen sallittu sellaisenaan kuin se nyt on tehty. Käytän siinä BigInteger-luokan valmiita probablePrime-, multiply-, substract-, gcd- ja modInverse-metodeja. Etenkin probablePrime-, gcd- ja modInverse-luokkien käyttäminen herättää kysymyksiä, koska ne ovat RSA-avaimien luomisessa tärkeimpiä toiminnallisuuksia ja nyt toteutan ne Javan valmiita työkaluja käyttämällä.

## Mitä teen seuraavaksi
Lisään ohjelmaan mahdollisuuden salata viestejä julkisen avaimen lisäksi myös yksityisellä avaimella ja vastaavasti purkaa julkisella avaimella yksityisen avaimen sijaan.
