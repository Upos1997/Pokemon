package pokemon;

import java.util.List;
import java.util.function.Function;

import Status.Status;
import Status.StatusName;
import ability.abilityLogic.Ability;
import moves.moveLogic.Move;

public class Pokemon {
    Pokemon(Species species, int level) {
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
        switch (stat) {
            case ATTACK:
                return attack;
            case DEFENSE:
                return defense;
            case SPECIAL_ATTACK:
                return specialAttack;
            case SPECIAL_DEFENSE:
                return specialDefense;
            case SPEED:
                return speed;
            default:
                return 0;
        }
    }

    float calcBase(int baseStat) {
        return ((2 * baseStat) * level / 100) + 5;
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
        this.attack = calcStat(Stat.ATTACK);
        this.defense = calcStat(Stat.DEFENSE);
        this.specialAttack = calcStat(Stat.SPECIAL_ATTACK);
        this.specialDefense = calcStat(Stat.SPECIAL_DEFENSE);
        this.speed = calcStat(Stat.SPEED);
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
        switch (stat) {
            case ATTACK:
                return attackStage;
            case DEFENSE:
                return defenseStage;
            case SPECIAL_ATTACK:
                return specialAttackStage;
            case SPECIAL_DEFENSE:
                return specialDefenseStage;
            case SPEED:
                return speedStage;
            case ACCURACY:
                return accuracyStage;
            case EVASION:
                return evasionStage;
            default:
                return 0;

        }
    }

    void updateStages(Stat stat, int stages, Function<Integer, Integer> update) {
        switch (stat) {
            case ATTACK:
                attackStage = update.apply(attackStage);
            case DEFENSE:
                defenseStage = update.apply(defenseStage);
            case SPECIAL_ATTACK:
                specialAttackStage = update.apply(specialAttackStage);
            case SPECIAL_DEFENSE:
                specialDefenseStage = update.apply(specialDefenseStage);
            case SPEED:
                speedStage = update.apply(speedStage);
            case ACCURACY:
                accuracyStage = update.apply(accuracyStage);
            case EVASION:
                evasionStage = update.apply(evasionStage);
            default:
                break;
        }
    }

    public void wentUp(Stat stat, int stages) {
        Function<Integer, Integer> function = start -> {
            return Math.min(6, start + stages);
        };
        updateStages(stat, stages, function);
    }

    public void lowered(Stat stat, int stages) {
        Function<Integer, Integer> function = start -> {
            return Math.max(-6, start - stages);
        };
        updateStages(stat, stages, function);
    }

    double attackMod = 1;
    double defenseMod = 1;
    double specialAttackMod = 1;
    double specialDefenseMod = 1;
    double speedMod = 1;
    double accuracyMod = 1;
    double evasionMod = 1;

    public double getMod(Stat stat) {
        switch (stat) {
            case ATTACK:
                return attackMod;
            case DEFENSE:
                return defenseMod;
            case SPECIAL_ATTACK:
                return specialAttackMod;
            case SPECIAL_DEFENSE:
                return specialDefenseMod;
            case SPEED:
                return speedMod;
            case ACCURACY:
                return accuracyMod;
            case EVASION:
                return evasionMod;
            default:
                return 1;

        }
    }

    public void updateMod(Stat stat, float mod) {
        switch (stat) {
            case ATTACK:
                attackMod *= mod;
            case DEFENSE:
                defenseMod *= mod;
            case SPECIAL_ATTACK:
                specialAttackMod *= mod;
            case SPECIAL_DEFENSE:
                specialDefenseMod *= mod;
            case SPEED:
                speedMod *= mod;
            case ACCURACY:
                accuracyMod *= mod;
            case EVASION:
                evasionMod *= mod;
            default:
                break;
        }
    }

    Move move1;
    Move move2;
    Move move3;
    Move move4;

    public List<Type> getTypes() {
        return species.getTypes();
    }

    public int getAdjustedStat(Stat stat) {
        return (int) (getStage(stat) * Stat.getMod(getStage(stat)) * getMod(stat));
    }

    public boolean isBelow(float treshold) {
        return hpCurrent < hpMax * treshold;
    }

    public boolean hasStatus(StatusName status) {
        return status.isSame(this.status);
    }

    public boolean hasType(Type type) {
        return getTypes().contains(type);
    }
}
