package pers.cabin.jichu.a5_designPattern.dm24_TemplatePattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {

        Game game = new CricketGame();
        game.play();
        System.out.println();
        game = new FootballGame();
        game.play();
    }
}
