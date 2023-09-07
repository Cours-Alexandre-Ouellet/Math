package edu.cegepvicto.math

/**
 * Représente une valeur entière
 */
class Entier(val valeur : Int) : Nombre() {

    override val typeNombre: TypeNombre
        get() = TypeNombre.ENTIER

    override fun getApproximation(): Double {
        return valeur.toDouble()
    }

    override fun additionner(nombre: Nombre): Nombre {
        return when(nombre.typeNombre) {
            TypeNombre.ENTIER -> Entier((nombre as Entier).valeur + valeur)
            TypeNombre.FRACTION -> (nombre as Fraction).additionner(nombre)
        }
    }

    override fun multiplier(nombre: Nombre): Nombre {
        return when(nombre.typeNombre) {
            TypeNombre.ENTIER -> Entier((nombre as Entier).valeur * valeur)
            TypeNombre.FRACTION -> Fraction(valeur, 1).multiplier(nombre as Fraction)
        }
    }

    override fun toString(): String {
        return valeur.toString()
    }

}