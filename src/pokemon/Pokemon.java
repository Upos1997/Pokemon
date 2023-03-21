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
import src.types.Type;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private final Species species;
    private String nickname;
    private int level;
    private long xp;
    private Ability ability;
    private Nature nature;
    private final Gender gender;
    private Status status;
    private int hpCurrent;
    private final StatList stats = new StatListBase();
    private final StatList ev;
    private final StatList iv;
    private final List<Move> moveList = new ArrayList<>();


    public Pokemon(Species species, int level, Nature nature, Gender gender, Ability ability, StatListBaseEV ev, StatListBaseIV iv)
    {
        this.species = species;
        this.nickname = species.getName();
        this.level = level;
        this.ability = ability;
        this.nature = nature;
        this.gender = gender;
        this.ev = ev;
        this.iv = iv;
        updateStats();
        hpCurrent = stats.getStat(Stat.HP);
    }

    public String getNickname()
    {
        return nickname;
    }
    public Species getSpecies()
    {
        return species;
    }
    public int getLevel()
    {
        return level;
    }
    public long getXp()
    {
        return xp;
    }
    public Ability getAbility()
    {
        return ability;
    }
    public Nature getNature()
    {
        return nature;
    }
    public Gender getGender()
    {
        return gender;
    }
    public Status getStatus()
    {
        return status;
    }
    public int getHpCurrent()
    {
        return hpCurrent;
    }
    public int getStat(Stat stat)
    {
        return stats.getStat(stat);
    }
    public int getEV(Stat stat)
    {
        return ev.getStat(stat);
    }
    public int getIV(Stat stat)
    {
        return iv.getStat(stat);
    }
    public Move getMove(int moveNumber)
    {
        return moveList.get(moveNumber);
    }
    public Type[] getTypes()
    {
        species.getTypes();
    }

    public void setStatus(Status newStatus)
    {
        status = newStatus;
    }
    public void setNickname(String newName)
    {
        nickname = newName;
    }
    public void setNature(Nature newNature)
    {
        nature = newNature;
    }
    public void setAbility(Ability newAbility)
    {
        ability = newAbility;
    }
    public void gainXp(long amount)
    {
        xp = xp + amount;
        int newLevel = species.getGrowthRate().xpToLevel(xp);
        while(newLevel > level)
            levelUp();
    }
    public void changeHp(int change)
    {
        int newHp = hpCurrent + change;
        int max = getStat(Stat.HP);
        int min = 0;
        if (newHp > max)
            newHp = max;
        else if (newHp < min)
            newHp = min;
        setHp(newHp);
    }
    public void forgetMove(Move move)
    {
        moveList.remove(move);
    }

    private void setLevel(int newLevel)
    {
        level = newLevel;
    }
    private void levelUp()
    {
        setLevel(level+1);
    }
    private void setHp(int newHp)
    {
        hpCurrent = newHp;
    }
    private void updateStats()
    {
        stats.setStat(Stat.HP, calcHp());
        stats.setStat(Stat.ATK, calcStat(Stat.ATK));
        stats.setStat(Stat.DEF, calcStat(Stat.DEF));
        stats.setStat(Stat.SP_ATK, calcStat(Stat.SP_ATK));
        stats.setStat(Stat.SP_DEF, calcStat(Stat.SP_DEF));
        stats.setStat(Stat.SPE, calcStat(Stat.SPE));
    }
    private int calcStat(Stat stat)
    {
        return Math.round(calcBase(stat) * nature.get_modifier(stat));
    }
    private int calcHp()
    {
        return Math.round(calcBase(Stat.HP) + level + 5);
    }
    private float calcBase(Stat stat)
    {
        int baseStatCalc = 2 * species.getBaseStat(stat);
        int IVStatCalc = getIV(stat);
        float EVStatCalc = getEV(stat)/4f;
        return ((baseStatCalc + IVStatCalc + EVStatCalc) * level / 100f) + 5;
    }
}
