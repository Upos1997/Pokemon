package enums;

import java.util.List;

import action.Reaction;
import modifier.Modifier;
import prevent.Prevent;

public enum Status {
    BURN(),
    frostbite,
    paralysis,
    poisoned,
    badly_poisoned,
    fainted,
    drowsy,
    ok;

    Status(List<Reaction> reactions,
            List<Modifier> modifiers,
            List<Prevent> prevents) {
        this.reactions = reactions;
        this.prevents = prevents;
        this.modifiers = modifiers;
    }

    List<Reaction> reactions;
    List<Modifier> modifiers;
    List<Prevent> prevents;

}
