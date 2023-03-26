package src.moves;

import src.pokemon.enums.Stat;
import src.types.Type;

public abstract class MoveDamaging extends Move{
    protected int power;
    protected Stat attack;
    protected Stat defense;

    MoveDamaging(Type[] types, int ppMax, int power, Stat attack, Stat defense) {
        super(types, ppMax);
        this.power = power;
        this.attack = attack;
        this.defense = defense;
    }

    public int getPower()
    {
        return  power;
    }
    public Stat getAttack()
    {
        return attack;
    }
    public Stat getDefense()
    {
        return defense;
    }
}
