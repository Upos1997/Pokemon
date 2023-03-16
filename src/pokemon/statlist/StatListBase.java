package src.pokemon.statlist;

import src.helper.Constants;
import src.pokemon.enums.Stat;

public class StatListBase implements StatList{
    protected int MIN_VALUE = 0;
    protected int MAX_VALUE = Integer.MAX_VALUE;
    protected int hp;
    protected int attack;
    protected int defense;
    protected int specialAttack;
    protected int specialDefense;
    protected int speed;

    public StatListBase(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed){
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }
    public StatListBase(){
        this.hp = 0;
        this.attack = 0;
        this.defense = 0;
        this.specialAttack = 0;
        this.specialDefense = 0;
        this.speed = 0;
    }

    protected int sum(){
        return hp+attack+defense+specialAttack+specialDefense+speed;
    }

    public int getStat(Stat stat){
        return switch (stat){
            case HP -> hp;
            case ATK -> attack;
            case DEF -> defense;
            case SP_ATK -> specialAttack;
            case SP_DEF -> specialDefense;
            case SPE -> speed;
            default -> 0;
        };
    }

    public void setStat(Stat stat, int newStat){
        if (newStat < MIN_VALUE) {
            newStat = MIN_VALUE;
        } else if (newStat > MAX_VALUE) {
            newStat = MAX_VALUE;
        }
        switch (stat){
            case HP: hp = newStat;
            case ATK: attack = newStat;
            case DEF: defense = newStat;
            case SP_ATK: specialAttack = newStat;
            case SP_DEF: specialDefense = newStat;
            case SPE: speed = newStat;
        };
    }

    public void modStatAdd(Stat stat, int change){
        setStat(stat, getStat(stat) + change);
    }
    public void modStatMul(Stat stat, float change){
        setStat(stat, Math.round(getStat(stat)*change));
    }
}
