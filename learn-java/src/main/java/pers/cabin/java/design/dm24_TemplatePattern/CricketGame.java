package pers.cabin.java.design.dm24_TemplatePattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class CricketGame extends Game {
    @Override
    void endPlay() {
        System.out.println("CricketGame Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("CricketGame Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("CricketGame Game Started. Enjoy the game!");
    }
}
