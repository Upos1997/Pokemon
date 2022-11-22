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

public enum Weather {
    CLEAR_SKIES(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    SUN(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    HARSH_SUN(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    RAIN(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    HEAVY_RAIN(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    SAND(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    HAIL(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    SHADOW(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    FOG(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
    WINDY(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());

    Weather(List<AbstractMap.SimpleImmutableEntry<MessageReaction, Reaction>> reactions, 
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
        return field.handleReactions(MessageReaction.WEATHER_STARTED, action);
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
        field.handleReactions(MessageReaction.WEATHER_STOPPED, action);
    }
}
