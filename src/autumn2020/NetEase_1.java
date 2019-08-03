package autumn2020;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NetEase_1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Student[] students = new Student[N];
        for(int i=0;i<N;i++)
        {
            students[i] = new Student(i,in.nextInt());
        }
        int queryTimes = in.nextInt();
        int[] querys = new int[queryTimes];
        for (int i = 0; i < queryTimes; i++)
        {
            querys[i] = in.nextInt()-1;
        }
        in.close();
        Arrays.sort(students,(a,b) -> {
            return b.getScore() - a.getScore();
        });
        for (int i = 0; i < N; i++)
        {
            map.put(students[i].getId(),i);
        }
        for (int i = 0; i < queryTimes; i++)
        {
            int index = map.get(querys[i]);
            while(index >0 && students[index-1].getScore()==students[index].getScore()){
                index--;
            }

            double res = (double)(N-index-1)/N * 100;
            DecimalFormat df = new DecimalFormat( "0.000000");
            System.out.println(df.format(res));
        }
    }
    static class Student{
        private int score;
        private int id;

        public Student(int id,int score){
            this.score= score ;
            this.id=id  ;
        }

        public int getScore(){
            return score;
        }
        public int getId(){
            return id;
        }
    }
}
