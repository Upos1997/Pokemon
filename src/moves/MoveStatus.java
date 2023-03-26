package src.moves;

import src.helper.Tag;
import src.types.Type;

public abstract class MoveStatus extends Move {
    MoveStatus(Type[] types, int ppMax) {
        super(types, ppMax);
        addTag(Tag.STATUS);
    }
}
