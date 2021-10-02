package rsatoolapp.domain;

import java.math.BigInteger;

public class RSAKey {
    private final BigInteger modulus;
    private final BigInteger exponent;

    public RSAKey(BigInteger modulus, BigInteger exponent) {
        this.modulus = modulus;
        this.exponent = exponent;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getExponent() {
        return this.exponent;
    }
}