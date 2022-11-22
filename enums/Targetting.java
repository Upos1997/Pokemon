package enums;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import field.Field;
import field.Slot;
import pokemon.Pokemon;

public enum Targetting {
    TARGET_ADJACENT((Field field, Pokemon user) -> {return target(field, adjacent(field, user));}),
    TARGET_ADJACENT_FOE((Field field, Pokemon user) -> {return target(field, intersection(foe(field, user), adjacent(field, user)));}),
    TARGET_ADJACENT_ALLY((Field field, Pokemon user) -> {return target(field, intersection(adjacent(field, user), ally(field, user)));}),
    TARGET_ADJACENT_ALLY_OR_SELF((Field field, Pokemon user) -> {return target(field, intersection(adjacent(field, user), union(ally(field, user), self(field, user))));}),
    TARGET_ANY((Field field, Pokemon user) -> {return target(field, all(field));}),
    ALL((Field field, Pokemon user) -> {return all(field);}),
    ADJACENT((Field field, Pokemon user) -> {return adjacent(field, user);}),
    ADJACENT_FOE((Field field, Pokemon user) -> {return intersection(foe(field, user), adjacent(field, user));}),
    ALLY((Field field, Pokemon user) -> {return ally(field, user);}),
    ALLY_AND_SELF((Field field, Pokemon user) -> {return union(ally(field, user), self(field, user));}),
    FOE((Field field, Pokemon user) -> {return foe(field, user);}),
    SELF((Field field, Pokemon user) -> {return self(field, user);});

    Targetting(BiFunction<Field, Pokemon, List<Slot>> filter){
        this.filter = filter;
    }
    BiFunction<Field, Pokemon, List<Slot>> filter;

    final static private List<Slot> adjacent(Field field, Pokemon user) {
        return field.getAdjacent(user);
    }

    final static private List<Slot> foe(Field field, Pokemon user) {
        return field.getFoe(user);
    }

    final static private List<Slot> ally(Field field, Pokemon user) {
        return field.getAlly(user);
    }

    final static private List<Slot> self(Field field, Pokemon user) {
        return field.getSelf(user);
    }

    final static private List<Slot> all(Field field) {
        return field.getAll();
    }

    final static private List<Slot> target(Field field, List<Slot> targets) {
        if (targets.size() > 1) {
            return getTarget(field, targets);
        } else if (targets.size() == 1){
            return List.of(targets.get(1));
        } else return Collections.emptyList();
    }

    final static private List<Slot> getTarget(Field field, List<Slot> targets) {
        return List.of(targets.get(1));
    }

    final static private List<Slot> intersection(List<Slot> list1, List<Slot> list2){
        return list1.stream().filter(slot -> {return list2.contains(slot);}).collect(Collectors.toList());
    }

    final static private List<Slot> union(List<Slot> list1, List<Slot> list2){
        return Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
    }

    final public List<Slot> getTargets(Field field, Pokemon user) {
        return filter.apply(field, user);
    }
}
