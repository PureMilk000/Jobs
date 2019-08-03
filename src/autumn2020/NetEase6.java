package test;

import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  //击鼓次数
        int k = in.nextInt();  //参与人数
        System.out.println(transFlower(k,n));
        in.close();

    }

    /**
     * 击鼓传花
     * @param n 参与人数
     * @param m 击鼓次数
     * @return
     */
    public static int transFlower(int n, int m){
        int temp[][] = new int[31][31];
        temp[1][1] = 1;
        temp[1][n - 1] = 1;
        for (int i = 2; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = temp[i - 1][(n-j-1) % n] + temp[i - 1][(n-j+1) % n];
            }
        }
        return temp[m][0];
    }
}
