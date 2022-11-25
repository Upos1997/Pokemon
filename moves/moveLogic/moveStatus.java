package moves.moveLogic;

public abstract class moveStatus extends Move {

    static protected Boolean makesContact = false;

    @Override
    public boolean isStatus() {
        return true;
    }
}
