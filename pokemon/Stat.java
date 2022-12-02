package pokemon;

public enum Stat {
    HP,
    ATK,
    DEF,
    SP_ATK,
    SP_DEF,
    SPE,
    ACC,
    EVA;

    static public double getMod(int stage) {
        if (stage < 0) {
            return 2 / (2 - stage);
        } else
            return (2 + stage) / 2;
    }

    static public double getAccMod(int acc, int eva) {
        int totalStage = acc - eva;
        if (totalStage < 0) {
            return 3 / (3 - totalStage);
        } else
            return (3 + totalStage) / 3;
    }
}
