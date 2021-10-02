# Toteutusdokumentti
RSA-algoritmille on eri toteutustapoja ja tässä ohjelmassa niistä on toteutettu yksi. Tästä lisää alla.

## Aikavaativuudet ja käytetyt tietorakenteet
Tärkein tietorakenne tässä ohjelmassa RSA-salauksen kannalta on Javan BigInteger. 

RSA-avaimien luomisessa tarvitaan kaksi erittäin suurta alkulukua p ja q, niin että p ≠ q. BigInteger-luokalla on valmis väline tähän: 
[probablePrime](https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#probablePrime(int,%20java.util.Random)), 
jota ohjelmassa käytetään. ProbablePrime-metodi on käytännössä yhdistelmä sarjasta [Miller-Rabinin testejä](https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test), 
jonka aikavaativuus on O(k log(n)<sup>3</sup>), yhdistettynä [Lucasin ja Lehmerin alkulukutestiin](https://fi.wikipedia.org/wiki/Lucasin_ja_Lehmerin_alkulukutesti), 
jonka aikavaativuus puolestaan on O(log(n)<sup>3</sup>). Tämä toteutus on todennäköisyyksiin perustuva: tuloksena saatu luku **ei ole** alkuluku alle 2^(-100) todennäköisyydellä (1 suhde 1,27 kvintiljoonaan).
On myös tapa varmasti alkuluku käyttämällä [AKS-alkulukutestiä](https://en.wikipedia.org/wiki/AKS_primality_test), mutta sen aikavaativuus on Õ(log(n)<sup>6</sup>), eli <br> O(log(n log<sup>k</sup> n)<sup>6</sup>).
Ottaen huomioon AKS-alkulukutestin suuremman aikavaativuuden ja probablePrime-metodin todennäköisyyden, tässä ohjelmassa on päätetty käyttää probablePrime-metodia.

Yllä kuvatun probablePrime-metodin suorittamisen jälkeen RSA-avaimien luomiseen tarvitaan myös [laajennettua Eukleideen algoritmia](https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm),
jonka aikavaativuus on O(nm).

## Lähteet
[probablePrime-metodi](https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#probablePrime(int,%20java.util.Random))  
[Miller-Rabinin testi](https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test)  
[Lucasin ja Lehmerin alkulukutesti](https://fi.wikipedia.org/wiki/Lucasin_ja_Lehmerin_alkulukutesti)  
[AKS-alkulukutesti](https://en.wikipedia.org/wiki/AKS_primality_test)
