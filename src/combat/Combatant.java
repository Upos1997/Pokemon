package src.combat;

import src.ability.Ability;
import src.pokemon.Pokemon;
import src.pokemon.enums.Stat;
import src.pokemon.statlist.StatList;
import src.pokemon.statlist.StatListStages;

public class Combatant {
    private Pokemon pokemon;
    private Ability ability;
    private final StatList stages = new StatListStages();


    Combatant(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    public int getStage(Stat stat)
    {
        return stages.getStat(stat);
    }
    public int getStat(Stat stat) {
        return Math.round(pokemon.getStat(stat) * Stat.getMod(getStage(stat)));
    }
}
