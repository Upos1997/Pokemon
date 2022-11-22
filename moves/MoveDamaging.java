package moves;

import enums.Stat;
import field.Field;
import pokemon.Pokemon;
import pokemon.Type;
import rng.Rng;

public abstract class MoveDamaging extends Move{

    protected Stat attack;
    protected Stat defense;

    private boolean isCrit(){
        return Rng.chance(critChance);
    }

    private boolean isStab(Pokemon user){
        return user.getType().stream().filter(type -> {return getTypes().contains(type);}).findFirst().isPresent();
    }

    protected int calcDamage(Field field, Pokemon user, Pokemon target) {
        int attackNumber;
        int defenseNumber;
        if (isCrit()){
            attackNumber = Math.max(user.getStat(attack), user.getAdjustedStat(attack));
            defenseNumber = Math.min(target.getStat(defense), target.getAdjustedStat(defense));
            damageModifier *= 1.5;
        } else {
            attackNumber = user.getAdjustedStat(attack);
            defenseNumber = target.getAdjustedStat(defense);
        }
        if (isStab(user)) {
            damageModifier *= 1.5;
        }
        for (Type aType : getTypes()){
            damageModifier *= aType.get_modifier(target.getType());
        }
        double random = Rng.range(0.85, 1);
        return (int) (((2*user.level/5+2)*power*attackNumber/defenseNumber/50+2)*damageModifier*random);
    }
    
}
