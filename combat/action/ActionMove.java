package action;

import java.util.List;
import java.util.stream.Collectors;

import field.Field;
import field.Slot;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import pokemon.Type;

public class ActionMove extends Action {

    ActionMove(Field field, Pokemon user, Move move, List<Slot> targets) {
        super(user);
        this.move = move;
        this.targets = targets;

    }

    private Move move;
    private List<Slot> targets;

    public Void takeAction(Field field) {
        return super.takeAction(field);
    }

    public boolean isType(Type type) {
        return move.isType(type);
    }

    @Override
    Void action(Field field) {
        field.handleReactions(MessageAction.BEFORE_ATTACK);
        List<Pokemon> targets = this.targets.stream().map((Slot target) -> {
            return target.getPokemon();
        }).collect(Collectors.toList());
        move.use(field, user, targets, null);
        field.handleReactions(MessageAction.AFTER_ATTACK);
        return null;
    }
}
