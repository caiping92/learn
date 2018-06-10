package pers.cabin.jichu.a5_designPattern.dm24_TemplatePattern;

/**
 * Created by caiping on 2017/3/3.
 */
public abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    //模板
    public final void play() {

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
