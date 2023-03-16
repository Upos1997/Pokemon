package src.pokemon;

import src.ability.Ability;
import src.moves.Move;
import src.pokemon.enums.*;
import src.pokemon.species.Species;
import src.status.Ok;
import src.status.Status;

public class Pokemon {
    private final Species species;
    private String nickname;
    private int level;
    private long xp;
    private Ability ability;
    private Nature nature;
    private Gender gender;
    private Status status;

    private int hpCurrent;
    private StatList stats;
    private StatList ev;
    private StatList iv;

    private Move move1;
    private Move move2;
    private Move move3;
    private Move move4;

    public Pokemon(Species species, int level, Nature nature, Gender gender, StatListEV ev, StatListIV iv) {
        this.species = species;
        this.level = level;
        this.nature = nature;
        this.gender = gender;
        this.ev = ev;
        this.iv = iv;
        updateStats();
        hpCurrent = stats.getStat(Stat.HP);
    }

    //////////
    //getters
    //////////

    public Species getSpecies(){
        return species;
    }
    public int getLevel() {
        return level;
    }
    public long getXp() {
        return xp;
    }
    public Ability getAbility(){
        return ability;
    }
    public Nature getNature(){
        return nature;
    }
    public Gender getGender(){return gender;}
    public Status getStatus(){return status;}
    public int getHpCurrent(){
        return hpCurrent;
    }
    public int getStat(Stat stat){
        return stats.getStat(stat);
    }
    public int getEv(Stat stat) {
        return ev.getStat(stat);
    }
    public int getIv(Stat stat){
        return iv.getStat(stat);
    }


    public void gainXp(long amount){
        xp = xp + amount;
    }
    public boolean setStatus(Status newStatus){
        if (status.equals(Ok.class)){
            status = newStatus;
            return true;
        } else return false;
    }


    private float calcBase(Stat stat) {
        int baseStatCalc = 2 * species.getBaseStat(stat);
        int IVStatCalc = getIv(stat);
        float EVStatCalc = getEv(stat)/4f;
        float result =  baseStatCalc + IVStatCalc + EVStatCalc;
        result *= level/100f;
        result += 5;
        return result;
    }

    private int calcStat(Stat stat) {
        return Math.round(calcBase(stat) * nature.get_modifier(stat));
    }

    private int calcHp() {
        return Math.round(calcBase(Stat.HP) + level + 5);
    }

    private void updateStats() {
        stats.setStat(Stat.HP, calcHp());
        stats.setStat(Stat.ATK, calcStat(Stat.ATK));
        stats.setStat(Stat.DEF, calcStat(Stat.DEF));
        stats.setStat(Stat.SP_ATK, calcStat(Stat.SP_ATK));
        stats.setStat(Stat.SP_DEF, calcStat(Stat.SP_DEF));
        stats.setStat(Stat.SPE, calcStat(Stat.SPE));
    }
}
