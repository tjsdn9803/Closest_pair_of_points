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
 
 
 <pre>
 <code>

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
  </code>
  </pre>
 
 배열 S를 재귀적으로 분할해 Sl과 Sr로 분할
 
 2개의 점이 남았을때 그대로 리턴
 
 -2단계
 
 <pre>
 <code>
 if(q-p==2){
                a= arr[p];
                b= arr[p+1];
                point c= arr[p+2];
                double temp=min(getdistance(a,b), getdistance(a,c), getdistance(b,c));

                if(temp == getdistance(a,b)) return new point[] {a,b};
                else if(temp == getdistance(a,c)) return new point[] {a,c};
            }
 </code>
 </pre>
 
 3개의 점이 남았을때 최근접 점의 쌍을 리턴
 
 <pre>
 <code>
 double d = min(DL,DR);
        middlepoints = new ArrayList<point>();
 for(int h=0;h<(q-p+1);h++){
            if(((arr[h+p].x) > (arr[k].x-d)) && ((arr[h+p].x) < (arr[k+1].x+d))){
                middlepoints.add(arr[h+p]);

            }
        }
        CPC = new point[2];
 </code>
 </pre>
 
 Sl과 Sr을 이용해 Sc를 정의하고 배열(middle points)에 저장
 
 
 CPl과 CPr를 이용해 d를 구하고 CPc를 구함
 
 <pre>
 <code>
 if(min(DL,DR,DC)==DL)return CPL;
        else if(min(DL,DR,DC)==DR)return CPR;
        else return CPC;
        
</code>
</pre>
 closest point를 해로 리턴
 
 
 -3단계
 
 <pre>
 <code>
  Collections.sort(middlepoints);//오름차순정렬
        for(int g=0;g<middlepoints.size();g++){
            for(int e=g+1;e<middlepoints.size();e++){
                if(d > ((middlepoints.get(g).getY())-(middlepoints.get(e).getY()))){

                    if(DC > getdistance(middlepoints.get(g),middlepoints.get(e))){
                        DC = getdistance(middlepoints.get(g),middlepoints.get(e));
                        CPC[0] = middlepoints.get(g);
                        CPC[1] = middlepoints.get(e);
                    }
                }
            }
        }
       
 </code>
 </pre>
 배열 middle points를 오름 차순으로 정렬한 뒤 d를 이용해 계산 횟수를 줄임
 
 


 
 
 
