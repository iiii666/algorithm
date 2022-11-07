package DFS;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class p17204 {
    static List<Integer> li ;
    static int result =0;
    static int count=0;
    static int K;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        li =new ArrayList<>();
        for(int i=0;i<N;i++){
            li.add(Integer.parseInt(br.readLine()));
        }
        dfs(0);
        if(count ==N){
            System.out.println(-1);
        }else{
            System.out.println( result);
        }

    }

    private static void dfs(int i) {
        result++;
        count++;
            int next=li.get(i);
            if(next == K){
                return;
            } else if (count ==N) {
                return;
            } else{
                dfs(next);
        }
    }

}
