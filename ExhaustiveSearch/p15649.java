package ExhaustiveSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p15649 {
	static boolean[] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> li = new ArrayList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int count = 1;
		for (int i = 0; i < N; i++) {
			arr[i] = count;
			count++;
		}
		visited = new boolean[N];
		dfs( 0, li, false, arr);
	}

	static void dfs( int depth, List<Integer> li, boolean temp, int[] arr) {
		if (depth == M) {
			for (int i = 0; i < li.size(); i++) {
				if(!(i ==li.size()-1)) {
					System.out.print(li.get(i) + " ");
				}else {
					System.out.print(li.get(i));
				}
				
			}
			System.out.println();
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs( depth + 1, li, li.add(arr[i]), arr);
					li.remove(li.size()-1);
					visited[i] = false;
				}

			}
		}
	}
}
