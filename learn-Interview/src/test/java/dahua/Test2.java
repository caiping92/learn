package dahua;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by caiping on 2017/9/23.
 */
public class Test2 {

    public static int t() {

        try {
            int m = 0 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            return 3;
        }
    }
        public static void main(String[] args){

            deleteFileByDayAgo("D:/tmp");

        }

        public static long getCurrentMills() {
            Date date=new Date();//取时间
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.getTimeInMillis();
        }

    /**
     * 删除目录下昨天之前的文件
     * @param dir
     */
    public static void deleteFileByDayAgo(String dir) {

            long currentDay = getCurrentMills();
            File file = new File(dir);
            File[] files = file.listFiles();
            BasicFileAttributes basicFileAttributes = null;
            for (File f : files) {

                try {
                    basicFileAttributes = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FileTime fileTime = basicFileAttributes.creationTime();
                long toMillis = fileTime.toMillis();
                if (toMillis < currentDay) {
                    if (f.isDirectory()) {
                        deleteFileByDayAgo(f.getPath());
                        f.delete();//删除文件
                    }
                    f.delete();
                }
            }
        }
}
