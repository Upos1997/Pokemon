package src.pokemon.statlist;

import src.pokemon.enums.Stat;

public interface StatList {
    int getStat(Stat stat);
    void setStat(Stat stat, int newStat);
    void modStatAdd(Stat stat, int change);
    void modStatMul(Stat stat, float change);
}
