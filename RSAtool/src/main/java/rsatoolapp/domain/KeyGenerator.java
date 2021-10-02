package rsatoolapp.domain;

import java.math.BigInteger;
import java.util.Random;

/**
 * Class for creating a new RSA key pair.
 */

public class KeyGenerator {
    RSAKey pubKey;
    RSAKey pvtKey;

    /**
     * Generates a new RSA key pair.
     */

    public void generateKeys() {
        Random rnd1 = new Random(System.currentTimeMillis());
        Random rnd2 = new Random(System.currentTimeMillis() * 10);

        // valitaan kaksi suurta alkulukua p ja q niin, että p ≠ q
        // probablePrime metodin tuottama luku ei ole alkuluku
        // alle 2^(-100) todennäköisyydellä, eli 1 / 1 267 650 600 228 229 401 496 703 205 376
        // (1 suhde 1,27 kvintiljoonaan)
        BigInteger p = BigInteger.probablePrime(2048, rnd1);
        BigInteger q = BigInteger.probablePrime(2048, rnd2);

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
     * @return the public key  as a RSAKey object
     */

    public RSAKey getPublicKey() {
        return pubKey;
    }

    /**
     * @return the private key  as a RSAKey object
     */

    public RSAKey getPrivateKey() {
        return pvtKey;
    }
}