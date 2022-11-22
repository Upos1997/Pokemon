package moves.moveLogic;

import field.Field;
import pokemon.Pokemon;
import pokemon.Stat;
import pokemon.Type;
import rng.Rng;

public abstract class MoveDamaging extends Move{

    protected Stat attack;
    protected Stat defense;

    private boolean isCrit(){
        return Rng.chance(critChance);
    }

    private boolean isStab(Pokemon user){
        return user.getTypes().stream().filter(type -> {return types.contains(type);}).findFirst().isPresent();
    }

    protected int dealDamage(Field field, Pokemon user, Pokemon target) {
        int attackNumber;
        int defenseNumber;
        if (isCrit()){
            attackNumber = Math.max(user.getStat(attack), user.getAdjustedStat(attack));
            defenseNumber = Math.min(target.getStat(defense), target.getAdjustedStat(defense));
            damageModifier *= critDamage;
        } else {
            attackNumber = user.getAdjustedStat(attack);
            defenseNumber = target.getAdjustedStat(defense);
        }
        if (isStab(user)) {
            damageModifier *= stab;
        }
        for (Type aType : getTypes()){
            damageModifier *= aType.get_modifier(target.getTypes());
        }
        double random = Rng.range(0.85, 1);
        int damage =  (int) (((2*user.level/5+2)*power*attackNumber/defenseNumber/50+2)*damageModifier*random);
        target.changeHp(damage * -1);
        return damage;
    }
    
}
