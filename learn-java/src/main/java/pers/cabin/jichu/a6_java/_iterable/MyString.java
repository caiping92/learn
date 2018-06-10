package pers.cabin.jichu.a6_java._iterable;

import java.util.Iterator;

/**
 * Created by caiping on 2017/10/11.
 */
public class MyString implements Iterable<Character>{

    private int length=0;
    private String str = null;

    public MyString(String str) {
        this.length = str.length();
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }

    @Override
    public Iterator<Character> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Character>{

        private int  curs=0;    // 下一个元素返回位置
        private int  lastRet = -1;// 最后一个元素位置

        @Override
        public boolean hasNext() {
            return curs!=length;
        }

        @Override
        public Character next() {

            int i = curs;
            if (i > length) {
                throw new IndexOutOfBoundsException("越界异常");
            }
            curs=i+1;
            return str.charAt(lastRet = i);
        }

        @Override
        public void remove() {
            //TODO 不能这样干！
      /*      if (lastRet<0) {
                throw new IllegalStateException();
            }
            str = str.substring(0, curs) + str.substring(curs + 1, length);
            curs = lastRet;
            lastRet=-1;*/
        }
    }
}
