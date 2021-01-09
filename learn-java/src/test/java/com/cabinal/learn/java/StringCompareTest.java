package com.cabinal.learn.java;

import org.junit.Test;
import pers.cabin.java.StdOut;

public class StringCompareTest {


    @Test
    public void test() {
        String a = "aaaa";
        String b = "aaaa";

        StdOut.println(a == b);
        StdOut.println(a.equals(b));


//        a.intern();

        String c = "aaaa";
        StdOut.println(c == b);

        String d = new String("aaaa");

        StdOut.println(c == d);

        StdOut.println(d.hashCode());

        StdOut.println(c.equals(b));

        StdOut.println(a.hashCode());
        StdOut.println(b.hashCode());
        StdOut.println(c.hashCode());

    }

}
