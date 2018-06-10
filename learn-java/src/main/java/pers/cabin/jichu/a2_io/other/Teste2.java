package pers.cabin.jichu.a2_io.other;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * Created by cc on 2016/11/13.
 */
public class Teste2 {

    @Test
    public void test1() {
        String dir = "D://mySoft_JavaTools";
        File directory = new File(dir);
        File[] files = directory.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
//            System.out.println(file.getAbsoluteFile());
        }

    }

    /**
     * 列出 dir 下得所有文件 及文件夹
     *
     * @param path
     */
    public void getFile(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getFile(f.getAbsolutePath());
            }
            System.out.println(f.getAbsolutePath());
        }
    }

    @Test
    public void test2() {
        getFile("D://mySoft_JavaTools");
    }

    public void getFileWithFileFilter(String path) {

        File dir = new File(path);
        File[] files = dir.listFiles(new FileTerByFileName("jar"));
        for (File f : files) {
            if (f.isDirectory()) {
                getFileWithFileFilter(f.getAbsolutePath());
            }
            System.out.println(f.getAbsolutePath());
        }

    }

    @Test
    public void test3() {
        getFileWithFileFilter("E://MyJava_1");
    }

    /**
     * 过滤文件后缀名
     */
    public void getFilenameWithFilenameFileter(String dir, String filterName) {
        File directory = new File(dir);
        File[] files = directory.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                String[] list = f.list(new MyFilenameFileter(filterName));
                if (list != null && list.length > 0) {
                    for (String filename : list) {
                        System.out.println(f.getAbsolutePath() + "\\" + filename);
                    }
                }
                getFilenameWithFilenameFileter(f.getAbsolutePath(), filterName);
            }
        }

    }

    @Test
    public void test4() {
        getFilenameWithFilenameFileter("E://MyJava_1", ".java");
    }

}

class FileTerByFileName implements FileFilter {
    private String filterName;

    public FileTerByFileName(String filterName) {
        this.filterName = filterName;
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(this.filterName);
    }
}

class MyFilenameFileter implements FilenameFilter {
    private String filtername;

    public MyFilenameFileter(String filtername) {
        this.filtername = filtername;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(this.filtername);
    }

}