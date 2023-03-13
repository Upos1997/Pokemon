package src.pokemon;

import src.ability.abilityLogic.Ability;
import src.moves.moveLogic.Move;
import src.pokemon.enums.Gender;
import src.pokemon.enums.Nature;
import src.pokemon.enums.Stat;
import src.types.Type;
import src.pokemon.species.Species;
import src.status.Status;
import src.status.StatusName;

import java.util.List;

public class Pokemon {
    public Pokemon(Species species, int level) {
        this.species = species;
        this.level = level;
        this.nature = Nature.random();
        this.gender = Gender.random(species.getGenderOdds());
        updateStats();
        hpCurrent = hpMax;
    }

    ////////////////////////
    //variables and getters
    ////////////////////////
    protected Species species;
    protected int level;
    protected long xp;
    protected Ability ability;
    protected Nature nature;
    protected Gender gender;
    protected Status status;
    public int hpCurrent;
    public int hpMax;
    int attack;
    int defense;
    int specialAttack;
    int specialDefense;
    int speed;

    Move move1;
    Move move2;
    Move move3;
    Move move4;

    public int getLevel() {
        return level;
    }

    public long getXp() {
        return xp;
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

    public List<Type> getTypes() {
        return species.getTypes();
    }

    //////////
    //setters
    //////////

    public void gainXp(long amount) {
        xp += amount;
    }
    public void setStatus(Status newStatus) {
        if (hasStatus(StatusName.OK)) {
            status = newStatus;
        }
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

    public void changeHp(int amount) {
        this.hpCurrent = Math.min(Math.max(hpCurrent + amount, 0), hpMax);
    }

    //////////////////
    //boolean methods
    //////////////////

    public boolean isBelow(float threshold) {
        return hpCurrent < hpMax * threshold;
    }

    public boolean hasStatus(StatusName status) {
        return status.isSame(this.status);
    }

    public boolean hasType(Type type) {
        return getTypes().contains(type);
    }

    ////////////////
    //Other methods
    ////////////////

    private float calcBase(int baseStat) {
        return ((2 * baseStat) * level / 100f) + 5;
    }

    private int calcStat(Stat stat) {
        int baseStat = species.getStat(stat);
        return Math.round(calcBase(baseStat) * nature.get_modifier(stat));
    }

    private int calcHp() {
        return Math.round(calcBase(species.getStat(Stat.HP)) + level + 5);
    }

    private void updateStats() {
        this.hpMax = calcHp();
        this.attack = calcStat(Stat.ATK);
        this.defense = calcStat(Stat.DEF);
        this.specialAttack = calcStat(Stat.SP_ATK);
        this.specialDefense = calcStat(Stat.SP_DEF);
        this.speed = calcStat(Stat.SPE);
    }
}
