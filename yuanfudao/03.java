public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();//表示经过的步数
        int n=sc.nextInt();//表示人数
        int [][] dp=new int[m+1][n+1];
        dp[0][1]=1;
        dp[1][2]=1;
        dp[1][n]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j==1)dp[i][1]=dp[i-1][2]+dp[i-1][n];
                else if(j==n)dp[i][n]=dp[i-1][n-1]+dp[i-1][1];
                else{
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1];
                }
            }
        }
        System.out.println(dp[m][1]);
    }
}