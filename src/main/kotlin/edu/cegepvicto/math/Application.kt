package edu.cegepvicto.math

/**
 * Point d'entrée du programme
 */
fun main() {
    val a = Entier(5)
    val b = Entier(-2)
    val c = Fraction(1, 2)
    val d = Fraction(-5, 4)
    val e = Fraction(16, -32)

    println("$a + $b  = ${a.additionner(b)}")
    println("$a - $b  = ${a.soustraire(b)}")
    println("$a * $c  = ${a.multiplier(c)}")
    println("$d * $c  = ${d.multiplier(c)}")
    println("$e")
}