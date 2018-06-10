package pers.cabin.jichu.a5_designPattern.dm06_AdaptecPatter;

/**
 * Created by caiping on 2017/3/2.
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
