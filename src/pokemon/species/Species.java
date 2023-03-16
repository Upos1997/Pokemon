package src.pokemon.species;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import src.ability.Ability;
import src.moves.moveLogic.Move;
import src.pokemon.Pokemon;
import src.pokemon.enums.EggGroup;
import src.pokemon.enums.GrowthRate;
import src.pokemon.enums.Stat;
import src.pokemon.enums.StatList;
import src.types.Type;

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
    protected StatList baseStats;
    protected int speed;
    protected List<Function<Pokemon, Species>> evolutions;
    protected Map<Integer, List<Move>> movesLevelUp;
    protected List<Move> movesOther;

    public String getName() {
        return name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public List<Ability> getAbilities() {
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

    public int getBaseStat(Stat stat) {
        return baseStats.getStat(stat);
    }

    public List<Move> getLevelUpMoves(int level) {
        return movesLevelUp.get(level);
    }

    ////////////////
    //other methods
    ////////////////

    public Boolean learns(Move move) {
        return Stream.concat(movesOther.stream(), movesLevelUp.values().stream().flatMap(List::stream))
                .anyMatch(_move -> _move == move);
    }

    public Boolean canBreed(Species with) {
        return eggGroups.stream().anyMatch(with.eggGroups::contains);
    }
}