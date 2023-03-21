package src.pokemon.species;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import src.ability.Ability;
import src.moves.Move;
import src.pokemon.Pokemon;
import src.pokemon.enums.EggGroup;
import src.pokemon.growthrate.GrowthRate;
import src.pokemon.enums.Stat;
import src.pokemon.statlist.StatList;
import src.types.Type;

public class Species {

    protected String name;
    protected Type[] types;
    protected Ability[] abilities;
    protected float height;
    protected float weight;
    protected int catchRate;
    protected int friendship = 50;
    protected int baseExp;
    protected GrowthRate growthRate;
    protected EggGroup[] eggGroups;
    protected float genderOdds = 0.5f;
    protected int eggCycles = 20;
    protected StatList baseStats;
    protected Function<Pokemon, Species>[] evolutions;
    protected Map<Integer, Move[]> movesLevelUp;
    protected Move[] movesOther;

    public String getName()
    {
        return name;
    }
    public Type[] getTypes()
    {
        return types;
    }
    public Ability[] getAbilities()
    {
        return abilities;
    }
    public double getHeight()
    {
        return height;
    }
    public double getWeight()
    {
        return weight;
    }
    public int getCatchRate()
    {
        return catchRate;
    }
    public int getFriendship()
    {
        return friendship;
    }
    public int getBaseExp()
    {
        return baseExp;
    }
    public GrowthRate getGrowthRate()
    {
        return growthRate;
    }
    public double getGenderOdds()
    {
        return genderOdds;
    }
    public int getEggCycles()
    {
        return eggCycles;
    }
    public int getBaseStat(Stat stat)
    {
        return baseStats.getStat(stat);
    }
    public Move[] getLevelUpMoves(int level)
    {
        return movesLevelUp.get(level);
    }

    public boolean learns(Move move)
    {
        return Stream.concat(Arrays.stream(movesOther), movesLevelUp.values().stream().flatMap(Arrays::stream))
                .anyMatch(_move -> _move == move);
    }
    public boolean canBreed(Species species)
    {
        return Arrays.stream(eggGroups).anyMatch(eggGroup -> eggGroup.canBreed(species.eggGroups));
    }
}