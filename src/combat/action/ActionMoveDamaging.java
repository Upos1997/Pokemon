package src.combat.action;

import src.combat.field.Slot;
import src.moves.moveLogic.MoveDamaging;
import src.pokemon.Pokemon;
import src.pokemon.Stat;

import java.util.List;

public class ActionMoveDamaging extends ActionMoveStatus {
    ActionMoveDamaging(Pokemon user, MoveDamaging source, List<Slot> targets) {
        super(user, source, targets);
        this.attack = source.getAttack();
        this.defense = source.getDefense();
        this.power = source.getPower();
        this.critChance = source.getCritChance();
        this.critDamage = source.getCritDamage();
        this.autoCrit = source.isAutoCrit();
        this.stab = source.getStab();
    }

    public Stat attack;
    public Stat defense;
    public int power;
    public float critChance;
    public float critDamage;
    public boolean autoCrit;
    public float stab;
    public float damageMod = 1;

    @Override
    public MoveDamaging getSource() {
        return (MoveDamaging) super.getSource();
    }

}
