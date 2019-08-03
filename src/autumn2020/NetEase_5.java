package autumn2020;

public class NetEase_5
{
    public static void main(String[] args) {

        //输入序列长度n和操作次数q
        int n = 0, q = 0;

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            n = in.nextInt();
            q = in.nextInt();

            int[] an = new int[n];
            for(int i = 0; i < n; i++){
                an[i] = in.nextInt();
            }

            int countq[] = new int[q];
            int test[] = new int[q];
            for(int i = 0; i < q; i++){
                countq[i] = 0;
                test[i] = in.nextInt();
            }

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < q; k++) {
                    if (an[j] >= test[k]) {
                        an[j]--;
                        countq[k]++;
                    }
                }
            }

            for(int i = 0; i < q; i++){
                System.out.println(countq[i]);
            }

        }
        in.close();
    }
}
