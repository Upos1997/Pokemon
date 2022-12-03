package pokemon;

import helper.Rng;

public enum Nature {
    HARDY("Hardy", Stat.ATK, Stat.ATK),
    LONELY("Lonely", Stat.ATK, Stat.DEF),
    BRAVE("Brave", Stat.ATK, Stat.SPE),
    ADAMANT("Adamant", Stat.ATK, Stat.SP_ATK),
    NAUGHTY("Naughty", Stat.ATK, Stat.SP_DEF),
    BOLD("Bold", Stat.DEF, Stat.ATK),
    DOCILE("Docile", Stat.DEF, Stat.DEF),
    RELAXED("Relaxed", Stat.DEF, Stat.SPE),
    IMPISH("Impish", Stat.DEF, Stat.SP_ATK),
    LAX("Lax", Stat.DEF, Stat.SP_DEF),
    TIMID("Timid", Stat.SPE, Stat.ATK),
    HASTY("Hasty", Stat.SPE, Stat.DEF),
    SERIOUS("Serious", Stat.SPE, Stat.SPE),
    JOLLY("Jolly", Stat.SPE, Stat.SP_ATK),
    NAIVE("Naive", Stat.SPE, Stat.SP_DEF),
    MODEST("Modest", Stat.SP_ATK, Stat.ATK),
    MILD("Mild", Stat.SP_ATK, Stat.DEF),
    QUIET("Quiet", Stat.SP_ATK, Stat.SPE),
    BASHFUL("Bashful", Stat.SP_ATK, Stat.SP_ATK),
    RASH("Rash", Stat.SP_ATK, Stat.SP_DEF),
    CALM("Calm", Stat.SP_DEF, Stat.ATK),
    GENTLE("Gentle", Stat.SP_DEF, Stat.DEF),
    SASSY("Sassy", Stat.SP_DEF, Stat.SPE),
    CAREFUL("Careful", Stat.SP_DEF, Stat.SP_ATK),
    QUIRKY("Quirky", Stat.SP_DEF, Stat.SP_DEF);

    Nature(String name, Stat up, Stat down) {
        this.name = name;
        this.up = up;
        this.down = down;
    }

    final String name;
    final Stat up;
    final Stat down;

    public float get_modifier(Stat stat) {
        if (up == stat && down == stat) {
            return 1;
        } else if (up == stat) {
            return boost;
        } else if (down == stat) {
            return detriment;
        } else {
            return 1;
        }
    }

    static public Nature random() {
        Nature[] natures = Nature.values();
        return natures[Rng.nextInt(natures.length)];
    }

    static final float boost = 1.1f;
    static final float detriment = 0.9f;
}
