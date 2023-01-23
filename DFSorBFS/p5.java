package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p5 {
	static int M;
	static int N;
	static int[] pm;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<Integer> li = new ArrayList<>();
		pm = new int[M];
		dfs(0, li);
	}

	public static void dfs(int depth, List<Integer> li) {
		if(depth == M) {
			for(int i =0;i<li.size();i++) {
				if(i != li.size()-1) {
					System.out.print(li.get(i) + " ");
				}else {
					System.out.println(li.get(i));
				}
				
			}
//			for(int i=0;i<pm.length;i++) {
//				System.out.print(pm[i]);
//			}
//			System.out.println();
////			
			
		}else {
			for(int i =1;i<N+1;i++) {
			//	li.add(i);
				li.set(depth, i);
			//	pm[depth] = i;
				dfs(depth+1,li );
				//li.remove(li.size()-1);
				
			}
		}
	}
}
