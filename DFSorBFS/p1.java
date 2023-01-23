package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1 {
	static int[] arr;
	static boolean[] visited;
	static String result = "NO";
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		int total = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
			total += temp;
		}

		dfs(0, 0, total, N);
		System.out.println(result);
	}

	public static void dfs(int depth, int sum, int total, int N) {
		if(flag ==true) {
			return;
		}
		if(sum>total/2) {
			return;
		}
		if(depth ==N) {
			if(total -sum==sum) {
				result ="YES";
				flag =true;
			}
		}else {
			dfs(depth +1,sum +arr[depth],total,N);
			dfs(depth +1,sum,total,N);
		}
		
	}
}
