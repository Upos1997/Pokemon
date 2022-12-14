package src.pokemon.species;

import src.ability.Overgrow;
import src.moves.Growl;
import src.moves.Tackle;
import src.moves.VineWhip;
import src.pokemon.enums.EggGroup;
import src.pokemon.enums.GrowthRate;
import src.pokemon.enums.Type;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Bulbasaur extends Species {

    Bulbasaur() {
        name="Bulbasaur";
        types = List.of(Type.GRASS, Type.POISON);
        abilities = List.of(Overgrow.getInstance());
        height = 0.7;
        weight = 6.9;
        catchRate = 45;
        baseExp = 64;
        growthRate = GrowthRate.MEDIUM;
        eggGroups = List.of(EggGroup.GRASS, EggGroup.MONSTER);
        genderOdds = 1/8f;
        hp = 45;
        attack = 49;
        defense = 49;
        specialAttack = 65;
        specialDefense = 65;
        speed = 45;
        movesLevelUp = new HashMap<>();
        movesLevelUp.put(1, List.of(Growl.getInstance(), Tackle.getInstance(), VineWhip.getInstance()));
        movesOther = Collections.emptyList();
    }
}
