package test;

import java.io.*;

/**
 *
 * jdk 已有classloader
 * BootStrapClassLoader     rt.jar resource.jar  ,jvm本身
 * ExtensionCLassLoader     加载java_home/lib/lib/ext/*.jar
 * AppClassLoader           从classpath 中加载
 *
 * --
 * 自定义加载器，            自定义加载路径
 * 继承ClassLoader
 *
 * Created by caiping on 2017/10/21.
 */
public class Test2_classloader {

    public static void main(String[] args){


        test1();
    }

    private static void test1() {
        ClassLoader classLoader = Test2_classloader.class.getClassLoader();
        for (;classLoader!=null;) {
            System.out.println("Test2_classloader 类加载器："+classLoader );
            System.out.println(classLoader+"的父类加载器："+(classLoader=classLoader.getParent()));//如果为null 则为bootstrap 加载器
        }
    }
}

class Test1ClassLoader extends ClassLoader {

    /**
     * 指定路径
     */
    private String path;

    /**
     * 构造器名称
     */
    private String name;

    public Test1ClassLoader(String name, String path) {
//        super();//默认省略，让系统类 成为父类的加载器
        this.name = name;
        this.path = path;
    }

    /**
     * 双亲委派
     * @param parent
     * @param path
     * @param name
     */
    public Test1ClassLoader(ClassLoader parent, String path, String name) {
        super(parent);
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    /**
     * 
     * 传入一个 pers.cabin 格式
     * 
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        
        byte[] resuData =  readClassFileByByteArray(name);

        return this.defineClass(name, resuData, 0, resuData.length);
    }

    /**
     * 获取 .class文件的字节数组
     *
     * 1.将类名 转换为 全路径
     * 2.读取字节流
     *
     * @param name 全路径+类名
     *             pers.cabin.demo.Test
     * @return
     */
    private byte[] readClassFileByByteArray(String name) {
        if (name == null || name.trim().equals("")) {
            return null;
        }
        byte[] ret = null;

        name = name.replaceAll("\\.", File.pathSeparator);

        String path = this.path + name + ".class";
        File c = new File(path);

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        InputStream in = null;

        try {
            in = new FileInputStream(c);
            int tmp =0;
            while ((tmp = in.read()) != -1) {
                arrayOutputStream.write(tmp);
            }
            ret = arrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (arrayOutputStream != null) {
                    arrayOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}