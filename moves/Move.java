package moves;

import java.util.Collections;
import java.util.List;

import action.Reaction;
import action.ReactionNoCheck;
import enums.Category;
import enums.MessageReaction;
import enums.Stat;
import enums.Targetting;
import enums.Weather;
import field.Field;
import modifier.MessageModifier;
import modifier.Modifier;
import modifier.ModifierNoCheck;
import pokemon.Pokemon;
import pokemon.Type;

public enum Move {
    GROWL(Type.NORMAL, Category.Status, Targetting.ADJACENT_FOE, 0, 0, 100, 40, false, Collections.emptyList(),
            (field, user, targets) -> {
                for (Pokemon target : targets)
                    target.lowered(Stat.ATTACK, 1);
                return null;
            }),

    TACKLE(Type.NORMAL, Category.Physical,
            Targetting.TARGET_ADJACENT, 0, 40, 100, 35, true, Collections
                    .emptyList(),
            emptyEffect()),
    VINE_WHIP(Type.GRASS, Category.Physical, Targetting.TARGET_ADJACENT, 0, 45, 100, 25, true, Collections
            .emptyList(),
            emptyEffect()),
    GROWTH(Type.NORMAL, Category.Status, Targetting.SELF, 1, 0, -1, 20, false,
            Collections.emptyList(), (field, user, pokemon) -> {
                int stages = 1;
                if (field.weather == Weather.SUN || field.weather == Weather.HARSH_SUN) {
                    stages = 2;
                }
                user.wentUp(Stat.ATTACK, stages);
                user.wentUp(Stat.SPECIAL_ATTACK, stages);
                return null;
            }),
    LEECH_SEED(Type.GRASS, Category.Status, Targetting.TARGET_ADJACENT, 1, 0, 90, 20, false,
            Collections.emptyList(), (field, user, pokemon) -> {
                Pokemon target = pokemon.get(0);
                Reaction drain = new ReactionNoCheck(user, Reaction.noAction);
                drain.action = (the_field, action) -> {
                    int damage = Math.round(target.hpMax / 8) * -1;
                    int heal = Math.round(damage / 2 * field.getModifier(MessageModifier.DRAIN, drain));
                    target.changeHp(damage);
                    user.changeHp(heal);
                    return null;
                };
                Reaction end = new Reaction(user, (the_field, action) -> {
                    return action.target == target;
                }, Reaction.noAction);
                end.action = (the_field, action) -> {
                    field.removeReaction(MessageReaction.ROUND_END, drain);
                    field.removeReaction(MessageReaction.ASWITCH, end);
                    return null;
                };
                field.addReaction(MessageReaction.ROUND_END, drain);
                field.addReaction(MessageReaction.ASWITCH, end);
                return null;
            }),
    RAZOR_LEAF(Type.GRASS, Category.Physical, Targetting.ADJACENT_FOE, 1, 55, 95, 25, false,
            List.of(new ModifierNoCheck(MessageModifier.CRIT_CHANCE, 4)), emptyEffect());

    Move(Type type, Category category, Targetting target, int priority, int power, int accuracy, int pp,
            boolean contact,
            List<Modifier> modifiers,
            TriFunction<Field, Pokemon, List<Pokemon>, Void> effect) {
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
        this.modifiers = modifiers;
        this.effect = effect;
    }

    Type type;
    Category category;
    Targetting target;
    int power;
    int accuracy;
    int pp;
    boolean contact;
    List<Modifier> modifiers;
    TriFunction<Field, Pokemon, List<Pokemon>, Void> effect;

    static TriFunction<Field, Pokemon, List<Pokemon>, Void> emptyEffect() {
        return (field, user, targets) -> {
            return null;
        };
    }

    void damage(Field field, Pokemon user, List<Pokemon> targets) {
        float damageModifier = 1;
        float critModifier = 1;
        Stat A;
        Stat D;
        if (category == Category.Physical) {
            A = Stat.ATTACK;
            D = Stat.DEFENSE;
        } else {
            A = Stat.SPECIAL_ATTACK;
            D = Stat.SPECIAL_DEFENSE;
        }
    }

    static float stab = (float) 1.5;
    static float crit_multiplier = (float) 1.5;
    static float crit_chance = (float) 1 / 24;
}
