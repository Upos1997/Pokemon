package src.combat.action;

import src.combat.action.MoveAction.MoveActionDamaging;
import src.combat.field.Slot;
import src.moves.moveLogic.MoveDamaging;
import src.moves.moveLogic.MoveStat;
import src.pokemon.Pokemon;
import src.pokemon.Stat;

import java.util.List;

public class ActionMoveDamaging extends ActionMoveStatus implements MoveActionDamaging {
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

    public List<MoveStat> mods = List.of(MoveStat.values());

    protected Stat attack;
    protected Stat defense;
    protected int power;
    protected float critChance;
    protected float critDamage;
    protected boolean autoCrit;
    protected float stab;
    protected float damageMod = 1;

    protected MoveDamaging source;
    @Override
    public MoveDamaging getSource() {
        return (MoveDamaging) super.getSource();
    }


    @Override
    public Stat getAttack() {
        return attack;
    }
    @Override
    public void setAttack(Stat attack) {
        this.attack = attack;
    }
    @Override
    public Stat getDefense() {
        return defense;
    }
    @Override
    public void setDefense(Stat defense) {
        this.defense = defense;
    }
    @Override
    public int getPower() {
        return power;
    }
    @Override
    public void setPower(int power) {
        this.power = power;
    }
    @Override
    public float getCritChance() {
        return critChance;
    }
    @Override
    public void setCritChance(float critChance) {
        this.critChance = critChance;
    }
    @Override
    public float getCritDamage() {
        return critDamage;
    }
    @Override
    public void setCritDamage(float critDamage) {
        this.critDamage = critDamage;
    }
    @Override
    public boolean isAutoCrit() {
        return autoCrit;
    }
    @Override
    public void setAutoCrit(boolean autoCrit) {
        this.autoCrit = autoCrit;
    }
    @Override
    public float getStab() {
        return stab;
    }
    @Override
    public void setStab(float stab) {
        this.stab = stab;
    }
    @Override
    public float getDamageMod() {
        return damageMod;
    }
    @Override
    public void setDamageMod(float damageMod) {
        this.damageMod = damageMod;
    }
}
