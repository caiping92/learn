package pers.cabin.java.io.other;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2016/11/13.
 */
public class Test3 {

    public void listDirectory(File dir, int level) {

        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println(getPrefix(level) + f.getName());
                listDirectory(f, level++);
            } else {
                System.out.println(getPrefix(level) + f.getName());
            }
        }

    }

    /**
     * 文件前缀
     *
     * @param level 目录层级
     * @return
     */
    private String getPrefix(int level) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("|--");
        for (int i = 0; i < level; i++) {
            stringBuffer.insert(0, "|  ");
        }
        return stringBuffer.toString();
    }

    //    ---------------------------------------------
//    @Test
    public void test1() {

        listDirectory(new File("D:/temp"), 1);

    }

    public int getSum(int i) {
        if (i == 1) {
            return 1;
        }
        return i + getSum(i - 1);
    }

    //    @Test
    public void test2() {
        System.out.println(getSum(2111));
    }
//-------------------------------------------

    /**
     * 将文件得文件名，存到List 集合中
     */
    public void getFileName(File dir, FilenameFilter filenameFilter, List<File> list) {
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                list.add(f);
                getFileName(f, filenameFilter, list);
            } else {
                if (filenameFilter.accept(dir, f.getName())) {
                    list.add(f);
                }
            }
        }
    }

    /**
     * 将List集合中的文件信息 写到目的文件
     *
     * @param dest
     * @param list
     */
    public void writeToFile(File dest, List<File> list) {
        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new FileWriter(dest));
            for (File f : list) {
                bufw.write(f.getAbsolutePath() + System.lineSeparator());
                bufw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufw != null) {
                try {
                    bufw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //    @Test
    public void test3() {
        File dest = new File("D:\\temp\\result.txt");
        File dir = new File("E:\\Myjava_4");
        ArrayList<File> files = new ArrayList<File>();
        getFileName(dir, new MyFilenameFileter2(""), files);
        writeToFile(dest, files);
    }

    public static void main(String[] args) {
        int i = -1;
        String j = new String("abc");

        show(i);
        show2(j);

        System.out.println(i);
        System.out.println(j);
    }

    private static void show2(String j) {
        j = "hahahah";
    }

    public static void show(int i) {
        i = 4;
    }
}

class MyFilenameFileter2 implements FilenameFilter {

    private String reagx;

    public MyFilenameFileter2(String reagx) {
        this.reagx = reagx;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.contains(this.reagx);
    }
}