package src.combat.action.MoveAction;

import src.combat.action.ActionTargeted;
import src.combat.field.Field;
import src.helper.Rng;
import src.moves.moveLogic.MoveStat;
import src.moves.moveLogic.Move;

import java.util.List;

public class MoveActionCrit extends ActionTargeted implements MoveActionDamaging{
    MoveActionCrit(MoveActionDamage source) {
        super(source.getUser(), source, source.getTarget());
        this.move = source.move;
        this.autoCrit = source.source.isAutoCrit();
        this.critChance = move.getCritChance();
        this.critDamage = move.getCritDamage();
    }

    public boolean autoCrit;
    public double critChance;
    public double critDamage;
    public Move move;
    private MoveActionDamage source;

    @Override
    public MoveActionDamage getSource() {
        return source;
    }

    @Override
    public Boolean action(Field field) {
        return (Boolean) super.action(field);
    }

    @Override
    public Boolean takeAction(Field field) {
        List<MoveStat> mods = List.of(MoveStat.AUTO_CRIT, MoveStat.CRIT_CHANCE);
        field.applyActionModifiers(this);
        user.applyActionModifiers(field, this);
        target.applyActionModifiers(field, this);
        return autoCrit || Rng.chance(critChance);
    }
}
