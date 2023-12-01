package chapter12Class

class Weapon(val name: String)
class Player1 {
    var weapon: Weapon? = Weapon("Ebony Kris")

    fun printWeaponName() {
        weapon?.also {
            println(it.name)
        }
    }
}

