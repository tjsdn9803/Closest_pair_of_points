# Computer_Algorithm project_01
## Closest_pair_of_points
2차원 평면상에 n개의 점이 입력으로 주어질 때, 거리가 가장 가까운 한 쌍의 점을 찾는 문제
### Algorithm
___
 1. **S에 있는 점의 수가 3개 이하면 더이상 분할 x**


  -*2개일 경우 그대로 리턴*


  -*3개일 경우 최근접 점의 쌍을 리턴*


 2. **x좌표가 오름차순으로 정렬 된 배열 S를 같은 개수의 점을 갖는 왼쪽(Sl) 오른쪽(Sr)으로 분할한다.**


  -*점의 개수가 홀수 개일 경우 왼쪽(Sl)에 1개 더 많게 분할*


 3. **Sl과 Sr에 대해 재귀적으로 분할해 최근접 점의 쌍을 CPl과 CPr이라 놓는다.**


 -*CPl과 CPr의 더 짧은 거리를 d로 정의*


 4. **d를 이용해 분할전 S에 중간 영역(Sc)에 속하는 점들을 찾고, 이 중에서 최근접 점의 쌍을 CPc라 놓는다.**


  -*Sl의 최우단점의 x좌표-d 보다 크고 Sr의 최좌단점의 x좌표+d 보다 작은 점을 middlepoints 배열에 저장해 y축 오름차순으로 정렬하여 최근접 점(CPc)의 쌍을 찾는다.*


 5. **CPl CPr CPc 중에서 가장 짧은 거리를 가진 쌍을 해를 리턴한다.**



#### coding histories

 -1단계

```java
public point[] ClosestPair(point arr[],int p,int q){
         if(q-p<=2){
             point a = arr[p];
             point b = arr[q];
             if(q-p==1) return new point[]{a, b};
             }
             int k = (q+p)/2;
         point[] CPL = ClosestPair(arr,p,k);
         point[] CPR = ClosestPair(arr,k+1,q);
  }
```



 배열 S를 재귀적으로 분할해 Sl과 Sr로 분할

 2개의 점이 남았을때 그대로 리턴

개선점: 점의 갯수가 3개일때 최근접쌍을 리턴해주어야됨, 중간영역에 대한 최근점쌍을 탐색해야됨



 -2단계

```java

if(q-p==2){
		a= arr[p];
        b= arr[p+1];
        point c= arr[p+2];
        double temp=min(getdistance(a,b), getdistance(a,c), getdistance(b,c));
    
		if(temp == getdistance(a,b)) return new point[] {a,b};
        else if(temp == getdistance(a,c)) return new point[] {a,c};
}
```



 3개의 점이 남았을때 최근접 점의 쌍을 리턴

```java

double d = min(DL,DR);
middlepoints = new ArrayList<point>();
for(int h=0;h<(q-p+1);h++){
            if(((arr[h+p].x) > (arr[k].x-d)) && ((arr[h+p].x) < (arr[k+1].x+d))){
                middlepoints.add(arr[h+p]);
			}
}
CPC = new point[2];

```

```java
//        for(int f=0;f<middlepoints.size();f++){
//            for(int t=f+1;t<middlepoints.size();t++){
//                double dis = getdistance(middlepoints.get(f),middlepoints.get(t));
//                if(DC > dis){
//                    DC = dis;
//                    CPC[0] = middlepoints.get(f);
//                    CPC[1] = middlepoints.get(t);
//                }
//            }
//		  }// 이경우에 middlepoints의 y축 분포가 넓으면 계산횟수가 n^2이므로 계산횟수가 급증함 개선이 필요함
```



 Sl과 Sr을 이용해 Sc를 정의하고 배열(middle points)에 저장

 CPl과 CPr를 이용해 d를 구하고 CPc를 구함

```java
if(min(DL,DR,DC)==DL)return CPL;
        else if(min(DL,DR,DC)==DR)return CPR;
        else return CPC;
```

 closest point를 해로 리턴

 -3단계



```java
  Collections.sort(middlepoints);//오름차순정렬
        for(int g=0;g ((middlepoints.get(g).getY())-(middlepoints.get(e).getY()))){

                    if(DC > getdistance(middlepoints.get(g),middlepoints.get(e))){
                        DC = getdistance(middlepoints.get(g),middlepoints.get(e));
                        CPC[0] = middlepoints.get(g);
                        CPC[1] = middlepoints.get(e);
                    }
                }
            }
        }
       
```


 2단계에서의 middlepointsdml y축분포가 넓을떄에 대한 문제를 배열 middle points를 오름 차순으로 정렬한 뒤 를 이용해 계산 횟수를 줄임

-4단계

입력 받을 때 x축으로 정렬된 입력을 받을 필요없이 받은 입력을 정렬해서 ClosestPair메소드에 삽입

```java
Arrays.sort(pointarr, new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                if(o1.getX()>o2.getX()){
                    return 1;
                }else if(o1.getX()<o2.getX()){
                    return -1;
                }else return 0;
            }
        });
        System.out.println();
```



 

#### 전체코드

```java
import java.util.*;

class point implements Comparable<point>{
    int x;
    int y;
    public void setop(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    @Override
    public int compareTo(point o) {
        if(this.y < o.getY()){
            return -1;
        }else if(this.y > o.getY()){
            return 1;
        }
        return 0;
    }
}
public class closest_pair_of_points {
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
        //middlepoints배열의 크기가 고정되어있어서 에를들어 [4]로 선언되고 [0][1][2]만 초기화되면 [3]이 null상태 이상태에서 getdistance하면 에러
        //동적배열로 선언하여 해결
        for(int h=0;h<(q-p+1);h++){//arr를 돌면서 좌측구역의 최우단점의 x좌표 -d보다 크고 우측구역의 최좌단의 x좌표+d보다 작은 점들을 middlepoints배열에 저장
            if(((arr[h+p].x) > (arr[k].x-d)) && ((arr[h+p].x) < (arr[k+1].x+d))){
                middlepoints.add(arr[h+p]);

            }
        }
        CPC = new point[2];
//        for(int f=0;f<middlepoints.size();f++){
//            for(int t=f+1;t<middlepoints.size();t++){
//                double dis = getdistance(middlepoints.get(f),middlepoints.get(t));
//                if(DC > dis){
//                    DC = dis;
//                    CPC[0] = middlepoints.get(f);
//                    CPC[1] = middlepoints.get(t);
//                }
//            }
//        }// 이 경우 middlepoints의 y축 분포가 넓으면 계산횟수가 n^2이므로 계산횟수가 급증함
        Collections.sort(middlepoints);//오름차순정렬
        for(int g=0;g<middlepoints.size();g++){
            for(int e=g+1;e<middlepoints.size();e++){
                if(d > ((middlepoints.get(g).getY())-(middlepoints.get(e).getY()))){//y좌표 차이가 d보다 클때는 계산하지 않음

                    if(DC > getdistance(middlepoints.get(g),middlepoints.get(e))){
                        DC = getdistance(middlepoints.get(g),middlepoints.get(e));
                        CPC[0] = middlepoints.get(g);
                        CPC[1] = middlepoints.get(e);
                    }
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
        for (int j = 0; j < n; j++) {
            x = pointarr[j].x;
            y = pointarr[j].y;
            System.out.print("(" + x + "," + y + ")");
        }
        Arrays.sort(pointarr, new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                if(o1.getX()>o2.getX()){
                    return 1;
                }else if(o1.getX()<o2.getX()){
                    return -1;
                }else return 0;
            }
        });
        System.out.println();
        System.out.println("정렬 후");
        for (int j = 0; j < n; j++) {
            x = pointarr[j].x;
            y = pointarr[j].y;
            System.out.print("(" + x + "," + y + ")");
        }
        closest_pair_of_points cpp = new closest_pair_of_points();
        closest2point = new point[2];
        closest2point = cpp.ClosestPair(pointarr,0,n-1);

        int closestLx = closest2point[0].x;
        int closestLy = closest2point[0].y;
        int closestRx = closest2point[1].x;
        int closestRy = closest2point[1].y;
        System.out.println();
        System.out.print("가장 가까운 두점은 (" + closestLx + "," + closestLy + ")");
        System.out.print("와");
        System.out.println("(" + closestRx + "," + closestRy + ")");
    }
}
```

#### 실행결과


점의 갯수 입력
8
1번째 점의 x 입력
5
1번째 점의 y 입력
10

***

생략

***

8번째 점의 x 입력
7
8번째 점의 y 입력
5
(5,10)(0,0)(15,8)(6,0)(11,5)(4,4)(8,10)(7,5)
정렬 후
(0,0)(4,4)(5,10)(6,0)(7,5)(8,10)(11,5)(15,8)
가장 가까운 두점은 (5,10)와(8,10)

Process finished with exit code 0



 

