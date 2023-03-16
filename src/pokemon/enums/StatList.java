package src.pokemon.enums;

public class StatList {
    protected int MIN_VALUE = 0;
    protected int MAX_VALUE = Integer.MAX_VALUE;
    protected int hp;
    protected int attack;
    protected int defense;
    protected int specialAttack;
    protected int specialDefense;
    protected int speed;

    public StatList(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed){
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
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

    public void modStat(Stat stat, int change){
        setStat(stat, getStat(stat) + change);
    }
}
