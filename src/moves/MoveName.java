package src.moves;

import src.moves.moveLogic.Move;

public enum MoveName {
    TACKLE(new Tackle()),
    GROWL(new Growl()),
    VINE_WHIP(new VineWhip());

    MoveName(Move move){
        this.move = move;
    }

    private final Move move;

    public Move getInstance(){
        return move.clone();
    }
    
}
