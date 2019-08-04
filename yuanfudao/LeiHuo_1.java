
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(),M = in.nextInt();
        Window[] windows = new Window[N+1];
        for (int i = N,j=1; i > 0; i--)
        {
            Window temp = new Window(j++,in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
            windows[i] = temp;
        }
        Point clickPositions[] = new Point[M];
        for (int i = 0; i < M; i++)
        {
            clickPositions[i] = new Point(in.nextInt(),in.nextInt());
        }
        for (int i = 0; i < M; i++)
        {
            boolean flag = false;
            Point curClick= clickPositions[i];
            for (int j = 1; j <= N; j++)
            {
                if(isClicked(windows[j],curClick)){
                    System.out.println(windows[j].id);
                    exch(windows,j);
                    flag = true;
                    break;
                }
            }
            if(!flag)
                System.out.println(-1);
        }
    }
    static void exch(Window[] windows,int a){
        if(a == 1)
            return;
        Window temp = windows[a];
        windows[a] = windows[1];
        windows[1] = temp;
        return;
    }
    static boolean isClicked(Window window,Point click){
        if(click.x < window.x || click.y < window.y)
            return false;
        if(click.x > window.x + window.width)
            return false;
        if(click.y > window.y + window.height)
            return false;
        return true;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static class Window{
        int id;
        int x;
        int y;
        int width;
        int height;

        public Window(int id,int x, int y, int width, int height)
        {
            this.id = id;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
}
