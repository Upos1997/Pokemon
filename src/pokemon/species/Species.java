package src.pokemon.species;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import src.ability.abilityLogic.Ability;
import src.moves.moveLogic.Move;
import src.pokemon.Pokemon;
import src.pokemon.enums.EggGroup;
import src.pokemon.enums.GrowthRate;
import src.pokemon.enums.Stat;
import src.pokemon.enums.Type;

public class Species {
    //////////////
    //variables and getters
    //////////////
    protected String name;
    protected List<Type> types;
    protected List<Ability> abilities;
    protected double height;
    protected double weight;
    protected int catchRate;
    protected int friendship = 50;
    protected int baseExp;
    protected GrowthRate growthRate;
    protected List<EggGroup> eggGroups;
    protected float genderOdds = 0.5f;
    protected int eggCycles = 20;
    protected int hp;
    protected int attack;
    protected int defense;
    protected int specialAttack;
    protected int specialDefense;
    protected int speed;
    protected List<Function<Pokemon, Species>> evolution;
    protected Map<Integer, List<Move>> movesLevelUp;
    protected List<Move> movesOther;

    public String getName() {
        return name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public List<Ability> abilities() {
        return abilities;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getCatchRate() {
        return catchRate;
    }

    public int getFriendship() {
        return friendship;
    }

    public int getBaseExp() {
        return baseExp;
    }

    public GrowthRate getGrowthRate() {
        return growthRate;
    }

    public double getGenderOdds() {
        return genderOdds;
    }

    public int getEggCycles() {
        return eggCycles;
    }

    public int getStat(Stat stat) {
        return switch (stat) {
            case HP -> hp;
            case ATK -> attack;
            case DEF -> defense;
            case SP_ATK -> specialAttack;
            case SP_DEF -> specialDefense;
            case SPE -> speed;
            default -> 0;
        };
    }

    public List<Move> getLevelUpMoves(int level) {
        return movesLevelUp.get(level);
    }

    ////////////////
    //other methods
    ////////////////

    public Species evolves(Pokemon pokemon) {
        Function<Pokemon, Species> evo = evolution.stream().filter(check -> !(check.apply(pokemon) == this)).findAny().orElse((_pokemon) -> this);
        return evo.apply(pokemon);
    }

    public Boolean learns(Move move) {
        return Stream.concat(movesOther.stream(), movesLevelUp.values().stream().flatMap(List::stream))
                .anyMatch(_move -> _move == move);
    }

    public Boolean canBreed(Species with) {
        return eggGroups.stream().anyMatch(with.eggGroups::contains);
    }
}