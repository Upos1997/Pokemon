package ability;

import java.util.function.BiFunction;
import java.util.function.Function;

import action.Action;
import action.Reaction;
import enums.MessageReaction;
import field.Field;
import modifier.MessageModifier;
import modifier.Modifier;
import moves.TriFunction;
import pokemon.Pokemon;
import pokemon.Type;
import prevent.Prevent;

public enum Ability{
    OVERGROW(Ability.ModifierEffect(MessageModifier.POWER, (float) 1.5, (pokemon, field, action) -> {
        return action.user == pokemon && action.move.type == Type.GRASS && pokemon.hpCurrent <= pokemon.hpMax/3;
    })), 
    CHLOROPHYLL(Ability.noEffect);

    Ability(BiFunction<Field, Pokemon, Void> effect) {
        this.effect = effect;
    }

    BiFunction<Field, Pokemon, Void> effect; 

    static BiFunction<Field, Pokemon, Void> ModifierEffect(MessageModifier message, float modifier, TriFunction<Pokemon, Field, Action, Boolean> check) {
        return (field, pokemon) -> {
            Modifier newModifier = new Modifier(modifier, (_field, action) -> {return check.apply(pokemon, field, action);});
            field.addModifier(message, newModifier);
            return null;};
    }

    static BiFunction<Field, Pokemon, Void> ReactionEffect(MessageReaction message, Reaction reaction) {
        return (field, pokemon) -> {
            field.addReaction(message, reaction);
            return null;};
    }

    static BiFunction<Field, Pokemon, Void> PreventEffect(Prevent prevent) {
        return (field, pokemon) -> {
            field.addPrevent(prevent);
            return null;};
    }

    void apply(Field field, Pokemon pokemon) {
        effect.apply(field, pokemon);
    }
}
