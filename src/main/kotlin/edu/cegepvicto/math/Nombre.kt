package edu.cegepvicto.math

/**
 * Abstraction représentant un type numérique dans la bibliothèque mathématique. Le nombre est immuable dans
 * l'exécution du système.
 */
abstract class Nombre {

    /**
     * Indique si le nombre est positif ou non
     */
    var estPositif : Boolean = true
        private set

    /**
     * Valeur du type de nombre
     */
    abstract val typeNombre : TypeNombre

    /**
     * Retourne une valeur approximée du nombre
     */
    abstract fun getApproximation() : Double

    /**
     * Additionne le [nombre] au nombre actuel et retourne le résultat. Le [nombre] est le membre de
     * droite de l'expression. L'addition doit être commutative.
     */
    abstract fun additionner(nombre : Nombre) : Nombre

    /**
     * Soustrait la valeur de [nombre] au nombre actuel et retourne le résutlat. Le [nombre] est le membre de
     * droite de l'expression. La soustraction doit être commutative.
     */
    fun soustraire(nombre : Nombre) : Nombre {
        return additionner(nombre.multiplier(Entier(-1)))
    }

    /**
     * Mutliplie le [nombre] au nombre actuel et retourne le résultat. Le [nombre] est le membre de droite du terme.
     */
    abstract fun multiplier(nombre : Nombre) : Nombre
}