package src.moves;

import src.helper.Tag;
import src.pokemon.enums.Stat;
import src.types.Type;

public abstract class MovePhysical extends  MoveDamaging {

    MovePhysical(Type[] types, int ppMax, int power) {
        super(types, ppMax, power, Stat.ATK, Stat.DEF);
        addTag(Tag.PHYSICAL);
    }
}
