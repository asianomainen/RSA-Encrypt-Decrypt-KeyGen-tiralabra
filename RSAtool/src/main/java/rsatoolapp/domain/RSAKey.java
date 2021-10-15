package rsatoolapp.domain;

import java.math.BigInteger;

/**
 * Luokka uuden RSA-avaimen luomiseen.
 */

public class RSAKey {
    private final BigInteger modulus;
    private final BigInteger exponent;

    /**
     * Luo uuden RSA-avaimen,
     *
     * @param modulus  avaimessa käytetty modulo
     * @param exponent avaimessa käytetty eksponentti
     */

    public RSAKey(BigInteger modulus, BigInteger exponent) {
        this.modulus = modulus;
        this.exponent = exponent;
    }

    /**
     * Palauttaa avaimen modulon.
     *
     * @return avaimen modulo
     */

    public BigInteger getModulus() {
        return this.modulus;
    }

    /**
     * Palauttaa avaimen eksponentin.
     *
     * @return avaimen eksponentti
     */

    public BigInteger getExponent() {
        return this.exponent;
    }
}