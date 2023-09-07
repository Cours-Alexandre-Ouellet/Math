package edu.cegepvicto.math

object MathUtil {

    /**
     * Calcule le plus petit commun multiple entre [a] et [b]
     */
    fun PPCM(a: Int, b: Int): Int {
        return Math.abs(a * b) / PGCD(a, b)
    }

    /**
     * Calcule le plus grand commun diviseur entre [a] et [b].
     */
    fun PGCD(a: Int, b: Int): Int {
        var x = a * if (a < 0) -1 else 1
        var y = b * if (b < 0) -1 else 1

        while (x != y) {
            if (x > y) {
                x -= y
            } else {
                y -= x
            }
        }

        return x
    }

}