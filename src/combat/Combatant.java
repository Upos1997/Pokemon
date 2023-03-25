package src.combat;

import src.ability.Ability;
import src.pokemon.Pokemon;
import src.pokemon.enums.Stat;
import src.pokemon.statlist.StatList;
import src.pokemon.statlist.StatListStages;
import src.types.Type;

public class Combatant {
    private final Pokemon pokemon;
    private Ability ability;
    private Type[] types;
    private final StatList stages = new StatListStages();


    Combatant(Pokemon pokemon)
    {
        this.pokemon = pokemon;
        this.ability = pokemon.getAbility();
        this.types = pokemon.getTypes();
    }

    public int getStage(Stat stat)
    {
        return stages.getStat(stat);
    }
    public int getStat(Stat stat)
    {
        return Math.round(pokemon.getStat(stat) * Stat.getMod(getStage(stat)));
    }
    public int getBaseStat(Stat stat)
    {
        return pokemon.getStat(stat);
    }
    public Type[] getTypes()
    {
        return pokemon.getTypes();
    }
    public int getLevel() {
        return pokemon.getLevel();
    }
    public void damage(int amount)
    {
        pokemon.changeHp(amount * -1);
    }
    public void heal(int amount)
    {
        pokemon.changeHp(amount);
    }
}
