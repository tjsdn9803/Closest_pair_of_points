
import java.util.ArrayList;
import java.util.List;
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
    static int g,y;
    static point[] pointarr;
    static point[] closest2point;
    List<point> middlepoints;
    public double getdistance(point a,point b){
        return Math.sqrt((b.x-a.x)*(b.x-a.x)+(b.y-a.y)*(b.y-a.y));
    }
    public double min(double a,double b){
        if(a<b) return a;
        else return b;
    }
    public double min(double a,double b,double c){
        if(a<b && a<c) return a;
        else if(b<a && b<c) return b;
        else return c;
    }

    public point[] ClosestPair(point arr[],int p,int q){
        if(q-p<=2){
            point a = arr[p];
            point b = arr[q];
            if(q-p==1) return new point[]{a, b};
            if(q-p==2){
                a= arr[p];
                b= arr[p+1];
                point c= arr[p+2];
                double temp=min(getdistance(a,b), getdistance(a,c), getdistance(b,c));
                if(temp == getdistance(a,b)) return new point[] {a,b};
                else if(temp == getdistance(a,c)) return new point[] {a,c};
                else return new point[] {b,c};
            }
        }
        int k = (q+p)/2;


        point[] CPL = ClosestPair(arr,p,k);
        point[] CPR = ClosestPair(arr,k+1,q);
        point[] CPC ;
        double DL = getdistance(CPL[0],CPL[1]);
        double DR = getdistance(CPR[0],CPR[1]);
        double DC = 10000;
        double d = min(DL,DR);
        middlepoints = new ArrayList<point>();
        int s=0; //middlepoints배열의 크기가 고정되어있어서 에를들어 [4]로 선언되고 [0][1][2]만 초기화되면 [3]이 null상태 이상태에서 getdistance하면 에러
        for(int h=0;h<(q-p+1);h++){//arr를 돌면서 좌측구역의 최우단점의 x좌표 -d보다 크고 우측구역의 최좌단의 x좌표+d보다 작은 점들을 middlepoints배열에 저장
            if((arr[h+p].x) > (arr[k].x-d) && (arr[h+p].x) < (arr[k+1].x+d)){

                middlepoints.add(arr[h+p]);
            }
        }
        //왜 middlepoints[h] = arr[0]dl 들감??
        CPC = new point[2];
        for(int f=0;f<middlepoints.size();f++){
            for(int t=f+1;t<middlepoints.size();t++){
                double dis = getdistance(middlepoints.get(f),middlepoints.get(t));
                if(DC > dis){
                    DC = dis;
                    CPC[0] = middlepoints.get(f);
                    CPC[1] = middlepoints.get(t);
                }
            }
        }
        if(min(DL,DR,DC)==DL)return CPL;
        else if(min(DL,DR,DC)==DR)return CPR;
        else return CPC;
    }


    public static void main(String[] args) {
        int x, y;

        Scanner sc = new Scanner(System.in);
        System.out.println("점의 갯수 입력");
        int n = sc.nextInt();
        pointarr = new point[n];
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "번째 점의 x 입력");
            x = sc.nextInt();
            System.out.println((i + 1) + "번째 점의 y 입력");
            y = sc.nextInt();
            point p = new point();
            p.setop(x, y);
            pointarr[i] = p;
        }
//        int xarr [] = {0,1,4,5 ,6,7,9,11,14};
//        int yarr [] = {1,1,3,11,2,3,4,4 ,1 };
//        for(int b=0;b<n;b++){
//            x = xarr[b];
//            y = yarr[b];
//            point p = new point();
//            p.setop(x,y);
//            pointarr[b] = p;
//        }
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
        System.out.print("가장 가까운 두점은 (" + closestLx + "," + closestLy + ")");
        System.out.print("와");
        System.out.println("(" + closestRx + "," + closestRy + ")");

    }
}