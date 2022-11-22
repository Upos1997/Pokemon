package pokemon;

import java.util.List;
import java.util.function.Function;

import ability.Ability;
import enums.Status;
import field.Field;
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
    public Species species;
    public int level;
    public Ability ability;
    Nature nature;
    Gender gender;
    Status status;

    public int hpCurrent;
    public int hpMax;
    int attack;
    int defense;
    int specialAttack;
    int specialDefense;
    int speed;

    int attackStage = 0;
    int defenseStage = 0;
    int specialAttackStage = 0;
    int specialDefenseStage = 0;
    int speedStage = 0;
    int accuracyStage = 0;
    int evasionStage = 0;

    Move move1;
    Move move2;
    Move move3;
    Move move4;

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

    void use(Field field, Move move, List<Pokemon> targets){
        move.use(field, this, targets);
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

    public void setStatus(Status new_status) {
        if (status == Status.ok) {
            status = new_status;
        }
    }

    public List<Type> getTypes() {
        return species.getTypes();
    }

    public int getStat(Stat stat){
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

    public int getStage(Stat stat){
        switch (stat){
            case ACCURACY:
                return accuracyStage;
            case ATTACK:
                return attackStage;
            case DEFENSE:
                return defenseStage;
            case EVASION:
                return evasionStage;
            case SPECIAL_ATTACK:
                return specialAttackStage;
            case SPECIAL_DEFENSE:
                return specialDefenseStage;
            case SPEED:
                return speedStage;
            default:
                return 0;
            
        }
    }

    public int getAdjustedStat(Stat stat){
        return (int) (getStage(stat) * Stat.getMod(getStage(stat)));
    }
}
