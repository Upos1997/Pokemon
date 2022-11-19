package pokemon;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.List;
import java.util.function.Function;

import ability.Ability;
import moves.Move;
import enums.EggGroup;

public enum Species {
    Bulbasaur("Bulbasaur", List.of(Type.GRASS, Type.POISON), List.of(Ability.OVERGROW, Ability.CHLOROPHYLL), 0.7, 6.9,
            45, 50, 64, GrowthRate.MEDIUM_SLOW,
            List.of(EggGroup.Grass, EggGroup.Monster), 0.875, 20,
            45, 49, 49, 65, 65, 45,
            List.of(move_entry(1, Move.GROWL), move_entry(1, Move.TACKLE), move_entry(3, Move.VINE_WHIP),
                    move_entry(6, Move.GROWTH)),
            List.of());

    public String name;
    public List<Type> type;
    public List<Ability> abilities;
    public double height;
    public double weight;

    public int catchRate;
    public int friendship;
    public int baseExp;
    public GrowthRate growthRate;

    public List<EggGroup> eggGroups;
    public double gender;
    public int eggCycles;

    public int hp;
    public int attack;
    public int defense;
    public int specialAttack;
    public int specialDefense;
    public int speed;

    public List<AbstractMap.SimpleImmutableEntry<Species, Function<Pokemon, Boolean>>> evolution;
    public List<AbstractMap.SimpleImmutableEntry<Integer, Move>> movesLevelUp;
    public List<Move> movesOther;

    static SimpleImmutableEntry<Integer, Move> move_entry(int level, Move move) {
        return new SimpleImmutableEntry<Integer, Move>(level, move);
    }

    Species(String name, List<Type> type, List<Ability> abilities, double height, double weight, int catchRate,
            int friendship, int baseExp, GrowthRate growthRate, List<EggGroup> eggGroups, double gender,
            int eggCycles, int hp, int attack, int defense, int specialAttack, int specialDefense, int speed,
            List<AbstractMap.SimpleImmutableEntry<Integer, Move>> movesLevelUp, List<Move> movesOther) {
        this.name = name;
        this.type = type;
        this.abilities = abilities;
        this.height = height;
        this.weight = weight;
        this.catchRate = catchRate;
        this.friendship = friendship;
        this.baseExp = baseExp;
        this.growthRate = growthRate;
        this.eggGroups = eggGroups;
        this.gender = gender;
        this.eggCycles = eggCycles;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.movesLevelUp = movesLevelUp;
        this.movesOther = movesOther;
    }
}