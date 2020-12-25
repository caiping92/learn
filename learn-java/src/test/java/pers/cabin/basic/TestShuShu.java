package pers.cabin.basic;

/**
 * 素数
 * 根据筛选法，求出100 以内所有素数，指从小到大 筛选去一个已知的数的所有倍数，
 * 例如，根据2 可以筛选出 4 6 8 10 ... 98 100
 * 然后，根据3 可以筛选出  9 15 ... 99（倍筛选了的会被取出）
 * 以此类推，剩下的就是100 以内的素数
 * Created by caiping on 2017/9/10.
 */
public class TestShuShu {
    public static void main(String[] args) {


        getSuShu1();
//        getSuShu2();
    }

    //开根号
    private static void getSuShu2() {
        int i, j, k;
        int[] a = new int[101];

        for (i = 1; i < 100; i++) {
            k = (int) Math.sqrt(i);
            for (j=2;j<=k;j++) {
                if (i % j == 0) {
                    break;
                }
                if (j > k) {
                    System.out.println("    " + i);
                }
            }
        }

    }

    private static void getSuShu1() {
        int[] a = new int[101];
        int i, j;

        for (i = 2; i < 101; i++) {
            if (a[i] == 0) {
                for (j = i + 1; j < 101;j++ ) {
                    if (j % i == 0) {
                        a[j] = 1;
                    }
                }
            }
        }

        //输出100 以内的素数
        for (i = 2; i < 101; i++) {
            if (a[i] != 1) {
                System.out.println(i);
            }
        }
    }

}
