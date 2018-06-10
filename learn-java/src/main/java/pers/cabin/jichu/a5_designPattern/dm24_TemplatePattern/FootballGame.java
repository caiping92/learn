package pers.cabin.jichu.a5_designPattern.dm24_TemplatePattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class FootballGame extends Game {
    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
