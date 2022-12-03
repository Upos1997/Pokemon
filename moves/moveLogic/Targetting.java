package moves.moveLogic;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import combat.field.Field;
import combat.field.Slot;
import pokemon.Pokemon;

public enum Targetting {
    TARGET_ADJACENT((Field field, Pokemon user) -> {return target(field, adjacent(field, user));}),
    TARGET_ADJACENT_FOE((Field field, Pokemon user) -> {return target(field, intersection(foe(field, user), adjacent(field, user)));}),
    TARGET_ADJACENT_ALLY((Field field, Pokemon user) -> {return target(field, intersection(adjacent(field, user), ally(field, user)));}),
    TARGET_ADJACENT_ALLY_OR_SELF((Field field, Pokemon user) -> {return target(field, intersection(adjacent(field, user), union(ally(field, user), self(field, user))));}),
    TARGET_ANY((Field field, Pokemon user) -> {return target(field, all(field));}),
    ALL((Field field, Pokemon user) -> {return all(field);}),
    ADJACENT(Targetting::adjacent),
    ADJACENT_FOE((Field field, Pokemon user) -> {return intersection(foe(field, user), adjacent(field, user));}),
    ALLY(Targetting::ally),
    ALLY_AND_SELF((Field field, Pokemon user) -> {return union(ally(field, user), self(field, user));}),
    FOE(Targetting::foe),
    SELF(Targetting::self);

    Targetting(BiFunction<Field, Pokemon, List<Slot>> filter){
        this.filter = filter;
    }
    BiFunction<Field, Pokemon, List<Slot>> filter;

    static private List<Slot> adjacent(Field field, Pokemon user) {
        return field.getAdjacent(user);
    }

    static private List<Slot> foe(Field field, Pokemon user) {
        return field.getFoe(user);
    }

    static private List<Slot> ally(Field field, Pokemon user) {
        return field.getAlly(user);
    }

    static private List<Slot> self(Field field, Pokemon user) {
        return field.getSelf(user);
    }

    static private List<Slot> all(Field field) {
        return field.getAll();
    }

    static private List<Slot> target(Field field, List<Slot> targets) {
        if (targets.size() > 1) {
            return getTarget(field, targets);
        } else if (targets.size() == 1){
            return List.of(targets.get(0));
        } else return Collections.emptyList();
    }

    static private List<Slot> getTarget(Field field, List<Slot> targets) {
        return List.of(targets.get(1));
    }

    static private List<Slot> intersection(List<Slot> list1, List<Slot> list2){
        return list1.stream().filter(list2::contains).collect(Collectors.toList());
    }

    static private List<Slot> union(List<Slot> list1, List<Slot> list2){
        return Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
    }

    final public List<Slot> getTargets(Field field, Pokemon user) {
        return filter.apply(field, user);
    }
}
