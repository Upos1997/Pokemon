package combat.action;

import java.util.List;
import java.util.function.Predicate;

import combat.action.actionLogic.Action;
import combat.action.actionLogic.MessageAction;
import combat.field.Field;
import combat.modifier.MessageModifier;
import moves.moveLogic.MoveDamaging;
import pokemon.Pokemon;
import pokemon.Stat;
import pokemon.Type;

public class ActionDamage extends Action {

    public ActionDamage(Pokemon user, MoveDamaging move, Pokemon target) {
        super(user, move, target);
    }

    @Override
    public MoveDamaging getSource() {
        return (MoveDamaging) super.getSource();
    }

    private boolean isStab(List<Type> types) {
        Predicate<Type> predicate = type -> user.getTypes().contains(type);
        return types.stream().anyMatch(predicate);
    }

    private boolean isCrit(Field field) {
        return new ActionCrit(user, getSource(), target).takeAction(field);
    }

    private double typeEffectiveness(List<Type> types) {
        double result = 1;
        List<Type> targetTypes = target.getTypes();
        Type.calcTypeEffectiveness(types, targetTypes);
        return result;
    }

    protected boolean action(Field field) {
        MoveDamaging move = getSource();
        Stat attack = move.getAttack();
        Stat defense = move.getDefense();
        int power = (int) doubleAdjustedValue(field, move.getPower(), MessageModifier.POWER);
        double damageMod = doubleAdjustedValue(field, 1, MessageModifier.DAMAGE);
        List<Type> types = move.getTypes();
        int level = user.getLevel();
        int attackNumber;
        int defenseNumber;
        if (isCrit(field)) {
            attackNumber = Math.max(user.getAdjustedStat(attack), user.getStat(attack));
            defenseNumber = Math.min(target.getAdjustedStat(defense), target.getStat(defense));
            double critDamage = doubleAdjustedValue(field, move.getCritDamage(), MessageModifier.CRIT_DAMAGE);
            damageMod *= critDamage;
        } else {
            attackNumber = user.getAdjustedStat(attack);
            defenseNumber = target.getAdjustedStat(defense);
        }
        if (isStab(types)) {
            double stabMod = doubleAdjustedValue(field, move.getStab(), MessageModifier.STAB);
            damageMod *= stabMod;
        }
        damageMod *= typeEffectiveness(types);
        int damage = (int) (((0.4 * level + 2) * power * attackNumber / defenseNumber / 50 + 2) * damageMod) * -1;
        target.changeHp(damage);
        field.handleReactions(MessageAction.CHANGE_HP);
        return true;
    }
}
