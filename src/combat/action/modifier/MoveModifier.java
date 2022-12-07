package src.combat.action.modifier;

import src.combat.action.Action;
import src.combat.action.MoveAction;
import src.combat.field.SingleField;
import src.moves.moveLogic.MoveStat;
import src.moves.moveLogic.Move;
import src.pokemon.Pokemon;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class MoveModifier extends Modifier {

    MoveModifier(Pokemon user, Object source, MoveStat stat, float modifier, BiFunction<SingleField, Action, Boolean> check) {
        super(user, source, modifier, check, Modifier.noAction);
        this.stat = stat;
        this.modifier = modifier;
    }

    MoveStat stat;
    Move move;

    static public Predicate<SingleField> makeAction(Move target, MoveStat stat, float mod){
        return (field_) -> {
            target.modMove(stat, mod);
            return true;
        };
    }

    public boolean check(SingleField field, MoveAction action) {
        if (super.check(field, action)){
            move = action.getSource();
            this.action = field1 -> {
                move.modMove(stat, modifier);
                return true;
            };
            return true;
        } else return false;
    }

    public void undo() {
        move.modMove(stat, 1/modifier);
        move = null;
    }
}
