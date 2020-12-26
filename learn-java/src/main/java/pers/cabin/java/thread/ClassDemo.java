package pers.cabin.java.thread;

import org.openjdk.jol.info.ClassLayout;
import pers.cabin.java.StdOut;

public class ClassDemo {

    public static void main(String[] args) {

        ClassLayout classLayout = ClassLayout.parseClass(Object.class);
        StdOut.println(classLayout.toPrintable());
        Object obj = new Object();
        StdOut.line();
        StdOut.println(ClassLayout.parseInstance(obj).toPrintable());

        StdOut.line();
        obj.hashCode();
        StdOut.println(ClassLayout.parseInstance(obj).toPrintable());


        StdOut.line();
        synchronized (obj){
            StdOut.println(ClassLayout.parseInstance(obj).toPrintable());
        }


        StdOut.line();
        StdOut.println(ClassLayout.parseInstance(obj).toPrintable());




    }


}
