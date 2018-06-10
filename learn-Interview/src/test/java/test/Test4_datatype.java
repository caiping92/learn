package test;

/**
 * Created by caiping on 2017/10/21.
 */
public class Test4_datatype {

    public static void main(String[] args){
        test1();
    }

    private static void test1() {

        //5 的阶乘
        int n = 50;
        String resu = 1+"";
        for (int i=1;i<=n;i++) {
            resu = multi(String.valueOf(resu),String.valueOf(i));
        }

        System.out.println(n+"!->"+resu);

    }

    /**
     * 两个数相乘
     *
     * @param n1
     * @param n2
     * @return
     */
    public static String multi(String n1, String n2) {

        int n = 0;


        char[] arr_1 = n1.toCharArray();
        char[] arr_2 = n2.toCharArray();

        int[] num1 = new int[arr_1.length];
        int[] num2 = new int[arr_2.length];
        //初始化 数值
        for (int i=0;i<arr_1.length;i++) {
            num1[i] = arr_1[i] - '0';
        }
        for (int i=0;i<arr_2.length;i++) {
            num2[i] = arr_2[i] - '0';
        }

        //结果
        int[] ret = new int[arr_1.length * arr_2.length];

        for (int i=0;i<num1.length;i++) {
            for (int j=0;j<num2.length;j++) {
                ret[i + j] += num1[i] * num2[j];
            }
        }

        //计算ret，满十  进一
        for (int i=ret.length-1;i>0;i--) {
            ret[i - 1] += ret[i] / 10;
            ret[i] = ret[i] % 10;
        }
        StringBuffer res = new StringBuffer();

        boolean isFirst = false;

        for (int t : ret) {
            if (t != 0) {//是否是第一个数
                isFirst = true;
            }
            if (isFirst) {
              /*  if (t == 0) {
                    n++;
                } else {
                    res.append(t);
                } */
                res.append(t);

            }
        }
        System.out.println(n1+"*"+n2+" = "+res);
        return res.toString();
    }

    public static void  test(){

        int n=5;
        int ret = 1;
        for (int i=1;i<n;i++) {
            ret = ret * i;
        }
        System.out.println(ret);
    }
}
