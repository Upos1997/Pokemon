package pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Type {
        NORMAL(false),
        FIRE(false),
        WATER(false),
        ELECTRIC(false),
        GRASS(false),
        ICE(false),
        FIGHTING(false),
        POISON(false),
        GROUND(false),
        FLYING(false),
        PSYCHIC(false),
        BUG(false),
        ROCK(false),
        GHOST(false),
        DRAGON(false),
        DARK(false),
        STEEL(false),
        FAIRY(true);

        Type(Boolean isLast) {
                if (isLast) {
                        setupTypes();
                }
        }

        public List<Type> resistances = new ArrayList<>();
        public List<Type> weaknesses = new ArrayList<>();
        public List<Type> immunities = new ArrayList<>();

        public float get_modifier(List<Type> types) {
                float modifier = 1;
                for (Type type : types) {
                        if (resistances.contains(type)) {
                                modifier = modifier * resistance_multiplier;
                        } else if (weaknesses.contains(type)) {
                                modifier = modifier * weakness_multiplier;
                        } else if (immunities.contains(type)) {
                                return 0;
                        }
                }
                return modifier;
        }

        static void setupType(Type type, List<Type> weaknesses, List<Type> resistances, List<Type> immunities) {
                type.weaknesses.addAll(weaknesses);
                type.resistances.addAll(resistances);
                type.immunities.addAll(immunities);
        }

        static void setupTypes() {
                setupType(NORMAL,
                                List.of(FIGHTING),
                                Collections.emptyList(),
                                List.of(GHOST));
                setupType(FIRE,
                                List.of(WATER, GROUND, ROCK),
                                List.of(FIRE, GRASS, ICE, BUG, STEEL, FAIRY),
                                Collections.emptyList());
                setupType(WATER,
                                List.of(ELECTRIC, GRASS),
                                List.of(FIRE, WATER, ICE, STEEL),
                                Collections.emptyList());
                setupType(ELECTRIC,
                                List.of(GROUND),
                                List.of(ELECTRIC, FLYING, STEEL),
                                Collections.emptyList());
                setupType(GRASS,
                                List.of(FIRE, ICE, POISON, FLYING, BUG),
                                List.of(WATER, ELECTRIC, GRASS, GROUND),
                                Collections.emptyList());
                setupType(ICE,
                                List.of(FIRE, FIGHTING, ROCK, STEEL),
                                List.of(ICE),
                                Collections.emptyList());
                setupType(FIGHTING,
                                List.of(FLYING, FIGHTING, FAIRY),
                                List.of(BUG, ROCK, DARK),
                                Collections.emptyList());
                setupType(POISON,
                                List.of(GROUND, PSYCHIC),
                                List.of(GRASS, FIGHTING, POISON, BUG, FAIRY),
                                Collections.emptyList());
                setupType(GROUND,
                                List.of(WATER, GRASS, ICE),
                                List.of(POISON, ROCK),
                                List.of(ELECTRIC));
                setupType(FLYING,
                                List.of(ELECTRIC, ICE, ROCK),
                                List.of(GRASS, FIGHTING, BUG),
                                List.of(GROUND));
                setupType(PSYCHIC,
                                List.of(BUG, GHOST, DARK),
                                List.of(FIGHTING, PSYCHIC),
                                Collections.emptyList());
                setupType(BUG,
                                List.of(FIRE, FLYING, ROCK),
                                List.of(GRASS, FIGHTING, GROUND),
                                Collections.emptyList());
                setupType(ROCK,
                                List.of(WATER, GRASS, FIGHTING, GROUND, STEEL),
                                List.of(NORMAL, FIRE, POISON, FLYING),
                                Collections.emptyList());
                setupType(GHOST,
                                List.of(GHOST, DARK),
                                List.of(POISON, BUG),
                                List.of(NORMAL, FIGHTING));
                setupType(DRAGON,
                                List.of(ICE, DRAGON, FAIRY),
                                List.of(FIRE, WATER, ELECTRIC, GRASS),
                                Collections.emptyList());
                setupType(DARK,
                                List.of(FIGHTING, BUG, FAIRY),
                                List.of(GHOST, DARK),
                                List.of(PSYCHIC));
                setupType(STEEL,
                                List.of(FIRE, FIGHTING, GROUND),
                                List.of(NORMAL, GRASS, ICE, FLYING, PSYCHIC, BUG,
                                                ROCK, DRAGON,
                                                STEEL, FAIRY),
                                List.of(POISON));
                setupType(FAIRY,
                                List.of(POISON, STEEL),
                                List.of(FIGHTING, BUG, DARK),
                                List.of(DRAGON));
        }

        static float resistance_multiplier = (float) 0.5;
        static int weakness_multiplier = 2;
}
