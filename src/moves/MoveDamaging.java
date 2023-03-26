package src.moves;

import src.pokemon.enums.Stat;

public class MoveDamaging extends Move{
    protected int power;
    protected Stat attack;
    protected Stat defense;

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
