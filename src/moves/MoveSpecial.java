package src.moves;

import src.helper.Tag;
import src.pokemon.enums.Stat;
import src.types.Type;

public abstract class MoveSpecial extends MoveDamaging {

    MoveSpecial(Type[] types, int ppMax, int power) {
        super(types, ppMax, power, Stat.SP_ATK, Stat.SP_DEF);
        addTag(Tag.SPECIAL);
    }
}
