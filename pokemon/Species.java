package pokemon;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import ability.AbilityName;
import moves.MoveName;

public enum Species {
    BULBASAUR("Bulbasaur", List.of(Type.GRASS, Type.POISON), List.of(AbilityName.OVERGROW),
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

    private final String name;
    private final List<Type> types;
    private final List<AbilityName> abilities;
    private final double height;
    private final double weight;

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

    private final int catchRate;
    private final int friendship;
    private final int baseExp;
    private final GrowthRate growthRate;

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

    private final List<EggGroup> eggGroups;
    private final double genderOdds;
    private final int eggCycles;

    public Boolean canBreed(Species with) {
        return eggGroups.stream().anyMatch(with.eggGroups::contains);
    }

    public double getGenderOdds() {
        return genderOdds;
    }

    public int getEggCycles() {
        return eggCycles;
    }

    private final int hp;
    private final int attack;
    private final int defense;
    private final int specialAttack;
    private final int specialDefense;
    private final int speed;

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

    private List<Function<Pokemon, Species>> evolution;
    private final Map<Integer, List<MoveName>> movesLevelUp;
    private final List<MoveName> movesOther;

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
                .anyMatch(_move -> {
                    return _move == move;
                });
    }

    public List<MoveName> getLevelUpMoves(int level) {
        return movesLevelUp.get(level);
    }
}