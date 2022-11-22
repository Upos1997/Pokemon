package action;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

import field.Field;
import helper.Rng;
import modifier.MessageModifier;
import modifier.Modifier;
import moves.moveLogic.Move;
import pokemon.Pokemon;

public class ActionMove extends Action{

    ActionMove(Pokemon user, Move move, List<Pokemon> targets) {
        super(user, targets, noAction);
        this.move = move;
    }
    
    public Move move;

    private Boolean calc_hit(Field field){
        if (field.getModifier(MessageModifier.AUTO_HIT, this) == 2){
            return true;
        } else {
            float acc = move.getAccuracy() * field.getModifier(MessageModifier.ACCURACY, this);
            return Rng.chance(acc);
        }
    }
    private Boolean calc_crit(Field field){
        float chance = crit_chance* field.getModifier(MessageModifier.CRIT_CHANCE, this);
        return Rng.chance(chance);
    }
    Function<Field, Void> action = (field) -> {
        List<Modifier> validModifiers = field.getModifiers(this);
        for (Pokemon target : targets)
        if (calc_hit(field)){
            
        }
        return null;
    };

    public Void takeAction(Field field) {
        Runnable beforeAction = () -> field.handleReactions(MessageReaction.BATTACK, this);
        Runnable afterAction = () -> field.handleReactions(MessageReaction.AATTACK, this);
        return super.takeAction(field, beforeAction, afterAction);
    }

    final private static float stab = (float) 1.5;
    final private static float crit_multiplier = (float) 1.5;
    final private static float crit_chance = (float) 1 / 24;
    
}
