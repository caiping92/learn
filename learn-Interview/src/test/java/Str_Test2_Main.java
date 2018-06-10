import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 1.A - Z,不区分大小写
 * 2.相同字母的大小写同时出现时，小写在前
 * 3. 非英文字母的字符串加在英文字符串的后面
 *
 * Created by caiping on 2017/9/18.
 */
public class Str_Test2_Main {

    public static void main(String[] args){

        System.out.println("请输入需要进行整理的字符串：");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str_resource = null;
        try {
            str_resource = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (str_resource != null && !(str_resource.trim().equals(""))) {
            String[] arr_resource = str_resource.split("");
            show(arr_resource);
            sort(arr_resource);
            show(arr_resource);
        }
    }


    public static void sort(Comparable[] arr) {
        sort(arr,0, arr.length-1);
    }

    private static void sort(Comparable[] arr, int low, int high) {

        if (high <= low) {
            return;
        }

        int lt = low, i = low + 1, gt = high;
        Comparable v = arr[low];

        while (i <= gt) {
            int cmp = arr[i].compareTo(v);

            if (cmp < 0) {
                exch(arr, lt++, i++);
            } else if (cmp > 0) {
                exch(arr, i, gt--);
            } else {
                i++;
            }
        }

        //现在arr[low,...lt-1] <v =a[lt...gt] <a[gt+1..high] 成立
        sort(arr, low, lt - 1);
        sort(arr, gt+1, high);
    }

    /**
     * 判断v 是否比w 小
     *  比较规则：
     *      1.忽略大小写
     *      2.大写再后
     *      3.非英文字母在后
     *      TODO
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        if (v == null) {
            return true;
        }
        if (w == null) {
            return false;
        }
        if (isEnglish(v)) { //v ->en
            if (isEnglish(w)) {
                if (String.valueOf(v).compareToIgnoreCase(String.valueOf(w)) == 0) {
                    if (String.valueOf(v).matches("^[a-z]$")) { //v是小写
                        return false;
                    }
                    return true;
                } else {
                    return String.valueOf(v).compareToIgnoreCase(String.valueOf(w))<=0;
                }
            }else{
                return false;
            }

        } else {
            if (String.valueOf(v).compareToIgnoreCase(String.valueOf(w)) == 0) {
                if (String.valueOf(v).matches("^[a-z]$")) { //v是小写
                    return false;
                }
                return true;
            } else {
                return String.valueOf(v).compareToIgnoreCase(String.valueOf(w))<=0;
            }
        }
    }

    public static boolean isEnglish(Comparable c) {
        String reg = "^[a-zA-Z]$";
        if (String.valueOf(c).matches(reg)) {
            return true;
        }
        return false;
    }

    /**
     * 交换数组arr 中 i 和j 的位置
     * @param arr
     * @param i
     * @param j
     */
    public static void exch(Comparable[] arr, int i, int j) {
        if (arr != null) {
            Comparable tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    /**
     * 打印单行数组
     * @param arr
     */
    public static void show(Comparable[] arr) {
        if (arr != null) {
            for (int i=0;i<arr.length;i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }

}
