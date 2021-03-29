
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
    static point[] middlepoints;
    public double getdistance(point a,point b){
        return Math.sqrt((b.x-a.x)*(b.x-a.x)+(b.y-a.y)*(b.y-a.y));
    }
    public double min(double a,double b){
        if(a<b) return a;
        else return b;
    }

    public point[] ClosestPair(point arr[],int p,int q){
        if(q-p<=2){
            point a = pointarr[p];
            point b = pointarr[q];
            if(q-p==1) return new point[]{a, b};
        }

        int k = (q+p)/2;
        point[] CPL = ClosestPair(arr,p,k);
        point[] CPR = ClosestPair(arr,k+1,q);
        double DL = getdistance(CPL[0],CPL[1]);
        double DR = getdistance(CPR[0],CPR[1]);
//
//        double d = min(DL,DR);
//        for(int w=0;w<q;w++){
//            if(arr[w+p].x > arr[k].x-d && arr[w+p].x < arr[k+1].x + d){
//                middlepoints = new point[q];
//                middlepoints[w] = arr[w+p];
//            }
//        }
//        point[] CPC = ClosestPair(middlepoints,p,q);
//        double DC = getdistance(CPC[0],CPC[1]);
//        if(DL<DR && DL<DC) return CPL;
//        else if(DR<DL && DR<DC) return CPR;
//        else return CPC;
        if(DL<DR)return CPL;
        else return CPR;


    }


    public static void main(String[] args) {
        int x, y;

        Scanner sc = new Scanner(System.in);
        System.out.println("점의 갯수 입력");
        int n = sc.nextInt();
        pointarr = new point[n];
//        for (int i = 0; i < n; i++) {
//            System.out.println(i + 1 + "번째 점의 x 입력");
//            x = sc.nextInt();
//            System.out.println(i + 1 + "번째 점의 y 입력");
//            y = sc.nextInt();
//            point p = new point();
//            p.setop(x, y);
//            pointarr[i] = p;
//        }
        int xarr [] = {1,4,5 ,6,7,9,11,14};
        int yarr [] = {1,3,11,2,2,4,3 ,1 };
        for(int b=0;b<n;b++){
            x = xarr[b];
            y = yarr[b];
            point p = new point();
            p.setop(x,y);
            pointarr[b] = p;
        }
        for (int j = 0; j < n; j++) {
            x = pointarr[j].x;
            y = pointarr[j].y;
            System.out.println("(" + x + "," + y + ")");
        }

        closest_pair_of_points cpp = new closest_pair_of_points();
        closest2point = new point[2];
        closest2point = cpp.ClosestPair(pointarr,0,n-1);

        int closestLx = closest2point[0].x;
        int closestLy = closest2point[0].y;
        int closestRx = closest2point[1].x;
        int closestRy = closest2point[1].y;
        System.out.println("(" + closestLx + "," + closestLy + ")");
        System.out.println("와");
        System.out.println("(" + closestRx + "," + closestRy + ")");

    }
}
