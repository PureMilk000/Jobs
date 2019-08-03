package autumn2020;

import java.util.Scanner;

public class Shoppee_1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String raw = in.nextLine();
        String[] rawArray = raw.split(" ");
        String str1 = rawArray[0], str2 = rawArray[1];

        int len1 = str1.length();
        int len2 = str2.length();
        int len = gcd(len1, len2);

        String res = str1.substring(0, len);
        if (isMatch(str1, res) && isMatch(str2, res))
        {
            System.out.println(res);
        }
        else
        {
            System.out.println("");
        }
    }

    private static int gcd(int n, int m)
    {
        return n == 0 ? m : gcd(m % n, n);
    }

    private static boolean isMatch(String str1, String str2)
    {
        for (int i = 0; i < str1.length(); i++)
        {
            if (str1.charAt(i) != str2.charAt(i % str2.length()))
                return false;
        }
        return true;
    }
}





