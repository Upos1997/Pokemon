package src.combat.action;

import src.combat.field.Field;
import src.helper.Rng;
import src.moves.moveLogic.MoveStat;
import src.moves.moveLogic.MoveDamaging;
import src.pokemon.Stat;
import src.pokemon.Type;

import java.util.List;

public class MoveActionDamage extends ActionTargeted{
    public MoveActionDamage(MoveActionSingle source) {
        super(source.user, source, source.target);
        this.move = (MoveDamaging) source.move;
        this.attack = move.getAttack();
        this.defense = move.getDefense();
        this.power = move.getPower();
        this.stab = move.getStab();
    }

    MoveActionSingle source;

    @Override
    public MoveActionSingle getSource() {
        return source;
    }

    public MoveDamaging move;
    public double power;
    public double damageMod=1;
    public double stab;
    public Stat attack;
    public Stat defense;
    public int attackNumber;
    public int defenseNumber;
    public double critDamage;


    public List<Type> getTypes(){
        return source.getTypes();
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
        List<MoveStat> mods = List.of(MoveStat.POWER, MoveStat.STAB, MoveStat.DAMAGE, MoveStat.ATTACK, MoveStat.DEFENSE, MoveStat.CRIT_DAMAGE);
        user.applyActionModifiers(field, this, mods);
        field.applyActionModifiers(this, mods);
        target.applyActionModifiers(field, this, mods);
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
