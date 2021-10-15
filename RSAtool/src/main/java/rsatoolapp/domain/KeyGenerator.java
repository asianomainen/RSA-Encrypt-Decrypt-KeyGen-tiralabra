package rsatoolapp.domain;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Luokka RSA-avainparin luomiseen.
 */

public class KeyGenerator {
    RSAKey pubKey;
    RSAKey pvtKey;

    /**
     * Luo uuden RSA-avainparin.
     */

    public void generateKeys() {
        // valitaan kaksi suurta alkulukua p ja q niin, että p ≠ q
        // isPrime metodin tuottama luku ei ole alkuluku
        // 1/4^40 todennäköisyydellä, eli 1 / 1 208 925 819 614 629 174 706 176

        BigInteger p;
        do {
            p = new BigInteger(2048, new SecureRandom());
        } while (!isPrime(p));

        BigInteger q;
        do {
            q = new BigInteger(2048, new SecureRandom());
        } while (!isPrime(q));

        // lasketaan modulus eli n = p * q
        BigInteger n = p.multiply(q);

        // määritellään ϕ(n)
        BigInteger pMinus1 = p.subtract(new BigInteger("1"));
        BigInteger qMinus1 = q.subtract(new BigInteger("1"));
        BigInteger phiN = pMinus1.multiply(qMinus1);

        // määritellään julkisen avaimen eksponentiksi e
        BigInteger e = new BigInteger("65537");

        // kasvatetaan e:n arvoa niin pitkään, että gcd(e, ϕ(n)) = 1
        // gcd = greatest common divisor = suurin yhteinen tekijä
        while (!phiN.gcd(e).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.ONE);
        }

        // määritellään yksityisen avaimen eksponentiksi d
        BigInteger d = e.modInverse(phiN);

        pubKey = new RSAKey(n, e);
        pvtKey = new RSAKey(n, d);
    }

    /**
     * Tarkistaa onko annettu BigInteger alkuluku
     * 1/4^40 todennäköisyydellä.
     *
     * @param n tarkistettava BigInteger
     * @return true jos luku on alkuluku, false jos ei ole
     */

    public boolean isPrime(BigInteger n) {
        SecureRandom random = new SecureRandom();

        // Suoritetaan Miller-Rabinin testi 40 kertaa
        for (int i = 0; i < 40; i++) {
            if (!millerRabin(n, random)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Suorittaa Miller-Rabinin alkulukutestin.
     *
     * @param n      testattava BiInteger
     * @param random SecureRandom satunnaisen luvun luomiseen
     * @return true jos luku on alkuluku, false jos ei ole
     */

    public boolean millerRabin(BigInteger n, SecureRandom random) {
        // Varmistaa, että 1 < temp < n
        BigInteger temp;
        do {
            temp = new BigInteger(n.bitLength() - 1, random);
        } while (temp.compareTo(BigInteger.ONE) <= 0);

        // n ei ole alkuluku mikäli sillä on yhteinen tekijä temp-luvun kanssa
        if (!n.gcd(temp).equals(BigInteger.ONE)) {
            return false;
        }

        BigInteger a = n.subtract(BigInteger.ONE);

        // Selvittää suurimman kahden potenssin k, joka jakautuu tasaisesti n-1:een
        int k = 0;
        while ((a.mod(BigInteger.TWO)).equals(BigInteger.ZERO)) {
            a = a.divide(BigInteger.TWO);
            k++;
        }

        BigInteger r = temp.modPow(a, n);

        // Mikäli r = 1, niin n on todennäköisesti alkuluku
        if (r.equals(BigInteger.ONE)) {
            return true;
        }

        // Muuten katsotaan tuleeko luvusta koskaan -1, kun sitä
        // korotetaan toistuvasti toiseen potenssiin
        for (int i = 0; i < k; i++) {
            if (r.equals(n.subtract(BigInteger.ONE))) {
                return true;
            } else {
                r = r.modPow(BigInteger.TWO, n);
            }
        }

        return false;
    }

    /**
     * Palauttaa julkisen avaimen.
     *
     * @return julkinen avain RSAKey-oliona
     */

    public RSAKey getPublicKey() {
        return pubKey;
    }

    /**
     * Palauttaa yksityisen avaimen.
     *
     * @return yksityinen avain RSAKey-oliona
     */

    public RSAKey getPrivateKey() {
        return pvtKey;
    }
}