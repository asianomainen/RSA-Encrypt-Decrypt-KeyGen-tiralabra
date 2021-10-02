package rsatoolapp.domain;

import java.math.BigInteger;

/**
 * Class for creating a new RSA key.
 */

public class RSAKey {
    private final BigInteger modulus;
    private final BigInteger exponent;

    /**
     * Creates a new RSA key.
     * @param modulus the modulus used in the key
     * @param exponent the exponent used in the key
     */

    public RSAKey(BigInteger modulus, BigInteger exponent) {
        this.modulus = modulus;
        this.exponent = exponent;
    }

    /**
     * Returns the modulus of the key.
     * @return      the modulus
     */

    public BigInteger getModulus() {
        return this.modulus;
    }

    /**
     * Returns the exponent of the key.
     * @return      the exponent
     */

    public BigInteger getExponent() {
        return this.exponent;
    }
}