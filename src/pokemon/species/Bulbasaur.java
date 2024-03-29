package src.pokemon.species;

import src.ability.Ability;
import src.moves.Move;
import src.pokemon.enums.EggGroup;
import src.pokemon.growthrate.GrowthRateMedium;
import src.pokemon.statlist.StatListBase;
import src.types.TypeGrass;
import src.types.TypePoison;
import src.types.Type;

import java.util.HashMap;

public class Bulbasaur extends Species {

    Bulbasaur() {
        name="Bulbasaur";
        types = new Type[]{TypeGrass.getInstance(), TypePoison.getInstance()};
        abilities = new Ability[0];
        height = 0.7f;
        weight = 6.9f;
        catchRate = 45;
        baseExp = 64;
        growthRate = GrowthRateMedium.getInstance();
        eggGroups = new EggGroup[]{EggGroup.GRASS, EggGroup.MONSTER};
        genderOdds = 1/8f;
        baseStats = new StatListBase(45, 49, 49, 65, 65, 45);
        movesLevelUp = new HashMap<>();
        movesOther = new Move[0];
    }

    static final private Bulbasaur instance = new Bulbasaur();
    public static Bulbasaur getInstance()
    {
        return instance;
    }
}
