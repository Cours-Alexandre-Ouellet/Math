package edu.cegepvicto.math

/**
 * Représente une fraction composée de deux entiers, l'un au numerateur et l'un au denominateur. Par défaut la fraction
 * vaut 1.
 */
class Fraction() : Nombre() {

    /**
     * Le numérateur de la fraction
     */
    var numerateur : Int = 0
        private set

    /**
     * Le dénominateur de la fraction
     */
    var denominateur : Int = 1
        private set

    /**
     * Initialiser une fraction en indiquant son [numerateur] et son [denominateur]
     */
    constructor(numerateur : Int , denominateur : Int ) : this(){
        this.numerateur = numerateur
        this.denominateur = denominateur

        simplifier()
    }

    override val typeNombre: TypeNombre
        get() = TypeNombre.FRACTION

    override fun getApproximation(): Double {
        return numerateur.toDouble() / denominateur.toDouble()
    }

    override fun additionner(nombre: Nombre): Nombre {
        val nombreAdditionne = convertirFraction(nombre)
        val ppcm = MathUtil.PPCM(numerateur, nombreAdditionne.numerateur)

        val facteurA = ppcm / denominateur
        val facteurB = ppcm / nombreAdditionne.denominateur

        val resultat = Fraction(numerateur * facteurB + nombreAdditionne.numerateur * facteurA, ppcm)
        resultat.simplifier()

        return resultat
    }

    override fun multiplier(nombre: Nombre): Nombre {
        val nombreMultiplie = convertirFraction(nombre)

        val resultat = Fraction(numerateur * nombreMultiplie.numerateur,
            denominateur * nombreMultiplie.denominateur)
        resultat.simplifier()

        return resultat
    }

    /**
     * Converti un [nombre] quelconque en fraction
     */
    private fun convertirFraction(nombre : Nombre) : Fraction {
        return when(nombre.typeNombre) {
            TypeNombre.ENTIER -> Fraction((nombre as Entier).valeur, 1)
            TypeNombre.FRACTION -> nombre as Fraction
        }
    }

    /**
     * Simplifie la fraction en retirant les facteurs communs du numérateur et du dénoninateur
     */
    private fun simplifier(){
        val pgcd = MathUtil.PGCD(numerateur, denominateur)

        if(pgcd != 1) {
            numerateur /= pgcd
            denominateur /= pgcd
        }

        // On replace le signe négatif au numérateur
        if(denominateur < 0) {
            numerateur *= -1
            denominateur *= -1
        }
    }

    override fun toString(): String {
        return if(denominateur == 1) {
            numerateur.toString()
        } else {
            "$numerateur / $denominateur"
        }
    }
}