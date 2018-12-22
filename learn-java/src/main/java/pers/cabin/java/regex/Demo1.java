package pers.cabin.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http://geek.csdn.net/news/detail/237488
 * <p>
 * 正则表达式语法
 * 1.用一对方括号[] 表示字符分类。方括号本身并不是要匹配的一部分。        //[abc]
 * [Jj]ohn
 * 字符分类[Jj] 匹配J或j，剩余的 ohn 会准确匹配字符ohn.
 * 2.预定义字符分类
 * \d 表示任意数字,
 * \s 表示任意空白字符,
 * \w 表示任意单词字符。
 * 3. 边界匹配
 * \w 匹配一个单词，^匹配行首,$ 匹配行尾。
 * 4.量词
 * A*  // * 0次或多次， + 1次 或多次
 * <p>
 * <p>
 * <p>
 * Created by caiping on 2017/9/21.
 */
public class Demo1 {

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();

//        test4();

//        test5();

//        test6();

//        test7();

        test8();

    }

    private static void test8() {
        String str = "asdf.asdfdsaf.2123.asdf";
//        String reg = "\\.";
        String reg = "\\.";
//        Pattern compile = Pattern.compile(reg);
//        String[] split = compile.split(str);
        String[] split = str.split(reg);

        for (String s : split) {
            System.out.println(s);
        }
    }

    /*
    start() 和 end() 返回每次匹配的字串在整个文本中的开始和结束位置。实际上, end() 返回的是字符串末尾的后一位，这样，可以在把 start() 和 end() 的返回值直接用在String.substring() 里。

     */
    private static void test7() {
        String text =
                "This is the text which is to be searched " +
                        "for occurrences of the word 'is'.";
        String patternString = "is";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("found: " + count + " : " + matcher.start() + " - " + matcher.end() + "----> " + text.substring(matcher.start(), matcher.end()));

        }
    }

    private static void test6() {
        String text =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";
        String patternString = "This is the";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        System.out.println("lookingAt = " + matcher.lookingAt());
        System.out.println("matches   = " + matcher.matches());
    }

    private static void test5() {
        String patternString = "sep";
        Pattern pattern = Pattern.compile(patternString);       //实例化 Pattern ，和 new Pattern(regex,0);  等同
        String pattern2 = pattern.pattern();        //pattern2 值为sep ，与patternString 变量相同。
        System.out.println(pattern2);
    }

    private static void test4() {
        String text = "A sep Text sep With sep Many sep Separators";
        String patternString = "sep";
        Pattern pattern = Pattern.compile(patternString);
//        String[] split = pattern.split(text,2);
//        String[] split = pattern.split(text,-1);
        String[] split = pattern.split(text);
        System.out.println("split.length = " + split.length);
        for (String element : split) {
            System.out.println("element = " + element);
        }
    }

    /*
        如果需要匹配多次出现,甚至输出不同的匹配文本，或者只是需要非默认设置。需要通过Pattern.compile() 方法得到一个Pattern 实例。

        如果需要匹配一个正则表达式在文本中多次出现，需要通过Pattern.compile() 方法创建一个Pattern对象。

         */
    private static void test3() {
        String text =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";
        String patternString = ".*http://.*";
        Pattern pattern = Pattern.compile(patternString);
//        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(text);
        boolean matches = matcher.matches();

        System.out.println(matcher.toMatchResult());
        System.out.println("matches = " + matches);
    }

    /*
“is” 是否出现，允许”is” 前后包含 0或多个字符(由 .* 指定)
     */
    private static void test2() {
        String text =
                "This is the text to be searched " +
                        "for occurrences of the pattern.";
        String pattern = ".*is.*";
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("matches = " + matches);
    }

    /*
    示例代码实际上没有检测找到的 http:// 是否是一个合法超链接的一部分,如包含域名和后缀(.com,.net 等等)。代码只是简单的查找字符串 http:// 是否出现。

     */
    private static void test1() {
        String text =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";

        String pattern = ".*http://.*";
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("matches = " + matches);
    }

}
