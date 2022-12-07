package src.combat.action;

import src.combat.field.Field;
import src.helper.Rng;
import src.moves.moveLogic.MoveStat;
import src.moves.moveLogic.Move;

import java.util.List;

public class MoveActionCrit extends ActionTargeted{
    MoveActionCrit(MoveActionDamage source) {
        super(source.user, source, source.target);
        this.move = source.move;
        this.autoCrit = move.isAutoCrit();
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
        field.applyActionModifiers(this, mods);
        user.applyActionModifiers(field, this, mods);
        target.applyActionModifiers(field, this, mods);
        return autoCrit || Rng.chance(critChance);
    }
}
