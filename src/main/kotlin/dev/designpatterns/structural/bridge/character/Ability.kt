package dev.designpatterns.structural.bridge.character

interface Ability {
    fun use()
}

class SwordAttack : Ability {

    override fun use() = println("* Attacks fiercely with a Sword")
}

class AxeAttack : Ability {

    override fun use() = println("* Attacks brutally with an Axe")
}

class MagicSpell : Ability {

    override fun use() = println("* Casts a powerful Magic Spell")
}

class FireBallSpell : Ability {

    override fun use() = println("* Throws a large Fireball")
}
