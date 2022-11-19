package pokemon;

import java.util.List;
import java.util.function.Function;

import ability.Ability;
import empty.Status;
import enums.Gender;
import enums.Stat;
import moves.Move;

public class Pokemon {
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
    int move1Pp;
    Move move2;
    int move2Pp;
    Move move3;
    int move3Pp;
    Move move4;
    int move4Pp;

    float calcBase(int baseStat) {
        return ((2 * baseStat) * level / 100) + 5;
    }

    int calcStat(int baseStat, Stat stat) {
        return (int) Math.round(calcBase(baseStat) * nature.get_modifier(stat));
    }

    int calcHp() {
        return Math.round(calcBase(species.hp) + level + 5);
    }

    void updateStats() {
        this.hpMax = calcHp();
        this.attack = calcStat(species.attack, Stat.ATTACK);
        this.defense = calcStat(species.defense, Stat.DEFENSE);
        this.specialAttack = calcStat(species.specialAttack, Stat.SPECIAL_ATTACK);
        this.specialDefense = calcStat(species.specialDefense, Stat.SPECIAL_DEFENSE);
        this.speed = calcStat(species.speed, Stat.SPEED);
    }

    public void changeHp(int amount) {
        this.hpCurrent = Math.min(Math.max(hpCurrent + amount, 0), hpMax);
    }

    void use_move1(List<Pokemon> targets) {
        if (!(move1Pp == 0)) {
            move1.use(this, targets);
            move1Pp--;
        }
    }

    void use_move2(List<Pokemon> targets) {
        if (!(move2Pp == 0)) {
            move2.use(this, targets);
            move2Pp--;
        }
    }

    void use_move3(List<Pokemon> targets) {
        if (!(move3Pp == 0)) {
            move3.use(this, targets);
            move3Pp--;
        }
    }

    void use_move4(List<Pokemon> targets) {
        if (!(move4Pp == 0)) {
            move4.use(this, targets);
            move4Pp--;
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

    public void setStatus(Status new_status) {
        if (status == Status.ok) {
            status = new_status;
        }
    }
}
