package io.zipcoder.casino;

import io.zipcoder.casino.Games.*;
import io.zipcoder.casino.utilities.Console;

import java.util.function.Function;

public enum GameEnum {
    HIGHLOW(HighLow::new),
    CRAPS(Craps::new),
    BLACKJACK(BlackJack::new),
    GOFISH(GoFish::new),
    INVALID(InvalidGame::new);

    private final Function<Console, GameInterface> function;


    GameEnum(Function<Console, GameInterface> function) {
        this.function = function;
    }

    public GameInterface create(Console console) {
        return function.apply(console);
    }

    public static GameEnum getValueOf(String userInput){

        userInput = userInput.toUpperCase();
        try {
            return valueOf(userInput);
        }
        catch(Exception iae){
            return  INVALID;
        }
    }


}
