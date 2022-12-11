package src.combat.action.MoveAction;

import src.combat.action.ActionTargeted;
import src.combat.field.Field;
import src.helper.Rng;
import src.moves.moveLogic.Move;

public class MoveActionCrit extends ActionTargeted<Boolean> {
    MoveActionCrit(MoveActionDamage source) {
        super(source.getSelf(), source, source.getTarget());
        this.move = source.move;
        this.autoCrit = source.getSource().autoCrit;
        this.critChance = move.getCritChance();
        this.critDamage = move.getCritDamage();
    }

    public boolean autoCrit;
    public double critChance;
    public double critDamage;
    public Move move;

    @Override
    public MoveActionDamage getSource() {
        return (MoveActionDamage) source;
    }

    @Override
    protected Boolean takeAction(Field field) {
        return autoCrit || Rng.chance(critChance);
    }
}
