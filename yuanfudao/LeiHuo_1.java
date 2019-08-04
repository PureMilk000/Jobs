
import java.util.Scanner;

public class LeiHuo_1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(),M = in.nextInt();
        WindowNode head = new WindowNode(null);
        WindowNode tail = new WindowNode(null);
        head.next = tail;
        tail.pre = head;
        for (int i = 1; i <= N; i++)
        {
            Window temp = new Window(i,in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
            WindowNode tempNode = new WindowNode(temp);
            tempNode.next = head.next;
            head.next.pre = tempNode;
            tempNode.pre = head;
            head.next = tempNode;
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
            WindowNode curNode = head.next;
            while(curNode.val != null)
            {
                if(isClicked(curNode,curClick)){
                    System.out.println(curNode.val.id);
                    curNode.pre.next = curNode.next;
                    curNode.next.pre = curNode.pre;
                    curNode.next = head.next;
                    head.next.pre = curNode;
                    curNode.pre = head;
                    head.next = curNode;
                    flag = true;
                    break;
                }
                curNode = curNode.next;
            }
            if(!flag)
                System.out.println(-1);
        }
    }
    static class WindowNode{
        Window val;
        WindowNode pre;
        WindowNode next;

        public WindowNode(Window val)
        {
            this.val = val;
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
    static boolean isClicked(WindowNode curNode,Point click){
        if(click.x < curNode.val.x || click.y < curNode.val.y)
            return false;
        if(click.x > curNode.val.x + curNode.val.width)
            return false;
        if(click.y > curNode.val.y + curNode.val.height)
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
