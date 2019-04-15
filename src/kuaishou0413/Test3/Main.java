package kuaishou0413.Test3;
import java.util.*;
public class Main {
    static  class Edge{
        int a, b, cost;
        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t -- >0){
            List<Edge> list = new ArrayList<>();
            int n  = sc.nextInt(), m = sc.nextInt();
            for(int i = 1; i <= n; i++){
                list.add(new Edge(0, i, sc.nextInt()));
            }
            for (int i = 0; i < m;i++){
                list.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }
            Collections.sort(list, (o1, o2) -> o1.cost - o2.cost);

            int []Tree = new int[n + 1];
            for(int i=0;i<=n;i++)
                Tree[i]=-1;
            int ans=0;
            for(int i=0;i<list.size();i++){
                int a=findRoot(list.get(i).a, Tree);
                int b=findRoot(list.get(i).b, Tree);
                if(a!=b){
                    Tree[a]=b;
                    ans+=list.get(i).cost;
                }
            }
            System.out.println(ans);

        }


    }
    static int findRoot(int x, int []Tree){
        if(Tree[x] == -1)
            return x;
        else{
            int tmp = findRoot(Tree[x], Tree);
            Tree[x] = tmp;
            return tmp;
        }
    }
}
