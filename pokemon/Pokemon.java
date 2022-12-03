package pokemon;

import java.util.List;
import java.util.function.Function;

import ability.abilityLogic.Ability;
import moves.moveLogic.Move;
import status.Status;
import status.StatusName;

public class Pokemon {
    public Pokemon(Species species, int level) {
        this.species = species;
        this.level = level;
        this.nature = Nature.random();
        this.gender = Gender.random(species.getGenderOdds());
        updateStats();
        hpCurrent = hpMax;
    }

    protected Species species;
    protected int level;
    protected long xp;
    protected Ability ability;
    protected Nature nature;
    protected Gender gender;
    protected Status status;

    public int getLevel() {
        return level;
    }

    public long getXp() {
        return xp;
    }

    public void gainXp(long amount) {
        xp += amount;
    }

    public Ability getAbility() {
        return ability;
    }

    public Nature getNature() {
        return nature;
    }

    public Gender getGender() {
        return gender;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status newStatus) {
        if (hasStatus(StatusName.OK)) {
            status = newStatus;
        }
    }

    public int hpCurrent;
    public int hpMax;
    int attack;
    int defense;
    int specialAttack;
    int specialDefense;
    int speed;

    public int getHpCurrent() {
        return hpCurrent;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getStat(Stat stat) {
        return switch (stat) {
            case ATK -> attack;
            case DEF -> defense;
            case SP_ATK -> specialAttack;
            case SP_DEF -> specialDefense;
            case SPE -> speed;
            default -> 0;
        };
    }

    public void modStat(Stat stat, double mod){
        switch (stat) {
            case ATK -> attack *= mod;
            case DEF -> defense *= mod;
            case SP_ATK -> specialAttack *= mod;
            case SP_DEF -> specialDefense *= mod;
            case SPE -> speed *= mod;
        }
    }

    float calcBase(int baseStat) {
        return ((2 * baseStat) * level / 100f) + 5;
    }

    int calcStat(Stat stat) {
        int baseStat = species.getStat(stat);
        return (int) Math.round(calcBase(baseStat) * nature.get_modifier(stat));
    }

    int calcHp() {
        return Math.round(calcBase(species.getStat(Stat.HP)) + level + 5);
    }

    void updateStats() {
        this.hpMax = calcHp();
        this.attack = calcStat(Stat.ATK);
        this.defense = calcStat(Stat.DEF);
        this.specialAttack = calcStat(Stat.SP_ATK);
        this.specialDefense = calcStat(Stat.SP_DEF);
        this.speed = calcStat(Stat.SPE);
    }

    public void changeHp(int amount) {
        this.hpCurrent = Math.min(Math.max(hpCurrent + amount, 0), hpMax);
    }

    int attackStage = 0;
    int defenseStage = 0;
    int specialAttackStage = 0;
    int specialDefenseStage = 0;
    int speedStage = 0;
    int accuracyStage = 0;
    int evasionStage = 0;

    public int getStage(Stat stat) {
        return switch (stat) {
            case ATK -> attackStage;
            case DEF -> defenseStage;
            case SP_ATK -> specialAttackStage;
            case SP_DEF -> specialDefenseStage;
            case SPE -> speedStage;
            case ACC -> accuracyStage;
            case EVA -> evasionStage;
            default -> 0;
        };
    }

    void updateStages(Stat stat, Function<Integer, Integer> update) {
        switch (stat) {
            case ATK:
                attackStage = update.apply(attackStage);
            case DEF:
                defenseStage = update.apply(defenseStage);
            case SP_ATK:
                specialAttackStage = update.apply(specialAttackStage);
            case SP_DEF:
                specialDefenseStage = update.apply(specialDefenseStage);
            case SPE:
                speedStage = update.apply(speedStage);
            case ACC:
                accuracyStage = update.apply(accuracyStage);
            case EVA:
                evasionStage = update.apply(evasionStage);
            default:
                break;
        }
    }

    public void wentUp(Stat stat, int stages) {
        Function<Integer, Integer> function = start -> {
            return Math.min(6, start + stages);
        };
        updateStages(stat, function);
    }

    public void lowered(Stat stat, int stages) {
        Function<Integer, Integer> function = start -> {
            return Math.max(-6, start - stages);
        };
        updateStages(stat, function);
    }

    Move move1;
    Move move2;
    Move move3;
    Move move4;

    public List<Type> getTypes() {
        return species.getTypes();
    }

    public int getAdjustedStat(Stat stat) {
        return (int) (getStage(stat) * Stat.getMod(getStage(stat)));
    }

    public boolean isBelow(float threshold) {
        return hpCurrent < hpMax * threshold;
    }

    public boolean hasStatus(StatusName status) {
        return status.isSame(this.status);
    }

    public boolean hasType(Type type) {
        return getTypes().contains(type);
    }

    static final public Pokemon emptyPokemon = new Pokemon(Species.BULBASAUR, 1);
}
