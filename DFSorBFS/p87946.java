package DFSorBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p87946 {
public static void main(String[] args) {
	Solution s  =new Solution();
	int[][] arr = {{80,20},
	                {50,40},
	                {30,10}};
	System.out.println(s.solution(80, arr));
}

static class Solution {

    static List<Integer> li = new ArrayList<>();
    static int answer = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
       
        dfs(k, dungeons,0, answer);
         Collections.sort(li);
         int result = li.get(li.size()-1);
        return result;
    }
    static void dfs(int k , int[][] dungeons,int depth, int answer){
        if(depth == dungeons.length){
            
            li.add(answer);
            return;
        }
        else{
            for(int i =0;i<dungeons.length;i++){
            
                if(!visited[i] &&k >= dungeons[i][0]  ){
                    visited[i] = true;
                    dfs(k-dungeons[i][1], dungeons, depth+1, answer+1);
                    visited[i] = false;
                }
            }
        }
        li.add(answer);
    }
}


}
