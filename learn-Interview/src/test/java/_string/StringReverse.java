package _string;

/**
 * Created by caiping on 2017/9/26.
 */
public class StringReverse {

    public static String reverse(String word){
        int i=0;
        if (word == null) {
            return null;
        }
        int j = word.length()-1;
        char[] chars = word.toCharArray();
        while (i < j) {
            char t = chars[i];

            chars[i]=chars[j];
            chars[j] = t;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args){

        String str = "hello word";

        System.out.println(reverse(str));

    }
}
