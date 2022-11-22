package moves;

import moves.moveLogic.Move;

public enum MoveName {
    TACKLE(new Tackle()),
    GROWL(new Growl()),
    VINE_WHIP(new VineWhip());

    MoveName(Move move){
        this.move = move;
    }

    private Move move;

    public Move getInstance(){
        return move.clone();
    }
    
}
