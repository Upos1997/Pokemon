package src.combat.action;

import src.combat.field.Field;
import src.combat.field.Slot;
import src.moves.moveLogic.MoveStat;
import src.moves.moveLogic.Move;
import src.pokemon.Pokemon;
import src.pokemon.Type;

import java.util.List;

public class MoveAction extends Action{
    MoveAction(Pokemon user, Move source, List<Slot> targets) {
        super(user, source);
        this.targets = targets;
        this.types = source.getTypes();
        this.priority = source.getPriority();
    }
    Move parent;
    List<Slot> targets;

    @Override
    public Move getParent() {
        return parent;
    }

    public List<Type> types;
    public int priority;

    @Override
    public Object takeAction(Field field) {
        List<MoveStat> mods = List.of(MoveStat.values());
        field.applyActionModifiers(this, mods);
        user.applyActionModifiers(field, this, mods);
        targets.stream().map(Slot::getPokemon).forEach(pokemon -> parent.singleTarget(field, user, pokemon));
        return parent.use(field, user);
    }
}
