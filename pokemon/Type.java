package pokemon;

import java.util.Collections;
import java.util.List;

import helper.Color;

public enum Type {
        NORMAL("Normal", new Color(197, 192, 182), false),
        FIRE("Fire", new Color(237, 63, 15), false),
        WATER("Water", new Color(49, 145, 240), false),
        ELECTRIC("Electric", new Color(253, 186, 24), false),
        GRASS("Grass", new Color(102, 187, 43), false),
        ICE("Ice", new Color(160, 229, 251), false),
        FIGHTING("Fighting", new Color(127, 51, 27), false),
        POISON("Poison", new Color(145, 68, 147), false),
        GROUND("Ground", new Color(203, 172, 82), false),
        FLYING("Flying", new Color(139, 160, 240), false),
        PSYCHIC("Psychic", new Color(234, 67, 123), false),
        BUG("Bug", new Color(163, 182, 25), false),
        ROCK("Rock", new Color(176, 160, 93), false),
        GHOST("Ghost", new Color(91, 91, 162), false),
        DRAGON("Dragon", new Color(115, 91, 220), false),
        DARK("Dark", new Color(79, 58, 45), false),
        STEEL("Steel", new Color(178, 177, 193), false),
        FAIRY("Fairy", new Color(238, 167, 239), true);

        Type(String name, Color color, Boolean isLast) {
                this.name = name;
                this.color = color;
                if (isLast) {
                        setupTypes();
                }
        }

        private final String name;
        private final Color color;
        private List<Type> resistances;
        private List<Type> weaknesses;
        private List<Type> immunities;

        public String getName() {
                return name;
        }

        public Color getColor() {
                return color;
        }

        private float getTypeEffectiveness(List<Type> types) {
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

        static public float calcTypeEffectiveness(List<Type> attacking, List<Type> defending) {
                float modifier = 1;
                for (Type type : defending) {
                        modifier *= type.getTypeEffectiveness(attacking);
                }
                return modifier;
        }

        final static float resistance_multiplier = (float) 0.5;
        final static int weakness_multiplier = 2;

        static void setupType(Type type, List<Type> weaknesses, List<Type> resistances, List<Type> immunities) {
                type.weaknesses = weaknesses;
                type.resistances = resistances;
                type.immunities = immunities;
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
}
