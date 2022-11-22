package enums;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;

import action.Action;
import action.MessageReaction;
import action.Reaction;
import field.Field;
import modifier.MessageModifier;
import modifier.Modifier;
import prevent.Prevent;

public enum Terrain {
    ELECTRIC(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    GRASSY(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    MISTY(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    PSYCHIC(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    NONE(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());

    Terrain(List<AbstractMap.SimpleImmutableEntry<MessageReaction, Reaction>> reactions, 
            List<AbstractMap.SimpleImmutableEntry<MessageModifier, Modifier>> modifiers, 
            List<Prevent> prevents){
        this.reactions = reactions;
        this.prevents = prevents;
        this.modifiers = modifiers;
    }

    List<AbstractMap.SimpleImmutableEntry<MessageReaction, Reaction>> reactions;
    List<AbstractMap.SimpleImmutableEntry<MessageModifier, Modifier>> modifiers;
    List<Prevent> prevents;

    Void start(Field field, Action action) {
        for (AbstractMap.SimpleImmutableEntry<MessageReaction, Reaction> reaction : reactions){
            field.addReaction(reaction.getKey(), reaction.getValue());
        }
        for (Prevent prevent : prevents) {
            field.addPrevent(prevent);
        }
        for (AbstractMap.SimpleImmutableEntry<MessageModifier, Modifier> modifier : modifiers) {
            field.addModifier(modifier.getKey(), modifier.getValue());
        }  
        return field.handleReactions(MessageReaction.TERRAIN_STARTED, action);
    }

    void stop(Field field, Action action){
        for (AbstractMap.SimpleImmutableEntry<MessageReaction, Reaction> reaction : reactions){
            field.removeReaction(reaction.getKey(), reaction.getValue());
        }
        for (Prevent prevent : prevents) {
            field.removePrevent(prevent);
        }
        for (AbstractMap.SimpleImmutableEntry<MessageModifier, Modifier> modifier : modifiers) {
            field.removeModifier(modifier.getKey(), modifier.getValue());
        }
        field.handleReactions(MessageReaction.TERRAIN_STOPPED, action);
    }
}
