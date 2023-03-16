package src.pokemon.species;

import src.pokemon.enums.EggGroup;
import src.pokemon.enums.GrowthRate;
import src.pokemon.enums.StatList;
import src.types.Grass;
import src.types.Poison;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Bulbasaur extends Species {

    Bulbasaur() {
        name="Bulbasaur";
        types = List.of(Grass.getInstance(), Poison.getInstance());
        abilities = Collections.emptyList();
        height = 0.7;
        weight = 6.9;
        catchRate = 45;
        baseExp = 64;
        growthRate = GrowthRate.MEDIUM;
        eggGroups = List.of(EggGroup.GRASS, EggGroup.MONSTER);
        genderOdds = 1/8f;
        baseStats = new StatList(45, 49, 49, 65, 65, 45);
        movesLevelUp = new HashMap<>();
        movesOther = Collections.emptyList();
    }

    static final private Bulbasaur instance = new Bulbasaur();
    public static Bulbasaur getInstance() {
        return instance;
    }
}
