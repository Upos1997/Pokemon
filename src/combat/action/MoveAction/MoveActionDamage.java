package src.combat.action.MoveAction;

import src.combat.action.ActionMoveDamaging;
import src.combat.action.ActionTargeted;
import src.combat.field.Field;
import src.helper.Rng;
import src.moves.moveLogic.MoveDamaging;
import src.moves.moveLogic.MoveStat;
import src.pokemon.Pokemon;
import src.pokemon.Stat;
import src.pokemon.Type;

import java.util.List;

public class MoveActionDamage extends ActionTargeted implements MoveActionDamaging{
    public MoveActionDamage(ActionMoveDamaging source, Pokemon target) {
        super(source.getUser(), source, target);
        this.move =  source.getSource();
        this.attack = source.getAttack();
        this.defense = source.getDefense();
        this.power = source.getPower();
        this.stab = source.getStab();
        this.damageMod = source.getDamageMod();
    }

    ActionMoveDamaging source;
    @Override
    public ActionMoveDamaging getSource() {
        return source;
    }

    public MoveDamaging move;
    public int power;
    public float damageMod;
    public float stab;
    public Stat attack;
    public Stat defense;
    public int attackNumber;
    public int defenseNumber;
    public float critDamage;

    @Override
    public int getPower() {
        return power;
    }
    @Override
    public void setPower(int power) {
        this.power = power;
    }
    @Override
    public float getDamageMod() {
        return damageMod;
    }
    @Override
    public void setDamageMod(float damageMod) {
        this.damageMod = damageMod;
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
    public float getCritDamage() {
        return critDamage;
    }
    @Override
    public void setCritDamage(float critDamage) {
        this.critDamage = critDamage;
    }

    private boolean isStab(){
        return user.getTypes().stream().anyMatch(type -> getTypes().contains(type));
    }
    private boolean isCrit(Field field) {
        return new MoveActionCrit(this).takeAction(field);
    }

    @Override
    public Integer action(Field field) {
        return (Integer) super.action(field);
    }

    @Override
    public Integer takeAction(Field field) {
        target.applyActionModifiers(field, this);
        attackNumber = user.getAdjustedStat(attack);
        defenseNumber = target.getAdjustedStat(defense);
        if (isCrit(field)){
            damageMod *= critDamage;
            attackNumber = Math.max(attackNumber, user.getStat(attack));
            defenseNumber = Math.min(defenseNumber, target.getStat(defense));
        }
        if (isStab()){
            damageMod *= stab;
        }
        damageMod *= Type.calcTypeEffectiveness(getTypes(), target.getTypes());
        damageMod *= Rng.range(0.85, 1);
        return (int) (((2/5f*user.getLevel()+2)*power*attackNumber/defenseNumber/50+2)*damageMod);
    }
}
