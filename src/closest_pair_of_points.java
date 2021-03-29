
import java.util.Scanner;
class point{
    int x;
    int y;
    public void setop(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class closest_pair_of_points {
    static point[] pointarr;
    static point[] closest2point;
    public double getdistance(point a,point b){
        return Math.sqrt((b.x-a.x)*(b.x-a.x)+(b.y-a.y)*(b.y-a.y));
    }
    public double min(double a,double b){
        if(a<b) return a;
        else return b;
    }

    public point[] ClosestPair(point arr[],int p,int q){
        closest2point = new point[2];
        if(q-p<=2){
            point a = pointarr[p];
            point b = pointarr[q];
            if(q-p==1) return new point[]{a, b};
        }

        int k = (q+p)/2;
        point[] CPL = ClosestPair(arr,p,k);
        point[] CPR = ClosestPair(arr,p+1,q);
        double DL = getdistance(getdistance(CPL[0],CPL[1]);
        double DR = getdistance(getdistance(CPR[0],CPR[1]);

        double d = min(DL,DR);
        
    }


    public static void main(String[] args) {
        int x, y;

        Scanner sc = new Scanner(System.in);
        System.out.println("점의 갯수 입력");
        int n = sc.nextInt();
        pointarr = new point[n];
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + "번째 점의 x 입력");
            x = sc.nextInt();
            System.out.println(i + 1 + "번째 점의 y 입력");
            y = sc.nextInt();
            point p = new point();
            p.setop(x, y);
            pointarr[i] = p;
        }
        for (int j = 0; j < n; j++) {
            x = pointarr[j].x;
            y = pointarr[j].y;
            System.out.println("(" + x + "," + y + ")");
        }
    }
}
