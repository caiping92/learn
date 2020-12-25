package pers.cabin.basic.reference;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * https://www.ibm.com/developerworks/cn/java/j-lo-langref/index.html?ca=drs-
 * <p>
 * <>java.lang.Reference</>
 * |-StrongReference
 *      直接调用 ，可能-内存泄露
 * |-SoftReference
 *      get()，不可能-内存泄露
 * |-WeakReference
 *      get()  ，不可能-内存泄露
 * |-PhantomReference
 *      PhantomReference 是所有“弱引用”中最弱的引用类型。不同于软引用和弱引用，虚引用无法通过 get() 方法来取得目标对象的强引用从而使用目标对象，观察源码可以发现 get() 被重写为永远返回 null。
 *      可能-内存泄露
 *
 * Created by caiping on 2017/9/13.
 */
public class TestLangReference {

    @Test
    public void testStrongReference() {

        String tag = new String("T");

    }

    @Test
    public void testSoftReference() {
        SoftReference<Person> personSoftReference = new SoftReference<Person>(new Person("haha",11));
        Person person = personSoftReference.get();
        System.out.println(person);
    }

    @Test
    public void testPhantomReference() {

        ReferenceQueue<Person> refQueue = new ReferenceQueue<>();
        PhantomReference<Person> reference = new PhantomReference<>(new Person("haha",1),refQueue);

        System.out.println(reference.get());    //null
        System.gc();

        System.out.println(refQueue.poll()==reference); //true

    }
}
