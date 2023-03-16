package src.pokemon;

import src.ability.Ability;
import src.moves.Move;
import src.pokemon.enums.*;
import src.pokemon.species.Species;
import src.pokemon.statlist.StatList;
import src.pokemon.statlist.StatListBase;
import src.pokemon.statlist.StatListBaseEV;
import src.pokemon.statlist.StatListBaseIV;
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
    private final StatList stats = new StatListBase();
    private final StatList ev;
    private final StatList iv;

    private Move move1;
    private Move move2;
    private Move move3;
    private Move move4;

    public Pokemon(Species species, int level, Nature nature, Gender gender, StatListBaseEV ev, StatListBaseIV iv) {
        this.species = species;
        this.level = level;
        this.nature = nature;
        this.gender = gender;
        this.ev = ev;
        this.iv = iv;
        updateStats();
        hpCurrent = stats.getStat(Stat.HP);
    }

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
    public int getEV(Stat stat) {
        return ev.getStat(stat);
    }
    public int getIV(Stat stat){
        return iv.getStat(stat);
    }


    public void gainXp(long amount){
        xp = xp + amount;
    }
    public void setStatus(Status newStatus){
            status = newStatus;
    }
    public void changeHp(int change){
        int newHp = hpCurrent + change;
        int max = getStat(Stat.HP);
        int min = 0;
        if (newHp > max){
            newHp = max;
        } else if (newHp < min){
            newHp = min;
        }
        setHp(newHp);
    }

    private void setHp(int newHp){
        hpCurrent = newHp;
    }
    private void updateStats() {
        stats.setStat(Stat.HP, calcHp());
        stats.setStat(Stat.ATK, calcStat(Stat.ATK));
        stats.setStat(Stat.DEF, calcStat(Stat.DEF));
        stats.setStat(Stat.SP_ATK, calcStat(Stat.SP_ATK));
        stats.setStat(Stat.SP_DEF, calcStat(Stat.SP_DEF));
        stats.setStat(Stat.SPE, calcStat(Stat.SPE));
    }
    private int calcStat(Stat stat) {
        return Math.round(calcBase(stat) * nature.get_modifier(stat));
    }
    private int calcHp() {
        return Math.round(calcBase(Stat.HP) + level + 5);
    }
    private float calcBase(Stat stat) {
        int baseStatCalc = 2 * species.getBaseStat(stat);
        int IVStatCalc = getIV(stat);
        float EVStatCalc = getEV(stat)/4f;
        float result = ((baseStatCalc + IVStatCalc + EVStatCalc) * level / 100f) + 5;
        return result;
    }
}
