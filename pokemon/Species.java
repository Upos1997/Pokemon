package pokemon;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import ability.AbilityName;
import moves.MoveName;

public enum Species {
    BULBASAUR("Bulbasaur", List.of(Type.GRASS, Type.POISON), List.of(AbilityName.OVERGROW, AbilityName.CHLOROPHYLL),
            0.7, 6.9,
            45, 50, 64, GrowthRate.MEDIUM,
            List.of(EggGroup.GRASS, EggGroup.MONSTER), 0.875, 20,
            45, 49, 49, 65, 65, 45,
            Map.of(1, List.of(MoveName.GROWL, MoveName.TACKLE), 3, List.of(MoveName.VINE_WHIP)),
            List.of());

    Species(String name, List<Type> types, List<AbilityName> abilities, double height, double weight, int catchRate,
            int friendship, int baseExp, GrowthRate growthRate, List<EggGroup> eggGroups, double genderOdds,
            int eggCycles, int hp, int attack, int defense, int specialAttack, int specialDefense, int speed,
            Map<Integer, List<MoveName>> movesLevelUp, List<MoveName> movesOther) {
        this.name = name;
        this.types = types;
        this.abilities = abilities;
        this.height = height;
        this.weight = weight;
        this.catchRate = catchRate;
        this.friendship = friendship;
        this.baseExp = baseExp;
        this.growthRate = growthRate;
        this.eggGroups = eggGroups;
        this.genderOdds = genderOdds;
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

    private String name;
    private List<Type> types;
    private List<AbilityName> abilities;
    private double height;
    private double weight;

    public String getName() {
        return name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public List<AbilityName> abilities() {
        return abilities;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    private int catchRate;
    private int friendship;
    private int baseExp;
    private GrowthRate growthRate;

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

    private List<EggGroup> eggGroups;
    private double genderOdds;
    private int eggCycles;

    public Boolean canBreed(Species with) {
        return eggGroups.stream().filter(slot -> {
            return with.eggGroups.contains(slot);
        }).findFirst().isPresent();
    }

    public double getGenderOdds() {
        return genderOdds;
    }

    public int getEggCycles() {
        return eggCycles;
    }

    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public int getStat(Stat stat) {
        switch (stat) {
            case HP:
                return hp;
            case ATK:
                return attack;
            case DEF:
                return defense;
            case SP_ATK:
                return specialAttack;
            case SP_DEF:
                return specialDefense;
            case SPE:
                return speed;
            default:
                return 0;
        }
    }

    private List<Function<Pokemon, Species>> evolution;
    private Map<Integer, List<MoveName>> movesLevelUp;
    private List<MoveName> movesOther;

    public Species evolves(Pokemon pokemon) {
        Function<Pokemon, Species> evo = evolution.stream().filter(check -> {
            return !(check.apply(pokemon) == this);
        }).findAny().orElse((_pokemon) -> {
            return this;
        });
        return evo.apply(pokemon);
    }

    public Boolean learns(MoveName move) {
        return Stream.concat(movesOther.stream(), movesLevelUp.values().stream().flatMap(List::stream))
                .filter(_move -> {
                    return _move == move;
                }).findAny().isPresent();
    }

    public List<MoveName> getLevelUpMoves(int level) {
        return movesLevelUp.get(level);
    }
}